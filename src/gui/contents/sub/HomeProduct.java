package gui.contents.sub;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import system.Setup;

public class HomeProduct extends JPanel implements MouseListener {
	private String text;
	public HomeProduct(JTextArea textArea, String text, boolean top) {
		this.text = text;
		this.setOpaque(false);
		
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
			
			JLabel imageLabel = new JLabel("");
			imagePanel.add(imageLabel);
			imageLabel.setIcon(Setup.imageSetSize(new ImageIcon(HomeProduct.class.getResource("/images/nullimage.png")),150,150));
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
			
			textArea.setFont(new Font(Setup.font, Font.BOLD, 12));
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setBounds(20, 5, 150, 56);
			textArea.addMouseListener(this);
			textPanel.add(textArea);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(text + "Click");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
