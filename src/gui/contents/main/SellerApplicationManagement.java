package gui.contents.main;

import database.SellerApplicationManagementDB;
import gui.contents.sub.GuideSubPanel;
import gui.contents.sub.SellerApplicationSubPanel;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SellerApplicationManagement extends JPanel implements MouseListener {
    private Font font1 = new Font(Setup.font, Font.BOLD, 16);
    private Font font2 = new Font(Setup.font, Font.BOLD, 14);
    private JLabel countLabel;
    private JLabel[] applicantTitleLabel = new JLabel[5];
    private String[] applicantTitleText = {"고객번호", "신청자 이름", "연락처", "사업자등록번호", "신청일"};
    private JPanel lastClickApplication = null;
    private JLayeredPane subLayerPanel;
    private List<List<String>> str = SellerApplicationManagementDB.sellerApplicationList();
    private JPanel[] ApplicationInfoPanel = new JPanel[str.size()];
    private JLabel[][] ApplicationInfo = new JLabel[str.size()][5];

    String text = null;
    public SellerApplicationManagement() {
        //SellerApplicationManagement Layout
            GridBagLayout sellerAppManagementLayout = new GridBagLayout();
            sellerAppManagementLayout.columnWidths = new int[]{675, 0, 0};
            sellerAppManagementLayout.rowHeights = new int[]{0, 0};
            sellerAppManagementLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            sellerAppManagementLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
            this.setLayout(sellerAppManagementLayout);

        //Main Panel
            JPanel mainPanel = new JPanel();
            GridBagConstraints mainBagCon = new GridBagConstraints();
            mainBagCon.insets = new Insets(0, 0, 0, 5);
            mainBagCon.fill = GridBagConstraints.BOTH;
            this.add(mainPanel, mainBagCon);

            GridBagLayout mainLayout = new GridBagLayout();
            mainLayout.columnWidths = new int[]{0, 0};
            mainLayout.rowHeights = new int[]{35, 30, 0, 0};
            mainLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            mainLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
            mainPanel.setLayout(mainLayout);

        //Count
            JPanel countPanel = new JPanel();
            countPanel.setLayout(new CardLayout());
            countPanel.setBackground(Setup.white);
            mainBagCon.insets = new Insets(0, 0, 1, 0);
            mainPanel.add(countPanel, mainBagCon);

            countLabel = new JLabel("  전체 " + str.size());
            countLabel.setFont(font1);
            countPanel.add(countLabel);
        //Title
            JPanel mainTitlePanel = new JPanel();
            mainTitlePanel.setBackground(Setup.white);
            mainBagCon.gridy = 1;
            mainPanel.add(mainTitlePanel, mainBagCon);

            GridBagLayout mainAppListLayout = new GridBagLayout();
            mainAppListLayout.columnWidths = new int[]{90, 120, 70, 120, 0, 20};
            mainAppListLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
            mainTitlePanel.setLayout(mainAppListLayout);

            mainBagCon.insets = new Insets(0, 0, 0, 0);
            mainBagCon.gridy = 0;
            mainBagCon.fill = GridBagConstraints.NONE;

            for (int i = 0; i < 5; i++) {
                applicantTitleLabel[i] = new JLabel(applicantTitleText[i]);
                applicantTitleLabel[i].setFont(font1);
                mainBagCon.gridx = i;
                mainTitlePanel.add(applicantTitleLabel[i], mainBagCon);
            }

        //Application List
            JScrollPane listScrollPanel = new JScrollPane();
            Setup.changeScrollBar(listScrollPanel);
            listScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            listScrollPanel.setBorder(BorderFactory.createLineBorder(Setup.white, 1));


        mainBagCon.fill = GridBagConstraints.BOTH;
            mainBagCon.gridx = 0;
            mainBagCon.gridy = 2;
            mainPanel.add(listScrollPanel, mainBagCon);


        JPanel listMainPanel = new JPanel();
        listMainPanel.setLayout(mainAppListLayout);

        JPanel ApplicationListPanel = new JPanel();
        ApplicationListPanel.setLayout(null);
        listScrollPanel.setViewportView(ApplicationListPanel);

        mainBagCon.fill = GridBagConstraints.NONE;
        mainBagCon.gridy = 0;

        for (int i = 0; i < str.size(); i++) {
            ApplicationInfoPanel[i] = new JPanel();
            ApplicationInfoPanel[i].setBounds(0, i*40, 663, 40);
            ApplicationInfoPanel[i].setLayout(mainAppListLayout);
            ApplicationInfoPanel[i].addMouseListener(this);
            if(i % 2 == 1) { ApplicationInfoPanel[i].setBackground(Setup.white); }
            for (int j = 0; j < 5; j++) {
                text = str.get(i).get(j);
                ApplicationInfo[i][j] = new JLabel(text);
                ApplicationInfo[i][j].setFont(font2);
                mainBagCon.gridx = j;
                ApplicationInfoPanel[i].add(ApplicationInfo[i][j], mainBagCon);
            }
            ApplicationListPanel.add(ApplicationInfoPanel[i]);
        }
        ApplicationListPanel.setPreferredSize(new Dimension(ApplicationListPanel.getWidth(), 40*str.size()));



        //Sub Panel
        mainBagCon.fill = GridBagConstraints.BOTH;
        mainBagCon.gridx = 1;
        mainBagCon.gridy = 0;
        subLayerPanel = new JLayeredPane();
        subLayerPanel.add(new GuideSubPanel("선택하여 승인이나 거절을 할 수 있습니다."));
        subLayerPanel.setLayout(new CardLayout());
        this.add(subLayerPanel, mainBagCon);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < str.size(); i++) {
            if(e.getSource() == ApplicationInfoPanel[i]) {
                if (e.getSource() == lastClickApplication) {
                    Setup.changePanel(subLayerPanel, new GuideSubPanel("선택하여 승인이나 거절을 할 수 있습니다."));
                    lastClickApplication.setBorder(null);
                    lastClickApplication = null;
                }else {
                    if(lastClickApplication != null) { lastClickApplication.setBorder(null); }
                    lastClickApplication = ApplicationInfoPanel[i];
                    ApplicationInfoPanel[i].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                    Setup.changePanel(subLayerPanel, new SellerApplicationSubPanel(str.get(i).get(0)));
                    return;
                }
            }
        }
    }
    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
}

