package bean;

public class RegisterBean implements java.io.Serializable{
    String fundername;
    String funderemail;
    String funderphone;
    String funderusername;
    String funderpass;

    public RegisterBean() {
    }

    public String getFundername() {
        return fundername;
    }

    public void setFundername(String fundername) {
        this.fundername = fundername;
    }

    public String getFunderemail() {
        return funderemail;
    }

    public void setFunderemail(String funderemail) {
        this.funderemail = funderemail;
    }

    public String getFunderphone() {
        return funderphone;
    }

    public void setFunderphone(String funderphone) {
        this.funderphone = funderphone;
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
