import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerInformationDialog extends JFrame{
    JTable table;
    Object a[][];
    Object name[] = {"身份证号码", "姓名", "房间号码", "入住时间", "退房时间"};

    CustomerInformationDialog() {
        a = new Object[25][5];
        try {
            Connection connection = JDBCUtil.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select *from tenants");
            int i=0;
            while(resultSet.next()){
                a[i][0]=resultSet.getString(2);
                a[i][1]=resultSet.getString(1);
                a[i][2]=resultSet.getString(3);
                a[i][3]=resultSet.getString(4);
                a[i][4]=resultSet.getString(5);
                i++;
            }
            connection.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        table = new JTable(a, name);
        Container com = getContentPane();
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);

        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
    }
}
