package gui.contents.main;


import gui.contents.sub.FindID;
import gui.contents.sub.FindPassword;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static system.Setup.textFieldBorderColor;

public class FindIdPw extends JPanel implements MouseListener {
    private JLabel idLabel;
    private JLabel passwdLabel;
    private JLayeredPane findLayerPanel;
    public FindIdPw(boolean id) {
        Setup.changeInsets(10, 0, 10, 0);
        this.setBackground(textFieldBorderColor);
        GridBagLayout findtitleLayout = new GridBagLayout();
        findtitleLayout.columnWidths = new int[]{0, 0};
        findtitleLayout.rowHeights = new int[]{140, 0, 0};
        findtitleLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        findtitleLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        this.setLayout(findtitleLayout);

        JPanel findPanel = new JPanel();
        GridBagConstraints findBagCon = new GridBagConstraints();
        findBagCon.insets = new Insets(0, 0, 1, 0);
        findBagCon.fill = GridBagConstraints.BOTH;
        findBagCon.gridx = 0;
        findBagCon.gridy = 0;
        this.add(findPanel, findBagCon);

        GridBagLayout findTitlePanel = new GridBagLayout();
        findTitlePanel.columnWidths = new int[]{255, 111, 49, 76, 0, 0};
        findTitlePanel.rowHeights = new int[]{78, 0, 0};
        findTitlePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        findTitlePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        findPanel.setLayout(findTitlePanel);

        findLayerPanel = new JLayeredPane();
        findBagCon.insets = new Insets(0, 0, 0, 0);
        findBagCon.gridx = 0;
        findBagCon.gridy = 1;
        this.add(findLayerPanel, findBagCon);

        idLabel = new JLabel("아이디 찾기");
        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        idLabel.addMouseListener(this);
        findBagCon.gridx = 1;
        findBagCon.gridy = 1;
        findPanel.add(idLabel, findBagCon);

        passwdLabel = new JLabel("비밀번호 찾기");
        passwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        passwdLabel.addMouseListener(this);
        findBagCon.gridx = 3;
        findBagCon.gridy = 1;
        findPanel.add(passwdLabel, findBagCon);

        findLayerPanel.setLayout(new CardLayout(0, 0));
        if(id)
            changeIdFind();
        else
            changePasswdFind();
    }

    public void changeIdFind() {
        passwdLabel.setForeground(Setup.textGray);
        idLabel.setForeground(Setup.magenta);
        Setup.changeFindPanel(findLayerPanel, new FindID());
    }
    public void changePasswdFind() {
        passwdLabel.setForeground(Setup.magenta);
        idLabel.setForeground(Setup.textGray);
        Setup.changeFindPanel(findLayerPanel, new FindPassword());
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == idLabel) {
            changeIdFind();
        }else if(e.getSource() == passwdLabel) {
            changePasswdFind();
        }
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}
