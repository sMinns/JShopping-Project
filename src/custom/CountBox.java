package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CountBox extends JPanel implements MouseListener {
    private JLabel minusButton, plusButton, countLabel;
    private int count = 1;
    public CountBox() {
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
        minusButton.addMouseListener(this);
        this.add(minusButton, searchBagCon);


        countLabel = new JLabel(count + "");
        countLabel.setFont(new Font(Setup.font, Font.PLAIN, 14));
        countLabel.setForeground(Setup.darkGray);
        searchBagCon.gridx = 1;
        this.add(countLabel, searchBagCon);


        plusButton = new JLabel();
        plusButton.setIcon(new ImageIcon(CountBox.class.getResource("/images/countplus.png")));
        plusButton.addMouseListener(this);
        searchBagCon.gridx = 2;
        this.add(plusButton, searchBagCon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == plusButton) {
            if(count == 10) { return; }
            count++;
            countLabel.setText(count + "");
        } else if (e.getSource() == minusButton) {
            if(count == 1) { return; }
            count--;
            countLabel.setText(count + "");
        }
    }
    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
}
