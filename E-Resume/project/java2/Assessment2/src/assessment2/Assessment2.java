package assessment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Assessment2 {

    public static void ATsort(ArrayList<sjf> sjf){
        
        //sort arrival time by using insertion sort
        for(int i = 1; i < sjf.size(); i++){
            sjf currentElement = sjf.get(i);
            int index = i-1;
            while(index >= 0 && sjf.get(index).getAT() > currentElement.getAT()){
                sjf.set(index+1, sjf.get(index));
                index--;
            }
            sjf.set(index+1, currentElement);
        }
    }
    
    public static void BTsort(ArrayList<sjf> sjf){
        
        /* sort burst time using insertion sort
            only sort from element 2nd to nth element of the arraylist
        */
        for(int i = 2; i < sjf.size(); i++){
            sjf currentElement = sjf.get(i);
            int index = i-1;
            while(index >= 1 && sjf.get(index).getBT() > currentElement.getBT()){
                sjf.set(index+1, sjf.get(index));
                index--;
            }
            sjf.set(index+1, currentElement);
        } 
    }
    
    public static void executing(ArrayList<sjf> sjf){
        
        int time = 0;
        int holdTime = 1;
        
        for(int i = 1; i <= sjf.size(); i++){
            
            boolean execut = false;
            while(!execut){
                int counter = 0;//for current job executing loop
                
                if(sjf.get(i-1).getAT() <= time){
                    
                    //current job executing
                    while(counter < sjf.get(i-1).getBT()){
                        time++;
                        System.out.println("Job " + sjf.get(i-1).getProcess() + " is executing...");
                        
                        //job in hold loop
                        //using the index of arraylist element as initialization
                        int c = i;
                        while(c < sjf.size())
                        {
                            if(((sjf.get(c).getAT()+1) <= time-1) ){
                                System.out.println("Job " + sjf.get(c).getProcess() + " is in hold for " + (time - sjf.get(c).getAT()) + " ms...");
                            }
                            ++c;
                        }//end of job in hold while
                        holdTime++;
                        
                        //arrived job
                        //loop for the whole arraylist to find the job that has arrived
                        int a = sjf.size();
                        while(a > 1)
                        {
                            if(sjf.get(a-1).getAT() == time-1 && sjf.get(a-1).getAT() != sjf.get(a-1).getET())
                            {
                                System.out.println("Job " + sjf.get(a-1).getProcess() + " has arrived...");
                            }
                            --a;
                        }//end arrived job while

                        System.out.println("\nTime: " + time);
                        
                        counter++;
                    }//end executing job while
                    
                    //putting the completion, turnaround, and waiting time
                    sjf.get(i-1).setCT(time);
                    sjf.get(i-1).setTAT(sjf.get(i-1).getCT() - sjf.get(i-1).getAT()); //calculation for turnaround time
                    sjf.get(i-1).setWT(sjf.get(i-1).getTAT() - sjf.get(i-1).getBT()); // calculation for waiting time
                    
                }//end if

                if(counter != sjf.get(i-1).getBT())
                    System.out.println("\nTime: " + (time+1));

                //stop the exec loop
                if(counter == sjf.get(i-1).getBT())
                        execut = true;
                else
                    time++;
                
                //set the executing time for element 2nd to nth element
                if(i < sjf.size())
                    sjf.get(i).setET(time);
            }//end of exec while   
        }
    }
    
    public static void sortJob(ArrayList<sjf> sjf){
        
        //sort job position back by using insertion sort
        for(int i = 1; i < sjf.size(); i++){
            sjf currentElement = sjf.get(i);
            int index = i-1;
            while(index >= 0 && sjf.get(index).getProcess() > currentElement.getProcess()){
                sjf.set(index+1, sjf.get(index));
                index--;
            }
            sjf.set(index+1, currentElement);
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Declaration of ADT arraylist from class sjf
        ArrayList<sjf> qSJF = new ArrayList<>();
        
        System.out.println("\t\tCPU SCHEDULING");
        System.out.println("\t\t--------------");
        
        System.out.print("\nEnter number of job: ");
        int n = input.nextInt();
        char job = 'A';

        //prompt user to input the job, arrival and burst time
        for (int i=0; i < n; i++)
        {
            System.out.println("\nJob "+job);
            System.out.print("Arrival time: ");
            int at = input.nextInt();
            System.out.print("Burst time: ");
            int bt = input.nextInt();
            
            sjf temp = new sjf(job, at, bt);
            qSJF.add(temp);      
            job++;
        }
        
        //sorting the arrival and burst time using insertion sort
        ATsort(qSJF);
        BTsort(qSJF);
        
        //executing method, full detail at line 38 - 106
        executing(qSJF);
        
        //calculating average turnaround & waiting time
        double avgTAT = 0.0, avgWT = 0.0;
        for(int a = 0; a < qSJF.size(); a++){
            avgTAT += qSJF.get(a).getTAT();
            avgWT += qSJF.get(a).getWT();
        }
        avgTAT/= qSJF.size();
        avgWT /= qSJF.size();
        //end of calculating average
        
        //end and display the average for turnaround and waiting time
        System.out.println("END");
        
        //Sort the job to original location or place
        sortJob(qSJF);
        
        //Display table
        System.out.println("\nJob | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting Time");
        for(int i=0;i<n;i++)
        {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(qSJF.get(i).getProcess()+"\t"+qSJF.get(i).getAT()+"\t\t"+qSJF.get(i).getBT()+"\t\t"+qSJF.get(i).getCT()+"\t\t"+qSJF.get(i).getTAT()+"\t\t"+qSJF.get(i).getWT());
        }
        
        //Show the Average of  turn around time and waiting time
        System.out.println("\nAverage turn-around time: " + avgTAT + " ms");
        System.out.println("Average waiting time: " + avgWT + " ms");
        
        qSJF.clear();//clear the list after program end
    }    
}
