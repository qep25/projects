package bean;

/**
 *
 * @author Smiling
 */
public class LoginUser implements java.io.Serializable{
     public String funderusername;
     public String funderpass;

    public LoginUser (){}

    public LoginUser(String funderusername, String funderpass) {
        this.funderusername = funderusername;
        this.funderpass = funderpass;
    }

    public String getFunderusername() {
        return funderusername;
    }

    public void setFunderusername(String funderusername) {
        this.funderusername = funderusername;
    }

    public String getFunderpass() {
        return funderpass;
    }

    public void setFunderpass(String funderpass) {
        this.funderpass = funderpass;
    }

   
    
}
