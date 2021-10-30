import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Hotel";
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String userName = "sa";
    private static String paword = "123123";

    static {
        try {
            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, paword);
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
