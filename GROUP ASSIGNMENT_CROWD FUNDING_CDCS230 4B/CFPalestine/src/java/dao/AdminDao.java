/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.AdminBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Haikal
 */
public class AdminDao {
    public AdminBean profileAdmin(int id){
//        String username=loginAdmin.getUsername();
//        int id=loginAdmin.getId();
//        int projid=loginAdmin.getProjId();
        
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String userNameDB="";
        int idDB=0;
        int projidDB=0;
        
        try{
            conn=DBConnection.createConnection();
            statement=conn.createStatement();
            resultSet=statement.executeQuery("SELECT founderId,founderName,projectId FROM founder where founderId="+id);
            
            while(resultSet.next()){
                userNameDB=resultSet.getString("founderName");
                idDB=resultSet.getInt("founderId");
                projidDB=resultSet.getInt("projectId");
                
                AdminBean admin = new AdminBean(idDB,userNameDB,projidDB);
                return admin;
//                if(username.equals(userNameDB)){
//                    
//                }
            }  
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
