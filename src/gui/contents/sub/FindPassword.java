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

public class FindPassword extends JPanel implements ActionListener, MouseListener {
	private String[] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	private JTextField idTextField, nameTextField, yearTextField, dayTextField;
	private JLabel idDesLabel, nameDesLabel, birthDesLabel, noAccLabel, signUpLabel;
	private JButton findPasswordButton;
	private JComboBox monthComboBox;
	public FindPassword() {
		this.setLayout(null);
		
		//ID
			JPanel idPanel = new JPanel(); 
			idPanel.setBounds(278, 60, 407, 95);
			this.add(idPanel);
			idPanel.setLayout(null);
			
			JLabel idLabel = new JLabel("아이디"); 
			idLabel.setBounds(6, 3, 43, 20);
			idLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			idPanel.add(idLabel);
			
			idTextField = new TextFieldType1(0, 2, "아이디");
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
			namePanel.setBounds(278, 155, 407, 95);
			this.add(namePanel);
			namePanel.setLayout(null);
			
			nameTextField = new TextFieldType1(0, 2, "이름");
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
			
			JPanel birthPanel = new JPanel();
			birthPanel.setBounds(278, 250, 407, 95);
			this.add(birthPanel);
			birthPanel.setLayout(null);
		
		//Birth
			JLabel birthLabel = new JLabel("생년월일");
			birthLabel.setBounds(6, 3, 67, 20);
			birthLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			birthPanel.add(birthLabel);
					
			yearTextField = new TextFieldType1(0, 2, "년(4자)");
			yearTextField.setBounds(0, 27, 120, 42);;
			birthPanel.add(yearTextField);
			
			dayTextField = new TextFieldType1(0, 2, "일");
			dayTextField.setBounds(287, 27, 120, 42);
			birthPanel.add(dayTextField);
			
			birthDesLabel = new JLabel();
			birthDesLabel.setBounds(10, 71, 158, 15);
			birthDesLabel.setForeground(Setup.magenta);
			birthDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			birthPanel.add(birthDesLabel);
			
			JPanel montComboPanel = new JPanel();
			montComboPanel.setBounds(144, 30, 120, 36);
			birthPanel.add(montComboPanel);
			
			monthComboBox = new ComboBoxType1(month, 120, "월");
			montComboPanel.add(monthComboBox);
		
		//JOIN
			JPanel signUpPanel = new JPanel();
			signUpPanel.setBounds(278, 432, 407, 23);
			this.add(signUpPanel);
			signUpPanel.setLayout(null);
			
			noAccLabel = new JLabel("계정이 없으신가요?");
			noAccLabel.setBounds(130, 1, 102, 15);
			signUpPanel.add(noAccLabel);
			noAccLabel.setForeground(Setup.darkGray);
			noAccLabel.addMouseListener(this);
			noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			
			signUpLabel = new JLabel("회원가입");
			signUpLabel.setBounds(232, 1, 57, 15);
			signUpLabel.setForeground(Setup.magenta);
			signUpLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			signUpLabel.addMouseListener(this);
			signUpPanel.add(signUpLabel);
					
			JPanel findPasswordButtonPanel = new JPanel();
			findPasswordButtonPanel.setBounds(278, 371, 407, 62);
			this.add(findPasswordButtonPanel);
		
		//PASSBTN
			findPasswordButton = new ButtonType1(17, 8, 7, "비밀번호 찾기", 16);
			findPasswordButton.addActionListener(this);
			findPasswordButtonPanel.add(findPasswordButton);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findPasswordButton) {
			if(idTextField.getText().equals("아이디")) {
				idDesLabel.setText("* 아이디를 입력해주세요.");
			}else { idDesLabel.setText(""); }
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
