#include <iostream>
#include <cctype>
#include <iomanip>
using namespace std;

/*The purpose of this program: To get the Employee's data and find the Employee's net pay weekly.
Assignment 3 
Author: Danial Thaqif Bin Mohamed Fikri (2020603134)
Date: 22 Oct 2020 */


//Function to get all input data from user
void inputData (int&id, string&name, double&hours){
	cout<<"Employee ID = ";
	cin>>id;
	cout<<"Employee First Name = ";
    cin>>name;
	cout<<"Hours worked per week (hours) = ";
	cin>>hours;
}

//Function to calculate gross Pay
double calcGross(double hours){
	double gross;
	
	if (hours<=40)
	    gross=hours*8.0; 
	   
	else if (hours<=50)
	        gross=(hours-40)*12+320; //320 = 40 * 8 >> 12 = 8*1.5
	        
	else
	    gross=(hours-50)*16+440; //440 = 320 + (10 * 12) >> 16 = 8*2
	    
	return gross;
}

//Function to calculate deduction
double calcDeduc(double gross){
	double deduc;
	
	deduc =(gross*0.19)+10; //0.19 = 0.08(income tax) + 0.11(KWSP) >> 10(the employee’s union)
	
	return deduc;
}

//Function to calculate net pay
double calcNet(double gross, double deduc){
	double net;
	
	net=gross-deduc;
	
	return net;
}

//Function to find highest net
double highNet(double net, double&high){
	
	if (net>high)
	    high=net;
	
	return high;
}

//Function to find highest name
void highnetname(double net, double&high, string name, string&hname){
	
	if (net>high)
	    hname=name;
}


//Main function
int main (){
	int id, n=0, u1200=0;
	string name, hname;
	double hours, gross, deduc, net, month, high=-999999999;
	char confirm='y';
    
    cout<<"Fill the data of the employees below : "<<endl;
    
    //Loop to find the employees data and net pay
    while(tolower(confirm)!='n'){
    	
    	//display the number of employee
		cout<<"\n\t\t\t\t\t\tEmployee "<<n+1<<endl<<endl;
    	
		//Function to get all input data from user caller
		inputData (id, name, hours);

		//Function to calculate gross Pay caller
    	gross=calcGross(hours);
    	cout<<"Gross Pay = RM ";
		cout<<fixed<<setprecision(2)<<gross<<endl; //Fix the decimal point to 2d.p.
		
		//Function to calculate deduction caller
    	deduc=calcDeduc(gross);
    	cout<<"Deduction = RM ";
    	cout<<fixed<<setprecision(2)<<deduc<<endl; //Fix the decimal point to 2d.p.
    	
    	//Function to calculate net pay caller
    	net=calcNet(gross,deduc);
    	cout<<"The Net Pay = RM ";
    	cout<<fixed<<setprecision(2)<<net<<endl; //Fix the decimal point to 2d.p.
    	
    	//Function to find the highest among the employees caller
        highnetname(net, high, name, hname);
    	high=highNet(net,high);
    	
    	//Calculation and process to find the total employees is under paid which RM1200 per month
    	month=net*4;
    	if (month<1200)
    	    u1200++;
    	
    	//updating 
    	n++;
    	cout<<"Do you want to continue (y/n) : ";
    	cin>>confirm;
    
	}
	
	//OUTPUT statement
	cout<<"\n\nTHE TOTAL OF EMPLOYEES : "<<n<<endl;
	cout<<"THE HIGHEST PAID :- "<<endl;
	cout<<"\t\t\t\t\t\t"<<hname<<endl;
	cout<<"\t\t\t\t\t     (RM "<<high<<")"<<endl;
	cout<<"THE TOTAL OF EMPLOYEES THAT PAID BELOW RM 1200 per month : "<<u1200<<endl;
	
	cout<<"\n\t-THANK YOU-"<<endl;
	
	return 0;

}
