package custom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import system.Setup;

public class TextFieldType1 extends JTextField implements FocusListener {
	private Color strokeColor = Setup.textFieldBorderColor;
	private String text;
	public TextFieldType1(int Columns, String text) {
		this.text = text;
		this.setColumns(Columns);
		this.setFont(new Font(Setup.font, Font.PLAIN, 16));
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10, 8, 10, 8));
		this.setForeground(Setup.Gray);
		this.setText(text);
		this.addFocusListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
		g2.setColor(Setup.white);
		g2.fillRoundRect(1, 1, width-2, height-2, 10, 10);
		g2.setColor(strokeColor);
		g2.setStroke(new BasicStroke(2f));
		g2.drawRoundRect(2, 2, width-4, height-4, 5, 5);
		super.paintComponent(g);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(((JTextField) e.getSource()).getText().equals(text)) {
			this.setForeground(Setup.darkGray);
			this.setText(null);
		}
		strokeColor = Setup.magenta;
		this.repaint();
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(((JTextField) e.getSource()).getText().equals("")) {
			this.setForeground(Setup.Gray);
			this.setText(text);
		}
		strokeColor = Setup.textFieldBorderColor;
		this.repaint();
		
	}

}
