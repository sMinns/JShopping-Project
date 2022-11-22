package gui.contents.sub;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextFieldType1;
import gui.common.Frame;
import gui.contents.main.SignUp;
import gui.menu.GuestMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FindID extends JPanel implements ActionListener, MouseListener {
	private JLabel noAccLabel, signUpLabel, nameDesLabel, birthDesLabel;
	private JButton findIdButton;
	private JTextField yearTextField, dayTextField, nameTextField;
	private JComboBox monthComboBox;
	private String[] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	public FindID() {
		this.setLayout(null);

		//NAME
		JPanel namePanel = new JPanel();
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

		nameTextField = new TextFieldType1(60, 2, "이름");
		nameTextField.setBounds(0, 35, 407, 44);
		namePanel.add(nameTextField);

		//Birth
		JPanel birthPanel = new JPanel();
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

		yearTextField = new TextFieldType1(0, 2, "년(4자)");
		yearTextField.setBounds(0, 40, 120, 42);
		birthPanel.add(yearTextField);

		dayTextField = new TextFieldType1(10, 2, "일");
		dayTextField.setBounds(287, 40, 120, 42);
		birthPanel.add(dayTextField);

		JPanel montComboPanel = new JPanel();
		montComboPanel.setBounds(144, 42, 120, 36);
		birthPanel.add(montComboPanel);

		monthComboBox = new ComboBoxType1(month, 120, "월");
		monthComboBox.setFont(new Font(Setup.font, Font.PLAIN, 11));
		monthComboBox.setForeground(Setup.darkGray);
		montComboPanel.add(monthComboBox);

		//IDBTN
		JPanel findIdButtonPanel = new JPanel();
		findIdButtonPanel.setBounds(278, 340, 407, 62);
		this.add(findIdButtonPanel);

		findIdButton = new ButtonType1(25, 8, 7, "아이디 찾기", 16);
		findIdButton.setFont(new Font(Setup.font, Font.BOLD, 16));
		findIdButton.addActionListener(this);
		findIdButtonPanel.add(findIdButton);

		//JOIN
		JPanel signUpPanel = new JPanel();
		signUpPanel.setBounds(278, 400, 407, 23);
		this.add(signUpPanel);
		signUpPanel.setLayout(null);

		noAccLabel = new JLabel("계정이 없으신가요?");
		noAccLabel.setBounds(130, 1, 102, 15);
		noAccLabel.setForeground(Setup.darkGray);
		noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		noAccLabel.addMouseListener(this);
		signUpPanel.add(noAccLabel);

		signUpLabel = new JLabel("회원가입");
		signUpLabel.setBounds(232, 1, 57, 15);
		signUpLabel.setForeground(Setup.magenta);
		signUpLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
		signUpLabel.addMouseListener(this);
		signUpPanel.add(signUpLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findIdButton) {
			if(nameTextField.getText().equals("이름")) {
				nameDesLabel.setText("* 이름을 입력해주세요.");
			}else { nameDesLabel.setText(""); }
			if(yearTextField.getText().equals("년(4자)") || dayTextField.getText().equals("일") ||
			monthComboBox.getSelectedItem().equals("월")) {
				birthDesLabel.setText("* 생년월일을 입력해주세요.");
			}else { birthDesLabel.setText(""); }
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == noAccLabel || e.getSource() == signUpLabel) {
			Setup.changePanel(Frame.contentLayeredPanel, new SignUp(), "회원가입");
			Setup.selectMenuPanel(GuestMenu.GuestPanel[2]);
		}
	}
	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
