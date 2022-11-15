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
    private static JPanel[] subInfoTitlePanel = new JPanel[6];
    private static String[] subInfoTitle = {"사진", "상품명", "카테고리", "판매가", "재고", "상태"};
    private static JLabel[] subInfoText = new JLabel[6];
    private static JPanel[] subInfoTextPanel = new JPanel[6];
    private static String[] items = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
            "가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품" };
    private static String[] stat = {"판매대기", "판매중"};
    private static JTextArea[] productInfo = new JTextArea[3];
    private static GridBagConstraints infoBagCon;
    private static JPanel infoMainPanel;
    Font font = new Font(Setup.font, Font.BOLD, 14);
    public ChangeInformation() {
        //ChangeInformation Layout
            GridBagLayout detailLayout = new GridBagLayout();
            detailLayout.columnWidths = new int[]{0, 0};
            detailLayout.rowHeights = new int[]{260, 0, 0};
            detailLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            detailLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            this.setLayout(detailLayout);

        //Image
            JPanel imagePanel = new JPanel();
            infoBagCon = new GridBagConstraints();
            infoBagCon.insets = new Insets(0, 0, 5, 0);
            infoBagCon.fill = GridBagConstraints.BOTH;
            infoBagCon.gridx = 0;
            infoBagCon.gridy = 0;
            this.add(imagePanel, infoBagCon);

            image = new JLabel();
            image.setIcon(Setup.imageSetSize(
                    new ImageIcon(ProductManagement.class.getResource(Setup.selectProduct[1])),260,260));;
            imagePanel.add(image);

        //InfoMainPanel
            infoMainPanel = new JPanel();
            infoBagCon.gridy = 1;
            this.add(infoMainPanel, infoBagCon);

            GridBagLayout infoLayout = new GridBagLayout();
            infoLayout.columnWidths = new int[]{70, 0, 0};
            infoLayout.rowHeights = new int[]{50, 75, 50, 50, 50, 50, 0, 0};
            infoLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            infoLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
            infoMainPanel.setLayout(infoLayout);


        //subInfoTitle for loop
            infoBagCon.insets = new Insets(0, 10, 5, 5);
            for(int i = 0; i < 6; i++) {
                subInfoTitlePanel[i] = new JPanel();
                subInfoTitlePanel[i].setLayout(new CardLayout());
                infoBagCon.gridy = i;
                infoMainPanel.add(subInfoTitlePanel[i], ChangeInformation.infoBagCon);
                subInfoText[i] = new JLabel(subInfoTitle[i]);
                subInfoText[i].setFont(font);
                subInfoTitlePanel[i].add(subInfoText[i]);
            }

        //Button
            JPanel buttonPanel = new JPanel();
            infoBagCon.gridwidth = 2;
            infoBagCon.gridx = 0;
            infoBagCon.gridy = 6;
            infoMainPanel.add(buttonPanel, infoBagCon);
            buttonPanel.add(new ButtonType1(40, 6, 2, "수정하기", 16));

        //Info
            infoBagCon.anchor = GridBagConstraints.WEST;
            infoBagCon.fill = GridBagConstraints.NONE;
            infoBagCon.gridx = 1;
            productStat();


    }

    public void productStat() {
        for(int i = 0; i < 6; i++) {
            subInfoTextPanel[i] = new JPanel();
            subInfoTextPanel[i].setLayout(new GridBagLayout());
            infoBagCon.gridy = i;
            if (i == 0 || i == 2 || i == 5) {
                infoBagCon.insets = new Insets(0, 3, 5, 10);
            } else {
                infoBagCon.insets = new Insets(0, 0, 5, 10);
            }
            infoMainPanel.add(subInfoTextPanel[i], infoBagCon);

            if (i == 0) {
                subInfoTextPanel[i].add(new ButtonType1(20, 8, 2, "이미지 변경", 16));
            }
            if (i == 1) {
                productInfo[0] = new TextAreaType1(17, 60, 1, Setup.selectProduct[2], 35);
                subInfoTextPanel[i].add(productInfo[0]);
            }
            if (i == 2) {
                subInfoTextPanel[i].add(new ComboBoxType1(items, 130, Setup.selectProduct[0]));
            }
            if (i == 3) {
                productInfo[1] = new TextAreaType1(17, 40, 1, Setup.selectProduct[3], 10);
                productInfo[1].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char caracter = e.getKeyChar();
                        if (((caracter < '0') || (caracter > '9'))
                                && (caracter != '\b')) {
                            e.consume();
                        }
                    }
                });
                subInfoTextPanel[i].add(productInfo[1]);
            }
            if (i == 4) {
                productInfo[2] = new TextAreaType1(17, 40, 1, Setup.selectProduct[5], 10);
                productInfo[2].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char caracter = e.getKeyChar();
                        if (((caracter < '0') || (caracter > '9'))
                                && (caracter != '\b')) {
                            e.consume();
                        }
                    }
                });
                subInfoTextPanel[i].add(productInfo[2]);
            }
            if (i == 5) { subInfoTextPanel[i].add(new ComboBoxType1(stat, 130, Setup.selectProduct[4])); }
        }
    }
}

