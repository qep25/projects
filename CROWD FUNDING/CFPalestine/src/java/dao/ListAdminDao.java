/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import bean.ListFundAdmin;
import util.DBConnection;
import java.util.*;
/**
 *
 * @author Haikal
 */
public class ListAdminDao {
    int projectId;
    public ListFundAdmin getProjectById(int id){      
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "";
        int projIdDB = 0;
        String projNameDB = "";
        String projDescDB = "";
        String dateDB = null;
        
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "select * from project where projectId="+id;

            resultSet = statement.executeQuery(sql);

             while (resultSet.next()) {
                projIdDB = resultSet.getInt("projectId");
                projNameDB = resultSet.getString("projectName");
                dateDB = resultSet.getString("deadline");
                projDescDB = resultSet.getString("projectDescription");
                
                ListFundAdmin lfa = new ListFundAdmin(projIdDB,projNameDB,dateDB,projDescDB);
                return lfa;
             }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public List<ListFundAdmin> getAllProject(){
        
        List projList = new LinkedList();        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "";
        int projIdDB = 0;
        String projNameDB = "";
        String projDescDB = "";
        String dateDB = null;
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "select * from PROJECT";

            resultSet = statement.executeQuery(sql);

             while (resultSet.next()) {
                projIdDB = resultSet.getInt("projectId");
                projNameDB = resultSet.getString("projectName");
                dateDB = resultSet.getString("deadline");
                projDescDB = resultSet.getString("projectDescription");
                
                ListFundAdmin lfa = new ListFundAdmin(projIdDB,projNameDB,dateDB,projDescDB);
                projList.add(lfa);
             }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return projList;
    }
    
    public String editProject(ListFundAdmin lfa){
        int id=lfa.getProjId();
        String projName = lfa.getProjName();
        String projDesc = lfa.getProjDesc();
        String dateline = lfa.getDateline();

        Connection con = null;
        Statement statement = null;
        String sql = "";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            if (isExists(projName)) {
                return "PROJECT ALREADY EXISTS";
            }
            
            sql = "update Project set projectName='"+projName+"',projectDescription='"+projDesc+"',deadline='"+dateline
                    + "' where projectid="+id;
            
//            return sql;
            statement.executeUpdate(sql);

            return "SUCCESS";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "FAILED. PLEASE TRY AGAIN";
    }
    
    public String addProject(ListFundAdmin listProj){
        
       
        String projName = listProj.getProjName();
        String projDesc = listProj.getProjDesc();
        String dateline = listProj.getDateline();

        Connection con = null;
        Statement statement = null;
        String sql = "";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            if (isExists(projName)) {
                return "CATEGORY ALREADY EXISTS";
            }
            
            sql = "insert into PROJECT(PROJECTNAME,PROJECTDESCRIPTION,DEADLINE) values('"+projName+"','"+projDesc+"','"+dateline+"')";

            statement.executeUpdate(sql);

            return "SUCCESS";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "FAILED. PLEASE TRY AGAIN";
    }
//    
//    
    public String deleteProject(int projId){

        Connection con = null;
        Statement statement = null;
        String sql = "";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "delete from PROJECT where PROJECTid="+projId;

            statement.executeUpdate(sql);

            return "SUCCESS";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "FAILED. PLEASE TRY AGAIN";
    }
    
    public boolean isExists(String projName) {

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "";
        String projNameDB = "";

        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "select PROJECTNAME FROM PROJECT";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                projNameDB = resultSet.getString("projectName");

                if (projName.equals(projNameDB)) {
                    
                    return true;
                    
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    
}
