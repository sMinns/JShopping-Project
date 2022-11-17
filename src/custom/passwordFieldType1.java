package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class passwordFieldType1 extends JPasswordField {
	private Color strokeColor = Setup.textFieldBorderColor;
	private int round;
	public passwordFieldType1(int Columns, int round) {
		this.round = round;
		this.setColumns(Columns);
		this.setFont(new Font(Setup.font, Font.PLAIN, 16));
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10, 8, 10, 8));
		this.setForeground(Setup.darkGray);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g2.setColor(Setup.white);
		g2.fillRoundRect(1, 1, width-2, height-2, round*2, round*2);
		g2.setColor(strokeColor);
		g2.setStroke(new BasicStroke(2f));
		g2.drawRoundRect(2, 2, width-4, height-4, round, round);
		super.paintComponent(g);
	}
}
