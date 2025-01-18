/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author HP
 */

public class UserBean {
    public int id;
    public String name;
    public String email;
    public String numPhone;

    public UserBean(int id, String name, String email, String numPhone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.numPhone = numPhone;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }
   
    
    

    
    

    
}
