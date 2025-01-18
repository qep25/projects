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
public class AdminBean {
    int id;
    String username;
    int projId;

    public AdminBean(int id, String username, int projId) {
        this.id = id;
        this.username = username;
        this.projId = projId;
    }

//    public AdminBean(String userNameDB, int idDB, int projidDB) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProjId() {
        return projId;
    }

    public void setProjId(int projId) {
        this.projId = projId;
    }

   
}
