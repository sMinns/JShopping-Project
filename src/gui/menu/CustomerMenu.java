package gui.menu;

import custom.ButtonType1;
import database.SellerApplicationDB;
import gui.common.Frame;
import gui.contents.main.*;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomerMenu extends JPanel implements MouseListener{
	public static JPanel[] customerPanel = new JPanel[8];
	private String[] imgStr = { "/images/home.png", "/images/search.png", "/images/orderlist.png", "/images/shoppingbasket.png", "/images/sellerapplication.png", "/images/profile.png", "/images/logout.png", "/images/exit.png" };
	private String[] textStr = { "홈", "상품검색", "주문목록", "장바구니", "판매자 신청", " 님", "로그아웃", "테스트" };
	private int j = 0;
	public CustomerMenu(String name) {;
		this.setBackground(new Color(24, 24, 24));
		
		//GridBagLayout
			GridBagLayout customerPanelBagLayout = new GridBagLayout();
			customerPanelBagLayout.columnWidths = new int[]{0, 0, 0};
			customerPanelBagLayout.rowHeights = new int[]{51, 50, 50, 50, 50, 50, 200, 50, 50, 50, 0, 0};
			customerPanelBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			customerPanelBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(customerPanelBagLayout);
		
		//MenuBagConstraints 
			GridBagConstraints customerBagConstraints = new GridBagConstraints();
			customerBagConstraints.gridwidth = 2;
			customerBagConstraints.insets = new Insets(1, 0, 1, 0);
			customerBagConstraints.fill = GridBagConstraints.BOTH;
			customerBagConstraints.gridx = 0;
			customerBagConstraints.gridy = 0;
			
		//Menu Panel
			for(int i = 0; i < 10; i++) {
				if(i == 1) { customerBagConstraints.insets = new Insets(0, 0, 1, 0); }
				if(i != 0) { customerBagConstraints.gridy++; }
				if(i == 4) {
					JPanel blankPanel1 = new JPanel();
					blankPanel1.setBackground(Setup.darkGray);
					this.add(blankPanel1, customerBagConstraints);
					continue;
				}
				if(i == 6) {
					JPanel blankPanel2 = new JPanel();
					blankPanel2.setBackground(Setup.darkGray);
					this.add(blankPanel2, customerBagConstraints);
					continue;
				}
				
				ImageIcon img = new ImageIcon(CustomerMenu.class.getResource(imgStr[j]));
				if(i == 7) {
					customerPanel[j] = new MenuButton(img, name + textStr[j]);
					
				}else {
					customerPanel[j] = new MenuButton(img, textStr[j]);
					customerPanel[j].addMouseListener(this);
				}
				this.add(customerPanel[j], customerBagConstraints);
				j++;
			}
			
		//Blank Panel
			JPanel blankPanel3 = new JPanel();
			blankPanel3.setBackground(Setup.darkGray);
			customerBagConstraints.gridy++;
			this.add(blankPanel3, customerBagConstraints);
			
		Setup.lastClickPanel = customerPanel[0];
		customerPanel[0].setBackground(Setup.magenta);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Setup.lastClickPanel == (JPanel) e.getSource()) { return; }
		if(Setup.lastClickPanel != null) { Setup.lastClickPanel.setBackground(Setup.darkGray); }
		Setup.lastClickPanel = (JPanel) e.getSource();
		Setup.lastClickPanel.setBackground(Setup.magenta);
		OrderPage.setOpenCalendar(false);

		Setup.changeInsets(10, 10, 10, 10);
		if(e.getSource() == customerPanel[0]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == customerPanel[1]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Search("", 0), textStr[1]);
		}else if(e.getSource() == customerPanel[2]) {
			Setup.changePanel(Frame.contentLayeredPanel, new OrderList(), textStr[2]);
		}else if(e.getSource() == customerPanel[3]) {
			Setup.changePanel(Frame.contentLayeredPanel, new ShoppingBasket(), textStr[3]);
		}else if(e.getSource() == customerPanel[4]) {
			if(SellerApplicationDB.sellerAppDuplicateCheck(Setup.CustomerNum)) {
				Setup.changePanel(Frame.contentLayeredPanel, new SellerApplication(), textStr[4]);
			}else {
				Setup.changePanel(Frame.contentLayeredPanel, new DuplicateSellerApp(), textStr[4]);
			}
		}else if(e.getSource() == customerPanel[6]) {
			Setup.CustomerNum = 0;
			Setup.changePanel(Frame.menuLayeredPanel, new GuestMenu(), textStr[0]);
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == customerPanel[7]) {
			//Setup.exit();
			Setup.changePanel(Frame.contentLayeredPanel, new TestPanel(), "테스트");
		}
	}

	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	class DuplicateSellerApp extends JPanel {
		Font font = new Font(Setup.font, Font.BOLD, 24);

		public DuplicateSellerApp() {
			this.setLayout(new GridLayout(2, 1));

			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 270));
			this.add(panel1);

			JLabel label1 = new JLabel("판매자 신청");
			label1.setFont(font);
			label1.setForeground(Setup.magenta);
			panel1.add(label1);

			JLabel label2 = new JLabel("이 이미 완료되었습니다.");
			label2.setFont(font);
			label2.setForeground(Setup.darkGray);
			panel1.add(label2);

			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
			this.add(panel2);

			JButton button = new ButtonType1(30, 6, 5, "홈으로 가기", 14);
			panel2.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
					Setup.lastClickReset();
					Setup.selectMenuPanel(customerPanel[0]);
				}
			});
		}
	}
}
