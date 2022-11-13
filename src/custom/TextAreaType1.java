package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextAreaType1 extends JTextArea implements FocusListener {
	private Color strokeColor = Setup.textFieldBorderColor;
	private String text;
	private int round;
	private int limit;
	public TextAreaType1(int Columns, int height, int round, String text, int limit) {
		this.setColumns(Columns);
		this.round = round;
		this.text = text;
		this.limit = limit;

		this.setDocument(new JTextFieldLimit(limit));
		this.setFont(new Font(Setup.font, Font.PLAIN, 12));
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10, 8, 10, 8));
		this.setForeground(Setup.darkGray);
		this.setText(text);
		this.setLineWrap(true);
		this.addFocusListener(this);
		this.setPreferredSize(new Dimension(0, height));
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
		strokeColor = Setup.magenta;
		this.repaint();
	}

	@Override
	public void focusLost(FocusEvent e) {
		strokeColor = Setup.textFieldBorderColor;
		this.repaint();
	}

	static class JTextFieldLimit extends PlainDocument {
		private int limit;
		JTextFieldLimit(int limit) {
			super();
			this.limit = limit;
		}

		JTextFieldLimit(int limit, boolean upper) {
			super();
			this.limit = limit;
		}

		public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			if (str == null)
				return;

			if ((getLength() + str.length()) <= limit) {
				super.insertString(offset, str, attr);
			}
		}
	}
}


