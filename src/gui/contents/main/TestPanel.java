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
    private JButton login = new ButtonType1(100, "로그인");
    private JButton find = new ButtonType1(100, "아이디 찾기");
    String[] items = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
            "가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품" };
    private JComboBox combo;
    public TestPanel() {
        this.setLayout(new GridLayout(4, 1));
        JPanel p1 = new JPanel();

        p1.add(new TextFieldType1(20, "아이디"));
        p1.add(new TextFieldType1(10, "비밀번호"));
        p1.add(combo = new ComboBoxType1(items, 120));
        add(p1);
        p1.add(login);
        login.addActionListener(this);
        find.addActionListener(this);
        p1.add(find);

        JPanel p2 = new JPanel();
        p2.add(new SearchBar(30, 200));
        add(p2);


        JPanel p3 = new JPanel();
        Font font = new Font(Setup.font, Font.BOLD, 14);
        p3.add(new CheckBoxType1("TESTETS", font));
        p3.add(new CheckBoxType1());
        add(p3);

        JPanel p4 = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton rb1 = new RadioType1("신용카드", font);
        rb1.setSelected(true);
        JRadioButton rb2 = new RadioType1("휴대폰 결제", font);
        group.add(rb1);
        group.add(rb2);
        p3.add(rb1);
        p3.add(rb2);
        add(p3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            Setup.changePanel(Frame.menuLayeredPanel, new CustomerMenu("김치찌개"), "홈");
            Setup.changePanel(Frame.contentLayeredPanel, new Home(), "홈");
            System.out.println(combo.getSelectedItem().toString());
        } else if (e.getSource() == find) {
            Setup.changePanel(Frame.contentLayeredPanel, new FindIdPw(true), "아이디 및 비밀번호 찾기");
        }
    }
}
