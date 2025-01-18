package dao;

/**
 *
 * @author HP
 */

import bean.ListFund;
import bean.ListFund.listFundDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import util.DBConnection;

public class ListFundDAO implements listFundDAO {

    public List<ListFund> getListFund() throws SQLException {
        
        List projList = new LinkedList();        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "";
        int projIdDB = 0;
//        String projIdDB = "";
        String fundIdDB = "";
        LocalDate dateDB = null;
        String titleDB = "";
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            sql = "SELECT * from DONATE";

            resultSet = statement.executeQuery(sql);

             while (resultSet.next()) {
//                projIdDB = resultSet.getInt("projectId");
                fundIdDB = resultSet.getString("funderId");
                dateDB = resultSet.getDate("date").toLocalDate();
                titleDB = resultSet.getString("title");
                
                ListFund lfa = new ListFund(fundIdDB,dateDB,titleDB);
                projList.add(lfa);
             }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return projList;
        
    }
}