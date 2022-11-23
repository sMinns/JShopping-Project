package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class onlyNumberTextField extends JFormattedTextField implements FocusListener, KeyListener {
	private Color strokeColor = Setup.textFieldBorderColor;
	private String text;
	private int round, limit;
	public onlyNumberTextField(int Columns, int round, int limit, String text) {
		this.round = round;
		this.limit = limit;
		this.text = text;
		this.setColumns(Columns);
		this.setFormatter(new NumberFormatter());
		this.setFont(new Font(Setup.font, Font.PLAIN, 12));
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10, 12, 10, 8));
		this.setForeground(Setup.Gray);
		this.setText(text);
		this.addFocusListener(this);
		this.addKeyListener(this);
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

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c) || ((JTextField) e.getSource()).getText().length() >= limit) {
			e.consume();
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) { }
}