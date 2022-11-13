package gui.contents.sub;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextAreaType1;
import gui.contents.main.ProductManagement;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangeInformation extends JPanel {
    private static JLabel image;
    private static JPanel[] subStatTitlePanel = new JPanel[6];
    private static String[] subStatTitle = {"사진", "상품명", "카테고리", "판매가", "재고", "상태"};
    private static JLabel[] subStatText = new JLabel[6];
    private static JPanel[] subStatTextPanel = new JPanel[6];
    private static String[] items = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
            "가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품" };
    private static String[] stat = {"판매대기", "판매중"};
    private static JTextArea[] productstat = new JTextArea[3];
    private static GridBagConstraints subStatBagCon;
    private static JPanel statPanel;
    Font font = new Font(Setup.font, Font.BOLD, 14);
    public ChangeInformation() {
        GridBagLayout detailLayout = new GridBagLayout();
        detailLayout.columnWidths = new int[]{0, 0};
        detailLayout.rowHeights = new int[]{260, 0, 0};
        detailLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        detailLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        this.setLayout(detailLayout);

        JPanel subPanel = new JPanel();
        GridBagConstraints subBagCon = new GridBagConstraints();
        subBagCon.insets = new Insets(0, 0, 5, 0);
        subBagCon.fill = GridBagConstraints.BOTH;
        subBagCon.gridx = 0;
        subBagCon.gridy = 0;
        this.add(subPanel, subBagCon);

        image = new JLabel();
        image.setIcon(Setup.imageSetSize(
                new ImageIcon(ProductManagement.class.getResource(Setup.selectProduct[1])),260,260));;
        subPanel.add(image);

        statPanel = new JPanel();
        GridBagConstraints statBagCon = new GridBagConstraints();
        statBagCon.fill = GridBagConstraints.BOTH;
        statBagCon.gridx = 0;
        statBagCon.gridy = 1;
        this.add(statPanel, statBagCon);

        GridBagLayout statLayout = new GridBagLayout();
        statLayout.columnWidths = new int[]{70, 0, 0};
        statLayout.rowHeights = new int[]{50, 75, 50, 50, 50, 50, 0, 0};
        statLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        statLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        statPanel.setLayout(statLayout);


        subStatBagCon = new GridBagConstraints();
        subStatBagCon.insets = new Insets(0, 10, 5, 5);
        subStatBagCon.fill = GridBagConstraints.BOTH;

        for(int i = 0; i < 6; i++) {
            subStatTitlePanel[i] = new JPanel();
            subStatTitlePanel[i].setLayout(new CardLayout());
            subStatBagCon.gridy = i;
            statPanel.add(subStatTitlePanel[i], subStatBagCon);
            subStatText[i] = new JLabel(subStatTitle[i]);
            subStatText[i].setFont(font);
            subStatTitlePanel[i].add(subStatText[i]);
        }




        subStatBagCon.anchor = GridBagConstraints.WEST;
        subStatBagCon.fill = GridBagConstraints.NONE;
        subStatBagCon.gridx = 1;

        productStat();

        JPanel panel_12 = new JPanel();
        GridBagConstraints gbc_panel_12 = new GridBagConstraints();
        gbc_panel_12.gridwidth = 2;
        gbc_panel_12.fill = GridBagConstraints.BOTH;
        gbc_panel_12.gridx = 0;
        gbc_panel_12.gridy = 6;
        statPanel.add(panel_12, gbc_panel_12);
        panel_12.add(new ButtonType1(40, 6, 2, "수정하기"));
    }

    public void productStat() {
        for(int i = 0; i < 6; i++) {
            subStatTextPanel[i] = new JPanel();
            subStatTextPanel[i].setLayout(new GridBagLayout());
            subStatBagCon.gridy = i;
            if (i == 0 || i == 2 || i == 5) {
                subStatBagCon.insets = new Insets(0, 3, 5, 10);
            } else {
                subStatBagCon.insets = new Insets(0, 0, 5, 10);
            }
            statPanel.add(subStatTextPanel[i], subStatBagCon);

            if (i == 0) {
                subStatTextPanel[i].add(new ButtonType1(20, 8, 2, "이미지 변경"));
            }
            if (i == 1) {
                productstat[0] = new TextAreaType1(17, 60, 1, Setup.selectProduct[2], 35);
                subStatTextPanel[i].add(productstat[0]);
            }
            if (i == 2) {
                subStatTextPanel[i].add(new ComboBoxType1(items, 130, Setup.selectProduct[0]));
            }
            if (i == 3) {
                productstat[1] = new TextAreaType1(17, 40, 1, Setup.selectProduct[3], 10);
                productstat[1].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char caracter = e.getKeyChar();
                        if (((caracter < '0') || (caracter > '9'))
                                && (caracter != '\b')) {
                            e.consume();
                        }
                    }
                });
                subStatTextPanel[i].add(productstat[1]);
            }
            if (i == 4) {
                productstat[2] = new TextAreaType1(17, 40, 1, Setup.selectProduct[5], 10);
                productstat[2].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char caracter = e.getKeyChar();
                        if (((caracter < '0') || (caracter > '9'))
                                && (caracter != '\b')) {
                            e.consume();
                        }
                    }
                });
                subStatTextPanel[i].add(productstat[2]);
            }
            if (i == 5) { subStatTextPanel[i].add(new ComboBoxType1(stat, 130, Setup.selectProduct[4])); }
        }
    }
}

