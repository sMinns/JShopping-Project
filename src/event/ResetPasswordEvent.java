package event;

import custom.ButtonType1;
import database.ResetPasswordDB;
import gui.common.Frame;
import gui.contents.main.Login;
import gui.contents.main.ResetPassword;
import gui.menu.GuestMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResetPasswordEvent extends MouseAdapter implements ActionListener, KeyListener {
    private ResetPassword r;
    public ResetPasswordEvent(ResetPassword r) {
        this.r = r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r.getChangePasswordButton()) {
            if(r.getPasswordField().equals("passw0rd")) {
                r.setPasswordDesLabel("* 비밀번호를 입력해주세요.");
                r.focusPasswordField();
                return;
            }else { r.setPasswordDesLabel(""); }
            if(r.getPasswordConfirmField().equals("passw0rd")) {
                r.setPasswordConfirmDesLabel("* 비밀번호 확인을 입력해주세요.");
                r.focusPasswordConfirmField();
                return;
            }
            if (!r.getPasswordField().equals(r.getPasswordConfirmField())) {
                r.focusPasswordConfirmField();
                return;
            }

            if(ResetPasswordDB.updatePassword(r.getPasswordField(), r.getNum())) {
                Setup.changePanel(Frame.contentLayeredPanel, new FinishResetPassword());
            }else {
                System.out.println("실패");
            }
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == r.srcGetPasswordField() || e.getSource() == r.srcGetPasswordConfirmField()) {
            //idTextField.getText()
            if (!r.getPasswordConfirmField().equals("passw0rd")) {
                if (!r.getPasswordField().equals("passw0rd")) {
                    if (r.getPasswordField().equals(r.getPasswordConfirmField())) {
                        r.setPasswordConfirmDesLabel("비밀번호가 일치합니다.");
                    } else {
                        r.setPasswordConfirmDesLabel("비밀번호가 다릅니다.");
                    }
                } else {
                    r.setPasswordConfirmDesLabel("* 비밀번호를 먼저 입력해주세요.");
                }
            }
        }
    }
    public void mouseEntered(MouseEvent e) { r.setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { r.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) { }

    class FinishResetPassword extends JPanel {
        Font font = new Font(Setup.font, Font.BOLD, 24);
        public FinishResetPassword() {
            this.setLayout(new GridLayout(2, 1));

            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 270));
            this.add(panel1);

            JLabel label1 = new JLabel("비밀번호 설정");
            label1.setFont(font);
            label1.setForeground(Setup.magenta);
            panel1.add(label1);

            JLabel label2 = new JLabel("이 완료되었습니다.");
            label2.setFont(font);
            label2.setForeground(Setup.darkGray);
            panel1.add(label2);

            JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            this.add(panel2);

            JButton button = new ButtonType1(30, 6, 5, "로그인하러 가기", 14);
            panel2.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Setup.changePanel(Frame.contentLayeredPanel, new Login(), "로그인");
                    Setup.selectMenuPanel(GuestMenu.GuestPanel[3]);
                }
            });
        }
    }
}
