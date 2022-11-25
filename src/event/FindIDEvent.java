package event;

import custom.ButtonType1;
import database.FindIDDB;
import gui.common.Frame;
import gui.contents.main.Login;
import gui.contents.main.SignUp;
import gui.contents.sub.FindID;
import gui.menu.GuestMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindIDEvent extends MouseAdapter implements ActionListener {
    FindID f;
    public FindIDEvent(FindID f) {
        this.f = f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == f.getFindIdButton()) {
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
            String id = FindIDDB.idFind(f.getNameTextField(), birth);
            if(id != null) {
                Setup.changePanel(Frame.contentLayeredPanel, new idGuidePanel(id));
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

    class idGuidePanel extends JPanel {
        Font font = new Font(Setup.font, Font.BOLD, 24);
        public idGuidePanel(String id) {
            this.setLayout(new GridLayout(2, 1));

            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 270));
            this.add(panel1);

            JLabel label1 = new JLabel("아이디는 ");
            label1.setFont(font);
            label1.setForeground(Setup.darkGray);
            panel1.add(label1);

            JLabel label2 = new JLabel(id);
            label2.setFont(font);
            label2.setForeground(Setup.magenta);
            panel1.add(label2);

            JLabel label3 = new JLabel(" 입니다.");
            label3.setFont(font);
            label3.setForeground(Setup.darkGray);
            panel1.add(label3);

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
