/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UserBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author HP
 */

public class UserDao {
    
    public UserBean profileUser(int id){
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String userNameDB="";
        int idDB=0;
        String emailDB="";
        String phoneDB="";
        
        
        try{
            conn = DBConnection.createConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT FUNDERID,FUNDERUSERNAME,FUNDEREMAIL,FUNDERPHONE FROM funders where FUNDERID="+id);
            
            while(resultSet.next()){
                userNameDB = resultSet.getString("funderUsername");
                idDB = resultSet.getInt("funderId");
                emailDB = resultSet.getString("funderEmail");
                phoneDB = resultSet.getString("funderPhone");
                
                UserBean user = new UserBean(idDB,userNameDB,emailDB,phoneDB);
                return user;
            }  
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
           public String editUser(UserBean userBean){
        
        int id = userBean.getId();
        String name = userBean.getName();
        String email = userBean.getEmail();
        String phone = userBean.getNumPhone();

        Connection con = null;
        Statement statement = null;
        String sql = "";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            if (isExists(email)) {
                return "Email ALREADY EXISTS";
            }
            
            sql = "update funders set funderName='"+name+"',funderPhone='"+phone+"',funderEmail='"+email
                    + "' where funderId="+id;
            
//            return sql;
            statement.executeUpdate(sql);

            return "SUCCESS";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "FAILED. PLEASE TRY AGAIN";
    }
     public boolean isExists(String email) {

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "";
        String emailDB = "";

        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "select funderEmail FROM FUNDERs";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                emailDB = resultSet.getString("funderEmail");

                if (email.equals(emailDB)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
     
}
