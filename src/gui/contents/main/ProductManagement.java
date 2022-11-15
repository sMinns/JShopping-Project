package gui.contents.main;

import custom.ButtonType1;
import custom.SearchBar;
import gui.contents.sub.ChangeInformation;
import gui.contents.sub.GuideSubPanel;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

public class ProductManagement extends JPanel implements MouseListener {
    private DecimalFormat formatter = new DecimalFormat("###,###");
    private String[][] str = {
            {"도서/음반/DVD", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "422100", "판매중", "12344"},
            {"패션의류", "/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화", "123350", "판매대기", "87"},
            {"생활용품", "/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화", "75430", "판매중", "854"},
            {"홈인테리어", "/images/nullimage.png", "아디다스 문디알팀 풋살화 축구화", "123322", "판매중", "764"},
            {"반려동물용품", "/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화", "612312", "판매대기", "54"},
            {"헬스/건강식품", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "876866", "판매대기", "142"},
            {"뷰티", "/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화", "45654", "판매중", "113"},
            {"도서/음반/DVD", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "422100", "판매중", "12344"},
            {"패션의류", "/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화", "123350", "판매대기", "87"},
            {"생활용품", "/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화", "75430", "판매대기", "854"},
            {"홈인테리어", "/images/nullimage.png", "아디다스 문디알팀 풋살화 축구화", "123322", "판매중", "764"},
            {"반려동물용품", "/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화", "612312", "판매대기", "54"},
            {"헬스/건강식품", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "876866", "판매중", "142"},
            {"뷰티", "/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화", "45654", "판매대기", "113"},
            {"도서/음반/DVD", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "422100", "판매대기", "12344"},
            {"패션의류", "/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화", "123350", "판매대기", "87"},
            {"생활용품", "/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화", "75430", "판매중", "854"},
            {"홈인테리어", "/images/nullimage.png", "아디다스 문디알팀 풋살화 축구화", "123322", "판매중", "764"},
            {"반려동물용품", "/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화", "612312", "판매대기", "54"},
            {"헬스/건강식품", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "876866", "판매대기", "142"},
            {"뷰티", "/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화", "45654", "판매대기", "113"}
    };
    private String[] items = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
            "가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품"};
    private String[] productTitleText = {"카테고리", "상품정보", "판매가", "상태", "재고"};

    private JPanel[] productPanel = new JPanel[str.length];
    private JPanel[][] productInfoPanel = new JPanel[str.length][str[1].length];
    private JLabel[][] productInfoLabel = new JLabel[str.length][str[1].length];
    private JTextArea[] productNameTextArea = new JTextArea[str.length];
    private JLabel[] productTitleLabel = new JLabel[5];
    private JPanel selectPanel= null;
    private JLayeredPane detailPanel;
    private Font font1 = new Font(Setup.font, Font.BOLD, 15);
    private Font font2 = new Font(Setup.font, Font.BOLD, 12);
    public ProductManagement() {
        Setup.changeInsets(10, 10, 10, 10);
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
        JPanel searchBar = new SearchBar(45, 50, "상품평 검색");
        searchBarPanel.add(searchBar);

        //Add Product
        JPanel addProductButton = new JPanel();
        searchBarBagCon.gridx = 1;
        topPanel.add(addProductButton, searchBarBagCon);
        addProductButton.add(new ButtonType1(22, 8, 2, "상품 등록", 12));

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
        for(int i = 0; i < str.length; i++) {
            this.productPanel[i] = new JPanel();
            this.productPanel[i].setBounds(0, 10, 673, 60);
            productListPanel.add(this.productPanel[i]);
            GridBagLayout productListLayout = new GridBagLayout();
            productListLayout.columnWidths = new int[]{110, 60, 220, 110, 60, 80, 0};
            productListLayout.rowHeights = new int[]{0, 0};
            productListLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
            productListLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
            this.productPanel[i].setLayout(productListLayout);
            this.productPanel[i].setBounds(0, i*60+i, 659, 60);
            this.productPanel[i].addMouseListener(this);

            GridBagConstraints productListBagCon = new GridBagConstraints();
            productListBagCon.fill = GridBagConstraints.BOTH;
            productListPanel.add(this.productPanel[i]);
            //addProductInfo
            addProductInfo(i, productListBagCon);
        }
        productScrollPanel.setViewportView(productListPanel);
        productListPanel.setPreferredSize(new Dimension(productListPanel.getWidth(),61*str.length-1));
        detailPanel = new JLayeredPane();
        detailPanel.setLayout(new CardLayout());
        productBagCon.insets = new Insets(0, 0, 0, 0);
        productBagCon.gridx = 1;
        this.add(detailPanel, productBagCon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(selectPanel == e.getSource()) {
            Setup.changeFindPanel(detailPanel, new GuideSubPanel());
            selectPanel.setBorder(null);
            selectPanel = null;
        }else {
            for (int i = 0; i < str.length; i++) {
                if (e.getSource() == productPanel[i]) {
                    if(selectPanel != null) { selectPanel.setBorder(null); }
                    selectPanel = (JPanel) e.getSource();
                    Setup.selectProduct = str[i];
                    Setup.changeFindPanel(detailPanel, new ChangeInformation());
                    selectPanel.setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (e.getSource() == productNameTextArea[i]) {
                if(selectPanel == productPanel[i]) {
                    Setup.changeFindPanel(detailPanel, new GuideSubPanel());
                    selectPanel.setBorder(null);
                    selectPanel = null;
                }else {
                    if(selectPanel != null) { selectPanel.setBorder(null); }
                    selectPanel = productPanel[i];
                    Setup.selectProduct = str[i];
                    Setup.changeFindPanel(detailPanel, new ChangeInformation());
                    selectPanel.setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                }
            }
        }
    }
    public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
    public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }

    public void addProductInfo(int i, GridBagConstraints productListBagCon) {
        for(int j = 0; j < str[i].length; j++ ) {
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
                            new ImageIcon(ProductManagement.class.getResource(str[i][1])),50,50));;
                }else if(j == 3 || j == 5) {
                    String text = formatter.format(Integer.parseInt(str[i][j]));
                    if(j == 3) {
                        productInfoLabel[i][j].setText(text + "원");
                    }else {
                        productInfoLabel[i][j].setText(text);
                    }
                }else {
                    productInfoLabel[i][j].setText(str[i][j]);
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
                productNameTextArea[i].setText(str[i][j]);
                productNameTextArea[i].setOpaque(false);
                productNameTextArea[i].setLineWrap(true);
                productNameTextArea[i].setFont(font2);
                productNameTextArea[i].addMouseListener(this);
                productInfoPanel[i][j].add(productNameTextArea[i], gbc);
            }
        }
    }
}
