import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        DengJiUI hxwJd = new DengJiUI();
        hxwJd.setTitle("宇宙大酒店客户登记系统");
        Dimension screening = Toolkit.getDefaultToolkit().getScreenSize();
        hxwJd.setBounds(screening.width / 2 - 250, screening.height / 2 - 220, 500, 220);
        hxwJd.setResizable(false);
        hxwJd.setIconImage(new ImageIcon("C:\\Users\\21170\\IdeaProjects\\酒店入住登记管理\\imag\\1.png").getImage());
    }
}
