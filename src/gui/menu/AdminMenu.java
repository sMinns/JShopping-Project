package gui.menu;

import custom.ButtonType1;
import gui.common.Frame;
import gui.contents.main.*;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminMenu extends JPanel implements MouseListener{
	public static JPanel[] adminPanel = new JPanel[7];
	private String[] imgStr = { "/images/home.png", "/images/customermanage.png", "/images/sellermanage.png", "/images/sellerappmanage.png", "/images/profile.png", "/images/logout.png", "/images/exit.png" };
	private String[] textStr = { "홈", "고객 관리", "판매자 관리", "신청자 관리", "관리자", "로그아웃", "테스트" };
	private int j = 0;
	public AdminMenu() {;
		this.setBackground(new Color(24, 24, 24));
		
		//GridBagLayout
			GridBagLayout adminPanelBagLayout = new GridBagLayout();
			adminPanelBagLayout.columnWidths = new int[]{0, 0, 0};
			adminPanelBagLayout.rowHeights = new int[]{51, 50, 50, 50, 50, 50, 200, 50, 50, 50, 0, 0};
			adminPanelBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			adminPanelBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(adminPanelBagLayout);
		
		//MenuBagConstraints 
			GridBagConstraints adminBagConstraints = new GridBagConstraints();
			adminBagConstraints.gridwidth = 2;
			adminBagConstraints.insets = new Insets(1, 0, 1, 0);
			adminBagConstraints.fill = GridBagConstraints.BOTH;
			adminBagConstraints.gridx = 0;
			adminBagConstraints.gridy = 0;
			
		//Menu Panel
			for(int i = 0; i < 10; i++) {
				if(i == 1) { adminBagConstraints.insets = new Insets(0, 0, 1, 0); }
				if(i != 0) { adminBagConstraints.gridy++; }
				if(i == 1) {
					JPanel blankPanel1 = new JPanel();
					blankPanel1.setBackground(Setup.darkGray);
					this.add(blankPanel1, adminBagConstraints);
					continue;
				}
				if(i == 4) {
					JPanel blankPanel2 = new JPanel();
					blankPanel2.setBackground(Setup.darkGray);
					this.add(blankPanel2, adminBagConstraints);
					continue;
				}
				if(i == 6) {
					JPanel blankPanel3 = new JPanel();
					blankPanel3.setBackground(Setup.darkGray);
					this.add(blankPanel3, adminBagConstraints);
					continue;
				}
				ImageIcon img = new ImageIcon(AdminMenu.class.getResource(imgStr[j]));
				if(i == 7) {
					adminPanel[j] = new MenuButton(img, textStr[j]);
					
				}else {
					adminPanel[j] = new MenuButton(img, textStr[j]);
					adminPanel[j].addMouseListener(this);
				}
				this.add(adminPanel[j], adminBagConstraints);
				j++;
			}
			
		//Blank Panel
			JPanel blankPanel4 = new JPanel();
			blankPanel4.setBackground(Setup.darkGray);
			adminBagConstraints.gridy++;
			this.add(blankPanel4, adminBagConstraints);
			
		Setup.lastClickPanel = adminPanel[0];
		adminPanel[0].setBackground(Setup.magenta);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Setup.lastClickPanel == (JPanel) e.getSource()) { return; }
		if(Setup.lastClickPanel != null) { Setup.lastClickPanel.setBackground(Setup.darkGray); }
		Setup.lastClickPanel = (JPanel) e.getSource();
		Setup.lastClickPanel.setBackground(Setup.magenta);

		Setup.changeInsets(10, 10, 10, 10);
		if(e.getSource() == adminPanel[0]) {
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == adminPanel[1]) {
			Setup.changePanel(Frame.contentLayeredPanel, new CustomerManagement(""), textStr[1]);
		}else if(e.getSource() == adminPanel[2]) {
			Setup.changePanel(Frame.contentLayeredPanel, new SellerManagement(""), textStr[2]);
		}else if(e.getSource() == adminPanel[3]) {
			Setup.changePanel(Frame.contentLayeredPanel, new SellerApplicationManagement(""), textStr[3]);
		}else if(e.getSource() == adminPanel[5]) {
			Setup.CustomerNum = 0;
			Setup.changePanel(Frame.menuLayeredPanel, new GuestMenu(), textStr[0]);
			Setup.changePanel(Frame.contentLayeredPanel, new Home(), "(홈) 카테고리별 추천상품 및 통계");
		}else if(e.getSource() == adminPanel[6]) {
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
					Setup.selectMenuPanel(adminPanel[0]);
				}
			});
		}
	}
}
