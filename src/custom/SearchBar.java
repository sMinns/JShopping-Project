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
    private JTextField TextField;
    private String text;
    public SearchBar(int size, int limit, String[] items, String text, int fontSize) {
        combo = new ComboBoxType1(items, 120, "뷰티");
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
        TextField = new SearchTextField(size, limit, text);
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

    public SearchBar(int size, int limit, String text) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Border lowered_bevelborder = BorderFactory.createLoweredBevelBorder();
        this.setBorder(lowered_bevelborder);

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
        TextField = new SearchTextField(size, limit, text);
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
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }


}
