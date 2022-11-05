package gui.contents.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import custom.ButtonType1;
import custom.TextFieldType1;
import gui.common.Frame;
import gui.menu.CustomerMenu;
import system.Setup;

public class Login extends JPanel implements ActionListener {
	private JButton login = new ButtonType1(100, "로그인");
	public Login() {
		add(new TextFieldType1(20, "아이디"));
		add(new TextFieldType1(10, "비밀번호"));
		add(login);
		login.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Setup.changePanel(Frame.menuLayeredPanel, new CustomerMenu("김치찌개"), "홈");
		Setup.changePanel(Frame.contentLayeredPanel, new Home(), "홈");
	}
		
}
