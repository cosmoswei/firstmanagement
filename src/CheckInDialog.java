import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class CheckInDialog extends JFrame implements ActionListener {
    JLabel id, name, roomNumber, checkInTime, checkOutTime;
    JTextField inId, inName, inRoomNumber, inCheckInTime, inCheckOutTime;
    ConfirmListener confirmListener;
    Connection con = null;

    CheckInDialog() {
        CheckInDialogInit();
    }

    void CheckInDialogInit() {
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setVgap(10);
        setLayout(flowLayout);
        id = new JLabel("身份证号码：");
        name = new JLabel("客户姓名：");
        roomNumber = new JLabel("房间号码：");
        checkInTime = new JLabel("入住时间：");
        checkOutTime = new JLabel("退房时间：");

        inCheckInTime = new JTextField(20);
        inId = new JTextField(20);
        inCheckOutTime = new JTextField(20);
        inName = new JTextField(20);
        inRoomNumber = new JTextField(20);

        add(id);
        add(inId);
        add(name);
        add(inName);
        add(roomNumber);
        add(inRoomNumber);
        add(checkInTime);
        add(inCheckInTime);
        add(checkOutTime);
        add(inCheckOutTime);

        JButton button = new JButton("确认登记");
        add(button, BorderLayout.SOUTH);

        confirmListener = new ConfirmListener();
        confirmListener.setInName(inName);
        confirmListener.setInId(inId);
        confirmListener.setInRoomNumber(inRoomNumber);
        confirmListener.setInCheckInTime(inCheckInTime);
        confirmListener.setInCheckOutTime(inCheckOutTime);

        button.addActionListener(confirmListener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
