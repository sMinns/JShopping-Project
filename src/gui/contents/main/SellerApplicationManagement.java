package gui.contents.main;

import custom.ButtonType1;
import gui.contents.sub.GuideSubPanel;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SellerApplicationManagement extends JPanel implements MouseListener {
    private Font font1 = new Font(Setup.font, Font.BOLD, 16);
    private Font font2 = new Font(Setup.font, Font.BOLD, 14);

    private JLabel[][] customerInfo = new JLabel[2][6];
    private JLabel[][] sellerInfo = new JLabel[2][6];

    private JLabel countLabel = new JLabel();
    private JLabel[] applicantTitleLabel = new JLabel[5];
    private String[] applicantTitleText = {"고객번호", "신청자 이름", "연락처", "사업자등록번호", "신청일"};
    private JPanel lastClickApplication = null;
    private JLayeredPane subLayerPanel;

    private static String[] customerAttributeArray = { "고객번호", "이름", "생년월일", "닉네임", "이메일", "가입일자" };
    private static String[] sellerAttributeArray = { "판매자명", "상호 / 대표자", "연락처", "Email", "<html>사업자<br>등록번호</html>", "신청일" };
    private static String[][] customerValueArray = {
            {"123", "기미김", "1999. 10. 05", "가나다라마", "g2g3234@naver.com", "2022. 11. 01"},
            {"543", "기미김", "2000. 11. 23", "fdgdf4553", "ad1d125@naver.com", "2022. 11. 01"},
            {"654", "스이니", "2011. 03. 25", "kjhhm24312", "g54jh45@naver.com", "2022. 11. 01"},
            {"765", "지니디", "2661. 05. 21", "ahgfnmd765", "k67l6l@naver.com", "2022. 11. 01"},
            {"373", "키밈니", "1962. 07. 21", "jhgj46", "2n223@naver.com", "2022. 11. 01"},
            {"17683", "히히리", "1976. 04. 21", "김치지디", "rwreq355@naver.com", "2022. 11. 01"},
            {"765", "기리리", "1987. 02. 12", "기미미니", "yy4532@naver.com", "2022. 11. 01"},
            {"1345", "홍김디", "1936. 12. 31", "라마", "i67i7454@naver.com", "2022. 11. 01"},
            {"126", "김티니", "2001. 04. 01", "a43hh312", "23rqqq223@naver.com", "2022. 11. 01"},
            {"133", "이름미", "2020. 05. 23", "456hh12", "t43t43yq3@naver.com", "2022. 11. 01"},
            {"123", "가나다라마", "1999. 10. 05", "긴elflal", "m565m5@naver.com", "2022. 11. 01"},
            {"543", "김길동", "2000. 11. 23", "asdfadasd", "z46z463@naver.com", "2022. 11. 01"},
            {"654", "스이니", "2011. 03. 25", "kjhhm24312", "m67m76m4@naver.com", "2022. 11. 01"},
            {"765", "지니디", "2661. 05. 21", "ahgfnmd765", "h534h3@naver.com", "2022. 11. 01"},
            {"373", "키밈니", "1962. 07. 21", "jhgj46", "m56m64@naver.com", "2022. 11. 01"},
            {"17683", "히히리", "1976. 04. 21", "김치지디", "li44@naver.com", "2022. 11. 01"},
            {"765", "기리리", "1987. 02. 12", "기미미니", "o4o4o9i@naver.com", "2022. 11. 01"},
            {"1345", "홍김디", "1936. 12. 31", "라마", "lkjyk87k@naver.com", "2022. 11. 01"},
            {"126", "김티니", "2001. 04. 01", "a43hh312", "l0980990@naver.com", "2022. 11. 01"},
            {"133", "이름미", "2020. 05. 23", "456hh12", "k56k4@naver.com", "2022. 11. 01"}
    };

    private static String[][] str = {
            {"21541", "헤니스","김길동", "010-1234-1234", "g2g3234@naver.com", "110-21-12345", "2022. 01. 11"},
            {"324433", "삼성전자", "기미김", "010-1234-1234", "ad1d125@naver.com", "054-971-8935", "2022. 01. 11"},
            {"16573", "현대", "스이니", "010-1234-1234", "g54jh45@naver.com", "110-21-12345", "2022. 01. 11"},
            {"17653", "도그아이", "지니디", "010-1234-1234", "k67l6l@naver.com", "054-971-8935", "2022. 01. 11"},
            {"133", "김치찌개", "키밈니", "010-1234-1234", "2n223@naver.com", "786-33-00664", "2022. 01. 11"},
            {"863", "불닭볶음면", "히히리", "010-1234-1234", "rwreq355@naver.com", "786-33-00664", "2022. 01. 11"},
            {"65463", "제육볶음", "기리리", "010-1234-1234", "yy4532@naver.com", "786-33-00664", "2022. 01. 11"},
            {"98", "신라면", "홍김디", "010-1234-1234", "i67i7454@naver.com", "786-33-00664", "2022. 01. 11"},
            {"92", "오징어짬뽕", "김티니", "010-1234-1234", "23rqqq223@naver.com", "786-33-00664", "2022. 01. 11"},
            {"234", "레몬돈가스", "이름미", "010-1234-1234", "t43t43yq3@naver.com", "786-33-00664", "2022. 01. 11"},
            {"23452", "에이프릴", "기미김", "010-1234-1234", "m565m5@naver.com", "786-33-00664", "2022. 01. 11"},
            {"456", "베니즈", "기미김", "010-1234-1234", "z46z463@naver.com", "786-33-00664", "2022. 01. 11"},
            {"987", "푸르미", "스이니", "010-1234-1234", "m67m76m4@naver.com", "786-70-00335", "2022. 01. 11"},
            {"737", "딩동펫", "지니디", "010-1234-1234", "h534h3@naver.com", "786-70-00335", "2022. 01. 11"},
            {"542", "노마진", "키밈니", "010-1234-1234", "m56m64@naver.com", "786-70-00335", "2022. 01. 11"},
            {"1050", "지앤비", "히히리", "010-1234-1234", "li44@naver.com", "786-70-00335", "2022. 01. 11"},
            {"283", "에티펫", "기리리", "010-1234-1234", "o4o4o9i@naver.com", "786-70-00335", "2022. 01. 11"},
            {"7803", "반려세상", "홍김디", "010-1234-1234", "lkjyk87k@naver.com", "786-70-00335", "2022. 01. 11"},
            {"1765", "바잇미", "김티니", "010-1234-1234", "l0980990@naver.com", "786-70-00335", "2022. 01. 11"},
            {"1543", "옥희독희", "이름미", "010-1234-1234", "k56k4@naver.com", "786-70-00335", "2022. 01. 11"}
    };
    private JPanel[] ApplicationInfoPanel = new JPanel[str.length];
    private JLabel[][] ApplicationInfo = new JLabel[str.length][5];

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

            countLabel = new JLabel("  전체 " + str.length);
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
            listScrollPanel.setBorder(null);

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

        for (int i = 0; i < str.length; i++) {
            ApplicationInfoPanel[i] = new JPanel();
            ApplicationInfoPanel[i].setBounds(0, i*40, 665, 40);
            ApplicationInfoPanel[i].setLayout(mainAppListLayout);
            ApplicationInfoPanel[i].addMouseListener(this);
            if(i % 2 == 1) { ApplicationInfoPanel[i].setBackground(Setup.white); }
            for (int j = 0; j < 5; j++) {
                if(j == 0) { text = str[i][0]; }
                if(j == 1) { text = str[i][2]; }
                if(j == 2) { text = str[i][3]; }
                if(j == 3) { text = str[i][5]; }
                if(j == 4) { text = str[i][6]; }
                ApplicationInfo[i][j] = new JLabel(text);
                ApplicationInfo[i][j].setFont(font2);
                mainBagCon.gridx = j;
                ApplicationInfoPanel[i].add(ApplicationInfo[i][j], mainBagCon);
            }
            ApplicationListPanel.add(ApplicationInfoPanel[i]);
        }
        ApplicationListPanel.setPreferredSize(new Dimension(ApplicationListPanel.getWidth(), 40*str.length));



        //Sub Panel
        mainBagCon.fill = GridBagConstraints.BOTH;
        mainBagCon.gridx = 1;
        mainBagCon.gridy = 0;
        subLayerPanel = new JLayeredPane();
        subLayerPanel.add(new GuideSubPanel("선택하여 승인이나 거절을 할 수 있습니다."));
        subLayerPanel.setLayout(new CardLayout());
        this.add(subLayerPanel, mainBagCon);
    }

    private class SubPanel extends JPanel {
        private String text;
        public SubPanel(int num) {
            GridBagLayout subPanelLayout = new GridBagLayout();
            subPanelLayout.columnWidths = new int[]{0, 0};
            subPanelLayout.rowHeights = new int[]{55, 270, 295, 0, 0};
            subPanelLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            subPanelLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
            this.setLayout(subPanelLayout);

            //Sub Title Panel
                JPanel subTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
                subTitlePanel.setBackground(Setup.white);
                GridBagConstraints subBagCon = new GridBagConstraints();
                subBagCon.fill = GridBagConstraints.BOTH;
                subBagCon.gridx = 0;
                subBagCon.gridy = 0;
                this.add(subTitlePanel, subBagCon);

                JLabel label = new JLabel("판매자 신청서");
                label.setFont(new Font(Setup.font, Font.BOLD, 20));
                label.setForeground(Setup.darkGray);
                subTitlePanel.add(label);

            //Customer Information Panel
                JPanel customerInfoMainPanel = new JPanel();
                subBagCon.gridy = 1;
                this.add(customerInfoMainPanel, subBagCon);

                GridBagLayout customerInfoMainLayout = new GridBagLayout();
                customerInfoMainLayout.rowHeights = new int[]{30, 0};
                customerInfoMainLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
                customerInfoMainLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
                customerInfoMainPanel.setLayout(customerInfoMainLayout);

            //Customer Information Title
                JPanel customerInfoTitle = new JPanel(new FlowLayout(FlowLayout.LEFT, 7, 0));
                customerInfoTitle.setBackground(Setup.white);
                subBagCon.insets = new Insets(0, 0, 2, 0);
                subBagCon.gridy = 0;
                customerInfoMainPanel.add(customerInfoTitle, subBagCon);

                JLabel customerInfoLabel = new JLabel("신청자 고객 정보");
                customerInfoLabel.setFont(new Font(Setup.font, Font.BOLD, 18));
                customerInfoLabel.setForeground(Setup.magenta);
                customerInfoTitle.add(customerInfoLabel);

            //Customer Information
                JPanel panelll = new JPanel();
                panelll.setBackground(Setup.white);
                GridBagConstraints gbc_panelll = new GridBagConstraints();
                gbc_panelll.gridy = 1;
                gbc_panelll.fill = GridBagConstraints.BOTH;
                customerInfoMainPanel.add(panelll, gbc_panelll);

                GridBagLayout customerInfoLayout = new GridBagLayout();
                customerInfoLayout.columnWidths = new int[]{70, 0, 0};
                customerInfoLayout.rowHeights = new int[]{37, 37, 37, 37, 37, 37, 0, 0};
                customerInfoLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
                customerInfoLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                panelll.setLayout(customerInfoLayout);

            subBagCon.insets = new Insets(0, 7, 0, 0);
            for (int i = 0; i < 6; i++) {
                customerInfo[0][i] = new JLabel(customerAttributeArray[i]);
                customerInfo[0][i].setFont(font2);
                subBagCon.gridx = 0;
                subBagCon.gridy = i;
                panelll.add(customerInfo[0][i], subBagCon);
                //customerAttributeArray
                customerInfo[1][i] = new JLabel(customerValueArray[num][i]);
                customerInfo[1][i].setFont(font2);
                subBagCon.gridx = 1;
                subBagCon.gridy = i;
                panelll.add(customerInfo[1][i], subBagCon);
            }

            //Seller Information Panel
            JPanel SellerInfoMainPanel = new JPanel();
            subBagCon.insets = new Insets(0, 0, 0, 0);
            subBagCon.gridx = 0;
            subBagCon.gridy = 2;
            this.add(SellerInfoMainPanel, subBagCon);

            GridBagLayout sellerInfoMainLayout = new GridBagLayout();
            sellerInfoMainLayout.columnWidths = new int[]{0, 0};
            sellerInfoMainLayout.rowHeights = new int[]{30, 0};
            sellerInfoMainLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            sellerInfoMainLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            SellerInfoMainPanel.setLayout(sellerInfoMainLayout);

            subBagCon.insets = new Insets(0, 0, 2, 0);
            subBagCon.gridy = 0;

            JPanel sellerInfoTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 7, 0));
            sellerInfoTitlePanel.setBackground(Setup.white);
            SellerInfoMainPanel.add(sellerInfoTitlePanel, subBagCon);

            JLabel sellerInfoTitleLabel = new JLabel("판매자 신청 정보");
            sellerInfoTitleLabel.setFont(new Font(Setup.font, Font.BOLD, 18));
            sellerInfoTitleLabel.setForeground(Setup.magenta);
            sellerInfoTitlePanel.add(sellerInfoTitleLabel);

            JPanel sellerInfoPanel = new JPanel();
            sellerInfoPanel.setBackground(Setup.white);
            subBagCon.insets = new Insets(0, 0, 0, 0);
            subBagCon.gridy = 1;
            SellerInfoMainPanel.add(sellerInfoPanel, subBagCon);

            GridBagLayout sellerInfoLayout = new GridBagLayout();
            sellerInfoLayout.columnWidths = new int[]{100, 0, 0};
            sellerInfoLayout.rowHeights = new int[]{40, 40, 40, 40, 60, 40, 0, 0};
            sellerInfoLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            sellerInfoLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
            sellerInfoPanel.setLayout(sellerInfoLayout);

            //Seller Information
            subBagCon.insets = new Insets(0, 7, 0, 0);
            for (int i = 0; i < 6; i++) {
                subBagCon.gridx = 0;
                sellerInfo[0][i] = new JLabel(sellerAttributeArray[i]);
                sellerInfo[0][i].setFont(font2);
                subBagCon.gridy = i;
                sellerInfoPanel.add(sellerInfo[0][i], subBagCon);

                if(i == 0) { text = str[num][0]; }
                if(i == 1) { text = str[num][2]; }
                if(i == 2) { text = str[num][3]; }
                if(i == 3) { text = str[num][4]; }
                if(i == 4) { text = str[num][5]; }
                if(i == 5) { text = str[num][6]; }

                sellerInfo[1][i] = new JLabel(text);
                sellerInfo[1][i].setFont(font2);
                subBagCon.gridx = 1;
                subBagCon.gridy = i;
                sellerInfoPanel.add(sellerInfo[1][i], subBagCon);
            }

            //Button Panel
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 7));
            buttonPanel.setBackground(Setup.white);
            subBagCon.insets = new Insets(2, 0, 0, 0);
            subBagCon.gridx = 0;
            subBagCon.gridy = 3;
            this.add(buttonPanel, subBagCon);

            buttonPanel.add(new ButtonType1(30, 4, 5, "승인", 16));
            buttonPanel.add(new ButtonType1(30, 4, 5, "거절", 16));
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < str.length; i++) {
            if(e.getSource() == ApplicationInfoPanel[i]) {
                if (e.getSource() == lastClickApplication) {
                    Setup.changePanel(subLayerPanel, new GuideSubPanel("선택하여 승인이나 거절을 할 수 있습니다."));
                    lastClickApplication.setBorder(null);
                    lastClickApplication = null;
                }else {
                    if(lastClickApplication != null) { lastClickApplication.setBorder(null); }
                    lastClickApplication = ApplicationInfoPanel[i];
                    ApplicationInfoPanel[i].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                    Setup.changePanel(subLayerPanel, new SubPanel(i));
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

