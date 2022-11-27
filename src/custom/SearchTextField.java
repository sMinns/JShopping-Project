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

public class SearchTextField extends JTextField implements FocusListener {
    private String text;
    private Font defaultFont = new Font(Setup.font, Font.BOLD, 12);
    private Font selectFont = new Font(Setup.font, Font.PLAIN, 12);
    public SearchTextField(int Columns, int limit, String text) {
        this.text = text;
        this.setColumns(Columns);
        this.setFont(defaultFont);
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(10, 7, 11, 7));
        this.setDocument(new JTextFieldLimit(limit));
        this.setForeground(Setup.Gray);
        this.setText(text);
        this.addFocusListener(this);
    }

    class JTextFieldLimit extends PlainDocument {
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

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.setColor(Setup.white);
        g2.fillRect(1, 2, width - 2, height - 4);
        super.paintComponent(g);
    }
    @Override
    public void focusGained(FocusEvent e) {
        if(((JTextField) e.getSource()).getText().equals(text)) {
            this.setForeground(Setup.darkGray);
            this.setFont(selectFont);
            this.setText(null);
        }
        this.repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(((JTextField) e.getSource()).getText().equals("")) {
            this.setForeground(Setup.Gray);
            this.setFont(defaultFont);
            this.setText(text);
        }
        this.repaint();
    }
}
