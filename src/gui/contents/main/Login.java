package gui.contents.main;

import custom.ButtonType1;
import custom.TextFieldType1;
import custom.passwordFieldType1;
import event.LoginEvent;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
	private JLabel findIdLabel, findPasswordLabel, idDesLabel, passwordDesLabel, noAccLabel, signUpLabel;
	private JTextField idTextField;
	private JPasswordField passwordTextField;
	private JButton login;

	public Login() {
		this.setLayout(null);
		this.setBackground(Setup.bgLightGray);
		LoginEvent loginEvent = new LoginEvent(this);
		//ID
			JPanel idPanel = new JPanel();
			idPanel.setLayout(null);
			idPanel.setOpaque(false);
			idPanel.setBounds(278,180, 407, 95);
			this.add(idPanel);

			JLabel id = new JLabel("아이디");
			id.setBounds(6, 0, 43, 20);
			id.setFont(new Font(Setup.font, Font.BOLD, 14));
			id.setForeground(Color.DARK_GRAY);
			idPanel.add(id);

			idTextField = new TextFieldType1(30,2,"아이디", 15);
			idTextField.setBounds(0, 25,  407, 44);
			idPanel.add(idTextField);

			idDesLabel = new JLabel();
			idDesLabel.setBounds(10, 71, 300, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);

			findIdLabel = new JLabel("* 아이디를 잊으셨나요?");
			findIdLabel.setBounds(280, 71, 136, 15);
			findIdLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			findIdLabel.setForeground(Setup.magenta);
			findIdLabel.addMouseListener(loginEvent);
			idPanel.add(findIdLabel);

		//Password
			JPanel passwordPanel = new JPanel();
			passwordPanel.setLayout(null);
			passwordPanel.setOpaque(false);
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
			passwordDesLabel.setBounds(10, 71, 300, 15);
			passwordDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passwordDesLabel.setForeground(Setup.magenta);
			passwordPanel.add(passwordDesLabel);

			findPasswordLabel = new JLabel("* 비밀번호를 잊으셨나요?");
			findPasswordLabel.setBounds(270, 71, 170, 15);
			findPasswordLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			findPasswordLabel.setForeground(Setup.magenta);
			findPasswordLabel.addMouseListener(loginEvent);
			passwordPanel.add(findPasswordLabel);

		//Button
			JPanel buttonPanel = new JPanel();
			buttonPanel.setOpaque(false);
			buttonPanel.setBounds(278, 410, 407, 62);
			this.add(buttonPanel);

			login = new ButtonType1(40, 8, 5, "로그인", 16);
			buttonPanel.add(login);
			login.addActionListener(loginEvent);

		JPanel signUpPanel = new JPanel();
		signUpPanel.setOpaque(false);
		signUpPanel.setBounds(278, 470, 407, 23);
		this.add(signUpPanel);
		signUpPanel.setLayout(null);

		noAccLabel = new JLabel("계정이 없으신가요?");
		noAccLabel.setBounds(130, 1, 102, 15);
		signUpPanel.add(noAccLabel);
		noAccLabel.setForeground(Setup.darkGray);
		noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		noAccLabel.addMouseListener(loginEvent);

		signUpLabel = new JLabel("회원가입");
		signUpLabel.setBounds(232, 1, 57, 15);
		signUpPanel.add(signUpLabel);
		signUpLabel.setForeground(Setup.magenta);
		signUpLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		signUpLabel.addMouseListener(loginEvent);
	}

	public void setIdDesLabel(String text) {
		idDesLabel.setText(text);
	}

	public void setPasswordDesLabel(String text) {
		passwordDesLabel.setText(text);
	}

	public JLabel getNoAccLabel() {
		return noAccLabel;
	}

	public JLabel getSignUpLabel() {
		return signUpLabel;
	}

	public String getIdTextField() {
		return idTextField.getText();
	}

	public void foucsIdTextField() {
		idTextField.requestFocus();
	}

	public String getPasswordTextField() {
		return passwordTextField.getText();
	}

	public void focusPasswordTextField() {
		passwordTextField.requestFocus();
	}
	public JButton getLogin() {
		return login;
	}

	public JLabel getFindIdLabel() {
		return findIdLabel;
	}

	public JLabel getFindPasswordLabel() {
		return findPasswordLabel;
	}
}
