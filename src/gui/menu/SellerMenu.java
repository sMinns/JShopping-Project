package gui.menu;

import gui.common.Frame;
import gui.contents.main.*;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SellerMenu extends JPanel implements MouseListener{
	public static JPanel[] sellerPanel = new JPanel[9];
	private String[] imgStr = { "/images/home.png", "/images/search.png", "/images/orderlist.png", "/images/shoppingbasket.png", "/images/ordermanage.png", "/images/shop.png", "/images/profile.png", "/images/logout.png", "/images/exit.png" };
	private String[] textStr = { "홈", "상품검색", "주문목록", "장바구니", "주문관리", "상품관리", " 님", "로그아웃", "테스트" };
	private int j = 0;
	public SellerMenu(String name) {;
		this.setBackground(new Color(24, 24, 24));
		
		//GridBagLayout
			GridBagLayout sellerPanelBagLayout = new GridBagLayout();
			sellerPanelBagLayout.columnWidths = new int[]{0, 0, 0};
			sellerPanelBagLayout.rowHeights = new int[]{51, 50, 50, 50, 50, 50, 50, 150, 50, 50, 50, 0, 0};
			sellerPanelBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			sellerPanelBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(sellerPanelBagLayout);
		
		//MenuBagConstraints 
			GridBagConstraints sellerBagConstraints = new GridBagConstraints();
			sellerBagConstraints.gridwidth = 2;
			sellerBagConstraints.insets = new Insets(1, 0, 1, 0);
			sellerBagConstraints.fill = GridBagConstraints.BOTH;
			sellerBagConstraints.gridx = 0;
			sellerBagConstraints.gridy = 0;
			
		//Menu Panel
			for(int i = 0; i < 11; i++) {
				if(i == 1) { sellerBagConstraints.insets = new Insets(0, 0, 1, 0); }
				if(i != 0) { sellerBagConstraints.gridy++; }
				if(i == 4) {
					JPanel blankPanel1 = new JPanel();
					blankPanel1.setBackground(Setup.darkGray);
					this.add(blankPanel1, sellerBagConstraints);
					continue;
				}
				if(i == 7) {
					JPanel blankPanel2 = new JPanel();
					blankPanel2.setBackground(Setup.darkGray);
					this.add(blankPanel2, sellerBagConstraints);
					continue;
				}
				
				ImageIcon img = new ImageIcon(SellerMenu.class.getResource(imgStr[j]));
				if(i == 8) {
					sellerPanel[j] = new MenuButton(img, name + textStr[j]);
					
				}else {
					sellerPanel[j] = new MenuButton(img, textStr[j]);
					sellerPanel[j].addMouseListener(this);
				}
				this.add(sellerPanel[j], sellerBagConstraints);
				j++;
			}
			
		//Blank Panel
			JPanel blankPanel3 = new JPanel();
			blankPanel3.setBackground(Setup.darkGray);
			sellerBagConstraints.gridy++;
			this.add(blankPanel3, sellerBagConstraints);
			
		Setup.lastClickPanel = sellerPanel[0];
		sellerPanel[0].setBackground(Setup.magenta);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Setup.lastClickPanel == (JPanel) e.getSource()) { return; }
		if(Setup.lastClickPanel != null) { Setup.lastClickPanel.setBackground(Setup.darkGray); }
		Setup.lastClickPanel = (JPanel) e.getSource();
		Setup.lastClickPanel.setBackground(Setup.magenta);
		OrderPage.setOpenCalendar(false);

		Setup.changeInsets(10, 10, 10, 10);
		if(e.getSource() == sellerPanel[0]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == sellerPanel[1]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Search("", 0), textStr[1]);
		}else if(e.getSource() == sellerPanel[2]) {
			Setup.changePanel(Frame.contentLayeredPanel, new OrderList(), textStr[2]);
		}else if(e.getSource() == sellerPanel[3]) {
			Setup.changePanel(Frame.contentLayeredPanel, new ShoppingBasket(), textStr[3]);
		}else if(e.getSource() == sellerPanel[4]) {
			Setup.changePanel(Frame.contentLayeredPanel, new OrderManagement(true, "", "주문번호"), textStr[4]);
		}else if (e.getSource() == sellerPanel[5]) {
			Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(""), textStr[5]);
		}else if(e.getSource() == sellerPanel[7]) {
			Setup.CustomerNum = 0;
			Setup.changePanel(Frame.menuLayeredPanel, new GuestMenu(), textStr[0]);
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == sellerPanel[8]) {
			//Setup.exit();
			Setup.changePanel(Frame.contentLayeredPanel, new TestPanel(), "테스트");
		}
	}

	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
