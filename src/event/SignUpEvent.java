package event;

import custom.ButtonType1;
import database.SignUpDB;
import gui.common.Frame;
import gui.contents.main.Login;
import gui.contents.main.SignUp;
import gui.menu.GuestMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.Calendar;

public class SignUpEvent extends MouseAdapter implements ActionListener, KeyListener {
    private SignUp s;
    private boolean idCheck = false;
    public SignUpEvent(SignUp s) {
        this.s = s;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == s.getSignUpButton()) {
            if (s.getIdTextField().equals("아이디")) {
                s.setIdDesLabel("* 아이디를 입력해주세요.");
                s.focusIdTextField();
                s.setScrollPaneValue();
                return;
            }

            if(!idCheck) {
                s.focusIdTextField();
                s.setScrollPaneValue();
                return;
            }

            if (s.getPassTextField().equals("passw0rd")) {
                s.setPassDesLabel("* 비밀번호를 입력해주세요.");
                s.focusPassTextField();
                s.setScrollPaneValue();
                return;
            }

            if (s.getPassCheckTextField().equals("passw0rd")) {
                s.setPassCheckDesLabel("* 비밀번호 확인을 입력해주세요.");
                s.focusPassCheckTextField();
                s.setScrollPaneValue();
                return;
            }

            if (!s.getPassTextField().equals(s.getPassCheckTextField())) {
                s.focusPassCheckTextField();
                s.setScrollPaneValue();
                return;
            }

            if (s.getNameTextField().equals("이름")) {
                s.setNameDesLabel("* 이름을 입력해주세요.");
                s.focusNameTextField();
                s.setScrollPaneValue();
                return;
            } else { s.setNameDesLabel(""); }

            if (s.getYearTextField().equals("년(4자)") || s.getDayTextField().equals("일") ||
                s.getMonthComboBox().equals("월") || s.getYearTextField().length() < 4) {
                    s.setBirthDesLabel("* 생년월일을 입력해주세요.");
                    s.focusYearTextField();
                    return;
            } else { s.setBirthDesLabel(""); }

            if(!calenderDateTest()) {
                s.setBirthDesLabel("* 생년월일을 다시 입력해주세요.");
                s.focusDayTextField();
                return;
            }
            LocalDate now = LocalDate.now();
            String birth = s.getYearTextField() + "-" + s.getMonthComboBox().replace("월", "") + "-" + s.getDayTextField();
            String nick = s.getIdTextField();
            if(!s.getNickNameTextField().equals("닉네임")) { nick = s.getNickNameTextField(); }
            String[] str = {s.getIdTextField(), s.getPassTextField(), nick,
                    s.getNameTextField(), birth, s.getEmailTextField(), String.valueOf(now)};

            if(SignUpDB.insertCustomer(str)) {
                Setup.changePanel(Frame.contentLayeredPanel, new FinishSignUpPanel());
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == s.srcGetIdTextField()) {
            if(s.getIdTextField().length() >= 4) {
                if (SignUpDB.idDuplicateCheck(s.getIdTextField())) {
                    s.setIdDesLabel("* 사용가능한 아이디입니다.");
                    idCheck = true;
                }else {
                    s.setIdDesLabel("* 이미 사용중인 아이디입니다.");
                    idCheck = false;
                }
            }else {
                s.setIdDesLabel("* 아이디 4자이상 입력해주세요.");
                idCheck = false;
            }
        }

        if(e.getSource() == s.srcGetPassCheckTextField() || e.getSource() == s.srcGetPassTextField()) {
            //idTextField.getText()
            if (!s.getPassCheckTextField().equals("passw0rd")) {
                if (!s.getPassTextField().equals("passw0rd")) {
                    if (s.getPassTextField().equals(s.getPassCheckTextField())) {
                        s.setPassCheckDesLabel("비밀번호가 일치합니다.");
                    } else {
                        s.setPassCheckDesLabel("비밀번호가 다릅니다.");
                    }
                } else {
                    s.setPassCheckDesLabel("* 비밀번호를 먼저 입력해주세요.");
                }
            }
        }
    }

    public boolean calenderDateTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(s.getYearTextField()), Integer.parseInt(s.getMonthComboBox().replace("월", "")) - 1, 1);
        if(Integer.parseInt(s.getDayTextField()) <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            return true;
        }else { return false; }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == s.getHaveAccLabel() || e.getSource() == s.getLoginLabel()) {
            Setup.changePanel(Frame.contentLayeredPanel, new Login(), "로그인");
            Setup.lastClickReset();
            Setup.selectMenuPanel(GuestMenu.GuestPanel[3]);
        }
    }
    public void mouseEntered(MouseEvent e) { s.setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { s.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void keyPressed(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }

    class FinishSignUpPanel extends JPanel {
        Font font = new Font(Setup.font, Font.BOLD, 24);
        public FinishSignUpPanel() {
            this.setLayout(new GridLayout(2, 1));

            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 270));
            this.add(panel1);

            JLabel label1 = new JLabel("회원가입");
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
                    Setup.lastClickReset();
                    Setup.selectMenuPanel(GuestMenu.GuestPanel[3]);
                }
            });
        }
    }
}