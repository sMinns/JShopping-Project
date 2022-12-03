package gui.contents.sub;

import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Collections;
import java.util.List;

public class Statistics extends JPanel {
	public Statistics(List<Integer> nums) {
		this.setLayout(new GridLayout());
		this.setBackground(Setup.white);
		for(int i = 0; i < 5; i++) {
			this.add(new StatGraph(Setup.statColor[i], nums.get(i), Collections.max(nums)));
		}
	}
	private class StatGraph extends JPanel {
		private float height;
		private Color color;
		private StatGraph(Color color, int num, int maxnum) {
			if(maxnum == 0 ) { maxnum++; }
			height = ( 430 / maxnum ) * (maxnum - num);
			this.color = color;
			this.setBackground(Setup.white);
			GridBagLayout gbl_panel_24 = new GridBagLayout();
			gbl_panel_24.columnWidths = new int[]{0, 0};
			gbl_panel_24.rowHeights = new int[]{276, 50, 0};
			gbl_panel_24.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_24.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			this.setLayout(gbl_panel_24);
			
			JPanel textPanel = new JPanel();
			textPanel.setOpaque(false);
			GridBagConstraints gbc_panel_34 = new GridBagConstraints();
			gbc_panel_34.fill = GridBagConstraints.BOTH;
			gbc_panel_34.gridx = 0;
			gbc_panel_34.gridy = 1;
			this.add(textPanel, gbc_panel_34);
			
			JLabel age1 = new JLabel("" + num);
			age1.setFont(new Font(Setup.font, Font.BOLD, 18));
			textPanel.add(age1);
		}
		
		public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setStroke(new BasicStroke(3));

			g2.setPaint(color);
			g2.fill(new Rectangle2D.Float(20, height, 20, 430-height));
			g2.setPaint(Setup.bgLightGray);
			g2.draw(new Rectangle2D.Float(20, height, 20, 430-height));
		}
  	}
}
