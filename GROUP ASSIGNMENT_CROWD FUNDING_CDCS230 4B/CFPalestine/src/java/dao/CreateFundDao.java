package dao;

/**
 *
 * @author HP
 */

import bean.CreateBean;
import bean.ListFund;
import bean.ListFund.listFundDAO;
import bean.ListFundAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CreateFundDao {
    public String addFund(CreateBean createFund){
        
       
        String date = createFund.getDate();
        int fundid = createFund.getFunderid();
        double amount = createFund.getAmount();
        int projid =createFund.getProjectId();

        Connection con = null;
        Statement statement = null;
        String sql = "";
        PreparedStatement pstmtInsert = null;
        ResultSet resultSet = null;

        try {
//            con = DBConnection.createConnection();
//            statement = con.createStatement();
//
//            
//            
//            sql = "insert into Donate(FUNDINGAMOUNT,FUNDINGDATE,FUNDERID,PROJECTID) values("+amount+",'"+date+"',"+fundid+","+projid+")";
//            
//     
            
            

        
            con = DBConnection.createConnection(); // call from dbconnection class

            // Check if username or email already exists
            

            // If not duplicate, proceed with insertion
            pstmtInsert = con.prepareStatement("INSERT INTO Donate(FUNDINGAMOUNT,FUNDINGDATE,FUNDERID,PROJECTID) "
                                             + "VALUES (?, ?, ?, ?)");
            pstmtInsert.setDouble(1, amount);
            pstmtInsert.setString(2, date);
            pstmtInsert.setInt(3, fundid);
            pstmtInsert.setInt(4, projid);

            pstmtInsert.executeUpdate();
            con.close();
            return "SUCCESS";

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "FAILED. PLEASE TRY AGAIN";
    }
    
}
