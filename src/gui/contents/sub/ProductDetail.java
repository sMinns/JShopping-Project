package gui.contents.sub;

import custom.ButtonType1;
import custom.ButtonType4;
import database.SubProductDetailDB;
import system.Setup;
import gui.common.Frame;
import gui.contents.main.OrderPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class ProductDetail extends JPanel implements ActionListener {
    private ButtonType1 addToBasketButton, buyButton;
    private ButtonType4 reviewButton;
    private List<List<String>> reviewList;
    private List<String> str;
    private JLayeredPane layeredPanel;
    private JPanel selectPanel;
    private JLabel reviewCustomerLabel, reviewInfoStarLabel, reviewInfoDateLabel;
    private JTextArea reviewContentText;
    private String reviewString;
    private String reviewStar = "";
    private String productStar = "";
    private int reviewStarCount;
    private int reviewCount;

    public ProductDetail(List<String> str, JLayeredPane layeredPanel, JPanel selectPanel) {
        this.str = str;
        this.layeredPanel = layeredPanel;
        this.selectPanel = selectPanel;
        reviewCustomerLabel = new JLabel();
        reviewInfoStarLabel = new JLabel();
        reviewInfoDateLabel = new JLabel();
        reviewContentText = new JTextArea();

        reviewList = SubProductDetailDB.reviewListLoad(Integer.parseInt(str.get(0)));
        reviewCount = reviewList.size();

        GridBagLayout detailLayout = new GridBagLayout();
        detailLayout.columnWidths = new int[]{0, 0};
        detailLayout.rowHeights = new int[]{245, 185, 0};
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
        image.setIcon(Setup.imageSetSize(new ImageIcon(SubProductDetailDB.productImageLoad(Integer.parseInt(str.get(0)))), 240, 240));
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
        productName.setText(str.get(1));
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

        JLabel productStarLabel = new JLabel();
        productStarLabel.setFont(new Font(Setup.font, Font.BOLD, 18));
        productStarLabel.setForeground(Setup.starYellow);
        
        if (reviewList.isEmpty()) {
            productStar = "☆☆☆☆☆";
        }
        else {
            int starSum = 0;
            for (int i = 0; i < reviewCount; i++)
                starSum += Integer.parseInt(reviewList.get(i).get(3));
            starSum = starSum / reviewCount;
    
            for (int i = 1; i <= 5; i++) {
                if (i <= starSum)
                    productStar += "★";
                else
                    productStar += "☆";
            }
        }
        productStarLabel.setText(productStar);
        starPanel.add(productStarLabel);

        //Product Category
        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        categoryPanel.setOpaque(false);
        productBagCon.gridy = 2;
        productInfoPanel.add(categoryPanel, productBagCon);

        JLabel cate = new JLabel(str.get(2));
        cate.setFont(new Font(Setup.font, Font.PLAIN, 15));
        categoryPanel.add(cate);


        //Product Date
        JPanel productdatePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        productdatePanel.setOpaque(false);
        productBagCon.gridy = 3;
        productInfoPanel.add(productdatePanel, productBagCon);

        JLabel date = new JLabel(String.format("등록일 : %s", str.get(3).replace('-', '.')));
        date.setFont(new Font(Setup.font, Font.PLAIN, 15));
        productdatePanel.add(date);

        //Product Price
        JPanel productPricePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        productPricePanel.setOpaque(false);
        productBagCon.gridy = 4;
        productInfoPanel.add(productPricePanel, productBagCon);

        JLabel price = new JLabel(String.format("%s원", NumberFormat.getInstance().format(Integer.parseInt(str.get(4)))));
        price.setFont(new Font(Setup.font, Font.BOLD, 18));
        price.setForeground(Setup.magenta);
        productPricePanel.add(price);


        //Product Button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        productBagCon.insets = new Insets(0, 0, 0, 0);
        productBagCon.gridy = 5;
        productInfoPanel.add(buttonPanel, productBagCon);

        if (Setup.CustomerNum != 0) { // 로그인이 되어 있는 경우에만 버튼 표시
            buttonPanel.add(addToBasketButton = new ButtonType1(18, 5, 2, "장바구니 담기", 15));
            buttonPanel.add(buyButton = new ButtonType1(34, 5, 2, "바로 구매", 15));
            addToBasketButton.addActionListener(this);
            buyButton.addActionListener(this);
        }

        JPanel reviewPanel = new JPanel();
        reviewPanel.setBackground(Setup.bgLightGray);
        GridBagConstraints reviewBagCon = new GridBagConstraints();
        reviewBagCon.fill = GridBagConstraints.BOTH;
        reviewBagCon.insets = new Insets(0, 0, 1, 0);
        reviewBagCon.gridx = 0;
        reviewBagCon.gridy = 2;
        this.add(reviewPanel, reviewBagCon);

        if (reviewList.isEmpty()) {
            GridBagLayout reviewLayout = new GridBagLayout();
            reviewLayout.columnWidths = new int[]{0, 0};
            reviewLayout.rowHeights = new int[]{45, 140};
            reviewLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            reviewLayout.rowWeights = new double[]{0.0, 1.0};
            reviewPanel.setLayout(reviewLayout);  
        }
        else {
            GridBagLayout reviewLayout = new GridBagLayout();
            reviewLayout.columnWidths = new int[]{0, 0};
            reviewLayout.rowHeights = new int[]{45, 110, 30, 0};
            reviewLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            reviewLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
            reviewPanel.setLayout(reviewLayout);  
        }

        JLabel reviewTitle1 = new JLabel(" 상품평");
        reviewTitle1.setFont(new Font(Setup.font, Font.BOLD, 16));
        JLabel reviewTitle2 = new JLabel("  상품을 구매하신 분들이 작성하신 상품평입니다.");
        reviewTitle2.setFont(new Font(Setup.font, Font.BOLD, 11));
        reviewTitle2.setForeground(Setup.Gray);
        JPanel reviewTitlePanel = new JPanel();
        reviewTitlePanel.setLayout(new BoxLayout(reviewTitlePanel, BoxLayout.Y_AXIS));
        reviewTitlePanel.setBackground(Setup.white);
        reviewBagCon.gridy = 0;
        reviewPanel.add(reviewTitlePanel, reviewBagCon);
        reviewTitlePanel.add(reviewTitle1);
        reviewTitlePanel.add(reviewTitle2);

        JPanel reviewPostPanel = new JPanel();
        reviewPostPanel.setBackground(Setup.white);
        reviewBagCon.gridy = 1;
        reviewPanel.add(reviewPostPanel, reviewBagCon);

        if (reviewList.isEmpty()) {
            GridBagLayout reviewDetailLayout = new GridBagLayout();
            reviewDetailLayout.columnWidths = new int[]{280};
            reviewDetailLayout.rowHeights = new int[]{110};
            reviewPostPanel.setLayout(reviewDetailLayout);

            GridBagConstraints noReview = new GridBagConstraints();
            noReview.fill = GridBagConstraints.VERTICAL;
            noReview.gridy = 0;

            JLabel noReviewLabel = new JLabel("아직 상품평이 작성되지 않은 상품입니다.");
            noReviewLabel.setFont(new Font(Setup.font, Font.BOLD, 13));
            noReviewLabel.setForeground(Setup.Gray);
            reviewPostPanel.add(noReviewLabel, noReview);
        }
        else {
            GridBagLayout reviewDetailLayout = new GridBagLayout();
            reviewDetailLayout.columnWidths = new int[]{280};
            reviewDetailLayout.rowHeights = new int[]{15, 25, 70};
            reviewPostPanel.setLayout(reviewDetailLayout);
    
            JPanel reviewCustomerPanel = new JPanel();
            reviewCustomerPanel.setOpaque(false);
    
            GridBagConstraints reviewCustomer = new GridBagConstraints();
            reviewCustomer.fill = GridBagConstraints.NONE;
            reviewCustomer.anchor = GridBagConstraints.WEST;
            reviewCustomer.insets = new Insets(0, 0, 0, 0);
            reviewCustomer.gridy = 0;
            reviewPostPanel.add(reviewCustomerPanel, reviewCustomer);
            reviewCustomerLabel.setText(String.format("%s 님", reviewList.get(0).get(6)));
            reviewCustomerLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
            reviewCustomerPanel.add(reviewCustomerLabel);
    
            JPanel reviewInfoPanel = new JPanel();
            reviewInfoPanel.setOpaque(false);
    
            GridBagConstraints reviewInfo = new GridBagConstraints();
            reviewInfo.fill = GridBagConstraints.NONE;
            reviewInfo.anchor = GridBagConstraints.WEST;
            reviewInfo.insets = new Insets(0, 0, 0, 0);
            reviewInfo.gridy = 1;
            reviewPostPanel.add(reviewInfoPanel, reviewInfo);
            reviewStarCount = Integer.parseInt(reviewList.get(0).get(3));
            for (int i = 1; i <= 5; i++) {
                if (i <= reviewStarCount)
                    reviewStar += "★";
                else
                    reviewStar += "☆";
            }
            reviewInfoStarLabel.setFont(new Font(Setup.font, Font.BOLD, 16));
            reviewInfoDateLabel.setFont(new Font(Setup.font, Font.BOLD, 12));
            reviewInfoStarLabel.setText(String.format("%s ", reviewStar));
            reviewInfoStarLabel.setForeground(Setup.starYellow);
            reviewInfoDateLabel.setText(String.format("%s", reviewList.get(0).get(2)));
            reviewInfoPanel.add(reviewInfoStarLabel);
            reviewInfoPanel.add(reviewInfoDateLabel);
            
            JPanel reviewContentPanel = new JPanel();
            reviewContentPanel.setLayout(new BorderLayout());
            reviewInfoPanel.setOpaque(false);
    
            JTextArea reviewContentText = new JTextArea();
            
            reviewString = reviewList.get(0).get(1);
            if (reviewString.length() >= 100) {
                reviewString = reviewString.substring(0, 100);
                reviewString += "...";
            }
            reviewContentText.setFont(new Font(Setup.font, Font.PLAIN, 12));
            reviewContentText.setText(reviewString);
            reviewContentText.setLineWrap(true);
            reviewContentText.setEditable(false);
            reviewContentText.setBackground(Setup.white);
    
            GridBagConstraints reviewContent = new GridBagConstraints();
            reviewContent.fill = GridBagConstraints.BOTH;
            reviewContent.anchor = GridBagConstraints.CENTER;
            reviewContent.insets = new Insets(0, 5, 0, 5);
            reviewContent.gridy = 2;
            reviewPostPanel.add(reviewContentPanel, reviewContent);
            reviewContentPanel.add(reviewContentText);
            
    
            JPanel reviewButtonPanel = new JPanel();
            reviewButtonPanel.setLayout(new BorderLayout());
            reviewButtonPanel.setBackground(Setup.white);
            reviewBagCon.insets = new Insets(0, 0, 0, 0);
            reviewBagCon.gridy = 2;
            reviewPanel.add(reviewButtonPanel, reviewBagCon);
            reviewButton = new ButtonType4(0, 0, 0, "상품평 전체 보기", 12);
            reviewButton.addActionListener(this);
            reviewButtonPanel.add(reviewButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToBasketButton) {
            SubProductDetailDB.addToShoppingBasket(Integer.parseInt(str.get(0)));
            selectPanel.setBorder(null);
            Setup.changePanel(layeredPanel, new SubShoppingBasket(Setup.CustomerNum, layeredPanel));
        }
        if (e.getSource() == reviewButton)
            Setup.changePanel(layeredPanel, new Review(reviewList, str, layeredPanel));
        if (e.getSource() == buyButton) {
            int prnum = Integer.parseInt(str.get(0));
            SubProductDetailDB.addToShoppingBasket(prnum);
            Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(Arrays.asList(prnum)));
        }
    }
}
