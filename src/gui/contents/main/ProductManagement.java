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
    private String[][] str = {{"도서/음반/DVD", "/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전", "422100", "판매중", "12344"},
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
    private JPanel[] ps = new JPanel[str.length];
    private JPanel[][] ps2 = new JPanel[str.length][str[1].length];
    private JLabel[][] ls = new JLabel[str.length][str[1].length];
    private JTextArea[] tx = new JTextArea[str.length];
    private JPanel selectPanel= null;
    private JLayeredPane detailPanel;
    public ProductManagement() {
        GridBagLayout ProductManageLayout = new GridBagLayout();
        ProductManageLayout.columnWidths = new int[]{675, 0, 0};
        ProductManageLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        ProductManageLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        this.setLayout(ProductManageLayout);

        JPanel productPanel = new JPanel();
        GridBagConstraints productBagCon = new GridBagConstraints();
        productBagCon.insets = new Insets(0, 0, 0, 5);
        productBagCon.fill = GridBagConstraints.BOTH;
        this.add(productPanel, productBagCon);

        GridBagLayout ProductLayout = new GridBagLayout();
        ProductLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        ProductLayout.rowHeights = new int[]{50, 25, 0, 0, 0};
        ProductLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        ProductLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        productPanel.setLayout(ProductLayout);

        JPanel topPanel = new JPanel();
        GridBagConstraints topPanelBagCon = new GridBagConstraints();
        topPanelBagCon.gridwidth = 5;
        topPanelBagCon.insets = new Insets(0, 0, 5, 0);
        topPanelBagCon.fill = GridBagConstraints.BOTH;
        topPanelBagCon.gridx = 0;
        topPanelBagCon.gridy = 0;
        productPanel.add(topPanel, topPanelBagCon);

        GridBagLayout topBagCon = new GridBagLayout();
        topBagCon.columnWidths = new int[]{550, 0, 0};
        topBagCon.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        topPanel.setLayout(topBagCon);

        JPanel searchBarPanel = new JPanel();
        GridBagConstraints searchBarBagCon = new GridBagConstraints();
        searchBarBagCon.fill = GridBagConstraints.BOTH;
        topPanel.add(searchBarPanel, searchBarBagCon);

        JPanel searchBar = new SearchBar(27, 50);
        searchBarPanel.add(searchBar);

        JPanel addProductButton = new JPanel();
        searchBarBagCon.gridx = 1;
        topPanel.add(addProductButton, searchBarBagCon);
        addProductButton.add(new ButtonType1(22, 8, 2, "상품 등록"));
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(Color.white);
        GridBagConstraints titleBagCOn = new GridBagConstraints();
        titleBagCOn.gridwidth = 5;
        titleBagCOn.insets = new Insets(0, 0, 2, 0);
        titleBagCOn.fill = GridBagConstraints.BOTH;
        titleBagCOn.gridx = 0;
        titleBagCOn.gridy = 1;
        productPanel.add(panel_8, titleBagCOn);


        Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
        Font font2 = new Font("맑은 고딕", Font.BOLD, 12);
        GridBagLayout gbldsadas = new GridBagLayout();
        gbldsadas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
        gbldsadas.columnWidths = new int[]{110, 280, 113, 55, 80};
        panel_8.setLayout(gbldsadas);

        String[] tt = {"카테고리", "상품정보", "판매가", "상태", "재고"};
        JLabel[] ll = new JLabel[5];
        GridBagConstraints label_gbc = new GridBagConstraints();
        for (int i = 0; i < tt.length; i++) {
            if (i == 4) {
                label_gbc.insets = new Insets(0, 0, 0, 0);
            }
            ll[i]  = new JLabel(tt[i]);
            ll[i].setFont(font1);
            panel_8.add(ll[i], label_gbc);
        }

        JScrollPane productScrollPanel = new JScrollPane();
        productScrollPanel.setBorder(BorderFactory.createLineBorder(Setup.white, 1));
        Setup.changeScrollBar(productScrollPanel);

        GridBagConstraints productScrollBagCon = new GridBagConstraints();
        productScrollBagCon.fill = GridBagConstraints.BOTH;
        productScrollBagCon.gridheight = 2;
        productScrollBagCon.gridwidth = 5;
        productScrollBagCon.gridy = 2;
        productPanel.add(productScrollPanel, productScrollBagCon);

        JPanel productListPanel = new JPanel();
        productListPanel.setLayout(null);
        int a = 5;
        for(int i = 0; i < str.length; i++) {
            ps[i] = new JPanel();
            ps[i].setBounds(0, 10, 673, 60);
            productListPanel.add(ps[i]);
            GridBagLayout productListLayout = new GridBagLayout();
            productListLayout.columnWidths = new int[]{110, 60, 220, 110, 60, 80, 0};
            productListLayout.rowHeights = new int[]{0, 0};
            productListLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
            productListLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
            ps[i].setLayout(productListLayout);
            ps[i].setBounds(0, i*60+i, 667, 60);
            ps[i].addMouseListener(this);

            GridBagConstraints productListBagCon = new GridBagConstraints();
            productListBagCon.fill = GridBagConstraints.BOTH;
            for(int j = 0; j < str[i].length; j++ ) {

                FlowLayout layout = new FlowLayout(1, 3, 22);
                ps2[i][j] = new JPanel();
                ps2[i][j].setBackground(Setup.white);
                ps[i].add(ps2[i][j], productListBagCon);

                ls[i][j] = new JLabel();
                ls[i][j].setFont(font2);
                if(j != 2) {
                    if(j == 1) {
                        layout.setVgap(5);
                        ls[i][j].setIcon(Setup.imageSetSize(
                                new ImageIcon(ProductManagement.class.getResource(str[i][1])),50,50));;
                    }else if(j == 3 || j == 5) {
                        String text = formatter.format(Integer.parseInt(str[i][j]));
                        if(j == 3) {
                            ls[i][j].setText(text + "원");
                        }else {
                            ls[i][j].setText(text);
                        }
                    }else {
                        ls[i][j].setText(str[i][j]);
                    }

                    ps2[i][j].add(ls[i][j]);
                    ps2[i][j].setLayout(layout);
                }else {
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.anchor = GridBagConstraints.WEST;
                    ps2[i][j].setLayout(new GridBagLayout());
                    tx[i] = new JTextArea(1, 18);
                    tx[i].setEditable(false);
                    tx[i].setText(str[i][j]);
                    tx[i].setOpaque(false);
                    tx[i].setLineWrap(true);
                    tx[i].setFont(font2);
                    tx[i].addMouseListener(this);
                    ps2[i][j].add(tx[i], gbc);
                }
            }
            productListPanel.add(ps[i]);
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
        }else {
            for (int i = 0; i < str.length; i++) {
                if (e.getSource() == ps[i]) {
                    if(selectPanel != null) { selectPanel.setBorder(null); }
                    selectPanel = (JPanel) e.getSource();
                    Setup.selectProduct = str[i];
                    Setup.changeFindPanel(detailPanel, new ChangeInformation());
                    selectPanel.setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (e.getSource() == tx[i]) {
                if(selectPanel == ps[i]) {
                    Setup.changeFindPanel(detailPanel, new GuideSubPanel());
                    selectPanel.setBorder(null);
                }else {
                    if(selectPanel != null) { selectPanel.setBorder(null); }
                    selectPanel = ps[i];
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


}
