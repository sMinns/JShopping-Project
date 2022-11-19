package gui.contents.main;

import system.Setup;

import javax.swing.*;

import custom.ButtonType1;
import custom.passwordFieldType1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static system.Setup.textFieldBorderColor;

public class ResetPassword extends JPanel {
   
    public ResetPassword() {
        
    
          this.setLayout(null);
          
          
          //비밀번호 재설정
             JPanel newPanel = new JPanel();
             newPanel.setBounds(278, 80, 407, 120);
             this.add(newPanel);
             newPanel.setLayout(null);
             
             JLabel newlabel = new JLabel("새 비밀번호");
             newlabel.setBounds(6, 12, 200, 32);
             newPanel.add(newlabel);
             newlabel.setFont(new Font(Setup.font, Font.BOLD, 14));
             newlabel.setForeground(Setup.darkGray); 
             
             JLabel newDeslabel = new JLabel("* 새로운 비밀번호를 입력해주세요.");
             newDeslabel.setBounds(10, 85, 200, 15);
             newPanel.add(newDeslabel);
             newDeslabel.setFont(new Font(Setup.font, Font.BOLD, 12));
             newDeslabel.setForeground(Setup.magenta);
             
             passwordFieldType1 pd = new passwordFieldType1(60, 2);
             pd.setBounds(0, 35, 407, 44);
             newPanel.add(pd);
          
             //새 비밀번호 확인
             JPanel newpdPanel = new JPanel();
             JLabel newlabel1 = new JLabel("새 비밀번호 확인");
             newpdPanel.add(newlabel1);
             newlabel1.setFont(new Font(Setup.font, Font.BOLD, 14));
             newlabel1.setForeground(Setup.darkGray); 
             newlabel1.setBounds(6, 12, 200, 32);
             newpdPanel.setBounds(278, 200, 407, 120);
             this.add(newpdPanel);
             newpdPanel.setLayout(null);
             
             passwordFieldType1 chpd = new passwordFieldType1(60, 2);
             chpd.setBounds(0, 35, 407, 44);
             newpdPanel.add(chpd);
           
             JLabel newpdDeslabel = new JLabel("* 비밀번호를 다시 입력해주세요.");
             newpdDeslabel.setBounds(10, 85, 200, 15);
             newpdPanel.add(newpdDeslabel);
             newpdDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
             newpdDeslabel.setForeground(Setup.magenta);
             
             //버튼
             JPanel chpassPanel = new JPanel();
             chpassPanel.setBounds(278, 300, 407, 62);
             this.add(chpassPanel);
             
          JButton chpassBtn = new ButtonType1(30, 8, 10, "비밀번호 변경", 16);
          chpassPanel.add(chpassBtn);
          chpassBtn.setFont(new Font(Setup.font, Font.BOLD, 16));   
             
             
             
             
    }
    }
  