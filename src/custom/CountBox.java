package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CountBox extends JPanel {
    private JLabel minusButton, plusButton, countLabel;
    private int count = 1;
    public CountBox(int count) {
        this.count = count;
        this.setBorder(new EmptyBorder(3, 5, 3, 5));
        this.setBackground(Setup.white);
        this.setBorder(BorderFactory.createLineBorder(Setup.checkBoxBorderColor, 2));

        GridBagLayout searchTextLayout = new GridBagLayout();
        searchTextLayout.columnWidths = new int[]{20, 40, 20, 0, 0};
        searchTextLayout.rowHeights = new int[]{0, 0};
        searchTextLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        searchTextLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        this.setLayout(searchTextLayout);

        GridBagConstraints searchBagCon = new GridBagConstraints();
        minusButton = new JLabel();
        minusButton.setIcon(new ImageIcon(CountBox.class.getResource("/images/countminus.png")));
        this.add(minusButton, searchBagCon);


        countLabel = new JLabel(count + "");
        countLabel.setFont(new Font(Setup.font, Font.PLAIN, 14));
        countLabel.setForeground(Setup.darkGray);
        searchBagCon.gridx = 1;
        this.add(countLabel, searchBagCon);


        plusButton = new JLabel();
        plusButton.setIcon(new ImageIcon(CountBox.class.getResource("/images/countplus.png")));
        searchBagCon.gridx = 2;
        this.add(plusButton, searchBagCon);
    }

    public int getCount() { return count; }

    public JLabel getMinusButton() {
        return minusButton;
    }

    public JLabel getPlusButton() {
        return plusButton;
    }

    public void setCountLabel(String text) {
        countLabel.setText(text);
    }
}
