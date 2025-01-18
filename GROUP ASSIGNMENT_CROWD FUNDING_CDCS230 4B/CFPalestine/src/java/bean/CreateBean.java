/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Haikal
 */
public class CreateBean {
    
    double amount;
    String date;
    int funderid;
    int projectId;

    public CreateBean(double amount, String date, int funderid, int projectId) {
        this.amount = amount;
        this.date = date;
        this.funderid = funderid;
        this.projectId = projectId;
    }

    public CreateBean() {
    }
    

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFunderid() {
        return funderid;
    }

    public void setFunderid(int funderid) {
        this.funderid = funderid;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    
    
}
