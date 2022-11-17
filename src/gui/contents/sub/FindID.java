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

public class FindID extends JPanel {
	private String[] month = {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};
	public FindID() {
		this.setLayout(null);
		
		//NAME
			JPanel namePanel = new JPanel();
			namePanel.setBounds(278, 84, 407, 120);
			this.add(namePanel);
			namePanel.setLayout(null);
			
			JLabel namelabel = new JLabel("이름");
			namelabel.setBounds(0, 10, 50, 15);
			namePanel.add(namelabel);
			namelabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			namelabel.setForeground(Setup.darkGray); 
			
			
			JLabel nameDeslabel = new JLabel("* 이름을 입력해주세요.");
			nameDeslabel.setBounds(10, 80, 165, 15);
			namePanel.add(nameDeslabel);
			nameDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			nameDeslabel.setForeground(Setup.magenta);
			
			JTextField nametextField = new TextFieldType1(60, 2, "이름");
			nametextField.setFont(new Font(Setup.font, Font.PLAIN, 12));;
			nametextField.setBounds(0, 35, 407, 44);
			namePanel.add(nametextField);
		
		//Birth
			JPanel birthPanel = new JPanel();
			birthPanel.setBounds(278, 201, 407, 120);
			this.add(birthPanel);
			birthPanel.setLayout(null);
			
			JLabel birthlabel = new JLabel("생년월일");
			birthlabel.setBounds(0, 10, 90, 32);
			birthPanel.add(birthlabel);
			birthlabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			birthlabel.setForeground(Setup.darkGray); 
			
			JLabel birthDeslabel = new JLabel("* 생년월일을 입력해주세요.");
			birthDeslabel.setBounds(10, 85, 160, 15);
			birthPanel.add(birthDeslabel);
			birthDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			birthDeslabel.setForeground(Setup.magenta);
			
			JTextField yeartextField = new TextFieldType1(0, 2, "년(4자)");
			yeartextField.setBounds(0, 40, 120, 42);
			birthPanel.add(yeartextField);
			yeartextField.setFont(new Font(Setup.font, Font.PLAIN, 11));
			yeartextField.setForeground(Setup.darkGray);	
			
			JTextField daytextField = new TextFieldType1(10, 2, "일");
			daytextField.setBounds(287, 40, 120, 42);
			birthPanel.add(daytextField);
			daytextField.setFont(new Font(Setup.font, Font.PLAIN, 11));
			daytextField.setForeground(Setup.darkGray);			
			
			JPanel montComboPanel = new JPanel();
			montComboPanel.setBounds(144, 45, 120, 36);
			birthPanel.add(montComboPanel);
			
			JComboBox monthComboBox = new ComboBoxType1(month, 120, "월");
			monthComboBox.setFont(new Font(Setup.font, Font.PLAIN, 11));
			monthComboBox.setForeground(Setup.darkGray);
			montComboPanel.add(monthComboBox);
		
		//IDBTN
			JPanel idFindbtnPanel = new JPanel();
			idFindbtnPanel.setBounds(278, 371, 407, 62);
			this.add(idFindbtnPanel);
			
			JButton idFindBtn = new ButtonType1(25, 8, 7, "아이디 찾기", 16);
			idFindbtnPanel.add(idFindBtn);
			idFindBtn.setFont(new Font(Setup.font, Font.BOLD, 16));	
		
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
				
		
	}
}
