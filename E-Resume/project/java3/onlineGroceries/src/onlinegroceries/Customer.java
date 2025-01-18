package onlinegroceries;

public class Customer {
    
    //Declaration
    private String name;
    private String noPhone;
    private String email;
    private String address;
    private char delivery;
    private char membership;
    
    //Default constructor
    public Customer(){
        name = null;
        noPhone = null;
        email = null;
        address = null;
        delivery  = '\u0000';
        membership = '\u0000';
    }
    
    //Mutator : Setter
    public void setData(String cn, String np, String em, String adr, char dlv, char mbs){
        name = cn;
        noPhone = np;
        email = em;
        address = adr;
        delivery  = dlv;
        membership =  mbs;
    }
    
    //Accesor : Getter
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getNoPhone(){return noPhone;} 
    public String getAddress(){return address;}
    public char getDelivery(){return delivery;}
    public char getMembership(){return membership;}
    
    //Display customer data in receipt
    public void display(){
            System.out.println("\nName : "+ name);
            System.out.println("\nNumber Phone : "+ noPhone);
            System.out.println("\nEmail : "+ email);
            System.out.println("\nDelivery [ D - Delivery / P - Pick-Up ]: "+ delivery);
            System.out.println("\nAddress : "+ address);
            System.out.println("\nMembership [ Y - Yes / N - No ]: "+ membership);
        }
}

