import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DengJiUI extends JFrame implements ActionListener {
    JButton checkIn, customerInformation, historyRecord, remainingRoom, checkOut;

    DengJiUI() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void init() {
        checkIn = new JButton("入住登记");
        customerInformation = new JButton("客户信息");
        remainingRoom = new JButton("剩余房间查询");
        checkOut = new JButton("退房");

        checkIn.addActionListener(this);
        customerInformation.addActionListener(this);
        remainingRoom.addActionListener(this);
        checkOut.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(checkIn);
        panel.add(customerInformation);
        panel.add(remainingRoom);
        panel.add(checkOut);
        JButton welcome = new JButton("W E L C O M E");
        welcome.setBackground(Color.white);
        Dimension preferredSize = new Dimension(200, 100);
        welcome.setPreferredSize(preferredSize);
        add(welcome, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(new JLabel("客服电话:18175737312  报警电话：110"), BorderLayout.SOUTH);
        setLayout(new FlowLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkIn) {
            int x = this.getBounds().x + (this.getBounds().width) / 4;
            int y = this.getBounds().y - 80;
            CheckInDialog checkInDialog = new CheckInDialog();
            checkInDialog.setBounds(x, y, 240, 400);
            checkInDialog.setVisible(true);
            checkInDialog.setTitle("入住登记");
            checkInDialog.setResizable(false);
            checkInDialog.setIconImage(new ImageIcon("C:\\Users\\21170\\IdeaProjects\\酒店入住登记管理\\imag\\2.png").getImage());

        } else if (e.getSource() == customerInformation) {
            int x = this.getBounds().x;
            int y = this.getBounds().y;
            CustomerInformationDialog customerInformationDialog = new CustomerInformationDialog();
            customerInformationDialog.setBounds(x - 245, y - 80, 1000, 500);
            customerInformationDialog.setVisible(true);
            customerInformationDialog.setTitle("客户信息");
            customerInformationDialog.setIconImage(new ImageIcon("C:\\Users\\21170\\IdeaProjects\\酒店入住登记管理\\imag\\3.png").getImage());

        } else if (e.getSource() == remainingRoom) {
            int i = 25;
            int j = 0;
            try {
                Connection connection = JDBCUtil.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select *from tenants");

                while (resultSet.next()) {
                    j++;
                }
                connection.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            i = i - j;
            JOptionPane.showMessageDialog(this, "剩余房间：" + i, "剩余房间查询", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == checkOut) {
            Connection connection = null;
            String str = JOptionPane.showInputDialog(this, "请输入房号退房：", "退房", JOptionPane.PLAIN_MESSAGE);
            try {
                connection = JDBCUtil.getConnection();
                User user = new User(str);
                UserDao userDao = new UserDaoImpl();
                userDao.deleteUser(user);
                JOptionPane.showMessageDialog(this, "退房成功！", "退房进程", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException sqlee) {
                sqlee.printStackTrace();
            }
        }
    }
}
