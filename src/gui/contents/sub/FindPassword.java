package gui.contents.sub;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextFieldType1;
import custom.onlyNumberTextField;
import event.FindPasswordEvent;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class FindPassword extends JPanel {
	private String[] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	private JTextField idTextField, nameTextField;
	private JFormattedTextField yearTextField, dayTextField;
	private JLabel idDesLabel, nameDesLabel, birthDesLabel, noAccLabel, signUpLabel;
	private JButton findPasswordButton;
	private JComboBox monthComboBox;
	public FindPassword() {
		this.setLayout(null);
		this.setBackground(Setup.bgLightGray);
		FindPasswordEvent findPasswordEvent = new FindPasswordEvent(this);
		//ID
			JPanel idPanel = new JPanel();
			idPanel.setOpaque(false);
			idPanel.setBounds(278, 60, 407, 95);
			this.add(idPanel);
			idPanel.setLayout(null);
			
			JLabel idLabel = new JLabel("아이디"); 
			idLabel.setBounds(6, 3, 43, 20);
			idLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			idPanel.add(idLabel);
			
			idTextField = new TextFieldType1(0, 2, "아이디", 15);
			idTextField.setBounds(0, 25, 407, 44);
			idPanel.add(idTextField);
			idTextField.setColumns(10);
			
			idDesLabel = new JLabel();
			idDesLabel.setBounds(10, 71, 136, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);
		
		//NAME
			JPanel namePanel = new JPanel();
			namePanel.setOpaque(false);
			namePanel.setBounds(278, 155, 407, 95);
			this.add(namePanel);
			namePanel.setLayout(null);
			
			nameTextField = new TextFieldType1(0, 2, "이름", 10);
			nameTextField.setBounds(0, 25, 407, 44);
			nameTextField.setColumns(10);
			namePanel.add(nameTextField);
			
			nameDesLabel = new JLabel();
			nameDesLabel.setBounds(10, 71, 135, 15);
			nameDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			nameDesLabel.setForeground(Setup.magenta);
			namePanel.add(nameDesLabel);
			
			JLabel nameLabel = new JLabel("이름");
			nameLabel.setBounds(6, 3, 43, 20);
			namePanel.add(nameLabel);
			nameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));

		//Birth
			JPanel birthPanel = new JPanel();
			birthPanel.setOpaque(false);
			birthPanel.setBounds(278, 250, 407, 95);
			this.add(birthPanel);
			birthPanel.setLayout(null);

			JLabel birthLabel = new JLabel("생년월일");
			birthLabel.setBounds(6, 3, 67, 20);
			birthLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			birthPanel.add(birthLabel);
					
			yearTextField = new onlyNumberTextField(0, 2, 4, "년(4자)");
			yearTextField.setBounds(0, 27, 120, 42);;
			birthPanel.add(yearTextField);
			
			dayTextField = new onlyNumberTextField(0, 2, 2, "일");
			dayTextField.setBounds(287, 27, 120, 42);
			birthPanel.add(dayTextField);
			
			birthDesLabel = new JLabel();
			birthDesLabel.setBounds(10, 71, 158, 15);
			birthDesLabel.setForeground(Setup.magenta);
			birthDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			birthPanel.add(birthDesLabel);
			
			JPanel monthComboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 1));
			monthComboPanel.setBackground(Setup.white);
			monthComboPanel.setBorder(BorderFactory.createLineBorder(Setup.textFieldBorderColor, 2));
			monthComboPanel.setBounds(144, 29, 125, 39);
			birthPanel.add(monthComboPanel);
			
			monthComboBox = new ComboBoxType1(month, 120, "월");
			monthComboPanel.add(monthComboBox);
		
		//JOIN
			JPanel signUpPanel = new JPanel();
			signUpPanel.setOpaque(false);
			signUpPanel.setBounds(278, 432, 407, 23);
			this.add(signUpPanel);
			signUpPanel.setLayout(null);
			
			noAccLabel = new JLabel("계정이 없으신가요?");
			noAccLabel.setBounds(130, 1, 102, 15);
			signUpPanel.add(noAccLabel);
			noAccLabel.setForeground(Setup.darkGray);
			noAccLabel.addMouseListener(findPasswordEvent);
			noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			
			signUpLabel = new JLabel("회원가입");
			signUpLabel.setBounds(232, 1, 57, 15);
			signUpLabel.setForeground(Setup.magenta);
			signUpLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			signUpLabel.addMouseListener(findPasswordEvent);
			signUpPanel.add(signUpLabel);

		//PASSBTN
			JPanel findPasswordButtonPanel = new JPanel();
			findPasswordButtonPanel.setOpaque(false);
			findPasswordButtonPanel.setBounds(278, 371, 407, 62);
			this.add(findPasswordButtonPanel);

			findPasswordButton = new ButtonType1(17, 8, 7, "비밀번호 찾기", 16);
			findPasswordButton.addActionListener(findPasswordEvent);
			findPasswordButtonPanel.add(findPasswordButton);
		}

	public String getIdTextField() {
		return idTextField.getText();
	}

	public void focusIdTextField() {
		idTextField.requestFocus();
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

	public void setIdDesLabel(String text) {
		idDesLabel.setText(text);
	}

	public void setNameDesLabel(String text) {
		nameDesLabel.setText(text);
	}

	public void setBirthDesLabel(String text) {
		birthDesLabel.setText(text);
	}

	public JLabel getNoAccLabel() {
		return noAccLabel;
	}

	public JLabel getSignUpLabel() {
		return signUpLabel;
	}

	public JButton getFindPasswordButton() {
		return findPasswordButton;
	}

	public String getMonthComboBox() {
		return (String) monthComboBox.getSelectedItem();
	}
}
