package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TVD
 */
public class DBConnect {

    public static Connection getConnection() {
        try {
            Connection cons = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cons = DriverManager.getConnection("jdbc:sqlserver://localhost:50642;databaseName=QLNVSach;"
                    + "user=sa;password=sa123456");
            return cons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }

}
