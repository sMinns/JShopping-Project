package gui.common;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import system.Setup;

public class BarPanel extends JPanel implements MouseListener, MouseMotionListener {
	public static JLabel titleTextLabel;
	private int x, y;
	
	public BarPanel() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Setup.magenta);
		
		GridBagLayout gbl_barPanel = new GridBagLayout();
		gbl_barPanel.columnWidths = new int[]{213, 946, 51, 0};
		gbl_barPanel.rowHeights = new int[]{0, 0};
		gbl_barPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_barPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		this.setLayout(gbl_barPanel);
		
		//Logo Panel
			JPanel logoPanel = new JPanel();
			logoPanel.setBackground(Setup.darkGray);;
			GridBagConstraints gbc_logoPanel = new GridBagConstraints();
			gbc_logoPanel.fill = GridBagConstraints.BOTH;
			gbc_logoPanel.gridx = 0;
			gbc_logoPanel.gridy = 0;
			this.add(logoPanel, gbc_logoPanel);
			logoPanel.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel logoImg = new JLabel("");
			logoImg.setIcon(new ImageIcon(Frame.class.getResource("/images/logo.png")));
			logoImg.setBackground(Setup.darkGray);
			logoImg.setHorizontalAlignment(SwingConstants.CENTER);
			logoImg.setOpaque(false);
			logoPanel.add(logoImg);
		
		//TitleBar Panel
			JPanel titleBarPanel = new JPanel();
			titleBarPanel.setBackground(Setup.magenta);
			GridBagConstraints gbc_titleBarPanel = new GridBagConstraints();
			gbc_titleBarPanel.fill = GridBagConstraints.BOTH;
			gbc_titleBarPanel.gridx = 1;
			gbc_titleBarPanel.gridy = 0;
			this.add(titleBarPanel, gbc_titleBarPanel);
			titleBarPanel.setLayout(new CardLayout(0, 0));
			
			titleTextLabel = new JLabel(" (홈) 카테고리별 추천상품 및 통계");
			titleTextLabel.setForeground(Setup.white);
			titleTextLabel.setFont(new Font(Setup.font, Font.BOLD, 30));
			titleTextLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			titleBarPanel.add(titleTextLabel);
			
		//Control Panel
			JPanel controlPanel = new JPanel();
			controlPanel.setOpaque(false);
			GridBagConstraints gbc_exitPanel = new GridBagConstraints();
			gbc_exitPanel.anchor = GridBagConstraints.WEST;
			gbc_exitPanel.fill = GridBagConstraints.VERTICAL;
			gbc_exitPanel.gridx = 2;
			gbc_exitPanel.gridy = 0;
			this.add(controlPanel, gbc_exitPanel);
			
			JLabel minimizeLabel = new JLabel("");
			minimizeLabel.setIcon(new ImageIcon(BarPanel.class.getResource("/images/minimize.png")));
			minimizeLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Frame.frame.setExtendedState(JFrame.ICONIFIED);
				}
			});
			controlPanel.add(minimizeLabel);
			
			JLabel exitLabel = new JLabel("");
			exitLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Setup.exit();
				}
				});
			exitLabel.setIcon(new ImageIcon(Frame.class.getResource("/images/close.png")));
			controlPanel.add(exitLabel);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int xx = e.getXOnScreen();
		int yy = e.getYOnScreen();
		Frame.frame.setLocation(xx-x, yy-y);
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
