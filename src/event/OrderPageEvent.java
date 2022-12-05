package event;

import custom.ButtonType1;
import database.LoginDB;
import database.OrderPageDB;
import gui.common.Frame;
import gui.contents.main.OrderList;
import gui.contents.main.OrderPage;
import gui.contents.sub.DesDateCalendar;
import gui.menu.CustomerMenu;
import gui.menu.SellerMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class OrderPageEvent extends MouseAdapter implements ActionListener {
private OrderPage o;
    public OrderPageEvent(OrderPage o) {
        this.o = o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == o.getCredit_card_RadioButton()) {
            o.showCl_paytype_panel("card");
        }else if(e.getSource() == o.getMobile_phone_payment_RadioButton()) {
            o.showCl_paytype_panel("mobile");
        }

        if(e.getSource() == o.getAgreement()) {
            if(o.getRecipient_textField().equals("")) {
                o.focusRecipient_textField();
                o.setValue(o.getDataSize() * 91);
                return;
            }
            if(o.getPhoneNumTextField1().equals("") || o.getPhoneNumTextField1().length() < 3 ||
                    o.getPhoneNumTextField2().equals("") || o.getPhoneNumTextField2().length() < 4 ||
                    o.getPhoneNumTextField3().equals("") || o.getPhoneNumTextField3().length() < 4) {
                o.focusPhoneNumTextField1();
                o.setValue(o.getDataSize() * 91 + 25);
                return;
            }

            if(o.getAddress_textField_1().equals("")) {
                o.focusAddress_textField_1();
                o.setValue(o.getDataSize() * 91 + 50);
                return;
            }

            if(o.getAddress_textField_2().equals("")) {
                o.focusAddress_textField_2();
                o.setValue(o.getDataSize() * 91 + 50);
                return;
            }

            LocalDate now = LocalDate.now();
            String orderDateNum = String.format("%03d", OrderPageDB.returnOrderNum(String.valueOf(now)) + 1);
            String orderNum = String.valueOf(now).replace("-", "") + orderDateNum;
            String phonenum = o.getPhoneNumTextField1() + " " + o.getPhoneNumTextField2() + " " + o.getPhoneNumTextField3();
            String address = o.getAddress_textField_1() + " " + o.getAddress_textField_2();
            String date = o.getDelivery_desired_date_textField().getText().replace(". ", "-");

            String[] str = { orderNum, o.getRecipient_textField(), phonenum, address, o.getShopping_Request_textField(),
                    date, String.valueOf(Setup.CustomerNum), String.valueOf(now)};

            if(OrderPageDB.InsertOrder(str)) {
                if(OrderPageDB.InsertOrderProduct(o.getStr(), orderNum)) {
                    OrderPageDB.updateProductStock(o.getPrnum(), o.getCount());
                    OrderPageDB.clearShoppingBasket(Setup.CustomerNum, o.getPrnum());
                    Setup.changePanel(Frame.contentLayeredPanel, new FinishOrderPanel());
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == o.getCalendarLabel() || e.getSource() == o.getDelivery_desired_date_textField()) {
            if(!o.isOpenCalendar()) {
                o.setOpenCalendar(true);
                Setup.changePanel(o.getCalender_panel(), new DesDateCalendar(o.getDelivery_desired_date_textField(), o.getCalender_panel()));
                o.getCalender_panel().setVisible(true);
            }
        }
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() != o.getCalender_panel()) {
            o.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() != o.getCalender_panel()) {
            o.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
class FinishOrderPanel extends JPanel {
    Font font = new Font(Setup.font, Font.BOLD, 24);
    public FinishOrderPanel() {
        this.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 270));
        this.add(panel1);

        JLabel label1 = new JLabel("주문해주셔서 ");
        label1.setFont(font);
        label1.setForeground(Setup.darkGray);
        panel1.add(label1);

        JLabel label2 = new JLabel("감사합니다.");
        label2.setFont(font);
        label2.setForeground(Setup.magenta);
        panel1.add(label2);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.add(panel2);

        JButton button = new ButtonType1(30, 6, 5, "주문목록 가기", 14);
        panel2.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LoginDB.sellerCheck(Setup.CustomerNum)) {
                    Setup.selectMenuPanel(SellerMenu.sellerPanel[2]);
                }else {
                    Setup.selectMenuPanel(CustomerMenu.customerPanel[2]);
                }
                Setup.changePanel(Frame.contentLayeredPanel, new OrderList(), "주문 목록");
           }
        });
    }
}
}
