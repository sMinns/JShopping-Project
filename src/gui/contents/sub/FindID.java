package gui.contents.sub;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextFieldType1;
import custom.onlyNumberTextField;
import event.FindIDEvent;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class FindID extends JPanel {
	private JLabel noAccLabel, signUpLabel, nameDesLabel, birthDesLabel;
	private JButton findIdButton;
	private JTextField nameTextField;
	private JFormattedTextField yearTextField, dayTextField;
	private JComboBox monthComboBox;
	private String[] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	public FindID() {
		FindIDEvent FindIDEvent = new FindIDEvent(this);
		this.setLayout(null);
		this.setBackground(Setup.bgLightGray);
		//NAME
		JPanel namePanel = new JPanel();
		namePanel.setOpaque(false);
		namePanel.setBounds(278, 84, 407, 120);
		this.add(namePanel);
		namePanel.setLayout(null);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(6, 15, 50, 15);
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
		nameLabel.setForeground(Setup.darkGray);


		nameDesLabel = new JLabel();
		nameDesLabel.setBounds(10, 80, 165, 15);
		namePanel.add(nameDesLabel);
		nameDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		nameDesLabel.setForeground(Setup.magenta);

		nameTextField = new TextFieldType1(60, 2, "이름", 10);
		nameTextField.setBounds(0, 35, 407, 44);
		namePanel.add(nameTextField);

		//Birth
		JPanel birthPanel = new JPanel();
		birthPanel.setOpaque(false);
		birthPanel.setBounds(278, 201, 407, 120);
		this.add(birthPanel);
		birthPanel.setLayout(null);

		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(6, 12, 90, 32);
		birthPanel.add(birthLabel);
		birthLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
		birthLabel.setForeground(Setup.darkGray);

		birthDesLabel = new JLabel();
		birthDesLabel.setBounds(10, 85, 160, 15);
		birthPanel.add(birthDesLabel);
		birthDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		birthDesLabel.setForeground(Setup.magenta);

		yearTextField = new onlyNumberTextField(0, 2, 4, "년(4자)");
		yearTextField.setBounds(0, 40, 120, 42);
		birthPanel.add(yearTextField);

		dayTextField = new onlyNumberTextField(10, 2, 2, "일");
		dayTextField.setBounds(287, 40, 120, 42);
		birthPanel.add(dayTextField);

		JPanel montComboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 1));
		montComboPanel.setBackground(Setup.white);
		montComboPanel.setBorder(BorderFactory.createLineBorder(Setup.textFieldBorderColor, 2));
		montComboPanel.setBounds(144, 43, 125, 39);
		birthPanel.add(montComboPanel);

		monthComboBox = new ComboBoxType1(month, 120, "월");
		monthComboBox.setFont(new Font(Setup.font, Font.PLAIN, 11));
		monthComboBox.setForeground(Setup.darkGray);
		montComboPanel.add(monthComboBox);

		//IDBTN
		JPanel findIdButtonPanel = new JPanel();
		findIdButtonPanel.setOpaque(false);
		findIdButtonPanel.setBounds(278, 340, 407, 62);
		this.add(findIdButtonPanel);

		findIdButton = new ButtonType1(25, 8, 7, "아이디 찾기", 16);
		findIdButton.setFont(new Font(Setup.font, Font.BOLD, 16));
		findIdButton.addActionListener(FindIDEvent);
		findIdButtonPanel.add(findIdButton);

		//JOIN
		JPanel signUpPanel = new JPanel();
		signUpPanel.setOpaque(false);
		signUpPanel.setBounds(278, 400, 407, 23);
		this.add(signUpPanel);
		signUpPanel.setLayout(null);

		noAccLabel = new JLabel("계정이 없으신가요?");
		noAccLabel.setBounds(130, 1, 102, 15);
		noAccLabel.setForeground(Setup.darkGray);
		noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		noAccLabel.addMouseListener(FindIDEvent);
		signUpPanel.add(noAccLabel);

		signUpLabel = new JLabel("회원가입");
		signUpLabel.setBounds(232, 1, 57, 15);
		signUpLabel.setForeground(Setup.magenta);
		signUpLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		signUpLabel.addMouseListener(FindIDEvent);
		signUpPanel.add(signUpLabel);
	}

	public JLabel getNoAccLabel() {
		return noAccLabel;
	}

	public JLabel getSignUpLabel() {
		return signUpLabel;
	}

	public void setNameDesLabel(String text) {
		nameDesLabel.setText(text);
	}

	public void setBirthDesLabel(String text) {
		birthDesLabel.setText(text);
	}

	public JButton getFindIdButton() {
		return findIdButton;
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

	public String getMonthComboBox() {
		return (String) monthComboBox.getSelectedItem();
	}
}
