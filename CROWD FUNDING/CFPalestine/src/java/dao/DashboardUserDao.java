package dao;

import bean.DashboardUserBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author HP
 */

public class DashboardUserDao {
    public String dashboardUser(DashboardUserBean db){
        String fundername = db.getFunderName();
        String funderid = db.getFunderid();
        String fundingamount = db.getFundingamount();
        String fundingdate = db.getFundingdate();
        String projectid = db.getProjectid();
      
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String funderidDB = "";
        String fundernameDB = "";
        String fundingamountDB = "";
        String fundingdateDB = "";
        String projectidDB = "";

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery( "SELECT DONATE.FUNDERID, FUNDERS.FUNDERNAME, DONATE.FUNDINGAMOUNT, DONATE.FUNDINGDATE, DONATE.PROJECTID " +
                                                "FROM DONATE " +
                                                "JOIN FUNDERS ON DONATE.FUNDERID = FUNDERS.FUNDERID");


            while (resultSet.next()){
                funderidDB = resultSet.getString("funderid");
                fundernameDB = resultSet.getString("fundername");
                fundingamountDB = resultSet.getString("fundingamount");
                fundingdateDB = resultSet.getString("fundingdate");
                projectidDB = resultSet.getString("projectid");

                if (funderid.equals(funderidDB)&& fundername.equals(fundernameDB) && fundingamount.equals(fundingamountDB) && fundingdate.equals(fundingdateDB) && projectid.equals(projectidDB)){
                    return "SUCCESS";
                }
            }
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return "Invalid user credentials.";
    }
    
    public List<DashboardUserBean> getAllProject(){
        
        List projList = new LinkedList();        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "";
        String projIdDB = "";
        String funderIdDB = "";
//        LocalDate fundingDateDB = "YYYY-MM-DD";
        String fundernameDB = "";
        String fundingamountDB = "";
        String fundingdateDB = "";
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "SELECT DONATE.FUNDERID, FUNDERS.FUNDERNAME, DONATE.FUNDINGAMOUNT, DONATE.FUNDINGDATE, DONATE.PROJECTID " +
                  "FROM DONATE " +
                  "JOIN FUNDERS ON DONATE.FUNDERID = FUNDERS.FUNDERID";


            resultSet = statement.executeQuery(sql);

             while (resultSet.next()) {
                funderIdDB = resultSet.getString("funderid");
                fundernameDB = resultSet.getString("fundername");
                fundingamountDB = resultSet.getString("fundingamount");
                fundingdateDB = resultSet.getString("fundingdate");
                projIdDB = resultSet.getString("projectId");
                
                DashboardUserBean dub = new DashboardUserBean(funderIdDB, fundernameDB, fundingamountDB, fundingdateDB, projIdDB);
                projList.add(dub);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
//        finally {
//            // Close resources in reverse order of creation
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return projList;
    }
}
