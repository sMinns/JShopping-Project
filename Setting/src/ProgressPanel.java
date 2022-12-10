import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class ProgressPanel extends JPanel {
    ArrayList<Shape> shapeArray = new ArrayList<Shape>();
    int start = 90;
    public ProgressPanel() {
        setOpaque(false);
        Shape s;
        for (int i = 0; i < 10; i++) {
            s = new Arc2D.Float(10, 10, 300, 300, start, -25, Arc2D.PIE);
            start -= 36;
            shapeArray.add(s);
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fill(new Arc2D.Float(0, 0, 320, 320, 0, 360, Arc2D.PIE));
        int i = 0;
        for(Shape s : shapeArray) {
            if(i < (Progress.percent) / 10) {
                g2.setColor(new Color(232, 70, 77));
            }else if(i > (Progress.percent) / 10) {
                g2.setColor(new Color(255, 230, 230));
            }else {
                g2.setColor(new Color(232, 70, 77, (Progress.percent % 10)*15 + 100));
            }
            g2.fill(s);
            i++;
        }
        g2.setColor(Color.white);
        g2.fill(new Arc2D.Float(40, 40, 240, 240, 0, 360, Arc2D.PIE));
        g2.setColor(new Color(34, 34, 34));
        g2.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        if(Progress.percent == 100) {
            g2.drawString("세팅 완료", 80, 172);
        }else {
            g2.drawString(Progress.percent + " %", 120, 172);
        }
    }
}