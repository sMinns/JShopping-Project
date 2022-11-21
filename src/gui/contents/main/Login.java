package gui.contents.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import custom.ButtonType1;
import custom.TextFieldType1;
import gui.common.Frame;
import gui.menu.CustomerMenu;
import system.Setup;

public class Login extends JPanel implements ActionListener {
	private JPanel idPanel, passPanel, logPanel, panel, panel1,panel2,panel3 ,Findidpanel; 
	public Login() {
		this.setLayout(null);
		
		
	        idPanel = new JPanel();
	        idPanel.setLayout(null);
	        idPanel.setBounds(278,150, 407, 95);
	        
	        JLabel id = new JLabel("아이디");
	        id.setBounds(6, 0, 43, 20);
	        id.setFont(new Font(Setup.font, Font.BOLD, 14));
	        id.setForeground(Color.DARK_GRAY);
	        idPanel.add(id);
	        
	        JTextField idtext = new TextFieldType1(30,2,"아이디");
	        idtext.setBounds(0, 25,  407, 44);
	        idtext.setFont(new Font(Setup.font, Font.PLAIN, 12));
	        idPanel.add(idtext);
	        
	        JLabel idDesLabel = new JLabel("* 아이디를 입력해주세요.");
			idDesLabel.setBounds(10, 71, 136, 15);
			idDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel.setForeground(Setup.magenta);
			idPanel.add(idDesLabel);
			
			JLabel idDesLabel2 = new JLabel("* 아이디를 잊으셨나요?");
			idDesLabel2.setBounds(280, 71, 136, 15);
			idDesLabel2.setFont(new Font(Setup.font, Font.BOLD, 11));
			idDesLabel2.setForeground(Setup.magenta);
			idPanel.add(idDesLabel2);
	    
	        
			passPanel = new JPanel();
	        passPanel.setLayout(null);
	        passPanel.setBounds(278, 250, 407, 95);
	        
	        JLabel pass = new JLabel("비밀번호");
	        pass.setBounds(6, 0, 70, 20);
	        pass.setFont(new Font(Setup.font, Font.BOLD, 14));
	        pass.setForeground(Color.DARK_GRAY);
	        passPanel.add(pass);
	        
	        JTextField passtext = new TextFieldType1(30,2,"비밀번호");
	        passtext.setBounds(0, 25,  407, 44);
	        passtext.setFont(new Font(Setup.font, Font.PLAIN, 12));
	        passPanel.add(passtext);
	        
	        JLabel passDesLabel = new JLabel("* 비밀번호를 입력해주세요.");
			passDesLabel.setBounds(10, 71, 170, 15);
			passDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			passDesLabel.setForeground(Setup.magenta);
			passPanel.add(passDesLabel);
			
			JLabel passDesLabel2 = new JLabel("* 비밀번호를 잊으셨나요?");
			passDesLabel2.setBounds(270, 71, 170, 15);
			passDesLabel2.setFont(new Font(Setup.font, Font.BOLD, 11));
			passDesLabel2.setForeground(Setup.magenta);
			passPanel.add(passDesLabel2);
			
	
	        logPanel = new JPanel();
	        logPanel.setLayout(null);
	        logPanel.setBounds(410, 350, 407, 95);
	        
	        JButton login = new ButtonType1(50, 7, 5, "로그인", 16);
	        login.setBounds(6, 0,150,50);
	        logPanel.add(login);
	        login.addActionListener(this);
	        
	                                
	        panel = new JPanel();
	        panel.setLayout(new GridLayout(0,1));
	        this.add(idPanel);
	        this.add(passPanel);
	        this.add(logPanel);
	        
	        add(panel);
	        
	}
	
	

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Setup.changePanel(Frame.menuLayeredPanel, new CustomerMenu("김치찌개"), "홈");
		Setup.changePanel(Frame.contentLayeredPanel, new Home(), "홈");
	
	}
		
}
