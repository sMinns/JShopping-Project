package event;

import custom.ButtonType1;
import database.SellerApplicationDB;
import gui.common.Frame;
import gui.contents.main.Home;
import gui.contents.main.SellerApplication;
import gui.menu.CustomerMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SellerApplicationEvent implements ActionListener {
    SellerApplication s;
    public SellerApplicationEvent(SellerApplication s) {
        this.s = s;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == s.getSellerAppButton()) {
            if (s.getSellertextField().equals("")) {
                s.setSellerDesLabel("* 판매자명을 입력해주세요.");
                s.focusSellertextField();
                return;
            } else {
                s.setSellerDesLabel("");
            }

            if (s.getShoptextField().equals("")) {
                s.setShopDesLabel("* 상호 / 대표자를 입력해주세요.");
                s.focusShoptextField();
                return;
            } else {
                s.setShopDesLabel("");
            }

            if (s.getPhonetextField().equals("") || s.getPhonetextField().length() < 3 ||
                    s.getPhonetextField2().equals("") || s.getPhonetextField2().length() < 4 ||
                    s.getPhonetextField3().equals("") || s.getPhonetextField3().length() < 4) {
                s.setPhoneDesLabel("* 연락처를 입력해주세요.");
                s.focusPhonetextField();
                return;
            } else {
                s.setPhoneDesLabel("");
            }

            if (s.getEmailtextField().equals("")) {
                s.setEmailDesLabel("* 상호 / 대표자를 입력해주세요.");
                s.focusEmailtextField();
                return;
            } else {
                s.setEmailDesLabel("");
            }

            if (s.getBusinessnumtextField().equals("") || s.getBusinessnumtextField2().equals("") ||
                    s.getBusinessnumtextField3().equals("")) {
                s.setBusinessnumDesLabel("* 연락처를 입력해주세요.");
                s.focusBusinessnumtextField();
                return;
            } else {
                s.setBusinessnumDesLabel("");
            }

            LocalDate now = LocalDate.now();
            String phone = s.getPhonetextField() + " " + s.getPhonetextField2() + " " + s.getPhonetextField3();
            String regnum = s.getBusinessnumtextField() + " - " + s.getBusinessnumtextField2() + " - " + s.getBusinessnumtextField3();
            String[] str = { s.getSellertextField(), s.getShoptextField(), phone,
                    s.getEmailtextField(), regnum, "승인대기", String.valueOf(now)};

            if(SellerApplicationDB.insertSellerApp(Setup.CustomerNum, str)) {
                Setup.changePanel(Frame.contentLayeredPanel, new FinishSellerApplication("이 완료되었습니다."));
            }else {
                Setup.changePanel(Frame.contentLayeredPanel, new FinishSellerApplication("이 실패하였습니다."));
            }
        }
    }
    class FinishSellerApplication extends JPanel {
        Font font = new Font(Setup.font, Font.BOLD, 24);

        public FinishSellerApplication(String result) {
            this.setLayout(new GridLayout(2, 1));

            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 270));
            this.add(panel1);

            JLabel label1 = new JLabel("판매자 신청");
            label1.setFont(font);
            label1.setForeground(Setup.magenta);
            panel1.add(label1);

            JLabel label2 = new JLabel(result);
            label2.setFont(font);
            label2.setForeground(Setup.darkGray);
            panel1.add(label2);

            JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            this.add(panel2);

            JButton button = new ButtonType1(30, 6, 5, "홈으로 가기", 14);
            panel2.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
                    Setup.lastClickReset();
                    Setup.selectMenuPanel(CustomerMenu.customerPanel[0]);
                }
            });
        }
    }
}
