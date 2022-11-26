package gui.menu;

import gui.common.Frame;
import gui.contents.main.*;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuestMenu extends JPanel implements MouseListener{
	public static JPanel[] GuestPanel = new JPanel[5];
	private String[] imgStr = { "/images/home.png", "/images/search.png", "/images/signup.png", "/images/login.png", "/images/exit.png" };
	private String[] textStr = { "홈", "상품검색", "회원가입", "로그인", "테스트" };
	private int j = 0;
	public GuestMenu() {;
		this.setBackground(new Color(24, 24, 24));
		
		//GridBagLayout
			GridBagLayout guestPanelBagLayout = new GridBagLayout();
			guestPanelBagLayout.columnWidths = new int[]{0, 0, 0};
			guestPanelBagLayout.rowHeights = new int[]{51, 50, 400, 50, 50, 50, 0, 0};
			guestPanelBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			guestPanelBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(guestPanelBagLayout);
		
		//MenuBagConstraints 
			GridBagConstraints guestBagConstraints = new GridBagConstraints();
			guestBagConstraints.gridwidth = 2;
			guestBagConstraints.insets = new Insets(1, 0, 1, 0);
			guestBagConstraints.fill = GridBagConstraints.BOTH;
			guestBagConstraints.gridx = 0;
			guestBagConstraints.gridy = 0;
			
		//Menu Panel
			for(int i = 0; i < 6; i++) {
				if(i == 1) { guestBagConstraints.insets = new Insets(0, 0, 1, 0); }
				if(i != 0) { guestBagConstraints.gridy++; }
				if(i == 2) {
					JPanel blankPanel1 = new JPanel();
					blankPanel1.setBackground(Setup.darkGray);
					this.add(blankPanel1, guestBagConstraints);
					continue;
				}
				ImageIcon img = new ImageIcon(GuestMenu.class.getResource(imgStr[j]));
				GuestPanel[j] = new MenuButton(img, textStr[j]); 
				GuestPanel[j].addMouseListener(this);
				this.add(GuestPanel[j], guestBagConstraints);
				j++;
			}
			
		//Blank Panel
			JPanel blankPanel2 = new JPanel();
			blankPanel2.setBackground(Setup.darkGray);
			guestBagConstraints.gridy++;
			this.add(blankPanel2, guestBagConstraints);
			
		Setup.lastClickPanel = GuestPanel[0];
		GuestPanel[0].setBackground(Setup.magenta);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Setup.lastClickPanel == (JPanel) e.getSource()) { return; }
		if(Setup.lastClickPanel != null) { Setup.lastClickPanel.setBackground(Setup.darkGray); }
		Setup.lastClickPanel = (JPanel) e.getSource();
		Setup.lastClickPanel.setBackground(Setup.magenta);
		Setup.changeInsets(10, 10, 10, 10);
		if(e.getSource() == GuestPanel[0]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == GuestPanel[1]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Search(), textStr[1]);
		}else if(e.getSource() == GuestPanel[2]) {
			Setup.changePanel(Frame.contentLayeredPanel, new SignUp(), textStr[2]);
		}else if(e.getSource() == GuestPanel[3]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Login(), textStr[3]);
		}else if(e.getSource() == GuestPanel[4]) {
			//Setup.exit();
			Setup.changePanel(Frame.contentLayeredPanel, new TestPanel(), "테스트");
		}
	}
	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
