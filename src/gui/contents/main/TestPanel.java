package gui.contents.main;

import custom.*;
import gui.common.Frame;
import gui.menu.CustomerMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPanel extends JPanel implements ActionListener {
    private JButton[] button = new JButton[14];
    private JPanel[] p = new JPanel[button.length];
    private String[] str = {"로그인테스트", "회원가입", "아이디 및 비밀번호 찾기", "비밀번호 재설정", "로그인", "상품검색",
    "주문목록", "장바구니", "주문 / 결제", "판매자 신청", "판매상품 관리", "신규주문관리", "일반고객관리", "판매자 관리", "판매자 신청 관리"};
    private JPanel[] panel = {new SignUp(), new FindIdPw(true), new ResetPassword(), new Login(), new Search(), new OrderList(),
    new ShoppingBasket(), new OrderPage(), new SellerApplication(), new ProductManagement(), new OrderManagement(),
    new CustomerManagement(), new SellerManagement(), new SellerApplicationManagement()};
    public TestPanel() {
        this.setLayout(new GridLayout(4, 4));
        for(int i = 0; i < button.length; i++) {
            p[i] = new JPanel(new GridBagLayout());
            button[i] = new ButtonType1(30, 8, 5, str[i]);
            button[i].addActionListener(this);
            p[i].add(button[i]);
            this.add(p[i]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < button.length; i++) {
            if(i == 0 && e.getSource() == button[0]) {
                Setup.changePanel(Frame.menuLayeredPanel, new CustomerMenu("김치찌개"), "홈");
                Setup.changePanel(Frame.contentLayeredPanel, new Home(), "홈");
            }else if (e.getSource() == button[i]) {
                Setup.changeFindPanel(Frame.contentLayeredPanel, panel[i-1]);
                Setup.lastClickReset();
            }
        }
    }
}
