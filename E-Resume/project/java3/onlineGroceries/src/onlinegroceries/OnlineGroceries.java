package onlinegroceries;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OnlineGroceries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Customer cus = new Customer();
        Item it = new Item();
                
        //welcome display
        System.out.println("\t=========================================");
        System.out.println("\t|\tWELCOME TO ONLINE GROCERIES\t|");
        System.out.println("\t=========================================\n\n");
        
        //Searching
        System.out.print("Do you want to search item [ Y - Yes / N - No ]: ");
        char sea = in.nextLine().charAt(0);                
        while(sea == 'Y' || sea == 'y'){
            System.out.print("\nItem [All capital letters e.g CHICKEN] : ");
            String search = in.nextLine();
            it.search(search);
            System.out.print("\nDo you want to search more item [ Y - Yes / N - No ]: ");
            sea = in.nextLine().charAt(0);
        }
        
        System.out.print("\nDo you want to start buy [ Y - Yes / N - No ]: ");
        char start = in.nextLine().charAt(0);
        
        if (start=='Y'||start=='y'){
            System.out.println("\n\t\t      CUSTOMER DATA");
            System.out.println("\t\t     ~~~~~~~~~~~~~~\n");

            //Input from user
            System.out.print("Name : ");
            String name = in.nextLine();
            System.out.print("Telephone Number : ");
            String noPhone = in.nextLine();
            System.out.print("Email [ Valid Email ] : ");
            String email = in.nextLine();
            System.out.print("Delivery Method [ D - Delivery / P - Pick-Up ] : ");
            char delivery = in.nextLine().charAt(0);
            System.out.print("Address [ Just in one line & If Pickup just ' - ' ]: ");
            String address = in.nextLine();
            System.out.print("Membership [ Y - Yes / N - No ] : ");
            char membership = in.nextLine().charAt(0);



            //Customer seacrh the code of item
            it.Catalog();

            //Initialize data 
            System.out.println("Just fill the code of item that you want [max 12] :-");
            char cart[] = new char[12];
            int quantity[] = new int[12];
            double price [] = new double[12];
            String itemName[] = new String[12];
            char cont = 'Y',itemCode = '\u0000';
            int k=0; 
            double totPrice=0.0, totalPrice=0.0;

            //Call setter from Item.java
            it.setDataItem(delivery, membership);

            //Loop for getting the items that user need & sort into the cartS
            while((cont == 'Y' || cont == 'y') && k<12){
                System.out.print((k+1)+".");
                System.out.print("Item code : ");
                itemCode = in.nextLine().charAt(0);
                cart[k]=itemCode;            
                System.out.print("  Quantity : ");
                quantity[k] = Integer.parseInt(in.nextLine());  
                if (itemCode=='G'||itemCode=='g'){
                    price[k]=5.00;
                    itemName[k]="Salt        ";}
                else if (itemCode=='S'||itemCode=='s'){
                    price[k]=3.50;
                    itemName[k]="Sugar       ";}
                else if (itemCode=='T'||itemCode=='t'){
                    price[k]=3.00;
                    itemName[k]="Wheat Flour ";}
                else if (itemCode=='R'||itemCode=='r'){
                    price[k]=2.00;
                    itemName[k]="Spices      ";}
                else if (itemCode=='C'||itemCode=='c'){
                    price[k]=9.00;
                    itemName[k]="Chicken 1kg ";}
                else if (itemCode=='M'||itemCode=='m'){
                    price[k]=11.00;
                    itemName[k]="Meat 1kg    ";}
                else if (itemCode=='F'||itemCode=='f'){
                    price[k]=7.00;
                    itemName[k]="Fish        ";}
                else if (itemCode=='V'||itemCode=='v'){
                    price[k]=5.00;
                    itemName[k]="Vegetable   ";}
                else if (itemCode=='K'||itemCode=='k'){
                    price[k]=5.40;
                    itemName[k]="Soy Sauce   ";}
                else if (itemCode=='Z'||itemCode=='z'){
                    price[k]=3.50;
                    itemName[k]="Chili Sauce ";}
                else if (itemCode=='E'||itemCode=='e'){
                    price[k]=2.30;
                    itemName[k]="Tomato Paste";}
                else if (itemCode=='H'||itemCode=='h'){
                    price[k]=3.30;
                    itemName[k]="Vinegar     ";}          

                price[k] = price[k]*quantity[k];           
                totPrice = totPrice + price[k];

                System.out.print("Continue [Y/N] : ");
                cont = in.nextLine().charAt(0);
                k++;
            }

            //Show Customer Cart
            System.out.println("\n\tCART :-");
            System.out.println("\t=*=*=*=");
            for(int c=0;c<k;c++){
                System.out.print((c+1)+"."+itemName[c]+"\t*\t"+quantity[c]+"\t=\tRM "); 
                System.out.format("%.2f", price[c]);
                System.out.println();
            }
            System.out.print("TOTAL = RM ");
            System.out.format("%.2f", totPrice);
            System.out.println();

            //User comfirmation & update data 
            char update='N';
            char add = 'Y';
            int a=0, extra;
            extra=12-k;
            while(update == 'N' || update == 'n'){
                    System.out.print("\nDo you want to confirm your cart or your data ? [ Y - Yes / N - No ] :");
                    update = in.nextLine().charAt(0);
                    if (update == 'N' || update == 'n'){
                        System.out.println("Press:- ");
                        System.out.print("\t1 - Change your Data\n\t2 - Update your cart\n:");
                        char choose = in.nextLine().charAt(0);

                        //update customer data
                        if(choose == '1'){
                            System.out.print("\nName : ");
                            String nname = in.nextLine();
                            System.out.print("Telephone Number : ");
                            String nnoPhone = in.nextLine();
                            System.out.print("Email [ Valid Email ] : ");
                            String nemail = in.nextLine();
                            System.out.print("Delivery Method [ D - Delivery / P - Pick-Up ] : ");
                            char ndelivery = in.nextLine().charAt(0);
                            System.out.print("Address [ Just in one line & If Pickup just ' - ' ]: ");
                            String naddress = in.nextLine();
                            System.out.print("Membership [ Y - Yes / N - No ] : ");
                            char nmembership = in.nextLine().charAt(0);

                            name = nname;
                            noPhone = nnoPhone;
                            email = nemail;
                            delivery = ndelivery;
                            address = naddress;
                            membership = nmembership;

                        }
                        //update item data
                        else if(choose == '2'){
                            for(int z=0;z<k;z++){                            
                                System.out.println("\n"+(z+1)+"."+itemName[z]+"\t>> "+quantity[z]);
                                System.out.print("Do you want to delete/update item list [X-delete / Y-update / N-no] : ");
                                char itemUp = in.nextLine().charAt(0);
                                if (itemUp == 'X' || itemUp == 'x'){
                                    totPrice=totPrice-price[z];                               
                                    price[z]=0.0;
                                    itemName[z]="    -      ";
                                    quantity[z]=0;
                                }
                                else if (itemUp == 'Y' || itemUp == 'y'){
                                    System.out.print("New item code [ Refer to ITEMS CODE list ^^ ] : ");
                                    cart[z]=in.nextLine().charAt(0);
                                    totPrice=totPrice-price[z];
                                    if (itemCode=='G'||itemCode=='g'){
                                        price[z]=5.00;
                                        itemName[z]="Salt        ";}
                                        else if (itemCode=='S'||itemCode=='s'){
                                            price[z]=3.50;
                                            itemName[z]="Sugar\t     ";}
                                        else if (itemCode=='T'||itemCode=='t'){
                                            price[z]=3.00;
                                            itemName[z]="Wheat Flour ";}
                                        else if (itemCode=='R'||itemCode=='r'){
                                            price[z]=2.00;
                                            itemName[z]="Spices      ";}
                                        else if (itemCode=='C'||itemCode=='c'){
                                            price[z]=9.00;
                                            itemName[z]="Chicken 1kg ";}
                                        else if (itemCode=='M'||itemCode=='m'){
                                            price[z]=11.00;
                                            itemName[z]="Meat 1kg    ";}
                                        else if (itemCode=='F'||itemCode=='f'){
                                            price[z]=7.00;
                                            itemName[z]="Fish\t      ";}
                                        else if (itemCode=='V'||itemCode=='v'){
                                            price[z]=5.00;
                                            itemName[z]="Vegetable   ";}
                                        else if (itemCode=='K'||itemCode=='k'){
                                            price[z]=5.40;
                                            itemName[z]="Soy Sauce   ";}
                                        else if (itemCode=='Z'||itemCode=='z'){
                                            price[z]=3.50;
                                            itemName[z]="Chili Sauce ";}
                                        else if (itemCode=='E'||itemCode=='e'){
                                            price[z]=2.30;
                                            itemName[z]="Tomato Paste";}
                                        else if (itemCode=='H'||itemCode=='h'){
                                            price[z]=3.30;
                                            itemName[z]="Vinegar     ";}

                                        System.out.print("Quantity : ");
                                        quantity[z] = Integer.parseInt(in.nextLine());
                                        price[z] = price[z]*quantity[z];           
                                        totPrice = totPrice + price[z];
                                    }                                
                            }
                            //Add Data
                            System.out.print("\nWant add more item [Y/N] : ");
                            add = in.nextLine().charAt(0);
                            while((add == 'Y' || add == 'y') && a<extra){
                                System.out.print((k+1)+".");
                                System.out.print("Item code : ");
                                itemCode = in.nextLine().charAt(0);
                                cart[k]=itemCode;            
                                System.out.print("  Quantity : ");
                                quantity[k] = Integer.parseInt(in.nextLine());  
                                if (itemCode=='G'||itemCode=='g'){
                                    price[k]=5.00;
                                    itemName[k]="Salt        ";}
                                else if (itemCode=='S'||itemCode=='s'){
                                    price[k]=3.50;
                                    itemName[k]="Sugar       ";}
                                else if (itemCode=='T'||itemCode=='t'){
                                    price[k]=3.00;
                                    itemName[k]="Wheat Flour ";}
                                else if (itemCode=='R'||itemCode=='r'){
                                    price[k]=2.00;
                                    itemName[k]="Spices      ";}
                                else if (itemCode=='C'||itemCode=='c'){
                                    price[k]=9.00;
                                    itemName[k]="Chicken 1kg ";}
                                else if (itemCode=='M'||itemCode=='m'){
                                    price[k]=11.00;
                                    itemName[k]="Meat 1kg    ";}
                                else if (itemCode=='F'||itemCode=='f'){
                                    price[k]=7.00;
                                    itemName[k]="Fish        ";}
                                else if (itemCode=='V'||itemCode=='v'){
                                    price[k]=5.00;
                                    itemName[k]="Vegetable   ";}
                                else if (itemCode=='K'||itemCode=='k'){
                                    price[k]=5.40;
                                    itemName[k]="Soy Sauce   ";}
                                else if (itemCode=='Z'||itemCode=='z'){
                                    price[k]=3.50;
                                    itemName[k]="Chili Sauce ";}
                                else if (itemCode=='E'||itemCode=='e'){
                                    price[k]=2.30;
                                    itemName[k]="Tomato Paste";}
                                else if (itemCode=='H'||itemCode=='h'){
                                    price[k]=3.30;
                                    itemName[k]="Vinegar     ";}          

                                price[k] = price[k]*quantity[k];           
                                totPrice = totPrice + price[k];

                                System.out.print("Want add more item [Y/N] : ");
                                add = in.nextLine().charAt(0);
                                a++;
                                k++;
                            }

                        }
                        System.out.println("\n\tCART :-");
                        System.out.println("\t=*=*=*=");
                        for(int c=0;c<k;c++){
                            System.out.print((c+1)+"."+itemName[c]+"\t*\t"+quantity[c]+"\t=\tRM "); 
                            System.out.format("%.2f", price[c]);
                            System.out.println();
                        }
                        System.out.print("TOTAL = RM ");
                        System.out.format("%.2f", totPrice);
                        System.out.println();
                    }
            }

            //call setter from Customer.java
            cus.setData(name, noPhone, email, address, delivery, membership);

            //Calculation: Total price after shipping cost and discount
            totalPrice=it.calcPrice(totPrice);
        
        
            //Receipt Display
            System.out.println ("\n\n\n- - - - - - - - - - - - - - - - - - - - - -");
            System.out.println ("                 RECEIPT                   ");
            System.out.println ("-------------------------------------------");
            System.out.println ("CUSTOMER DATA :-                           ");
            cus.display();
            System.out.println ("-------------------------------------------");
            System.out.println ("ITEMS         | QUANTITY   |  PRICE (RM)   ");
            System.out.println ("___________________________________________");
            for (int y=0;y<k;y++){
                System.out.print((y+1)+"."+itemName[y]+"\t    "+quantity[y]+"\t\t"); 
                System.out.format("%.2f", price[y]);
                System.out.println();
            }
            System.out.println ("___________________________________________");
            System.out.print("\t\t\t\t = ");
            System.out.format("%.2f", totPrice);
            System.out.println();
            System.out.println ("===========================================");
            if (delivery=='D'||delivery=='d'){
                System.out.println ("\t\t  Delivery charge - RM 5.00");            
                System.out.println ("===========================================");
            }
            if (membership=='Y'||membership=='y'){
                System.out.println ("\t\t\t\tMember - 5%");            
                System.out.println ("===========================================");
            }
            if (membership == 'Y'|| membership == 'y'){
                if (totPrice >= 200){
                    System.out.println ("\t\t     RM 200 an above - 10%");            
                    System.out.println ("===========================================");
                }

            }
            else if (membership == 'N' || membership == 'n'){
                if (totPrice >= 200){
                    System.out.println ("\t\t     RM 200 an above - 5%");            
                    System.out.println ("===========================================");
                }   
            }
            System.out.print ("TOTAL : RM ");
            System.out.format("%.2f", totalPrice);
            System.out.println ("\n___________________________________________");
        }
        else
            System.out.println("\t\n-THANK YOU-");
        
        //Local date and time for the receipt
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("\t\t\tdd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));
    }
    
}
