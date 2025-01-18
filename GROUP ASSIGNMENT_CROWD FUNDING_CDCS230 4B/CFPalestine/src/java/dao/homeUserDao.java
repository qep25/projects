package dao;

import bean.homeBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author ASUS
 */
public class homeUserDao {
    public String homeUser(homeBean hb){
      String projectname = hb.getProjectname();
      String projectdescription = hb.getProjectdescription();
      String deadline = hb.getDeadline();
      
      Connection con = null;
      Statement statement = null;
      ResultSet resultSet = null;
      String projectDB = "";
      String descriptionDB = "";
      String deadlineDB = "";
      
      try {
          con = DBConnection.createConnection();
          statement = con.createStatement();
          resultSet = statement.executeQuery("Select projectname, projectdescription, deadline from app.project");
          
          while (resultSet.next()){
              projectDB = resultSet.getString("projectname");
              descriptionDB = resultSet.getString("projectdescription");
              deadlineDB = resultSet.getString("deadline");
              
              if (projectname.equals(projectDB)&& projectdescription.equals(descriptionDB)&& deadline.equals(deadlineDB)){
                  return "SUCCESS";
              }
          }
      }catch(SQLException e){
          e.printStackTrace();
      }
      return "Invalid user credentials.";
    }
}