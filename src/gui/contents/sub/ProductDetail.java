package gui.contents.sub;

import custom.ButtonType1;
import gui.contents.main.ProductManagement;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class ProductDetail extends JPanel {
    public ProductDetail() {
        GridBagLayout detailLayout = new GridBagLayout();
        detailLayout.columnWidths = new int[]{0, 0};
        detailLayout.rowHeights = new int[]{275, 185, 0};
        detailLayout.columnWeights = new double[]{1.0};
        detailLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
        this.setLayout(detailLayout);

        //image
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        imagePanel.setBackground(Setup.white);
        GridBagConstraints productBagCon = new GridBagConstraints();
        productBagCon.fill = GridBagConstraints.BOTH;
        productBagCon.gridx = 0;
        productBagCon.gridy = 0;
        this.add(imagePanel, productBagCon);

        JLabel image = new JLabel();
        image.setIcon(Setup.imageSetSize(
                new ImageIcon(ProductManagement.class.getResource("/images/nullimage.png")),260,260));
        imagePanel.add(image);

        //Info Panel
        JPanel productInfoPanel = new JPanel();
        productInfoPanel.setBackground(Setup.white);
        productBagCon.gridy = 1;
        this.add(productInfoPanel, productBagCon);

        GridBagLayout productInfoLayout = new GridBagLayout();
        productInfoLayout.columnWidths = new int[]{0, 0};
        productInfoLayout.rowHeights = new int[]{45, 25, 25, 25, 30, 35};
        productInfoLayout.columnWeights = new double[]{1.0};
        productInfoLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        productInfoPanel.setLayout(productInfoLayout);

        //Product Name
        JPanel productNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        productNamePanel.setOpaque(false);
        productBagCon.gridy = 0;
        productInfoPanel.add(productNamePanel, productBagCon);

        JTextArea productName = new JTextArea(1, 15);
        productName.setEditable(false);
        productName.setText("상품명3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화");
        productName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        productName.setOpaque(false);
        productName.setLineWrap(true);
        productName.setFont(new Font(Setup.font, Font.BOLD, 18));
        productNamePanel.add(productName);

        //Product Star
        JPanel starPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        starPanel.setOpaque(false);
        productBagCon.insets = new Insets(0, 0, 0, 18);
        productBagCon.gridy = 1;
        productInfoPanel.add(starPanel, productBagCon);

        JLabel star = new JLabel("★★★★★");
        star.setFont(new Font(Setup.font, Font.BOLD, 18));
        starPanel.add(star);

        //Product Category
        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        categoryPanel.setOpaque(false);
        productBagCon.gridy = 2;
        productInfoPanel.add(categoryPanel, productBagCon);

        JLabel cate = new JLabel("신발");
        cate.setFont(new Font(Setup.font, Font.PLAIN, 15));
        categoryPanel.add(cate);


        //Product Date
        JPanel productdatePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        productdatePanel.setOpaque(false);
        productBagCon.gridy = 3;
        productInfoPanel.add(productdatePanel, productBagCon);

        JLabel date = new JLabel("등록일 : 2022. 06. 25");
        date.setFont(new Font(Setup.font, Font.PLAIN, 15));
        productdatePanel.add(date);

        //Product Price
        JPanel productPricePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        productPricePanel.setOpaque(false);
        productBagCon.gridy = 4;
        productInfoPanel.add(productPricePanel, productBagCon);

        JLabel price = new JLabel("29, 800원");
        price.setFont(new Font(Setup.font, Font.BOLD, 18));
        productPricePanel.add(price);


        //Product Button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        productBagCon.insets = new Insets(0, 0, 0, 0);
        productBagCon.gridy = 5;
        productInfoPanel.add(buttonPanel, productBagCon);

        buttonPanel.add(new ButtonType1(12, 6, 2, "장바구니 담기", 16));
        buttonPanel.add(new ButtonType1(28, 6, 2, "바로 구매", 16));


        JPanel reviewPanel = new JPanel();
        reviewPanel.setBackground(Setup.bgLightGray);
        GridBagConstraints reviewBagCon = new GridBagConstraints();
        reviewBagCon.fill = GridBagConstraints.BOTH;
        reviewBagCon.insets = new Insets(0, 0, 1, 0);
        reviewBagCon.gridx = 0;
        reviewBagCon.gridy = 2;
        this.add(reviewPanel, reviewBagCon);

        GridBagLayout reviewLayout = new GridBagLayout();
        reviewLayout.columnWidths = new int[]{0, 0};
        reviewLayout.rowHeights = new int[]{50, 100, 35, 0};
        reviewLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        reviewLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        reviewPanel.setLayout(reviewLayout);

        JPanel reviewTitlePanel = new JPanel();
        reviewTitlePanel.setBackground(Setup.white);
        reviewBagCon.gridy = 0;
        reviewPanel.add(reviewTitlePanel, reviewBagCon);

        JPanel reviewPostPanel = new JPanel();
        reviewPostPanel.setBackground(Setup.white);
        reviewBagCon.gridy = 1;
        reviewPanel.add(reviewPostPanel, reviewBagCon);

        JPanel reviewButtonPanel = new JPanel();
        reviewButtonPanel.setBackground(Setup.white);
        reviewBagCon.insets = new Insets(0, 0, 0, 0);
        reviewBagCon.gridy = 2;
        reviewPanel.add(reviewButtonPanel, reviewBagCon);
    }
}
