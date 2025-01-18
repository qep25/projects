package bean;

/**
 *
 * @author Smiling
 */
public class homeBean implements java.io.Serializable{
//    public String projectid;
    public String projectname;
    public String projectdescription;
    public String deadline;

    public homeBean() {
    }

    public homeBean(String projectname, String projectdescription, String deadline) {
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.deadline = deadline;
    }
    
    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    
}
