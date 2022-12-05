package gui.contents.sub;

import custom.ButtonType1;
import system.Setup;
import gui.common.Frame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.List;

public class Review extends JPanel implements ActionListener {
    private String productStar = "";
    private List<String> str;
    private JLabel[] reviewCustomerLabel, reviewStarLabel, reviewDateLabel;
    private JTextArea[] reviewContentText;
    private String[] reviewString, reviewStar;
    private JPanel[] reviewPanel, reviewStarPanel;
    private JLayeredPane layeredPanel;
    private ButtonType1 backButton;
    private int reviewCount;

    public Review(List<List<String>> reviewList, List<String> str, JLayeredPane layeredPanel) {
        this.str = str;
        this.layeredPanel = layeredPanel;
        JScrollPane scrollPane = new JScrollPane();
        int y_axis = 0;

        JLabel titleLabel1, titleLabel2, productStarLabel, reviewCountLabel;
        reviewCount = reviewList.size();

        reviewCustomerLabel = new JLabel[reviewCount];
        reviewStarLabel = new JLabel[reviewCount];
        reviewDateLabel = new JLabel[reviewCount];
        reviewContentText = new JTextArea[reviewCount];
        reviewString = new String[reviewCount];
        reviewStar = new String[reviewCount];
        reviewPanel = new JPanel[reviewCount];
        reviewStarPanel = new JPanel[reviewCount];

        GridBagLayout mainPanelLayout = new GridBagLayout();
        mainPanelLayout.columnWidths = new int[]{290, 0};
        mainPanelLayout.rowHeights = new int[]{50, 50, 540, 30};
        this.setLayout(mainPanelLayout);
        this.setBackground(Setup.white);

        GridBagLayout starPanelLayout = new GridBagLayout();
        starPanelLayout.columnWidths = new int[]{200, 90};
        
        titleLabel1 = new JLabel("상품 리뷰");
        titleLabel1.setFont(new Font(Setup.font, Font.BOLD, 20));
        titleLabel2 = new JLabel("상품을 구매하신 분들이 작성하신 상품명입니다.");
        titleLabel2.setFont(new Font(Setup.font, Font.BOLD, 12));
        titleLabel2.setForeground(Setup.Gray);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Setup.white);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.add(titleLabel1);
        titlePanel.add(titleLabel2);

        GridBagConstraints titlePanelCon = new GridBagConstraints();
        titlePanelCon.insets = new Insets(5, 5, 0, 0);
        titlePanelCon.gridy = 0;
        titlePanelCon.fill = GridBagConstraints.BOTH;
        titlePanelCon.anchor = GridBagConstraints.WEST;
        this.add(titlePanel, titlePanelCon);

        JPanel productStarPanel = new JPanel();
        productStarPanel.setBackground(Setup.white);
        productStarPanel.setLayout(new BoxLayout(productStarPanel, BoxLayout.X_AXIS));
        productStarLabel = new JLabel();
        reviewCountLabel = new JLabel();
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

        productStarLabel.setText(productStar);
        productStarLabel.setFont(new Font(Setup.font, Font.BOLD, 35));
        productStarLabel.setForeground(Setup.starYellow);

        reviewCountLabel.setText(Integer.toString(reviewCount));
        reviewCountLabel.setFont(new Font(Setup.font, Font.BOLD, 35));
        productStarPanel.add(productStarLabel);
        productStarPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        productStarPanel.add(reviewCountLabel);

        GridBagConstraints productStarPanelCon = new GridBagConstraints();
        productStarPanelCon.insets = new Insets(0, 5, 1, 0);
        productStarPanelCon.gridy = 1;
        productStarPanelCon.fill = GridBagConstraints.BOTH;
        productStarPanelCon.anchor = GridBagConstraints.WEST;
        this.add(productStarPanel, productStarPanelCon);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        GridBagConstraints contentPanelCon = new GridBagConstraints();
        contentPanelCon.insets = new Insets(0, 5, 0, 0);
        contentPanelCon.gridy = 2;
        contentPanelCon.fill = GridBagConstraints.BOTH;
        contentPanelCon.anchor = GridBagConstraints.CENTER;
        this.add(contentPanel, contentPanelCon);

        JPanel reviewListPanel = new JPanel();
        reviewListPanel.setLayout(null);
        reviewListPanel.setBackground(Setup.white);

        contentPanel.add(reviewListPanel);
        contentPanel.setBackground(Setup.white);

        GridBagLayout reviewPanelLayout = new GridBagLayout();
        reviewPanelLayout.columnWidths = new int[]{290, 0};
        reviewPanelLayout.rowHeights = new int[]{10, 15, 15, 120, 10};

        for (int count = 0; count < reviewCount; count++) {
            reviewCustomerLabel[count] = new JLabel();
            reviewCustomerLabel[count].setFont(new Font(Setup.font, Font.BOLD, 15));
            reviewCustomerLabel[count].setOpaque(false);
            reviewStarPanel[count] = new JPanel();
            reviewStarPanel[count].setLayout(new BoxLayout(reviewStarPanel[count], BoxLayout.X_AXIS));
            reviewStarPanel[count].setOpaque(false);
            reviewStarLabel[count] = new JLabel();
            reviewStarLabel[count].setFont(new Font(Setup.font, Font.BOLD, 14));
            reviewStarLabel[count].setForeground(Setup.starYellow);
            reviewStarLabel[count].setOpaque(false);
            reviewDateLabel[count] = new JLabel();
            reviewDateLabel[count].setFont(new Font(Setup.font, Font.BOLD, 12));
            reviewDateLabel[count].setOpaque(false);
            reviewContentText[count] = new JTextArea();
            reviewContentText[count].setLineWrap(true);
            reviewContentText[count].setEditable(false);
            reviewContentText[count].setFont(new Font(Setup.font, Font.PLAIN, 12));
            reviewString[count] = "";
            reviewStar[count] = "";
            reviewPanel[count] = new JPanel();
            reviewPanel[count].setBackground(Setup.white);
            reviewPanel[count].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Setup.bgLightGray));
            reviewPanel[count].setLayout(reviewPanelLayout);
        }

        GridBagConstraints reviewCustomerLabelCon = new GridBagConstraints();
        reviewCustomerLabelCon.insets = new Insets(0, 0, 0, 0);
        reviewCustomerLabelCon.gridy = 1;
        reviewCustomerLabelCon.fill = GridBagConstraints.BOTH;
        reviewCustomerLabelCon.anchor = GridBagConstraints.WEST;

        GridBagConstraints reviewStarPanelCon = new GridBagConstraints();
        reviewStarPanelCon.insets = new Insets(0, 0, 0, 0);
        reviewStarPanelCon.gridy = 2;
        reviewStarPanelCon.fill = GridBagConstraints.VERTICAL;
        reviewStarPanelCon.anchor = GridBagConstraints.WEST;

        GridBagConstraints reviewContentTextCon = new GridBagConstraints();
        reviewContentTextCon.insets = new Insets(10, 0, 0, 10);
        reviewContentTextCon.gridy = 3;
        reviewContentTextCon.fill = GridBagConstraints.BOTH;
        reviewContentTextCon.anchor = GridBagConstraints.CENTER;


        for (int count = 0; count < reviewCount; count++) {
            reviewCustomerLabel[count].setText(String.format("%s 님", reviewList.get(count).get(6)));
            int reviewStarCount = Integer.parseInt(reviewList.get(count).get(3));
            for (int i = 1; i <= 5; i++) {
                if (i <= reviewStarCount)
                    reviewStar[count] += "★";
                else
                    reviewStar[count] += "☆";
            }
            reviewStarLabel[count].setText(reviewStar[count]);
            reviewDateLabel[count].setText(reviewList.get(count).get(2));
            reviewContentText[count].setText(reviewList.get(count).get(1));
            reviewPanel[count].add(reviewCustomerLabel[count], reviewCustomerLabelCon);
            reviewStarPanel[count].add(reviewStarLabel[count]);
            reviewStarPanel[count].add(Box.createRigidArea(new Dimension(10, 0)));
            reviewStarPanel[count].add(reviewDateLabel[count]);
            reviewPanel[count].add(reviewStarPanel[count], reviewStarPanelCon);
            reviewPanel[count].add(reviewContentText[count], reviewContentTextCon);
            reviewPanel[count].setBounds(0, y_axis, 290, 170);
            reviewListPanel.add(reviewPanel[count]);
            y_axis += 170;
        }
        
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new BorderLayout());
        backButton = new ButtonType1(0, 0, 0, "상품 정보로 돌아가기", 14);
        backButton.addActionListener(this);
        backButtonPanel.add(backButton);

        GridBagConstraints backButtonPanelCon = new GridBagConstraints();
        backButtonPanelCon.insets = new Insets(0, 0, 0, 0);
        backButtonPanelCon.gridy = 3;
        backButtonPanelCon.fill = GridBagConstraints.BOTH;
        backButtonPanelCon.anchor = GridBagConstraints.CENTER;
        this.add(backButtonPanel, backButtonPanelCon);

        contentPanel.add(scrollPane);
        scrollPane.setBackground(Setup.white);
        scrollPane.setBorder(null);
		Setup.changeScrollBar(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(reviewListPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		reviewListPanel.setPreferredSize(new Dimension(reviewListPanel.getWidth(), y_axis));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton)
            Setup.changePanel(layeredPanel, new ProductDetail(str, layeredPanel, null));
    }
    
}
