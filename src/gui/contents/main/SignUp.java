package gui.contents.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextFieldType1;
import custom.passwordFieldType1;
import system.Setup;

public class SignUp extends JPanel {
	
	String MON[] = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	
	private JTextField idTextField, passTextField, passCheckTextField, nickNameTextField, nameTextField, yearTextField, dayTextField, emailTextField;
	private JComboBox monthComboBox;
	private JPanel joinPanel, idPanel, passPanel, passCheckPanel, nickNamePanel, namePanel, birthPanel, monthComboPanel, haveAccPanel;
	private JButton joinBtn;
	private JLabel idLabel, idDesLabel, passLabel, passDesLabel, passCheckLabel, passCheckDesLabel, nickNameLabel, nameLabel, nameDesLabel, birthDesLabel, emailLabel, emailDesLabel, haveAccLabel, loginLabel;
		
	public SignUp() {
		Setup.changeInsets(10,10,10,6);
		this.setLayout(new CardLayout());
		
		//SCROLL         
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBorder(null);
	        Setup.changeScrollBar(scrollPane);
	        this.add(scrollPane);
	     
	        JPanel joinPanel = new JPanel();
	        joinPanel.setPreferredSize(new Dimension(this.getWidth(), 820));
	        joinPanel.setLayout(null);      
	        scrollPane.setViewportView(joinPanel);
		
		//ID
			JPanel idPanel = new JPanel();
			idPanel.setBounds(280, 20, 400, 95);
			joinPanel.add(idPanel);
			idPanel.setLayout(null);
			
			JLabel idLabel = new JLabel("아이디");
			idLabel.setBounds(6, 8, 70, 20);
			idPanel.add(idLabel);
			idLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			
			JTextField idTextField = new TextFieldType1(0, 2, "아이디");
			idTextField.setBounds(0, 30, 400, 40);
			idPanel.add(idTextField);
			idTextField.setColumns(10);
			
			JLabel idDesLabel = new JLabel("* 필수 입력 정보입니다.");
			idDesLabel.setBounds(10, 72, 140, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);
			
		//PASSWORD
			JPanel passPanel = new JPanel();
			passPanel.setLayout(null);
			passPanel.setBounds(280, 120, 400, 95);
			joinPanel.add(passPanel);
			
			JLabel passLabel = new JLabel("비밀번호");
			passLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			passLabel.setBounds(6, 8, 70, 20);
			passPanel.add(passLabel);
			
			passwordFieldType1 passTextField = new passwordFieldType1(0, 2);
			passTextField.setColumns(10);
			passTextField.setBounds(0, 30, 400, 40);
			passPanel.add(passTextField);
			
			JLabel passDesLabel = new JLabel("* 필수 입력 정보입니다.");
			passDesLabel.setForeground(Setup.magenta);
			passDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passDesLabel.setBounds(10, 72, 140, 15);
			passPanel.add(passDesLabel);
			
		//PASSCHECK
			JPanel passCheckPanel = new JPanel();
			passCheckPanel.setLayout(null);
			passCheckPanel.setBounds(280, 220, 400, 95);
			joinPanel.add(passCheckPanel);
			
			JLabel passCheckLabel = new JLabel("비밀번호 확인");
			passCheckLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			passCheckLabel.setBounds(6, 8, 100, 20);
			passCheckPanel.add(passCheckLabel);
			
			passwordFieldType1 passCheckTextField = new passwordFieldType1(0, 2);
			passCheckTextField.setColumns(10);
			passCheckTextField.setBounds(0, 30, 400, 40);
			passCheckPanel.add(passCheckTextField);
			
			JLabel passCheckDesLabel = new JLabel("* 필수 입력 정보입니다.");
			passCheckDesLabel.setForeground(Setup.magenta);
			passCheckDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passCheckDesLabel.setBounds(10, 72, 140, 15);
			passCheckPanel.add(passCheckDesLabel);
			
		//NICKNAME
			JPanel nickNamePanel = new JPanel();
			nickNamePanel.setLayout(null);
			nickNamePanel.setBounds(280, 320, 400, 70);
			joinPanel.add(nickNamePanel);
			
			JLabel nickNameLabel = new JLabel("닉네임");
			nickNameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			nickNameLabel.setBounds(6, 8, 100, 20);
			nickNamePanel.add(nickNameLabel);
			
			TextFieldType1 nickNameTextField = new TextFieldType1(0, 2, "닉네임");
			nickNameTextField.setColumns(10);
			nickNameTextField.setBounds(0, 30, 400, 40);
			nickNamePanel.add(nickNameTextField);
			
		//NAME
			JPanel namePanel = new JPanel();
			namePanel.setLayout(null);
			namePanel.setBounds(280, 400, 400, 95);
			joinPanel.add(namePanel);
			
			JLabel nameLabel = new JLabel("이름");
			nameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			nameLabel.setBounds(6, 8, 70, 20);
			namePanel.add(nameLabel);
			
			TextFieldType1 nameTextField = new TextFieldType1(0, 2, "이름");
			nameTextField.setColumns(10);
			nameTextField.setBounds(0, 30, 400, 40);
			namePanel.add(nameTextField);
			
			JLabel nameDesLabel = new JLabel("* 필수 입력 정보입니다.");
			nameDesLabel.setForeground(Setup.magenta);
			nameDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			nameDesLabel.setBounds(10, 72, 140, 15);
			namePanel.add(nameDesLabel);
			
		//BIRTH
			JPanel birthPanel = new JPanel();
			birthPanel.setBounds(280, 495, 400, 95);
			joinPanel.add(birthPanel);
			birthPanel.setLayout(null);
			
			JLabel birthLabel = new JLabel("생년월일");
			birthLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			birthLabel.setBounds(6, 8, 70, 20);
			birthPanel.add(birthLabel);
			
			TextFieldType1 yearTextField = new TextFieldType1(0, 2, "년(4자)");
			yearTextField.setColumns(10);
			yearTextField.setBounds(0, 30, 120, 40);
			birthPanel.add(yearTextField);
			
			JLabel birthDesLabel = new JLabel("* 필수 입력 정보입니다.");
			birthDesLabel.setForeground(Setup.magenta);
			birthDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			birthDesLabel.setBounds(10, 72, 130, 15);
			birthPanel.add(birthDesLabel);
			
			JPanel monthComboPanel = new JPanel();
			monthComboPanel.setBounds(140, 30, 120, 40);
			birthPanel.add(monthComboPanel);;
			
			monthComboBox = new ComboBoxType1(MON, 120, "월");
			monthComboBox.setFont(new Font(Setup.font, Font.BOLD, 12));
			monthComboPanel.add(monthComboBox);
			
			TextFieldType1 dayTextField = new TextFieldType1(0, 2, "일");
			dayTextField.setColumns(10);
			dayTextField.setBounds(280, 30, 120, 40);
			birthPanel.add(dayTextField);
			
		//EMAIL
			JPanel emailPanel = new JPanel();
			emailPanel.setLayout(null);
			emailPanel.setBounds(280, 595, 400, 95);
			joinPanel.add(emailPanel);
			
			JLabel emailLabel = new JLabel("이메일");
			emailLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			emailLabel.setBounds(6, 8, 70, 20);
			emailPanel.add(emailLabel);
			
			TextFieldType1 emailTextField = new TextFieldType1(0, 2, "이메일");
			emailTextField.setColumns(10);
			emailTextField.setBounds(0, 30, 400, 40);
			emailPanel.add(emailTextField);
			
			JLabel emailDesLabel = new JLabel("");
			emailDesLabel.setForeground(new Color(232, 70, 77));
			emailDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			emailDesLabel.setBounds(10, 72, 140, 15);
			emailPanel.add(emailDesLabel);
			
		//JOINBTN
			JPanel joinBtnPanel = new JPanel();
			joinBtnPanel.setBounds(415, 710, 130, 45);
			joinPanel.add(joinBtnPanel);
			
			joinBtn = new ButtonType1(25, 7, 7, "가입하기", 16);
			joinBtn.addActionListener(null);
			joinBtnPanel.add(joinBtn);
			
		//haveAcc
			JPanel haveAccPanel = new JPanel();
			haveAccPanel.setBounds(282, 770, 300, 30);
			joinPanel.add(haveAccPanel);
			haveAccPanel.setLayout(null);
			
			JLabel haveAccLabel = new JLabel("이미 계정이 있으신가요?");
			haveAccLabel.setBounds(119, 0, 147, 15);
			haveAccLabel.setForeground(Setup.darkGray);
			haveAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			haveAccPanel.add(haveAccLabel);
			
			JLabel loginLabel = new JLabel("로그인");
			loginLabel.setBounds(249, 1, 57, 15);
			loginLabel.setForeground(Setup.magenta);
			loginLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			haveAccPanel.add(loginLabel);					
	}
}
