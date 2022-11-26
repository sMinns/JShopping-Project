package gui.contents.sub;

import custom.ButtonType1;
import database.SellerApplicationManagementDB;
import gui.common.Frame;
import gui.contents.main.SellerApplicationManagement;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerApplicationSubPanel extends JPanel implements ActionListener {
        private Font font2 = new Font(Setup.font, Font.BOLD, 14);
        private static String[] customerAttributeArray = { "고객번호", "이름", "생년월일", "닉네임", "이메일", "가입일자" };
        private static String[] sellerAttributeArray = { "판매자명", "상호 / 대표자", "연락처", "Email", "<html>사업자<br>등록번호</html>", "신청일" };
        private String[] sellerAppInfo, customerAppInfo;
        private JLabel[][] customerInfoLabel = new JLabel[2][6];
        private JLabel[][] sellerInfoLabel = new JLabel[2][6];
        private JButton ok, refuse;
        private int num;
        public SellerApplicationSubPanel(String num) {
            this.num = Integer.parseInt(num);
            sellerAppInfo = SellerApplicationManagementDB.sellerAppInfo(this.num);
            customerAppInfo = SellerApplicationManagementDB.customerAppInfo(this.num);
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
                this.customerInfoLabel[0][i] = new JLabel(customerAttributeArray[i]);
                this.customerInfoLabel[0][i].setFont(font2);
                subBagCon.gridx = 0;
                subBagCon.gridy = i;
                panelll.add(this.customerInfoLabel[0][i], subBagCon);
                //customerAttributeArray
                this.customerInfoLabel[1][i] = new JLabel(customerAppInfo[i]);
                this.customerInfoLabel[1][i].setFont(font2);
                subBagCon.gridx = 1;
                subBagCon.gridy = i;
                panelll.add(this.customerInfoLabel[1][i], subBagCon);
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
                sellerInfoLabel[0][i] = new JLabel(sellerAttributeArray[i]);
                sellerInfoLabel[0][i].setFont(font2);
                subBagCon.gridy = i;
                sellerInfoPanel.add(sellerInfoLabel[0][i], subBagCon);

                sellerInfoLabel[1][i] = new JLabel(sellerAppInfo[i]);
                sellerInfoLabel[1][i].setFont(font2);
                subBagCon.gridx = 1;
                subBagCon.gridy = i;
                sellerInfoPanel.add(sellerInfoLabel[1][i], subBagCon);
            }

            //Button Panel
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 7));
            buttonPanel.setBackground(Setup.white);
            subBagCon.insets = new Insets(2, 0, 0, 0);
            subBagCon.gridx = 0;
            subBagCon.gridy = 3;
            this.add(buttonPanel, subBagCon);
            ok = new ButtonType1(30, 4, 5, "승인", 16);
            ok.addActionListener(this);
            buttonPanel.add(ok);
            refuse = new ButtonType1(30, 4, 5, "거절", 16);
            refuse.addActionListener(this);
            buttonPanel.add(refuse);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == ok) {
                if(SellerApplicationManagementDB.updatePassword(this.num)) {
                    Setup.changePanel(Frame.contentLayeredPanel, new SellerApplicationManagement());
                }
            }
            if(e.getSource() == refuse) {
                if(SellerApplicationManagementDB.deleteApplication(this.num)) {
                    Setup.changePanel(Frame.contentLayeredPanel, new SellerApplicationManagement());
                }
            }
        }
    }
