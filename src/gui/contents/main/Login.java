package gui.contents.main;

import custom.ButtonType1;
import custom.TextFieldType1;
import custom.passwordFieldType1;
import gui.common.Frame;
import gui.menu.GuestMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JPanel implements ActionListener, MouseListener {
	JLabel findIdLabel, findPasswordLabel, idDesLabel, passwordDesLabel, noAccLabel, signUpLabel;
	JTextField idTextField;
	JPasswordField passwordTextField;
	JButton login;
	public Login() {
		this.setLayout(null);

		//ID
			JPanel idPanel = new JPanel();
			idPanel.setLayout(null);
			idPanel.setBounds(278,180, 407, 95);
			this.add(idPanel);

			JLabel id = new JLabel("아이디");
			id.setBounds(6, 0, 43, 20);
			id.setFont(new Font(Setup.font, Font.BOLD, 14));
			id.setForeground(Color.DARK_GRAY);
			idPanel.add(id);

			idTextField = new TextFieldType1(30,2,"아이디");
			idTextField.setBounds(0, 25,  407, 44);
			idPanel.add(idTextField);

			idDesLabel = new JLabel();
			idDesLabel.setBounds(10, 71, 136, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);

			findIdLabel = new JLabel("* 아이디를 잊으셨나요?");
			findIdLabel.setBounds(280, 71, 136, 15);
			findIdLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			findIdLabel.setForeground(Setup.magenta);
			findIdLabel.addMouseListener(this);
			idPanel.add(findIdLabel);

		//Password
			JPanel passwordPanel = new JPanel();
			passwordPanel.setLayout(null);
			passwordPanel.setBounds(278, 280, 407, 95);
			this.add(passwordPanel);

			JLabel password = new JLabel("비밀번호");
			password.setBounds(6, 0, 70, 20);
			password.setFont(new Font(Setup.font, Font.BOLD, 14));
			password.setForeground(Color.DARK_GRAY);
			passwordPanel.add(password);

			passwordTextField = new passwordFieldType1(30,2);
			passwordTextField.setBounds(0, 25,  407, 44);
			passwordPanel.add(passwordTextField);

			passwordDesLabel = new JLabel();
			passwordDesLabel.setBounds(10, 71, 170, 15);
			passwordDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passwordDesLabel.setForeground(Setup.magenta);
			passwordPanel.add(passwordDesLabel);

			findPasswordLabel = new JLabel("* 비밀번호를 잊으셨나요?");
			findPasswordLabel.setBounds(270, 71, 170, 15);
			findPasswordLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			findPasswordLabel.setForeground(Setup.magenta);
			findPasswordLabel.addMouseListener(this);
			passwordPanel.add(findPasswordLabel);

		//Button
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBounds(278, 410, 407, 62);
			this.add(buttonPanel);

			login = new ButtonType1(40, 8, 5, "로그인", 16);
			buttonPanel.add(login);
			login.addActionListener(this);

		JPanel signUpPanel = new JPanel();
		signUpPanel.setBounds(278, 470, 407, 23);
		this.add(signUpPanel);
		signUpPanel.setLayout(null);

		noAccLabel = new JLabel("계정이 없으신가요?");
		noAccLabel.setBounds(130, 1, 102, 15);
		signUpPanel.add(noAccLabel);
		noAccLabel.setForeground(Setup.darkGray);
		noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		noAccLabel.addMouseListener(this);

		signUpLabel = new JLabel("회원가입");
		signUpLabel.setBounds(232, 1, 57, 15);
		signUpPanel.add(signUpLabel);
		signUpLabel.setForeground(Setup.magenta);
		signUpLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		signUpLabel.addMouseListener(this);
	        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			if(idTextField.getText().equals("아이디")) {
				idDesLabel.setText("* 아이디를 입력해주세요.");
			}else { idDesLabel.setText(""); }
			if(passwordTextField.getText().equals("passw0rd")) {
				passwordDesLabel.setText("* 비밀번호를 입력해주세요.");
			}else { passwordDesLabel.setText(""); }
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == findIdLabel) {
			Setup.changePanel(Frame.contentLayeredPanel, new FindIdPw(true), "아이디 및 비밀번호 찾기");
			Setup.lastClickReset();
		}
		if (e.getSource() == findPasswordLabel) {
			Setup.changePanel(Frame.contentLayeredPanel, new FindIdPw(false), "아이디 및 비밀번호 찾기");
			Setup.lastClickReset();
		}
		if (e.getSource() == noAccLabel || e.getSource() == signUpLabel) {
			Setup.changePanel(Frame.contentLayeredPanel, new SignUp(), "회원가입");
			Setup.lastClickReset();
			Setup.selectMenuPanel(GuestMenu.GuestPanel[2]);
		}
	}
	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
