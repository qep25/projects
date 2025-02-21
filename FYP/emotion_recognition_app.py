import tkinter as tk
from tkinter import messagebox
from tkinter import ttk
import cv2
from PIL import Image, ImageTk
import numpy as np
import tensorflow as tf
import os
from datetime import datetime
import csv
import json
import sys

# Load the model architecture from a JSON file and the weights from an H5 file
def load_model_from_json(json_path, weights_path):
    with open(json_path, 'r') as json_file:
        model_json = json_file.read()
    model = tf.keras.models.model_from_json(model_json)
    model.load_weights(weights_path)
    return model

# Define the paths to the model JSON and weights

def resource_path(relative_path):
    """Get the absolute path to the resource, 
    works for both development and PyInstaller executables."""
    if getattr(sys, 'frozen', False):  
        # Check if the script is bundled as an executable
        base_path = sys._MEIPASS
    else:
        base_path = os.path.abspath(".")
    return os.path.join(base_path, relative_path)

# Update your file loading
model_path = resource_path("model2.json")
weights_path = resource_path("model_weights.h5")
csv_path = resource_path("StaffID.csv")

# Load the model
model = load_model_from_json(model_path, weights_path)

# Emotion labels
emotions = ['Angry', 'Disgust', 'Fear', 'Happy', 'Neutral', 'Sad', 
            'Surprise']

# Update the predict_emotion function for grayscale input
def predict_emotion(frame):
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 
                                "haarcascade_frontalface_default.xml")
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, 
                                minNeighbors=5, minSize=(48, 48))

    if len(faces) == 0:
        return "No Face Detected", 0.0

    for (x, y, w, h) in faces:
        roi_gray = gray[y:y+h, x:x+w]
        roi_gray = cv2.resize(roi_gray, (48, 48))
        roi_gray = roi_gray.astype("float32") / 255.0
        roi_gray = np.expand_dims(roi_gray, axis=-1)  # Add channel dimension for grayscale
        roi_gray = np.expand_dims(roi_gray, axis=0)   # Add batch dimension

        predictions = model.predict(roi_gray, verbose=0)
        max_index = np.argmax(predictions[0])
        accuracy = predictions[0][max_index] * 100
        return emotions[max_index], accuracy

# Update the webcam feed
def update_webcam():
    global cap, live_feed_active
    if live_feed_active:
        ret, frame = cap.read()
        if ret:
            frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            img = Image.fromarray(frame)
            imgtk = ImageTk.PhotoImage(image=img)
            display_label.imgtk = imgtk
            display_label.configure(image=imgtk)
        display_label.after(10, update_webcam)

# Capture and predict emotion
def capture_and_predict():
    global cap, live_feed_active, image_counter
    live_feed_active = False  # Stop the live feed
    ret, frame = cap.read()
    if ret:
        # Display captured image
        frame_rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
        captured_img = Image.fromarray(frame_rgb)
        imgtk = ImageTk.PhotoImage(image=captured_img)
        display_label.imgtk = imgtk
        display_label.configure(image=imgtk)

        # Predict emotion
        predicted_emotion, accuracy = predict_emotion(frame)
        result_label.config(
        text=f"Emotion Predicted: {predicted_emotion}\nAccuracy Model: {accuracy:.2f}%",
        font=("Arial", 16, "bold"), fg="blue")

        # Save the result
        save_result(frame, predicted_emotion, accuracy)

# Save the captured image and prediction result
def save_result(frame, emotion, accuracy):
    global image_counter, selected_cashier_id, selected_cashier_name
    if not selected_cashier_id:
        messagebox.showerror("Error", "Please select the cashier.")
        return

    # Create the results directory for the cashier if it doesn't exist
    cashier_dir = os.path.join('StaffData', selected_cashier_id)
    if not os.path.exists(cashier_dir):
        os.makedirs(cashier_dir)

    # Generate a unique filename
    timestamp = datetime.now().strftime("%Y_%m_%d_%H%M")
    image_filename = os.path.join(cashier_dir,f"img{image_counter}_{timestamp}.png")
    image_counter += 1

    # Save the image
    cv2.imwrite(image_filename, frame)

    # Save the prediction result in a CSV file named after the cashier's name
    csv_filename = os.path.join(cashier_dir,   
                            f"{selected_cashier_name}.csv")
    file_exists = os.path.isfile(csv_filename)
    with open(csv_filename, mode='a', newline='') as file:
        writer = csv.writer(file)
        if not file_exists:
            writer.writerow(["Timestamp", "ID", "Emotion", "Accuracy", "Image Filename"])
        writer.writerow([timestamp, f"img{image_counter-1}", emotion, f"{accuracy:.2f}%", image_filename])

# Initialize the image counter from the CSV file
def initialize_image_counter():

    global image_counter
    image_counter = 0
    for root, dirs, files in os.walk('results'):
        for file in files:
            if file.endswith(".csv"):
                csv_filename = os.path.join(root, file)
                with open(csv_filename, mode='r') as file:
                    reader = csv.reader(file)
                    next(reader)  # Skip the header
                    rows = list(reader)
                    if rows:
                        last_row = rows[-1]
                        last_id = last_row[1]
                        current_counter = int(last_id[3:]) + 1
                        if current_counter > image_counter:
                            image_counter = current_counter

# Load cashier data from CSV file
def load_cashier_data():
    cashier_data = []
    with open(csv_path, mode='r') as file:
        reader = csv.reader(file)
        next(reader)  # Skip the header
        for row in reader:
            cashier_id, cashier_name = row
            cashier_data.append(f"{cashier_id} - {cashier_name}")
    return cashier_data

# Restart the live feed
def restart_feed():
    global live_feed_active
    live_feed_active = True
    result_label.config(text="")
    update_webcam()

# Open the main application window
def open_main_window():
    global root, selected_cashier_id, selected_cashier_name

    selected_cashier = cashier_combobox.get()
    if not selected_cashier:
        messagebox.showerror("Error", "Please select the cashier.")
        return

    selected_cashier_id, selected_cashier_name = selected_cashier.split(" - ")

    # Close the cashier selection window
    cashier_selection_window.destroy()

    # Initialize the main window
    root = tk.Tk()
    root.title("Emotion Recognition")
    root.geometry("800x600")
    root.configure(bg="#8EE7E1")

    # Title
    title_label = tk.Label(root, text="CUSTOMER EMOTION IS IMPORTANT",
                            font=("Arial", 28, "bold"), bg="#8EE7E1", fg="black")
    title_label.pack(pady=10)

    # Display area for webcam and captured photo
    global display_label
    display_label = tk.Label(root , text="Webcam Feed", bg="gray", relief="solid")
    display_label.pack(pady=10, expand=True)

    # Bind the resize event to the resize_display_label function
    root.bind('<Configure>', resize_display_label)

    # Result label
    global result_label
    result_label = tk.Label(root, text="", font=("Arial", 18), bg="#8EE7E1", fg="black")
    result_label.pack(pady=10)

    # Buttons
    buttons_frame = tk.Frame(root, bg="#8EE7E1")
    buttons_frame.pack(pady=10)

    capture_button = tk.Button(buttons_frame, text="Capture",
                                command=capture_and_predict, bg="#4CAF50",
                                  fg="white", font=("Arial", 16), width=12)
    capture_button.grid(row=0, column=0, padx=10)

    restart_button = tk.Button(buttons_frame, text="Restart",
                                command=restart_feed, bg="#2196F3",
                                  fg="white", font=("Arial", 16), width=12)
    restart_button.grid(row=0, column=1, padx=10)

    exit_button = tk.Button(buttons_frame, text="Exit", command=close_app,
                             bg="#F44336", fg="white", font=("Arial", 16),
                               width=12)
    exit_button.grid(row=0, column=2, padx=10)

    # Initialize webcam
    global cap, live_feed_active
    cap = cv2.VideoCapture(0)
    live_feed_active = True
    initialize_image_counter()
    if not cap.isOpened():
        messagebox.showerror("Error", "Unable to access the webcam.")
    else:
        update_webcam()

    # Properly close the application
    root.protocol("WM_DELETE_WINDOW", close_app)
    root.mainloop()

# Close the application properly
def close_app():
    global cap
    if cap.isOpened():
        cap.release()
    root.destroy()

# Resize the display label based on window size
def resize_display_label(event):
    new_width = int(root.winfo_width() * 0.8)
    new_height = int(root.winfo_height() * 0.5)
    display_label.config(width=new_width, height=new_height)

# Initialize the cashier selection window
cashier_selection_window = tk.Tk()
cashier_selection_window.title("Select Staff")
cashier_selection_window.geometry("400x200")
cashier_selection_window.configure(bg="#8EE7E1")

# Cashier selection
cashier_label = tk.Label(cashier_selection_window, text="Select Staff:",
                          font=("Arial", 16), bg="#8EE7E1", fg="black")
cashier_label.pack(pady=5)
cashier_combobox = ttk.Combobox(cashier_selection_window, font=("Arial", 14))
cashier_combobox['values'] = load_cashier_data()
cashier_combobox.pack(pady=5)

# Confirm button
confirm_button = tk.Button(cashier_selection_window, text="Confirm", 
                        command=open_main_window, bg="#4CAF50", fg="white",
                         font=("Arial", 16), width=10)
confirm_button.pack(pady=20)

# Start the cashier selection window
cashier_selection_window.mainloop()