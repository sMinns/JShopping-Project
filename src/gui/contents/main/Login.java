package gui.contents.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextFieldType1;
import gui.common.Frame;
import gui.menu.CustomerMenu;
import system.Setup;

public class Login extends JPanel implements ActionListener {
	private JButton login = new ButtonType1(100, "로그인");
	private JButton find = new ButtonType1(100, "아이디 찾기");
	String[] items = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
			"가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품" };
	private JComboBox combo;
	public Login() {
		add(new TextFieldType1(20, "아이디"));
		add(new TextFieldType1(10, "비밀번호"));
		add(combo = new ComboBoxType1(items, 120));
		add(login);
		login.addActionListener(this);
		find.addActionListener(this);
		add(find);
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
