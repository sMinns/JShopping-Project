package gui.contents.sub;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextFieldType1;
import system.Setup;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class FindPassword extends JPanel {
	private String[] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	public FindPassword() {					
		this.setLayout(null);
		
		//ID
			JPanel idPanel = new JPanel(); 
			idPanel.setBounds(278, 60, 407, 95);
			this.add(idPanel);
			idPanel.setLayout(null);
			
			JLabel idLabel = new JLabel("아이디"); 
			idLabel.setBounds(6, 0, 43, 20);
			idLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			idPanel.add(idLabel);
			
			JTextField idTextField = new TextFieldType1(0, 2, "아이디");
			idTextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			idTextField.setBounds(0, 25, 407, 44);
			idPanel.add(idTextField);
			idTextField.setColumns(10);
			
			JLabel idDesLabel = new JLabel("* 아이디를 입력해주세요.");
			idDesLabel.setBounds(10, 71, 136, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);
		
		//NAME
			JPanel namePanel = new JPanel();
			namePanel.setBounds(278, 155, 407, 95);
			this.add(namePanel);
			namePanel.setLayout(null);
			
			JTextField nameTextField = new TextFieldType1(0, 2, "이름");
			nameTextField.setFont(new Font(Setup.font, Font.PLAIN, 12));;
			nameTextField.setBounds(0, 25, 407, 44);
			nameTextField.setColumns(10);
			namePanel.add(nameTextField);
			
			JLabel nameDesLabel = new JLabel("* 이름을 입력해주세요.");
			nameDesLabel.setBounds(10, 71, 135, 15);
			nameDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			nameDesLabel.setForeground(Setup.magenta);
			namePanel.add(nameDesLabel);
			
			JLabel nameLabel = new JLabel("이름");
			nameLabel.setBounds(6, 0, 43, 20);
			namePanel.add(nameLabel);
			nameLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			
			JPanel birthPanel = new JPanel();
			birthPanel.setBounds(278, 250, 407, 95);
			this.add(birthPanel);
			birthPanel.setLayout(null);
		
		//Birth
			JLabel birthLabel = new JLabel("생년월일");
			birthLabel.setBounds(6, 0, 67, 20);
			birthLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			birthPanel.add(birthLabel);
					
			JTextField yearTextField = new TextFieldType1(0, 2, "년(4자)");
			yearTextField.setBounds(0, 27, 120, 42);;
			yearTextField.setFont(new Font(Setup.font, Font.PLAIN, 11));
			yearTextField.setForeground(Setup.darkGray);	
			birthPanel.add(yearTextField);
			
			JTextField dayTextField = new TextFieldType1(0, 2, "일");
			dayTextField.setBounds(287, 27, 120, 42);
			dayTextField.setFont(new Font(Setup.font, Font.PLAIN, 11));
			dayTextField.setForeground(Setup.darkGray);	
			birthPanel.add(dayTextField);
			
			JLabel birthDesLabel = new JLabel("* 생년월일을 입력해주세요.");
			birthDesLabel.setBounds(10, 71, 158, 15);
			birthDesLabel.setForeground(Setup.magenta);
			birthDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			birthPanel.add(birthDesLabel);
			
			JPanel montComboPanel = new JPanel();
			montComboPanel.setBounds(144, 30, 120, 36);
			birthPanel.add(montComboPanel);
			
			JComboBox monthComboBox = new ComboBoxType1(month, 120, "월");
			monthComboBox.setFont(new Font(Setup.font, Font.PLAIN, 11));
			monthComboBox.setForeground(Setup.darkGray);
			montComboPanel.add(monthComboBox);
		
		//JOIN
			JPanel joinPanel = new JPanel();
			joinPanel.setBounds(278, 432, 407, 23);
			this.add(joinPanel);
			joinPanel.setLayout(null);
			
			JLabel noAccLabel = new JLabel("계정이 없으신가요?");
			noAccLabel.setBounds(130, 1, 102, 15);
			joinPanel.add(noAccLabel);
			noAccLabel.setForeground(Setup.darkGray);
			noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			
			JLabel joinLabel = new JLabel("회원가입");
			joinLabel.setBounds(232, 1, 57, 15);
			joinPanel.add(joinLabel);
			joinLabel.setForeground(Setup.magenta);
			joinLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
					
			JPanel passFindbtnPanel = new JPanel();
			passFindbtnPanel.setBounds(278, 371, 407, 62);
			this.add(passFindbtnPanel);
		
		//PASSBTN
			JButton passFindBtn = new ButtonType1(17, 8, 7, "비밀번호 찾기", 16);
			passFindbtnPanel.add(passFindBtn);
			passFindBtn.setFont(new Font(Setup.font, Font.BOLD, 16));	
		}
}
