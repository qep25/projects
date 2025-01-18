package bean;

/**
 *
 * @author HP
 */
public class DashboardUserBean implements java.io.Serializable{
    public String funderid;
    public String funderName;
    public String fundingamount;
    public String fundingdate;
    public String projectid;

    public DashboardUserBean() {
    }

    public DashboardUserBean(String funderid, String funderName, String fundingamount, String fundingdate, String projectid) {
        this.funderid = funderid;
        this.funderName = funderName;
        this.fundingamount = fundingamount;
        this.fundingdate = fundingdate;
        this.projectid = projectid;
    }


    public String getFunderid() {
        return funderid;
    }

    public void setFunderid(String funderid) {
        this.funderid = funderid;
    }

    public String getFunderName() {
        return funderName;
    }

    public void setFunderName(String funderName) {
        this.funderName = funderName;
    }

    public String getFundingamount() {
        return fundingamount;
    }

    public void setFundingamount(String fundingamount) {
        this.fundingamount = fundingamount;
    }

    public String getFundingdate() {
        return fundingdate;
    }

    public void setFundingdate(String fundingdate) {
        this.fundingdate = fundingdate;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }
}