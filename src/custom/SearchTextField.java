package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class SearchTextField extends JTextField {
    private Color strokeColor = Setup.textFieldBorderColor;
    private String text;

    public SearchTextField(int Columns, int limit) {
        this.setColumns(Columns);
        this.setFont(new Font(Setup.font, Font.PLAIN, 16));
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(7, 7, 7, 7));
        this.setForeground(Setup.darkGray);
        this.setDocument(new JTextFieldLimit(limit));
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
}
