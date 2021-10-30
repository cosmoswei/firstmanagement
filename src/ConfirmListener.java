import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ConfirmListener implements ActionListener {
    JTextField inId, inName, inRoomNumber, inCheckInTime, inCheckOutTime;
    Connection connection = null;

    public void setInId(JTextField inId) {
        this.inId = inId;
    }

    public void setInName(JTextField inName) {
        this.inName = inName;
    }

    public void setInRoomNumber(JTextField inRoomNumber) {
        this.inRoomNumber = inRoomNumber;
    }

    public void setInCheckInTime(JTextField inCheckInTime) {
        this.inCheckInTime = inCheckInTime;
    }

    public void setInCheckOutTime(JTextField inCheckOutTime) {
        this.inCheckOutTime = inCheckOutTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            connection = JDBCUtil.getConnection();
            String conId = inId.getText();
            String conName = inName.getText();
            String conRoomNumber = inRoomNumber.getText();
            String conCheckInTime = inCheckInTime.getText();
            String conCheckOutTime = inCheckOutTime.getText();
            User user = new User(conName, conId, conRoomNumber, conCheckInTime, conCheckOutTime);
            UserDao userDao = new UserDaoImpl();
            userDao.addUser(user);
            connection.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
