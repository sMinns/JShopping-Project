package gui.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import gui.common.Frame;
import gui.contents.main.Home;
import gui.contents.main.OrderList;
import gui.contents.main.Search;
import gui.contents.main.SellerApplication;
import gui.contents.main.ShoppingBasket;
import system.Setup;

public class CustomerMenu extends JPanel implements MouseListener{
	private JPanel[] CustomerPanel = new JPanel[8];
	private String[] imgStr = { "/images/home.png", "/images/search.png", "/images/orderlist.png", "/images/shoppingbasket.png", "/images/sellerapplication.png", "/images/profile.png", "/images/logout.png", "/images/exit.png" };
	private String[] textStr = { "홈", "상품검색", "주문목록", "장바구니", "판매자 신청", " 님", "로그아웃", "종료" };
	private int j = 0;
	public CustomerMenu(String name) {;
		this.setBackground(new Color(24, 24, 24));
		
		//GridBagLayout
			GridBagLayout CustomerPanelBagLayout = new GridBagLayout();
			CustomerPanelBagLayout.columnWidths = new int[]{0, 0, 0};
			CustomerPanelBagLayout.rowHeights = new int[]{51, 50, 50, 50, 50, 50, 200, 50, 50, 50, 0, 0};
			CustomerPanelBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			CustomerPanelBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(CustomerPanelBagLayout);
		
		//MenuBagConstraints 
			GridBagConstraints GuestBagConstraints = new GridBagConstraints();
			GuestBagConstraints.gridwidth = 2;
			GuestBagConstraints.insets = new Insets(1, 0, 1, 0);
			GuestBagConstraints.fill = GridBagConstraints.BOTH;
			GuestBagConstraints.gridx = 0;
			GuestBagConstraints.gridy = 0;
			
		//Menu Panel
			for(int i = 0; i < 10; i++) {
				if(i == 1) { GuestBagConstraints.insets = new Insets(0, 0, 1, 0); }
				if(i != 0) { GuestBagConstraints.gridy++; }
				if(i == 4) {
					JPanel blankPanel1 = new JPanel();
					blankPanel1.setBackground(Setup.darkGray);
					this.add(blankPanel1, GuestBagConstraints);
					continue;
				}
				if(i == 6) {
					JPanel blankPanel2 = new JPanel();
					blankPanel2.setBackground(Setup.darkGray);
					this.add(blankPanel2, GuestBagConstraints);
					continue;
				}
				
				
				ImageIcon img = new ImageIcon(CustomerMenu.class.getResource(imgStr[j]));
				if(i == 7) {
					CustomerPanel[j] = new MenuButton(img, name + textStr[j]);
					
				}else {
					CustomerPanel[j] = new MenuButton(img, textStr[j]);
					CustomerPanel[j].addMouseListener(this);
				}
				this.add(CustomerPanel[j], GuestBagConstraints);
				j++;
			}
			
		//Blank Panel
			JPanel blankPanel3 = new JPanel();
			blankPanel3.setBackground(Setup.darkGray);
			GuestBagConstraints.gridy++;
			this.add(blankPanel3, GuestBagConstraints);
			
		Setup.lastClickPanel = CustomerPanel[0];
		CustomerPanel[0].setBackground(Setup.magenta);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Setup.lastClickPanel != null) { Setup.lastClickPanel.setBackground(Setup.darkGray); }
		Setup.lastClickPanel = (JPanel) e.getSource();
		Setup.lastClickPanel.setBackground(Setup.magenta);

		if(e.getSource() == CustomerPanel[0]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == CustomerPanel[1]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Search(), textStr[1]);
		}else if(e.getSource() == CustomerPanel[2]) {
			Setup.changePanel(Frame.contentLayeredPanel, new OrderList(), textStr[2]);
		}else if(e.getSource() == CustomerPanel[3]) {
			Setup.changePanel(Frame.contentLayeredPanel, new ShoppingBasket(), textStr[3]);
		}else if(e.getSource() == CustomerPanel[4]) {
			Setup.changePanel(Frame.contentLayeredPanel, new SellerApplication(), textStr[0]);
		}else if(e.getSource() == CustomerPanel[6]) {
			Setup.changePanel(Frame.menuLayeredPanel, new GuestMenu(), textStr[0]);
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == CustomerPanel[7]) {
			Setup.exit();
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
