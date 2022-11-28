package gui.contents.sub;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.List;
import java.awt.event.*;

import custom.ButtonType1;
import custom.CheckBoxType1;
import custom.CountBox;
import database.SubShoppingBasketDB;
import system.Setup;

public class SubShoppingBasket extends JPanel implements ActionListener {
	private int count = 0;
	private int productCount;
	private JPanel[] productPanel;
	private JLayeredPane layeredPanel;
	private CheckBoxType1[] productCheckBox;
	private JLabel[] productImage;
	private JPanel[] productDetail;
	private JLabel[] productName;
	private JLabel[] productPrice;
	private CountBox[] productCountBox;
	private ButtonType1[] productDelButton;
	private int[] productNum;

	public SubShoppingBasket() { // 로그인 상태가 아닐 시 출력될 패널
		GridBagLayout subPanelLayout = createGBL(new int[] {290}, new int[] {40, 630});
		setLayout(subPanelLayout);

		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		JPanel contentPanel = new JPanel();
		titlePanel.setBackground(Setup.white);
		contentPanel.setBackground(Setup.white);

		GridBagConstraints gbc_titlePanel = createGBC(0, 0, new int[]{0, 0, 1, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints gbc_contentPanel = createGBC(0, 1, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);

		JLabel titleName = new JLabel("장바구니");
		titleName.setFont(new Font(Setup.font, Font.BOLD, 18));
		titleName.setForeground(Setup.magenta);

		JLabel contentName = new JLabel("로그인 후 이용 가능합니다.");
		contentName.setFont(new Font(Setup.font, Font.BOLD, 16));
		
		add(titlePanel, gbc_titlePanel);
		add(contentPanel, gbc_contentPanel);
		titlePanel.add(titleName);

		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 300));
		contentPanel.add(contentName);
	}
	public SubShoppingBasket(int customerNum, JLayeredPane layeredPanel) { // 로그인 상태일 시 출력될 패널
		this.layeredPanel = layeredPanel;
		int priceSum = 0;
		int y_axis = 0;
		List<List<String>> shoppingBasketList = SubShoppingBasketDB.shoppingBasketList(customerNum);
		String splitedProductName;

		GridBagLayout gridBagLayout = createGBL(new int[] {290}, new int[] {40, 30, 550, 50});
		GridBagLayout pricePanelLayout = createGBL(new int[] {42, 103}, new int[] {50});
		GridBagLayout productLayout = createGBL(new int[] {25, 75, 190}, new int[] {81});
		GridBagLayout productDetailLayout = createGBL(new int[] {190}, new int[] {20, 20, 40});
		setLayout(gridBagLayout);

		JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel contentPanel = new JPanel();
		JPanel productListPanel = new JPanel();
		JPanel pricePanel = new JPanel(pricePanelLayout);
		JPanel resultPanel = new JPanel(new GridLayout(1, 2));
		JScrollPane scrollPane = new JScrollPane();

		titlePanel.setBackground(Setup.white);
		checkPanel.setBackground(Setup.white);
		productListPanel.setBackground(Setup.white);
		pricePanel.setBackground(Setup.white);
		resultPanel.setBackground(Setup.white);

		JLabel titleNameLabel = new JLabel("장바구니");
		titleNameLabel.setFont(new Font(Setup.font, Font.BOLD, 18));
		titleNameLabel.setForeground(Setup.magenta);

		JLabel selectAllLabel = new JLabel("전체 선택");
		selectAllLabel.setFont(new Font(Setup.font, Font.BOLD, 12));

		JLabel sumLabel = new JLabel("합계: ");
		sumLabel.setFont(new Font(Setup.font, Font.BOLD, 14));

		JLabel priceLabel = new JLabel("0원");
		priceLabel.setFont(new Font(Setup.font, Font.BOLD, 14));

		productCount = shoppingBasketList.size();
		productPanel = new JPanel[productCount];
		productCheckBox = new CheckBoxType1[productCount];
		productImage = new JLabel[productCount];
		productDetail = new JPanel[productCount];
		productName = new JLabel[productCount];
		productPrice = new JLabel[productCount];
		productCountBox = new CountBox[productCount];
		productDelButton = new ButtonType1[productCount];
		productNum = new int[productCount];
		// 사용할 패널들의 GBC 설정
		GridBagConstraints productPanelCheckBox = createGBC(0, 0, new int[]{0, 5, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelImage = createGBC(1, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelDetail = createGBC(2, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelName = createGBC(0, 0, new int[]{10, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelPrice = createGBC(0, 1, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);	
		GridBagConstraints productPanelCountBox = createGBC(0, 2, new int[]{0, 0, 10, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelDelButton = createGBC(0, 2, new int[]{0, 0, 5, 10}, GridBagConstraints.NONE, GridBagConstraints.EAST);
		// productPanel 내부의 레이블과 패널에 대한 GBC 설정
		GridBagConstraints titlePanelGBC = createGBC(0, 0, new int[]{0, 0, 1, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints checkPanelGBC = createGBC(0, 1, new int[]{0, 0, 1, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productListPanelGBC = createGBC(0, 2, new int[]{0, 0, 1, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints resultPanelGBC = createGBC(0, 3, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints sumLabelGBC = createGBC(0, 0, new int[]{0, 5, 0, 0}, GridBagConstraints.VERTICAL, GridBagConstraints.WEST);
		GridBagConstraints priceLabelGBC = createGBC(1, 0, new int[]{0, 0, 0, 10}, GridBagConstraints.VERTICAL, GridBagConstraints.EAST);

		add(titlePanel, titlePanelGBC);
		titlePanel.add(titleNameLabel);

		add(checkPanel, checkPanelGBC);
		checkPanel.add(new CheckBoxType1());
		checkPanel.add(selectAllLabel);
	
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(scrollPane);
		
		productListPanel.setLayout(null);
		add(contentPanel, productListPanelGBC);

		for (count = 0; count < productCount; count++) { //패널 및 변수 설정/초기화
			productPanel[count] = new JPanel();
			productPanel[count].setLayout(productLayout);
			productPanel[count].setBackground(Setup.white);
			productCheckBox[count] = new CheckBoxType1();
			productImage[count] = new JLabel("");
			productDetail[count] = new JPanel();
			productDetail[count].setLayout(productDetailLayout);
			productDetail[count].setOpaque(false);
			productName[count] = new JLabel();
			productName[count].setFont(new Font(Setup.font, Font.BOLD, 12));
			productPrice[count] = new JLabel();
			productPrice[count].setFont(new Font(Setup.font, Font.BOLD, 12));
			productPrice[count].setForeground(Setup.magenta);
			productCountBox[count] = new CountBox();
			productDelButton[count] = new ButtonType1(15, 4, 5, "삭 제", 10);
			productDelButton[count].addActionListener(this);
			priceSum += Integer.parseInt(shoppingBasketList.get(count).get(2)) * productCountBox[count].getCount();
		}
		for (count = 0; count < productCount; count++) {
			productNum[count] = Integer.parseInt(shoppingBasketList.get(count).get(0));
			productImage[count].setIcon(Setup.imageSetSize(new ImageIcon(SubShoppingBasketDB.productImageLoad(productNum[count])), 70, 70));
			if ((splitedProductName = shoppingBasketList.get(count).get(1)).length() >= 25)
				productName[count].setText(splitedProductName.substring(0, 24) + "...");
			else
				productName[count].setText(splitedProductName);
			productPrice[count].setText(String.format("%s원", NumberFormat.getInstance().format(Integer.parseInt(shoppingBasketList.get(count).get(2)))));
			productPanel[count].add(productCheckBox[count], productPanelCheckBox);
			productPanel[count].add(productImage[count], productPanelImage);
			productPanel[count].add(productDetail[count], productPanelDetail);
			productDetail[count].add(productName[count], productPanelName);
			productDetail[count].add(productPrice[count], productPanelPrice);
			productDetail[count].add(productCountBox[count], productPanelCountBox);
			productDetail[count].add(productDelButton[count], productPanelDelButton);
			productPanel[count].setBounds(0, y_axis, 290, 80);
			productPanel[count].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Setup.bgLightGray));
			productListPanel.add(productPanel[count]);
			y_axis += 81;
		}

		add(resultPanel, resultPanelGBC);
		resultPanel.add(pricePanel);
		pricePanel.add(sumLabel, sumLabelGBC);
		priceLabel.setText(String.format("%s원", NumberFormat.getInstance().format(priceSum)));
		pricePanel.add(priceLabel, priceLabelGBC);
		resultPanel.add(new ButtonType1(0, 0, 0, "구 매 하 기", 16));

		scrollPane.setBorder(null);
		Setup.changeScrollBar(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(productListPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		productListPanel.setPreferredSize(new Dimension(productListPanel.getWidth(), y_axis));
		scrollPane.setBorder(BorderFactory.createLineBorder(Setup.white, 1));
	}
	// GridBagConstraints를 만들기 위한 함수
	private GridBagConstraints createGBC(int gridx, int gridy, int[] insets, int fill, int anchor) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);
		gbc.fill = fill;
		gbc.anchor = anchor;
		return gbc;
	}
	// GridBagLayout를 만들기 위한 함수
	private GridBagLayout createGBL(int columnWidths[], int rowHeights[]) {
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = columnWidths;
		gbl.rowHeights = rowHeights;
		return gbl;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < count; i++)
			if (e.getSource() == productDelButton[i]) {
				if (SubShoppingBasketDB.deleteShoppingBasketList(Setup.CustomerNum, productNum[i]));
					Setup.changePanel(layeredPanel, new SubShoppingBasket(Setup.CustomerNum, layeredPanel));
		}
	}
}