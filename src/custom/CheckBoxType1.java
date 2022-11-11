package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckBoxType1 extends JCheckBox {
    private final int BORDER = 4;
    public CheckBoxType1(String text, Font font) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setBackground(Setup.Gray);
        setForeground(Setup.darkGray);
        setFont(font);
        setText(text);
        setFocusPainted(false);
    }
    public CheckBoxType1() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setBackground(Setup.Gray);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int ly = (getHeight() - 16) / 2;
        if (isSelected()) {
            if (isEnabled()) {
                g2.setColor(Setup.magenta);
            } else {
                g2.setColor(Setup.darkGray);
            }
            g2.fillRoundRect(1, ly, 16, 16, BORDER, BORDER);

            int px[] = {4, 8, 14, 12, 8, 6};
            int py[] = {ly+8, ly+14, ly+5, ly+3, ly+10, ly+6};
            g2.setColor(Setup.white);
            g2.fillPolygon(px, py, px.length);
        } else {
            g2.setColor(Setup.white);
            g2.fillRoundRect(1, ly, 16, 16, BORDER, BORDER);
            g2.setColor(Setup.checkBoxBorderColor);
            g2.drawRoundRect(1, ly, 16, 16, BORDER, BORDER);
        }
    }
}
