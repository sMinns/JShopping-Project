package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SearchBar extends JPanel implements MouseListener {
    private JComboBox combo;
    String[] items = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
            "가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품"};
    private JTextField TextField;
    public SearchBar(int size, int limit) {
        combo = new ComboBoxType1(items, 120);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Border lowered_bevelborder = BorderFactory.createLoweredBevelBorder();
        this.setBorder(lowered_bevelborder);
        this.add(combo);

        JPanel searchTextPanel = new JPanel();
        searchTextPanel.setOpaque(false);
        GridBagLayout searchTextLayout = new GridBagLayout();
        searchTextLayout.columnWidths = new int[]{0, 0, 0};
        searchTextLayout.rowHeights = new int[]{0, 0};
        searchTextLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        searchTextLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        searchTextPanel.setLayout(searchTextLayout);



        GridBagConstraints searchBagCon = new GridBagConstraints();
        searchBagCon.insets = new Insets(0, 0, 0, -1);
        TextField = new SearchTextField(size, limit);
        searchTextPanel.add(TextField, searchBagCon);

        JLabel searchButtonLabel = new JLabel();
        ImageIcon icon = new ImageIcon(SearchBar.class.getResource("/images/searchbutton.png"));
        searchButtonLabel.setIcon(icon);
        searchBagCon.gridx = 1;
        searchTextPanel.add(searchButtonLabel, searchBagCon);
        searchButtonLabel.addMouseListener(this);
        this.add(searchTextPanel);
        this.setBorder(new EmptyBorder(2, 3, 2, 3));

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.setColor(Setup.magenta);
        g2.setStroke(new BasicStroke(2f));
        g2.drawRect(1, 1, width-3, height-4);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(combo.getSelectedItem() + ": " + TextField.getText());
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }

    static class SearchTextField extends JTextField {
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
}
