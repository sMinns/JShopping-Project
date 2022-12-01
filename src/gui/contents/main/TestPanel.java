package gui.contents.main;

import custom.ButtonType1;
import gui.common.Frame;
import gui.menu.CustomerMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPanel extends JPanel implements ActionListener {
    private JButton[] button = new JButton[16];
    private JPanel[] p = new JPanel[button.length];
    private String[] str = {"로그인테스트", "회원가입", "아이디 및 비밀번호 찾기", "비밀번호 재설정", "로그인", "상품검색",
    "주문목록", "장바구니", "주문 / 결제", "판매자 신청", "판매상품 관리", "신규주문관리", "일반고객관리", "판매자 관리", "판매자 신청 관리", "달력 테스트"};
    public TestPanel() {
        this.setLayout(new GridLayout(4, 4));
        for(int i = 0; i < str.length; i++) {
            p[i] = new JPanel(new GridBagLayout());
            button[i] = new ButtonType1(30, 8, 5, str[i], 16);
            button[i].addActionListener(this);
            p[i].add(button[i]);
            this.add(p[i]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button[0]) {
            Setup.changePanel(Frame.menuLayeredPanel, new CustomerMenu("김치찌개"), "홈");
            Setup.changePanel(Frame.contentLayeredPanel, new Home(), "홈");
        }else if (e.getSource() == button[1]) {
            Setup.changePanel(Frame.contentLayeredPanel, new SignUp());
            Setup.lastClickReset();
        }else if (e.getSource() == button[2]) {
            Setup.changePanel(Frame.contentLayeredPanel, new FindIdPw(true));
            Setup.lastClickReset();
        }else if (e.getSource() == button[3]) {
            Setup.changePanel(Frame.contentLayeredPanel, new ResetPassword(0));
            Setup.lastClickReset();
        }else if (e.getSource() == button[4]) {
            Setup.changePanel(Frame.contentLayeredPanel, new Login());
            Setup.lastClickReset();
        }else if (e.getSource() == button[5]) {
            Setup.changePanel(Frame.contentLayeredPanel, new Search("", 0));
            Setup.lastClickReset();
        }else if (e.getSource() == button[6]) {
            Setup.changePanel(Frame.contentLayeredPanel, new OrderList());
            Setup.lastClickReset();
        }else if (e.getSource() == button[7]) {
            Setup.changePanel(Frame.contentLayeredPanel, new ShoppingBasket());
            Setup.lastClickReset();
        }else if (e.getSource() == button[9]) {
            Setup.changePanel(Frame.contentLayeredPanel, new SellerApplication());
            Setup.lastClickReset();
        }else if (e.getSource() == button[10]) {
            Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(""));
            Setup.lastClickReset();
        }else if (e.getSource() == button[11]) {
            Setup.changePanel(Frame.contentLayeredPanel, new OrderManagement());
            Setup.lastClickReset();
        }else if (e.getSource() == button[12]) {
            Setup.changePanel(Frame.contentLayeredPanel, new CustomerManagement(""));
            Setup.lastClickReset();
        }else if (e.getSource() == button[13]) {
            Setup.changePanel(Frame.contentLayeredPanel, new SellerManagement(""));
            Setup.lastClickReset();
        }else if (e.getSource() == button[14]) {
            Setup.changePanel(Frame.contentLayeredPanel, new SellerApplicationManagement(""));
            Setup.lastClickReset();
        }
    }
}
