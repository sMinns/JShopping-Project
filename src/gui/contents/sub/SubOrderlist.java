package gui.contents.sub;

import custom.ButtonType1;
import database.OrderListDB;
import database.SubOrderListDB;
import gui.common.Frame;
import gui.contents.main.OrderList;
import system.Setup;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubOrderlist extends JPanel implements ActionListener, MouseListener{
    Date now = Calendar.getInstance().getTime();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
    String nowdate = formatter.format(now);
    JTextArea review1;
    JTextArea review2;
    JLabel datelabel = new JLabel();
    JButton submit;
    Font font1 = new Font(Setup.font, Font.BOLD, 18);
    Font font2 = new Font(Setup.font, Font.PLAIN, 16);
    Font font3 = new Font(Setup.font, Font.BOLD, 16);

    Font starfont = new Font(Setup.font, Font.BOLD, 25);
    Font starfont2 = new Font(Setup.font, Font.BOLD, 15);

    JPanel t1 = new JPanel(); // 위
    JPanel t2 = new JPanel(); // 아래

    JPanel top1 = new JPanel(); // 위 그림
    JPanel top2 = new JPanel(); // 위 이름

    JPanel[] under = new JPanel[5];
    JLabel[] star = new JLabel[5];
    JPanel[] un = new JPanel[2];
    JPanel[] un3 = new JPanel[2];
    JTextArea re_text = new JTextArea(1,15);
    JLabel del = new JLabel("삭제하기");
    String[] requset = new String[8];
    int sel_star=0;

    public SubOrderlist(String[] select,boolean wr) {
        //{"190014","/images/nullimage.png","축구화6","2","29800","2022-11-07","배송중"}
        if(wr==true) {//Integer.parseInt(select[7])

            String[] reviewall = SubOrderListDB.myreview(Setup.CustomerNum, Integer.parseInt(select[7]));
            requset = select;
            del.setFont(new Font(Setup.font, Font.BOLD, 16));
            del.setForeground(Color.red);
            del.addMouseListener(this);
            int star_num=4; // star
            star_num=Integer.parseInt(reviewall[3]);
            re_text.setText(reviewall[1]); //post
            re_text.setEditable(false);
            re_text.setFont(font2);
            re_text.setLineWrap(true);
            datelabel.setFont(font2);
            datelabel.setText(reviewall[2]);
            JPanel npanel = new JPanel();
            JPanel p3 = new JPanel();
            JTextArea subname = new JTextArea(1,15);
            subname.setText(select[2]);
            subname.setEditable(false);
            subname.setLineWrap(true);
            subname.setFont(font1);
            review1 = new JTextArea(5,15);
            review1.setFont(font2);
            review1.setLineWrap(true);
            Border lineBorder = BorderFactory.createLineBorder(Setup.bgLightGray, 3);

            review1.setBorder(lineBorder);
            GridBagConstraints topGBC = new GridBagConstraints();
            GridBagConstraints underGBC = new GridBagConstraints();
            GridBagConstraints under2GBC = new GridBagConstraints();
            GridBagConstraints under3GBC = new GridBagConstraints();

            GridBagLayout sublayout = new GridBagLayout();
            sublayout.columnWidths = new int[] {283};
            sublayout.rowHeights = new int[] {365,319};//685

            GridBagLayout t1layout = new GridBagLayout();
            t1layout.columnWidths = new int[] {283};
            t1layout.rowHeights = new int[] {275,90};// 365

            GridBagLayout t2layout = new GridBagLayout();
            t2layout.columnWidths = new int[] {283};
            t2layout.rowHeights = new int[] {40,30,124,125};// 319 /35 50 135 100

            GridBagLayout unlayout = new GridBagLayout();

            GridBagLayout un2layout = new GridBagLayout();
            un2layout.columnWidths = new int[] {155,100};//283
            un2layout.rowHeights = new int[] {40};//50

            GridBagLayout un3layout = new GridBagLayout();
            un2layout.columnWidths = new int[] {155,100};//283
            un2layout.rowHeights = new int[] {30};//50




            GridBagConstraints subGBC = new GridBagConstraints();

            p3.setLayout(sublayout);


            t1.setLayout(t1layout);
            t2.setLayout(t2layout);
            for(int i=0;i<5;i++) {
                star[i]=new JLabel("☆");
                star[i].setFont(starfont2);
                star[i].setForeground(Setup.starYellow);

            }
            for(int i=0;i<star_num;i++) {
                star[i].setText("★");
            }

            for(int i=0;i<2;i++) {
                un[i]=new JPanel();
                un3[i]=new JPanel();
                un[i].setBackground(Color.white);
                un3[i].setBackground(Color.white);
            }
            for(int i=0;i<5;i++) {
                un[0].setLayout(new BoxLayout(un[0], BoxLayout.X_AXIS));
                un[0].add(star[i]);
            }
            un[1].setLayout(new BoxLayout(un[1], BoxLayout.X_AXIS));
            un[1].add(datelabel);
            for(int i=0;i<4;i++) {
                under[i]=new JPanel();
                under[i].setLayout(unlayout);
            }
            for(int i=0;i<4;i++) {
                if(i==0) {
                    under[0].setLayout(new FlowLayout(FlowLayout.LEFT));
                    for(int j=0;j<2;j++) {
                        under[0].add(un[j]);
                    }
                }
                if(i==1) {
                    under[1].setLayout(un3layout);
                    for(int j=0;j<2;j++) {
                        under3GBC.gridx=j;
                        under3GBC.gridy=0;
                        under3GBC.fill=GridBagConstraints.BOTH;
                        under[1].add(un3[j],under3GBC);
                    }
                    JLabel saler =new JLabel();
                    saler.setFont(new Font(Setup.font, Font.BOLD, 15));
                    saler.setText(String.format("판매자: %s                   ", OrderListDB.sllername(Integer.parseInt(select[7]))));
                    under[2].add(saler);
                    un3[0].add(saler);
                    un3[1].add(del);
                }
                if(i==2) {
                    under[2].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
                    under[2].add(re_text);
                }
                if(i==3) {
                    under[3].add(npanel);
                    npanel.setBackground(Color.white);
                }

                underGBC.gridx=0;
                underGBC.gridy=i;
                underGBC.fill=GridBagConstraints.BOTH;
                t2.add(under[i],underGBC);
                under[i].setBackground(Color.white);
            }



            topGBC.gridx=0;
            topGBC.gridy=0;
            topGBC.fill=GridBagConstraints.BOTH;
            t1.add(top1,topGBC);
            topGBC.gridx=0;
            topGBC.gridy=1;
            topGBC.fill=GridBagConstraints.BOTH;
            t1.add(top2,topGBC);

            top1.setBackground(Color.white);
            JLabel img =new JLabel();
            img.setIcon(Setup.imageSetSize(new ImageIcon(OrderListDB.productImageLoad(Integer.parseInt(select[7]))),245,245));
            top1.add(img);


            top2.add(subname);
            top2.setBackground(Color.white);


            p3.add(t1,subGBC);
            subGBC.gridx=0;
            subGBC.gridy=1;
            subGBC.insets=new Insets(1,0,0,0);
            p3.add(t2,subGBC);

            t1.setBackground(Color.red);
            t2.setBackground(Color.gray);
            this.add(p3);
        }else {
            requset = select;
            datelabel.setFont(font2);
            datelabel.setText("  " + nowdate);

            JPanel p3 = new JPanel();
            JTextArea subname = new JTextArea(1,15);
            subname.setText(select[2]);
            subname.setEditable(false);
            subname.setLineWrap(true);
            subname.setFont(font1);
            review2 = new JTextArea(5,15);
            review2.setFont(font2);
            review2.setLineWrap(true);
            Border lineBorder = BorderFactory.createLineBorder(Setup.bgLightGray, 2);

            review2.setBorder(lineBorder);
            GridBagConstraints topGBC = new GridBagConstraints();
            GridBagConstraints underGBC = new GridBagConstraints();
            GridBagConstraints under2GBC = new GridBagConstraints();

            GridBagLayout sublayout = new GridBagLayout();
            sublayout.columnWidths = new int[] {283};
            sublayout.rowHeights = new int[] {365,319};//685

            GridBagLayout t1layout = new GridBagLayout();
            t1layout.columnWidths = new int[] {283};
            t1layout.rowHeights = new int[] {275,90};// 365

            GridBagLayout t2layout = new GridBagLayout();
            t2layout.columnWidths = new int[] {283};
            t2layout.rowHeights = new int[] {35,40,30,100,90};// 319 /35 50 135 100

            GridBagLayout unlayout = new GridBagLayout();

            GridBagLayout un2layout = new GridBagLayout();
            un2layout.columnWidths = new int[] {155,100};//283
            un2layout.rowHeights = new int[] {40};//50




            GridBagConstraints subGBC = new GridBagConstraints();

            p3.setLayout(sublayout);


            t1.setLayout(t1layout);
            t2.setLayout(t2layout);
            for(int i=0;i<5;i++) {
                star[i]=new JLabel("☆");
                star[i].setFont(starfont);
                star[i].setForeground(Setup.starYellow);
                star[i].addMouseListener(this);

            }

            for(int i=0;i<2;i++) {
                un[i]=new JPanel();
                un[i].setBackground(Color.white);
            }
            un[1].setBackground(Color.white);
            for(int i=0;i<5;i++) {
                un[0].setLayout(new FlowLayout(FlowLayout.LEFT, 5, -1));
                un[0].add(star[i]);
                //un[0].setBackground(Color.black);
            }
            un[1].setLayout(new BoxLayout(un[1], BoxLayout.X_AXIS));
            //un[1].setBackground(Color.gray);
            un[1].add(datelabel);
            for(int i=0;i<5;i++) {
                under[i]=new JPanel();
                under[i].setLayout(unlayout);
            }
            for(int i=0;i<5;i++) {
                if(i==0) {
                    JLabel desc =new JLabel("구매하신 상품에 리뷰를 작성해주세요.");
                    desc.setFont(new Font(Setup.font, Font.BOLD, 15));
                    under[0].add(desc);
                }
                if(i==1) {
                    under[1].setLayout(un2layout);
                    for(int j=0;j<2;j++) {
                        under2GBC.gridx=j;
                        under2GBC.gridy=0;
                        under2GBC.fill=GridBagConstraints.BOTH;
                        under[1].add(un[j],under2GBC);
                    }
                }
                if(i==2) {
                    JLabel saler =new JLabel();
                    saler.setFont(new Font(Setup.font, Font.BOLD, 15));
                    saler.setText("판매자: "+OrderListDB.sllername(Integer.parseInt(select[7]))) ;
                    under[2].add(saler);
                }
                if(i==3) {
                    under[3].add(review2);
                }
                if(i==4) {
                    submit = new ButtonType1(30,8,5,"전송하기",14);
                    submit.addActionListener(this);
                    under[4].add(submit);
                }

                underGBC.gridx=0;
                underGBC.gridy=i;
                underGBC.fill=GridBagConstraints.BOTH;
                t2.add(under[i],underGBC);
                under[i].setBackground(Color.white);
            }





            topGBC.gridx=0;
            topGBC.gridy=0;
            topGBC.fill=GridBagConstraints.BOTH;
            t1.add(top1,topGBC);
            topGBC.gridx=0;
            topGBC.gridy=1;
            topGBC.fill=GridBagConstraints.BOTH;
            t1.add(top2,topGBC);

            top1.setBackground(Color.white);
            JLabel img =new JLabel();
            img.setIcon(Setup.imageSetSize(new ImageIcon(OrderListDB.productImageLoad(Integer.parseInt(select[7]))),245,245));
            top1.add(img);


            top2.add(subname);
            top2.setBackground(Color.white);


            p3.add(t1,subGBC);
            subGBC.gridx=0;
            subGBC.gridy=1;
            subGBC.insets=new Insets(1,0,0,0);
            p3.add(t2,subGBC);

            t1.setBackground(Color.red);
            t2.setBackground(Color.gray);
            this.add(p3);
        }


    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String text= "";
            text = review2.getText();
            SubOrderListDB.insertReview(text, sel_star, Setup.CustomerNum, Integer.parseInt(requset[7]));
            Setup.changePanel(Frame.contentLayeredPanel, new OrderList());
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {

        int sel=0;
        for (int i = 0; i < 5; i++) {

            if (e.getSource() == star[i]) {
                sel=i;

            }
            star[i].setText("☆");

        }

        for(int i = 0;i<sel+1;i++) {
            star[i].setText("★");
        }
        sel++;
        sel_star= sel;



    }

    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == del) {
            String[] request= this.requset;
            int re_num =0 ;
            int pr_num = Integer.parseInt(requset[7]);

            re_num = SubOrderListDB.searchReviewnum(pr_num,Setup.CustomerNum);
            SubOrderListDB.deleteReview(re_num);
            Setup.changePanel(Frame.contentLayeredPanel, new OrderList());
        }
    }
    public void mouseReleased(MouseEvent e) {}
}