package custom;

import system.Setup;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchBar extends JPanel {
    private JComboBox combo;
    private JTextField TextField;
    private JLabel searchButtonLabel;
    public SearchBar(int size, int limit, String[] items, String text, String combodefault, int fontSize) {
        combo = new ComboBoxType1(items, 120, combodefault);
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

        searchButtonLabel = new JLabel();
        ImageIcon icon = new ImageIcon(SearchBar.class.getResource("/images/searchbutton.png"));
        searchButtonLabel.setIcon(icon);
        searchBagCon.gridx = 1;
        searchTextPanel.add(searchButtonLabel, searchBagCon);
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

        searchButtonLabel = new JLabel();
        ImageIcon icon = new ImageIcon(SearchBar.class.getResource("/images/searchbutton.png"));
        searchButtonLabel.setIcon(icon);
        searchBagCon.gridx = 1;
        searchTextPanel.add(searchButtonLabel, searchBagCon);
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

    public JComboBox getCombo() {
        return combo;
    }

    public JTextField getTextField() {
        return TextField;
    }

    public void setTextField(String text) {
        TextField.setForeground(Setup.darkGray);
        TextField.setText(text);
    }

    public JLabel getSearchButtonLabel() {
        return searchButtonLabel;
    }
}
