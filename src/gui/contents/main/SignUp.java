package gui.contents.main;

import custom.*;
import event.SignUpEvent;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JPanel {

	private String MON[] = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};

	private JTextField idTextField, passTextField, passCheckTextField, nickNameTextField, nameTextField, emailTextField;
	private JFormattedTextField yearTextField, dayTextField;
	private JComboBox monthComboBox;
	private JButton signUpButton;
	private JLabel idDesLabel, passDesLabel, passCheckDesLabel, nameDesLabel, birthDesLabel, emailDesLabel, haveAccLabel, loginLabel;
	private JScrollPane scrollPane;

	public SignUp() {
		Setup.changeInsets(10,10,10,6);
		this.setLayout(new CardLayout());
		SignUpEvent SignUpEvent = new SignUpEvent(this);
		//SCROLL
	        scrollPane = new JScrollPane();
	        scrollPane.setBorder(null);
	        Setup.changeScrollBar(scrollPane);
	        this.add(scrollPane);

	        JPanel joinPanel = new JPanel();
	        joinPanel.setPreferredSize(new Dimension(this.getWidth(), 820));
	        joinPanel.setLayout(null);
			joinPanel.setBackground(Setup.bgLightGray);
	        scrollPane.setViewportView(joinPanel);

		//ID
			JPanel idPanel = new JPanel();
			idPanel.setBounds(280, 20, 400, 95);
			joinPanel.add(idPanel);
			idPanel.setOpaque(false);
			idPanel.setLayout(null);

			JLabel idLabel = new JLabel("아이디");
			idLabel.setBounds(6, 8, 70, 20);
			idPanel.add(idLabel);
			idLabel.setFont(new Font(Setup.font, Font.BOLD, 14));

			idTextField = new TextFieldType1(0, 2, "아이디", 15);
			idTextField.setBounds(0, 30, 400, 40);
			idTextField.addKeyListener(SignUpEvent);

			idTextField.setColumns(10);
			idPanel.add(idTextField);

			idDesLabel = new JLabel("* 필수 입력 정보입니다.");
			idDesLabel.setBounds(10, 72, 300, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);

		//PASSWORD
			JPanel passPanel = new JPanel();
			passPanel.setOpaque(false);
			passPanel.setLayout(null);
			passPanel.setBounds(280, 120, 400, 95);
			joinPanel.add(passPanel);

			JLabel passLabel = new JLabel("비밀번호");
			passLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			passLabel.setBounds(6, 8, 70, 20);
			passPanel.add(passLabel);

			passTextField = new passwordFieldType1(0, 2);
			passTextField.setColumns(10);
			passTextField.setBounds(0, 30, 400, 40);
			passTextField.addKeyListener(SignUpEvent);
			passPanel.add(passTextField);

			passDesLabel = new JLabel("* 필수 입력 정보입니다.");
			passDesLabel.setForeground(Setup.magenta);
			passDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passDesLabel.setBounds(10, 72, 300, 15);
			passPanel.add(passDesLabel);

		//PASSCHECK
			JPanel passCheckPanel = new JPanel();
			passCheckPanel.setLayout(null);
			passCheckPanel.setOpaque(false);
			passCheckPanel.setBounds(280, 220, 400, 95);
			joinPanel.add(passCheckPanel);

			JLabel passCheckLabel = new JLabel("비밀번호 확인");
			passCheckLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			passCheckLabel.setBounds(6, 8, 100, 20);
			passCheckPanel.add(passCheckLabel);

			passCheckTextField = new passwordFieldType1(0, 2);
			passCheckTextField.setColumns(10);
			passCheckTextField.setBounds(0, 30, 400, 40);
			passCheckTextField.addKeyListener(SignUpEvent);
			passCheckPanel.add(passCheckTextField);

			passCheckDesLabel = new JLabel("* 필수 입력 정보입니다.");
			passCheckDesLabel.setForeground(Setup.magenta);
			passCheckDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passCheckDesLabel.setBounds(10, 72, 300, 15);
			passCheckPanel.add(passCheckDesLabel);

		//NICKNAME
			JPanel nickNamePanel = new JPanel();
			nickNamePanel.setLayout(null);
			nickNamePanel.setOpaque(false);
			nickNamePanel.setBounds(280, 320, 400, 70);
			joinPanel.add(nickNamePanel);

			JLabel nickNameLabel = new JLabel("닉네임");
			nickNameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			nickNameLabel.setBounds(6, 8, 100, 20);
			nickNamePanel.add(nickNameLabel);

			nickNameTextField = new TextFieldType1(0, 2, "닉네임", 6);
			nickNameTextField.setColumns(10);
			nickNameTextField.setBounds(0, 30, 400, 40);
			nickNamePanel.add(nickNameTextField);

		//NAME
			JPanel namePanel = new JPanel();
			namePanel.setLayout(null);
			namePanel.setOpaque(false);
			namePanel.setBounds(280, 400, 400, 95);
			joinPanel.add(namePanel);

			JLabel nameLabel = new JLabel("이름");
			nameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			nameLabel.setBounds(6, 8, 70, 20);
			namePanel.add(nameLabel);

			nameTextField = new TextFieldType1(0, 2, "이름", 10);
			nameTextField.setColumns(10);
			nameTextField.setBounds(0, 30, 400, 40);
			namePanel.add(nameTextField);

			nameDesLabel = new JLabel("* 필수 입력 정보입니다.");
			nameDesLabel.setForeground(Setup.magenta);
			nameDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			nameDesLabel.setBounds(10, 72, 300, 15);
			namePanel.add(nameDesLabel);

		//BIRTH
			JPanel birthPanel = new JPanel();
			birthPanel.setOpaque(false);
			birthPanel.setBounds(280, 495, 400, 95);
			joinPanel.add(birthPanel);
			birthPanel.setLayout(null);

			JLabel birthLabel = new JLabel("생년월일");
			birthLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			birthLabel.setBounds(6, 8, 70, 20);
			birthPanel.add(birthLabel);

			yearTextField = new onlyNumberTextField(0, 2, 4, "년(4자)");
			yearTextField.setColumns(10);
			yearTextField.setBounds(0, 30, 120, 40);
			birthPanel.add(yearTextField);

			JPanel monthComboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 1));
			monthComboPanel.setBackground(Setup.white);
			monthComboPanel.setBorder(BorderFactory.createLineBorder(Setup.textFieldBorderColor, 2));
			monthComboPanel.setBounds(138, 32, 125, 37);
			birthPanel.add(monthComboPanel);

			monthComboBox = new ComboBoxType1(MON, 120, "월");
			monthComboBox.setFont(new Font(Setup.font, Font.BOLD, 12));
			monthComboPanel.add(monthComboBox);

			dayTextField = new onlyNumberTextField(0, 2, 2, "일");
			dayTextField.setColumns(10);
			dayTextField.setBounds(280, 30, 120, 40);
			birthPanel.add(dayTextField);

			birthDesLabel = new JLabel("* 필수 입력 정보입니다.");
			birthDesLabel.setForeground(Setup.magenta);
			birthDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			birthDesLabel.setBounds(10, 72, 300, 15);
			birthPanel.add(birthDesLabel);

		//EMAIL
			JPanel emailPanel = new JPanel();
			emailPanel.setLayout(null);
			emailPanel.setOpaque(false);
			emailPanel.setBounds(280, 595, 400, 95);
			joinPanel.add(emailPanel);

			JLabel emailLabel = new JLabel("이메일");
			emailLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			emailLabel.setBounds(6, 8, 70, 20);
			emailPanel.add(emailLabel);

			emailTextField = new TextFieldType1(0, 2, "user@jshopping.com", 30);
			emailTextField.setColumns(10);
			emailTextField.setBounds(0, 30, 400, 40);
			emailPanel.add(emailTextField);

			emailDesLabel = new JLabel("");
			emailDesLabel.setForeground(new Color(232, 70, 77));
			emailDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			emailDesLabel.setBounds(10, 72, 300, 15);
			emailPanel.add(emailDesLabel);

		//JOINBTN
			JPanel buttonPanel = new JPanel();
			buttonPanel.setOpaque(false);
			buttonPanel.setBounds(415, 710, 130, 45);
			joinPanel.add(buttonPanel);

			signUpButton = new ButtonType1(25, 7, 7, "가입하기", 16);
			signUpButton.addActionListener(SignUpEvent);
			buttonPanel.add(signUpButton);

		//haveAcc
			JPanel haveAccPanel = new JPanel();
			haveAccPanel.setOpaque(false);
			haveAccPanel.setBounds(282, 770, 300, 30);
			joinPanel.add(haveAccPanel);
			haveAccPanel.setLayout(null);

			haveAccLabel = new JLabel("이미 계정이 있으신가요?");
			haveAccLabel.setBounds(119, 0, 147, 15);
			haveAccLabel.setForeground(Setup.darkGray);
			haveAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			haveAccLabel.addMouseListener(SignUpEvent);
			haveAccPanel.add(haveAccLabel);

			loginLabel = new JLabel("로그인");
			loginLabel.setBounds(249, 1, 57, 15);
			loginLabel.setForeground(Setup.magenta);
			loginLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			loginLabel.addMouseListener(SignUpEvent);
			haveAccPanel.add(loginLabel);
	}
	public String getIdTextField() {
		return idTextField.getText();
	}

	public void focusIdTextField() {
		idTextField.requestFocus();
	}

	public JTextField srcGetIdTextField() {
		return idTextField;
	}

	public String getPassTextField() {
		return passTextField.getText();
	}

	public void focusPassTextField() {
		passTextField.requestFocus();
	}

	public JTextField srcGetPassTextField() {
		return passTextField;
	}

	public String getPassCheckTextField() {
		return passCheckTextField.getText();
	}

	public void focusPassCheckTextField() {
		passCheckTextField.requestFocus();
	}

	public JTextField srcGetPassCheckTextField() {
		return passCheckTextField;
	}

	public String getNickNameTextField() {
		return nickNameTextField.getText();
	}

	public String getNameTextField() {
		return nameTextField.getText();
	}

	public void focusNameTextField() {
		nameTextField.requestFocus();
	}

	public String getYearTextField() {
		return yearTextField.getText();
	}

	public void focusYearTextField() {
		yearTextField.requestFocus();
	}

	public String getDayTextField() {
		return dayTextField.getText();
	}

	public void focusDayTextField() {
		dayTextField.requestFocus();
	}

	public String getEmailTextField() {
		return emailTextField.getText();
	}

	public String getMonthComboBox() {
		return String.valueOf(monthComboBox.getSelectedItem());
	}

	public JButton getSignUpButton() {
		return signUpButton;
	}

	public void setIdDesLabel(String text) {
		idDesLabel.setText(text);
	}

	public void setPassDesLabel(String text) {
		passDesLabel.setText(text);
	}

	public void setPassCheckDesLabel(String text) {
		passCheckDesLabel.setText(text);
	}

	public void setNameDesLabel(String text) {
		nameDesLabel.setText(text);
	}

	public void setBirthDesLabel(String text) {
		birthDesLabel.setText(text);
	}

	public void setEmailDesLabel(String text) {
		emailDesLabel.setText(text);
	}

	public void setScrollPaneValue() {
		scrollPane.getVerticalScrollBar().setValue(0);
	}

	public JLabel getHaveAccLabel() {
		return haveAccLabel;
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}
}

