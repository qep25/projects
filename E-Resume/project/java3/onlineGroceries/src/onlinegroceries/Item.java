package onlinegroceries;

public class Item {
    
    //Declaration
    private char delivery;
    private char member;
    
    //default constructor
    public Item(){
        delivery  = '\u0000';
        member = '\u0000';
    }
    
    //Mutator : Setter
    public void setDataItem(char dlv, char mbs){ 
        delivery  = dlv;
        member =  mbs;
    }
    
    public void search(String search){
        if ("SALT".equals(search))
            System.out.println("Salt:-\nPrice : RM 5.00\nCode : G");
        else if ("SUGAR".equals(search))
            System.out.println("Sugar:-\nPrice : RM 3.50\nCode : S");
        else if ("WHEAT FLOUR".equals(search)||"FLOUR".equals(search))
            System.out.println("Wheat Flour:-\nPrice : RM 3.00\nCode : T");
        else if ("SPICES".equals(search))
            System.out.println("Spices:-\nPrice : RM 2.00\nCode : R");
        else if ("CHICKEN".equals(search))
            System.out.println("Chicken 1kg:-\nPrice : RM 9.00\nCode : C");
        else if ("MEAT".equals(search))
            System.out.println("Meat 1kg:-\nPrice : RM 11.00\nCode : M");
        else if ("FISH".equals(search))
            System.out.println("Fish:-\nPrice : RM 7.00\nCode : F");
        else if ("VEGETABLE".equals(search))
            System.out.println("Vegetable:-\nPrice : RM 5.00\nCode : V");
        else if ("SOY SAUCE".equals(search))
            System.out.println("Soy Sauce:-\nPrice : RM 5.40\nCode : K");
        else if ("CHILI SAUCE".equals(search))
            System.out.println("Chili Sauce:-\nPrice : RM 3.50\nCode : Z");
        else if ("TOMATO PASTE".equals(search))
            System.out.println("Tomato Paste:-\nPrice : RM 2.30\nCode : E");
        else if ("VINEGAR".equals(search))
            System.out.println("Vinegar:-\nPrice : RM 3.30\nCode : H");
        else
            System.out.println("\t-OUT OF STOCK-");
    }
    
    //Calculate total price 
    public double calcPrice(double tot_price){
        double memberDisc = 0.95;
        double shipCost = 5;
        double total=0.0;

        if (member == 'Y'|| member == 'y'){
            total = (tot_price*memberDisc);
            if (total >= 200)
                total = total*0.90;  
        }
        else if (member == 'N' || member == 'n'){
            total = tot_price ;
            if (total >= 200)
                total = total*0.95;
        }
        if (delivery == 'D'|| delivery == 'd')
                total=total+shipCost;        
        return total;
    }
    
    //Display Catalog
    public void Catalog(){
        System.out.println ("\n	---------------ITEMS CODE------------------");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	|               Dry Food                  |");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	| Code |         ITEM         | Price(RM) |");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	|  G   |       Salt(1kg)      |    5.00   |");
        System.out.println ("	|  S   |       Sugar(1kg)     |    3.50   |");
        System.out.println ("	|  T   |      Wheat Flour     |    3.00   |");
        System.out.println ("	|  R   |        Spices        |    2.00   |");
        System.out.println ("	-------------------------------------------\n");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	|               Wet Food                  |");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	| Code |         ITEM         | Price(RM) |");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	|  C   |      Chicken (1kg)   |    9.00   |");
        System.out.println ("	|  M   |       Meat (1kg)     |   11.00   |");
        System.out.println ("	|  F   |         Fish         |    7.00   |");
        System.out.println ("	|  V   |       Vegetable      |    5.00   |");
        System.out.println ("	-------------------------------------------\n");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	|            Bottle & Can                 |");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	| Code |         ITEM         | Price(RM) |");
        System.out.println ("	-------------------------------------------");
        System.out.println ("	|  K   |      Soy Sauce       |    5.40   |");
        System.out.println ("	|  Z   |     Chili Sauce      |    3.50   |");
        System.out.println ("	|  E   |     Tomato Paste     |    2.30   |");
        System.out.println ("	|  H   |       Vinegar        |    3.30   |");
        System.out.println ("	-------------------------------------------\n\n");
    }
   
}
