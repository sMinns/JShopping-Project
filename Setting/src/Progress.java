import javax.swing.*;
import java.awt.*;

public class Progress extends JFrame {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int x = screenSize.width / 2 - 165;
    public static int y = screenSize.height / 2 - 165;
    public static int percent = 0;
    public static JPanel prog;
    public Progress() {
        setUndecorated(true);
        setBackground(new Color(0, 0, 0 ,0));
        setBounds(x, y, 330, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prog = new ProgressPanel();
        add(prog);
        setVisible(true);
    }
}

