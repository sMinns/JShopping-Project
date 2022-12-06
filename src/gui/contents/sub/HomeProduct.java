package gui.contents.sub;

import database.HomeDB;
import database.LoginDB;
import gui.common.Frame;
import gui.contents.main.Search;
import gui.menu.CustomerMenu;
import gui.menu.GuestMenu;
import gui.menu.SellerMenu;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeProduct extends JPanel implements MouseListener {
	private ImageIcon image;
	private String name;
	private int prnum;
	private JTextArea textArea;
	JLabel imageLabel;
	public HomeProduct(int prnum, boolean top) {
		this.prnum = prnum;
		this.setOpaque(false);
		if(prnum == 0) {
			image = new ImageIcon(HomeProduct.class.getResource("/images/nullimage.png"));
			name = "상품이 부족합니다.";
		}else {
			image = new ImageIcon(HomeDB.productImageLoad(prnum));
			name = HomeDB.returnHomeProductName(prnum);
		}
		//Layout
			GridBagLayout gbl_panel_11 = new GridBagLayout();
			if(top) {
				gbl_panel_11.rowHeights = new int[]{70, 150, 0, 0};
			}else {
				gbl_panel_11.rowHeights = new int[]{30, 150, 0, 0};
			}
			gbl_panel_11.columnWidths = new int[]{116, 0};
			gbl_panel_11.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(gbl_panel_11);

		//Image
			JPanel imagePanel = new JPanel();
			imagePanel.setOpaque(false);
			GridBagConstraints gbc_panel_16 = new GridBagConstraints();
			gbc_panel_16.insets = new Insets(0, 0, 5, 0);
			gbc_panel_16.fill = GridBagConstraints.BOTH;
			gbc_panel_16.gridx = 0;
			gbc_panel_16.gridy = 1;
			this.add(imagePanel, gbc_panel_16);

			imageLabel = new JLabel();
			imagePanel.add(imageLabel);
			imageLabel.setIcon(Setup.imageSetSize(image, 150, 150));
			imageLabel.addMouseListener(this);

		//Text
			JPanel textPanel = new JPanel();
			textPanel.setLayout(null);
			textPanel.setOpaque(false);
			GridBagConstraints gbc_panel_21 = new GridBagConstraints();
			gbc_panel_21.fill = GridBagConstraints.BOTH;
			gbc_panel_21.gridx = 0;
			gbc_panel_21.gridy = 2;
			this.add(textPanel, gbc_panel_21);

			textArea = new JTextArea();
			textArea.setFont(new Font(Setup.font, Font.BOLD, 12));
			textArea.setText(name);
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setBounds(20, 5, 150, 56);
			textArea.addMouseListener(this);
			textPanel.add(textArea);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(prnum != 0) {
			if(Setup.CustomerNum == 0) {
				Setup.lastClickReset();
				Setup.selectMenuPanel(GuestMenu.GuestPanel[1]);
			}else if(LoginDB.sellerCheck(Setup.CustomerNum)) {
				Setup.lastClickReset();
				Setup.selectMenuPanel(SellerMenu.sellerPanel[1]);
			}else if(Setup.CustomerNum == -1) {
				return;
			}else {
				Setup.lastClickReset();
				Setup.selectMenuPanel(CustomerMenu.customerPanel[1]);
			}
			Setup.changePanel(Frame.contentLayeredPanel, new Search(name, 0, "전체"), "상품검색");
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) { if(prnum != 0) setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { if(prnum != 0) setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }

	public void setImageLabel(ImageIcon image) {
		imageLabel.setIcon(Setup.imageSetSize(image, 150, 150));
	}

	public void setTextArea(String str) {
		textArea.setText(str);
	}

	public void setName(String str) { name = str; }
}
