package gui.contents.sub;

import system.Setup;

import javax.swing.*;
import java.awt.*;

public class GuideSubPanel extends JPanel {
    Font font = new Font(Setup.font, Font.BOLD, 14);
    public GuideSubPanel(String text) {
        this.setLayout(new GridBagLayout());
        JLabel label = new JLabel(text);
        label.setFont(font);
        this.add(label);
    }
}
