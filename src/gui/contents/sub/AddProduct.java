package gui.contents.sub;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.TextAreaType1;
import database.CategoryDB;
import event.AddProductEvent;
import gui.contents.main.ProductManagement;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddProduct extends JPanel {
    private static JLabel image;
    private static JPanel[] subInfoTitlePanel = new JPanel[6];
    private static String[] subInfoTitle = {"사진", "상품명", "카테고리", "판매가", "재고", "상태"};
    private static JLabel[] subInfoText = new JLabel[6];
    private static JPanel[] subInfoTextPanel = new JPanel[6];
    private static String[] items = CategoryDB.categoryList().toArray(new String[0]);
    private static String[] stat = {"판매대기", "판매중"};
    private static JTextArea[] productInfo = new JTextArea[3];
    private static GridBagConstraints infoBagCon;
    private static JPanel infoMainPanel;
    private JComboBox category, productStat;
    private JButton addButton, imageButton;
    private Font font = new Font(Setup.font, Font.BOLD, 14);
    private AddProductEvent addProductEvent;
    private String text;
    public AddProduct(String text) {
        this.text = text;
        addProductEvent = new AddProductEvent(this);
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
                    new ImageIcon(ProductManagement.class.getResource("/images/nullimage.png")),260,260));;
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
                infoMainPanel.add(subInfoTitlePanel[i], AddProduct.infoBagCon);
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
            addButton = new ButtonType1(40, 6, 2, "등록하기", 16);
            addButton.addActionListener(addProductEvent);
            buttonPanel.add(addButton);

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
                imageButton = new ButtonType1(20, 8, 2, "이미지 등록", 16);
                imageButton.addActionListener(addProductEvent);
                subInfoTextPanel[i].add(imageButton);
            }
            if (i == 1) {
                productInfo[0] = new TextAreaType1(17, 60, 1, "", 35);
                subInfoTextPanel[i].add(productInfo[0]);
            }
            if (i == 2) {
                category = new ComboBoxType1(items, 130, "패션의류");
                subInfoTextPanel[i].add(category);
            }
            if (i == 3) {
                productInfo[1] = new TextAreaType1(17, 40, 1, "", 10);
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
                productInfo[2] = new TextAreaType1(17, 40, 1, "", 10);
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
            productStat = new ComboBoxType1(stat, 130, "판매대기");
            if (i == 5) { subInfoTextPanel[i].add(productStat); }
        }
    }

    public String getProductName() {
        return productInfo[0].getText();
    }

    public void focusProductName() {
        productInfo[0].requestFocus();
    }

    public String getProductPrice() {
        return productInfo[1].getText();
    }

    public void focusProductPrice() {
        productInfo[1].requestFocus();
    }

    public String getProductStock() {
        return productInfo[2].getText();
    }

    public void focusProductStock() {
        productInfo[2].requestFocus();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public String getCategory() {
        return (String) category.getSelectedItem();
    }

    public String getProductStat() {
        return (String) productStat.getSelectedItem();
    }

    public JButton getImageButton() {
        return imageButton;
    }

    public void setImage(String file) {
        image.setIcon(Setup.imageSetSize(
                new ImageIcon(file),260,260));
    }

    public void setImageStroke(int thickness) {
        image.setBorder(BorderFactory.createLineBorder(Setup.magenta, thickness));
    }

    public String getText() {
        return text;
    }
}

