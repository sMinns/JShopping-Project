package custom;

import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Ellipse2D;

public class RadioType1 extends JRadioButton {
    public RadioType1(String text, Font font) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        setBackground(Setup.white);
        setForeground(Setup.darkGray);
        setFont(font);
        setText(text);
        setFocusPainted(false);
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
                g2.setColor(Setup.checkBoxBorderColor);
            }
            g2.fillOval(1, ly, 16, 16);
            g2.setColor(Setup.white);
            g2.fillOval(2, ly + 1, 14, 14);
            if (isEnabled()) {
                g2.setColor(Setup.magenta);
            } else {
                g2.setColor(Setup.checkBoxBorderColor);
            }
            g2.fillOval(5, ly + 4, 8, 8);
        }else {
            g2.setColor(Setup.checkBoxBorderColor);
            g2.fillOval(1, ly, 16, 16);
            g2.setColor(Setup.white);
            g2.fillOval(2, ly + 1, 14, 14);
        }
        g2.dispose();
    }


}
