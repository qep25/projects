/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LoginAdmin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Haikal
 */
public class LoginAdminDao {
    private int userId;
    public String authenticateUser(LoginAdmin loginAdmin){
        String username=loginAdmin.getUsername();
        String password=loginAdmin.getPassword();
        
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String userNameDB="";
        String passwordDB="";
        int userIdDB = 0;
        
        try{
            conn=DBConnection.createConnection();
            statement=conn.createStatement();
            resultSet=statement.executeQuery("SELECT founderId,founderName,founderPass FROM founder");
            while(resultSet.next()){
                userNameDB=resultSet.getString("founderName");
                passwordDB=resultSet.getString("founderPass");
                
                
                if(username.equals(userNameDB)&&password.equals(passwordDB)){
                    userIdDB=resultSet.getInt("founderId");
                    setUserId(userIdDB);
                    return "SUCCESS";
                }
            }  
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    
}
