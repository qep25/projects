package dao;

import bean.RegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

/**
 *
 * @author Smiling
 */

public class RegisterDao {

    public String registerUser(RegisterBean registerBean) {
        String fundername = registerBean.getFundername();
        String funderemail = registerBean.getFunderemail();
        String funderphone = registerBean.getFunderphone();
        String funderusername = registerBean.getFunderusername();
        String funderpass = registerBean.getFunderpass();

        Connection con = null;
        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtInsert = null;
        ResultSet resultSet = null;

        try {
            con = DBConnection.createConnection(); // call from dbconnection class

            // Check if username or email already exists
            pstmtCheck = con.prepareStatement("SELECT COUNT(*) "
                                            + " FROM FUNDERS WHERE funderusername = ? OR funderemail = ?");
            pstmtCheck.setString(1, funderusername);
            pstmtCheck.setString(2, funderemail);

            resultSet = pstmtCheck.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Username or email already exists
                return "Username or email already exists";
            }

            // If not duplicate, proceed with insertion
            pstmtInsert = con.prepareStatement("INSERT INTO FUNDERS (fundername, funderemail, funderphone, funderusername, funderpass)"
                                             + "VALUES (?, ?, ?, ?, ?)");
            pstmtInsert.setString(1, funderusername);
            pstmtInsert.setString(2, funderemail);
            pstmtInsert.setString(3, funderphone);
            pstmtInsert.setString(4, funderusername);
            pstmtInsert.setString(5, funderpass);

            pstmtInsert.executeUpdate();
            con.close();

            return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmtCheck != null) {
                    pstmtCheck.close();
                }
                if (pstmtInsert != null) {
                    pstmtInsert.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "FAILED.";
    }
}
