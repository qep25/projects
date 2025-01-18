package dao;

import bean.LoginUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class LoginUserDao {
    private int userId;
    
    public String authenticateUser(LoginUser loginUser){
        String funderusername=loginUser.getFunderusername();
        String funderpass=loginUser.getFunderpass();
        
        Connection conn=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String usernameDB="";
        String passwordDB="";
        int userIdDB=0;
        
        try{
            conn=DBConnection.createConnection();
            statement=conn.createStatement();
            resultSet=statement.executeQuery("SELECT funderId,funderusername,funderpass FROM funders");
            while(resultSet.next()){
                usernameDB=resultSet.getString("funderusername");
                passwordDB=resultSet.getString("funderpass");
                
                if(funderusername.equals(usernameDB)&&funderpass.equals(passwordDB)){
                    userIdDB=resultSet.getInt("funderId");
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
