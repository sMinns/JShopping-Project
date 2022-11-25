package gui.contents.main;

import custom.ButtonType1;
import custom.passwordFieldType1;
import event.ResetPasswordEvent;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class ResetPassword extends JPanel {
   int num;
   private JLabel passwordDesLabel, passwordConfirmDesLabel;
   private JPasswordField passwordField, passwordConfirmField;
   private JButton changePasswordButton;
    public ResetPassword(int num) {
       ResetPasswordEvent resetPasswordEvent = new ResetPasswordEvent(this);
       this.num = num;
       this.setLayout(null);
          
          //비밀번호 재설정
             JPanel passwordPanel = new JPanel();
             passwordPanel.setLayout(null);
             passwordPanel.setBounds(278, 180, 407, 100);
             this.add(passwordPanel);
             
             JLabel passwordLabel = new JLabel("새 비밀번호");
             passwordLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
             passwordLabel.setForeground(Setup.darkGray);
             passwordLabel.setBounds(6, 8, 200, 32);
             passwordPanel.add(passwordLabel);
             
             passwordDesLabel = new JLabel("* 새로운 비밀번호를 입력해주세요.");
             passwordDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
             passwordDesLabel.setForeground(Setup.magenta);
             passwordDesLabel.setBounds(10, 81, 200, 15);
             passwordPanel.add(passwordDesLabel);
             
             passwordField = new passwordFieldType1(60, 2);
             passwordField.setBounds(0, 35, 407, 44);
             passwordField.addKeyListener(resetPasswordEvent);
             passwordPanel.add(passwordField);
          
         //새 비밀번호 확인
             JPanel passwordConfirmPanel = new JPanel();
             passwordConfirmPanel.setLayout(null);
             passwordConfirmPanel.setBounds(278, 280, 407, 120);
             this.add(passwordConfirmPanel);
             

             JLabel passwordConfirmLabel = new JLabel("새 비밀번호 확인");
             passwordConfirmLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
             passwordConfirmLabel.setForeground(Setup.darkGray); 
             passwordConfirmLabel.setBounds(6, 8, 200, 32);
             passwordConfirmPanel.add(passwordConfirmLabel);
             
             passwordConfirmField = new passwordFieldType1(60, 2);
             passwordConfirmField.setBounds(0, 35, 407, 44);
             passwordConfirmField.addKeyListener(resetPasswordEvent);
             passwordConfirmPanel.add(passwordConfirmField);
           
             passwordConfirmDesLabel = new JLabel("* 비밀번호를 다시 입력해주세요.");
             passwordConfirmDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
             passwordConfirmDesLabel.setForeground(Setup.magenta);
             passwordConfirmDesLabel.setBounds(10, 81, 200, 15);
             passwordConfirmPanel.add(passwordConfirmDesLabel);
             
         //버튼
             JPanel buttonPanel = new JPanel();
             buttonPanel.setBounds(278, 410, 407, 62);
             this.add(buttonPanel);
             
             changePasswordButton = new ButtonType1(20, 8, 5, "비밀번호 변경", 16);
             changePasswordButton.addActionListener(resetPasswordEvent);
             buttonPanel.add(changePasswordButton);
    	}

   public int getNum() {
      return num;
   }

   public void setPasswordDesLabel(String text) {
      passwordDesLabel.setText(text);
   }

   public void setPasswordConfirmDesLabel(String text) {
      passwordConfirmDesLabel.setText(text);
   }

   public String getPasswordField() {
      return passwordField.getText();
   }

   public void focusPasswordField() {
      passwordField.requestFocus();
   }

   public String getPasswordConfirmField() {
      return passwordConfirmField.getText();
   }

   public void focusPasswordConfirmField() {
      passwordConfirmField.requestFocus();
   }

   public JButton getChangePasswordButton() {
      return changePasswordButton;
   }

   public JPasswordField srcGetPasswordField() {
       return passwordField;
   }

   public JPasswordField srcGetPasswordConfirmField() {
      return passwordConfirmField;
   }
}
  