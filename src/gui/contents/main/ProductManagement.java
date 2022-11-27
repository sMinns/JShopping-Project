package gui.contents.main;

import custom.ButtonType1;
import custom.SearchBar;
import database.CategoryDB;
import database.ProductManagementDB;
import gui.common.Frame;
import gui.contents.sub.AddProduct;
import gui.contents.sub.ChangeProductInfo;
import gui.contents.sub.GuideSubPanel;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.List;

public class ProductManagement extends JPanel implements MouseListener, ActionListener {
    private DecimalFormat formatter = new DecimalFormat("###,###");
    private List<List<String>> str;
    private List<String> items = CategoryDB.categoryList();
    private String[] productTitleText = {"카테고리", "상품정보", "판매가", "상태", "재고"};

    private JPanel[] productPanel;
    private JPanel[][] productInfoPanel;
    private JLabel[][] productInfoLabel;
    private JTextArea[] productNameTextArea;
    private JLabel[] productTitleLabel = new JLabel[5];
    private int selectPanel = -1;
    private JLayeredPane detailPanel;
    private Font font1 = new Font(Setup.font, Font.BOLD, 15);
    private Font font2 = new Font(Setup.font, Font.BOLD, 12);
    private JButton addButton;
    private String text;
    SearchBar search;
    public ProductManagement(String text) {
        this.text = text;
        str = ProductManagementDB.productList(Setup.CustomerNum, text);
        productPanel = new JPanel[str.size()];
        productInfoLabel = new JLabel[str.size()][6];
        productInfoPanel = new JPanel[str.size()][6];
        productNameTextArea = new JTextArea[str.size()];
        //ProductManagement Layout
        GridBagLayout ProductManageLayout = new GridBagLayout();
        ProductManageLayout.columnWidths = new int[]{675, 0, 0};
        ProductManageLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        ProductManageLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        this.setLayout(ProductManageLayout);

        //productListMainPanel
        JPanel productListMainPanel = new JPanel();
        GridBagConstraints productBagCon = new GridBagConstraints();
        productBagCon.insets = new Insets(0, 0, 0, 5);
        productBagCon.fill = GridBagConstraints.BOTH;
        this.add(productListMainPanel, productBagCon);

        GridBagLayout productListMainLayout = new GridBagLayout();
        productListMainLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        productListMainLayout.rowHeights = new int[]{50, 25, 0, 0, 0};
        productListMainLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        productListMainLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        productListMainPanel.setLayout(productListMainLayout);

        //TopPanel
        JPanel topPanel = new JPanel();
        GridBagConstraints topBagCon = new GridBagConstraints();
        topBagCon.gridwidth = 5;
        topBagCon.insets = new Insets(0, 0, 5, 0);
        topBagCon.fill = GridBagConstraints.BOTH;
        topBagCon.gridx = 0;
        topBagCon.gridy = 0;
        productListMainPanel.add(topPanel, topBagCon);

        GridBagLayout topPanelLayout = new GridBagLayout();
        topPanelLayout.columnWidths = new int[]{550, 0, 0};
        topPanelLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        topPanel.setLayout(topPanelLayout);

        //SearchBar Panel
        JPanel searchBarPanel = new JPanel();
        GridBagConstraints searchBarBagCon = new GridBagConstraints();
        searchBarBagCon.fill = GridBagConstraints.BOTH;
        topPanel.add(searchBarPanel, searchBarBagCon);
        //SearchBar
        search = new SearchBar(45, 50, "삼품명 검색");
        search.getTextField().addActionListener(this);
        search.getSearchButtonLabel().addMouseListener(this);
        JPanel searchBar = search;
        searchBarPanel.add(searchBar);

        if(!text.equals("")) {
            search.setTextField(text);
            search.getTextField().setFont(new Font(Setup.font, Font.PLAIN, 12));
        }

        //Add Product
        JPanel addProductButton = new JPanel();
        searchBarBagCon.insets = new Insets(1, 0, 0, 0);
        searchBarBagCon.gridx = 1;
        topPanel.add(addProductButton, searchBarBagCon);
        addButton = new ButtonType1(25, 8, 2, "상품 등록", 16);
        addButton.addActionListener(this);
        addProductButton.add(addButton);

        //Title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.white);
        GridBagConstraints titleBagCon = new GridBagConstraints();
        titleBagCon.gridwidth = 5;
        titleBagCon.insets = new Insets(0, 0, 2, 0);
        titleBagCon.fill = GridBagConstraints.BOTH;
        titleBagCon.gridx = 0;
        titleBagCon.gridy = 1;
        productListMainPanel.add(titlePanel, titleBagCon);

        GridBagLayout titleLayout = new GridBagLayout();
        titleLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
        titleLayout.columnWidths = new int[]{110, 280, 113, 55, 80};
        titlePanel.setLayout(titleLayout);

        //Product Title for loop
        GridBagConstraints productTitleBagCon = new GridBagConstraints();
        for (int i = 0; i < productTitleText.length; i++) {
            if (i == 4) {
                productTitleBagCon.insets = new Insets(0, 0, 0, 0);
            }
            productTitleLabel[i]  = new JLabel(productTitleText[i]);
            productTitleLabel[i].setFont(font1);
            titlePanel.add(productTitleLabel[i], productTitleBagCon);
        }

        //Product Scroll
        JScrollPane productScrollPanel = new JScrollPane();
        productScrollPanel.setBorder(BorderFactory.createLineBorder(Setup.white, 1));
        productScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Setup.changeScrollBar(productScrollPanel);

        GridBagConstraints productScrollBagCon = new GridBagConstraints();
        productScrollBagCon.fill = GridBagConstraints.BOTH;
        productScrollBagCon.gridheight = 2;
        productScrollBagCon.gridwidth = 5;
        productScrollBagCon.gridy = 2;
        productListMainPanel.add(productScrollPanel, productScrollBagCon);

        //Product List
        JPanel productListPanel = new JPanel();
        productListPanel.setLayout(null);
        int a = 5;
        for(int i = 0; i < str.size(); i++) {
            this.productPanel[i] = new JPanel();
            this.productPanel[i].setBounds(0, 10, 673, 60);
            productListPanel.add(this.productPanel[i]);
            GridBagLayout productListLayout = new GridBagLayout();
            productListLayout.columnWidths = new int[]{110, 60, 220, 110, 60, 80, 0};
            productListLayout.rowHeights = new int[]{0, 0};
            productListLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
            productListLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
            this.productPanel[i].setLayout(productListLayout);
            this.productPanel[i].setBounds(0, i*60+i, 673, 60);
            this.productPanel[i].addMouseListener(this);

            GridBagConstraints productListBagCon = new GridBagConstraints();
            productListBagCon.fill = GridBagConstraints.BOTH;
            productListPanel.add(this.productPanel[i]);
            //addProductInfo
            addProductInfo(i, productListBagCon);
        }
        productScrollPanel.setViewportView(productListPanel);
        productListPanel.setPreferredSize(new Dimension(productListPanel.getWidth(),61*str.size()-1));
        detailPanel = new JLayeredPane();
        detailPanel.setLayout(new CardLayout());
        detailPanel.add(new GuideSubPanel("상품을 선택해서 정보를 변경할 수 있습니다."));
        productBagCon.insets = new Insets(0, 0, 0, 0);
        productBagCon.gridx = 1;
        this.add(detailPanel, productBagCon);
    }

    public void addProductInfo(int i, GridBagConstraints productListBagCon) {
        int k = 1;
        for(int j = 0; j < 6; j++ ) {
            FlowLayout layout = new FlowLayout(1, 3, 22);
            productInfoPanel[i][j] = new JPanel();
            productInfoPanel[i][j].setBackground(Setup.white);
            this.productPanel[i].add(productInfoPanel[i][j], productListBagCon);

            productInfoLabel[i][j] = new JLabel();
            productInfoLabel[i][j].setFont(font2);
            if(j != 2) {
                if(j == 1) {
                    layout.setVgap(5);
                    productInfoLabel[i][j].setIcon(Setup.imageSetSize(
                            new ImageIcon(ProductManagementDB.productImageLoad(Integer.parseInt(str.get(i).get(0)))),50,50));;
                }else if(j == 3 || j == 5) {
                    String text = formatter.format(Integer.parseInt(str.get(i).get(k)));
                    if(j == 3) {
                        productInfoLabel[i][j].setText(text + "원");
                    }else {
                        productInfoLabel[i][j].setText(text);
                    }
                }else {
                    productInfoLabel[i][j].setText(str.get(i).get(k));
                }
                productInfoPanel[i][j].add(productInfoLabel[i][j]);
                productInfoPanel[i][j].setLayout(layout);
            }else {
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.WEST;
                productInfoPanel[i][j].setLayout(new GridBagLayout());
                productNameTextArea[i] = new JTextArea(1, 18);
                productNameTextArea[i].setEditable(false);
                productNameTextArea[i].setText(str.get(i).get(j));
                productNameTextArea[i].setOpaque(false);
                productNameTextArea[i].setLineWrap(true);
                productNameTextArea[i].setFont(font2);
                productNameTextArea[i].addMouseListener(this);
                productInfoPanel[i][j].add(productNameTextArea[i], gbc);
            }
            if(j != 1) { k++; }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < str.size(); i++) {
            if (selectPanel != -1) {
                if (e.getSource() == productNameTextArea[selectPanel] || e.getSource() == productPanel[selectPanel]) {
                    Setup.changePanel(detailPanel, new GuideSubPanel("상품을 선택해서 정보를 변경할 수 있습니다."));
                    productPanel[selectPanel].setBorder(null);
                    selectPanel = -1;
                    return;
                }else if (e.getSource() == productNameTextArea[i] || e.getSource() == productPanel[i]) {
                    productPanel[selectPanel].setBorder(null);
                    selectPanel = i;
                    Setup.changePanel(detailPanel, new ChangeProductInfo(str.get(i).get(0), text));
                    productPanel[selectPanel].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                    return;
                }
            }else if (e.getSource() == productNameTextArea[i] || e.getSource() == productPanel[i]) {
                selectPanel = i;
                Setup.changePanel(detailPanel, new ChangeProductInfo(str.get(i).get(0), text));
                productPanel[selectPanel].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                return;
            }
        }
    }
    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == search.getSearchButtonLabel()) {
            if(search.getTextField().getText().equals("삼품명 검색")) {
                text = "";
            }else {
                text = search.getTextField().getText();
            }
            Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(text));
        }
    }
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton) {
            Setup.changePanel(detailPanel, new AddProduct(text));
        }
        if(e.getSource() == search.getTextField()) {
            if(search.getTextField().getText().equals("삼품명 검색")) {
                text = "";
            }else {
                text = search.getTextField().getText();
            }
            Setup.changePanel(Frame.contentLayeredPanel, new ProductManagement(text));
        }
    }

    public String getText() {
        return text;
    }
}
