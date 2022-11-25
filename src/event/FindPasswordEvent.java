package event;

import database.FindPasswordDB;
import gui.common.Frame;
import gui.contents.main.ResetPassword;
import gui.contents.main.SignUp;
import gui.contents.sub.FindPassword;
import gui.menu.GuestMenu;
import system.Setup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindPasswordEvent extends MouseAdapter implements ActionListener {
    FindPassword f;
    public FindPasswordEvent(FindPassword f) {
        this.f = f;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == f.getFindPasswordButton()) {
            if(f.getIdTextField().equals("아이디")) {
                f.setIdDesLabel("* 아이디를 입력해주세요.");
                f.focusIdTextField();
                return;
            }else { f.setIdDesLabel(""); }
            if(f.getNameTextField().equals("이름")) {
                f.setNameDesLabel("* 이름을 입력해주세요.");
                f.focusNameTextField();
                return;
            }else { f.setNameDesLabel(""); }
            if(f.getYearTextField().equals("년(4자)") || f.getDayTextField().equals("일") ||
                    f.getMonthComboBox().equals("월")) {
                f.setBirthDesLabel("* 생년월일을 입력해주세요.");
                f.focusYearTextField();
                return;
            }else { f.setBirthDesLabel(""); }

            String birth = f.getYearTextField() + "-" + f.getMonthComboBox().replace("월", "") + "-" + f.getDayTextField();
            int num = FindPasswordDB.findPasswordCheck(f.getIdTextField(), f.getNameTextField(), birth);
            if(num != 0) {
                Setup.changePanel(Frame.contentLayeredPanel, new ResetPassword(num));
            }else {
                f.setBirthDesLabel("* 본인인증에 실패하였습니다.");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == f.getNoAccLabel() || e.getSource() == f.getSignUpLabel()) {
            Setup.changePanel(Frame.contentLayeredPanel, new SignUp(), "회원가입");
            Setup.selectMenuPanel(GuestMenu.GuestPanel[2]);
        }
    }
    public void mouseEntered(MouseEvent e) { f.setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { f.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
}
