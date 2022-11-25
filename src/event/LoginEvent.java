package event;

import database.LoginDB;
import gui.common.Frame;
import gui.contents.main.FindIdPw;
import gui.contents.main.Home;
import gui.contents.main.Login;
import gui.contents.main.SignUp;
import gui.menu.CustomerMenu;
import gui.menu.GuestMenu;
import system.Setup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginEvent extends MouseAdapter implements ActionListener {
    Login l;
    public LoginEvent(Login l) {
        this.l = l;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == l.getLogin()) {
            if(l.getIdTextField().equals("아이디")) {
                l.setIdDesLabel("* 아이디를 입력해주세요.");
                l.foucsIdTextField();
                return;
            }else { l.setIdDesLabel(""); }
            if(l.getPasswordTextField().equals("passw0rd")) {
                l.setPasswordDesLabel("* 비밀번호를 입력해주세요.");
                l.focusPasswordTextField();
                return;
            }else { l.setPasswordDesLabel(""); }

            int customerNum = LoginDB.loginPwCheck(l.getIdTextField(), l.getPasswordTextField());
            if(customerNum != 0) {
                Setup.CustomerNum = customerNum;
                Setup.changePanel(Frame.menuLayeredPanel, new CustomerMenu(LoginDB.returnNickname(customerNum)), "홈");
                Setup.changePanel(Frame.contentLayeredPanel, new Home(), "홈");
            }else {
                l.setPasswordDesLabel("* 아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == l.getFindIdLabel()) {
            Setup.changePanel(Frame.contentLayeredPanel, new FindIdPw(true), "아이디 및 비밀번호 찾기");
            Setup.lastClickReset();
        }
        if (e.getSource() == l.getFindPasswordLabel()) {
            Setup.changePanel(Frame.contentLayeredPanel, new FindIdPw(false), "아이디 및 비밀번호 찾기");
            Setup.lastClickReset();
        }
        if (e.getSource() == l.getNoAccLabel() || e.getSource() == l.getSignUpLabel()) {
            Setup.changePanel(Frame.contentLayeredPanel, new SignUp(), "회원가입");
            Setup.lastClickReset();
            Setup.selectMenuPanel(GuestMenu.GuestPanel[2]);
        }
    }
    public void mouseEntered(MouseEvent e) { l.setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { l.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
}
