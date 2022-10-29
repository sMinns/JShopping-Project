package gui.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import gui.main.HomePanel;
import gui.main.LoginPanel;
import gui.main.SearchPanel;
import gui.main.SignUpPanel;
import system.Setup;

public class GuestPanel extends JPanel implements MouseListener{
	private JPanel GuestPanel[] = new JPanel[5];
	private String[] imgStr = { "/images/home.png", "/images/search.png", "/images/signup.png", "/images/login.png", "/images/exit.png" };
	private String[] textStr = { "Ȩ", "��ǰ�˻�", "ȸ������", "�α���", "����" };
	private JPanel lastClickPanel;
	private int j = 0;
	public GuestPanel() {;
		this.setBackground(new Color(24, 24, 24));
		
		//GridBagLayout
			GridBagLayout GuestPanelBagLayout = new GridBagLayout();
			GuestPanelBagLayout.columnWidths = new int[]{0, 0, 0};
			GuestPanelBagLayout.rowHeights = new int[]{51, 50, 400, 50, 50, 50, 0, 0};
			GuestPanelBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			GuestPanelBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(GuestPanelBagLayout);
		
		//MenuBagConstraints 
			GridBagConstraints GuestBagConstraints = new GridBagConstraints();
			GuestBagConstraints.gridwidth = 2;
			GuestBagConstraints.insets = new Insets(1, 0, 1, 0);
			GuestBagConstraints.fill = GridBagConstraints.BOTH;
			GuestBagConstraints.gridx = 0;
			GuestBagConstraints.gridy = 0;
			
		//Menu Panel
			for(int i = 0; i < 6; i++) {
				if(i == 1) { GuestBagConstraints.insets = new Insets(0, 0, 1, 0); }
				if(i != 0) { GuestBagConstraints.gridy++; }
				if(i == 2) {
					JPanel blankPanel1 = new JPanel();
					blankPanel1.setBackground(Setup.darkGray);
					this.add(blankPanel1, GuestBagConstraints);
					continue;
				}
				ImageIcon img = new ImageIcon(GuestPanel.class.getResource(imgStr[j]));
				GuestPanel[j] = new MenuButton(img, textStr[j]); 
				GuestPanel[j].addMouseListener(this);
				this.add(GuestPanel[j], GuestBagConstraints);
				j++;
			}
			
		//Blank Panel
			JPanel blankPanel2 = new JPanel();
			blankPanel2.setBackground(Setup.darkGray);
			GuestBagConstraints.gridy++;
			this.add(blankPanel2, GuestBagConstraints);
			
		lastClickPanel = GuestPanel[0];
		GuestPanel[0].setBackground(Setup.magenta);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		lastClickPanel.setBackground(Setup.darkGray);
		lastClickPanel = (JPanel) e.getSource();
		lastClickPanel.setBackground(Setup.magenta);
		
		if(e.getSource() == GuestPanel[0]) {
			Setup.changePanel(new HomePanel(), " Ȩ");
		}else if(e.getSource() == GuestPanel[1]) {
			Setup.changePanel(new SearchPanel(), " ��ǰ�˻�");
		}else if(e.getSource() == GuestPanel[2]) {
			Setup.changePanel(new SignUpPanel(), " ȸ������");
		}else if(e.getSource() == GuestPanel[3]) {
			Setup.changePanel(new LoginPanel(), " �α���");
		}else if(e.getSource() == GuestPanel[4]) {
			Setup.exit();
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
