package gui.contents.sub;

import system.Setup;

import javax.swing.*;
import java.awt.*;

public class GuideSubPanel extends JPanel {
    Font font = new Font(Setup.font, Font.BOLD, 14);
    public GuideSubPanel() {
        this.setLayout(new GridBagLayout());
        JLabel label = new JLabel("상품을 선택해서 정보를 변경할 수 있습니다.");
        label.setFont(font);
        this.add(label);
    }
}
