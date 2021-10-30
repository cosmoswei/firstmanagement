import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    Connection connection;

    @Override
    public void addUser(User user) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into tenants values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getRoomNumber());
            preparedStatement.setString(4, user.getDatein());
            preparedStatement.setString(5, user.getDateout());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
    }

    @Override
    public void updataUser(User user) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into tenants values(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getId());
            preparedStatement.setString(3, user.getRoomNumber());
            preparedStatement.setString(4, user.getDatein());
            preparedStatement.setString(5, user.getDateout());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            connection = JDBCUtil.getConnection();
            String sql = "delete from tenants where roomNumber=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getRoomNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
    }
}
