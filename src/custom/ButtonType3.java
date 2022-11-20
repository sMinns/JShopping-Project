package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonType3 extends JButton implements MouseListener {
	int[] xx, yy;
	public ButtonType3(boolean minus) {
		if (minus) {
			xx = new int[]{9, 10, 3, 10, 9, 0};
			yy = new int[]{0, 2, 9, 16, 18, 9};
		}else {
			xx = new int[]{7, 6, 13, 6, 7, 16};
			yy = new int[]{0, 2, 9, 16, 18, 9};
		}
		this.setContentAreaFilled(false);
		this.setBorder(new EmptyBorder(10, 8, 10, 8));
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.addMouseListener(this);
		this.setForeground(Setup.darkGray);
	}
	
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		int ly = (height - 16) / 2;
		int px[] = xx;
		int py[] = {ly+yy[0], ly+yy[1], ly+yy[2], ly+yy[3], ly+yy[4], ly+yy[5]};

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g2.setColor(Setup.white);
		g2.fillRect(2, 0, width-3, height-3);
		super.paintComponent(g);



		g2.setColor(Setup.darkGray);
		g2.fillPolygon(px, py, px.length);
	}

	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent arg0) { }
	public void mouseClicked(MouseEvent e) { }
}
