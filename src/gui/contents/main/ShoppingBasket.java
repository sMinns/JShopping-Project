package gui.contents.main;

import gui.common.Frame;
import gui.menu.CustomerMenu;
import gui.menu.SellerMenu;
import custom.ButtonType1;
import custom.CheckBoxType1;
import custom.CountBox;
import database.LoginDB;
import database.ShoppingBasketDB;
import system.Setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class ShoppingBasket extends JPanel implements ActionListener, MouseListener {
	private List<List<String>> shoppingBasketList;
	private int productCount;
	private JPanel[] productPanel;
	private JPanel[] sellerPanel;
	private JLabel[] sellerNameLabels;
	private JLabel[] productImage;
	private JPanel[] productDetail;
	private JLabel[] productName;
	private JLabel[] productPrice;
	private JLabel orderPrice;
	private CheckBoxType1[] productCheckBox;
	private CheckBoxType1 selectAll;
	private ButtonType1 selectDelete;
	private CountBox[] productCountBox;
	private ButtonType1[] productOrderButton;
	private ButtonType1 order;
	private ButtonType1 shopping;
	private int priceSum;

	public ShoppingBasket() {
		shoppingBasketList = ShoppingBasketDB.shoppingBasketList(Setup.CustomerNum);
		int count = 0;
		int y_axis = 0;
		priceSum = 0;
		productCount = shoppingBasketList.size();

		productPanel = new JPanel[productCount];
		sellerPanel = new JPanel[productCount];
		sellerNameLabels = new JLabel[productCount];
		productImage = new JLabel[productCount];
		productDetail = new JPanel[productCount];
		productName = new JLabel[productCount];
		productPrice = new JLabel[productCount];
		productCheckBox = new CheckBoxType1[productCount];
		productCountBox = new CountBox[productCount];
		productOrderButton = new ButtonType1[productCount];

		//각 패널에 사용할 레이아웃 설정
		GridBagLayout mainPanelLayout = createGBL(new int[]{986, 0}, new int[] {55, 560, 70});
		GridBagLayout productPanelLayout = createGBL(new int[]{50, 120, 550, 100, 50}, new int[] {120, 0});
		GridBagLayout bottomPanelLayout = createGBL(new int[]{493, 493}, new int[] {70, 0});
		GridBagLayout topPanelLayout = createGBL(new int[]{493, 493}, new int[] {55, 0});
		GridBagLayout productDetailLayout = createGBL(new int[]{550, 0}, new int[] {30, 30, 30});

		Setup.changeInsets(0, 0, 0, 5);
		setLayout(mainPanelLayout);
		// 각 패널의 레이아웃에 사용할 Constraints 설정
		GridBagConstraints gbc_topPanel = createGBC(0, 0, new int[]{0, 0, 5, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints topPanelSelectAll = createGBC(0, 0, new int[]{0, 80, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.WEST);
		GridBagConstraints topPanelSelectDelete = createGBC(1, 0, new int[]{3, 0, 0, 98}, GridBagConstraints.NONE, GridBagConstraints.EAST);

		GridBagConstraints gbc_bottomPanel = createGBC(0, 2, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints bottomPanelPrice = createGBC(0, 0, new int[]{0, 0, 0, 10}, GridBagConstraints.NONE, GridBagConstraints.EAST);
		GridBagConstraints bottomButtonBagcon = createGBC(1, 0, new int[]{4, 0, 0, 0}, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);

		GridBagConstraints gbc_middlePanel = createGBC(0, 1, new int[]{0, 0, 5, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelName = createGBC(0, 0, new int[]{10, 0, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelPrice = createGBC(0, 1, new int[]{0, 0, 5, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelCountBox = createGBC(0, 2, new int[]{0, 0, 10, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelCheckBox = createGBC(0, 0, new int[]{0, 3, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.CENTER);
		GridBagConstraints productPanelImage = createGBC(1, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelDetail = createGBC(2, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelButton = createGBC(3, 0, new int[]{3, 0, 0, 0}, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(topPanelLayout);
		topPanel.setBackground(Setup.white);
		add(topPanel, gbc_topPanel);
		
		selectAll = new CheckBoxType1("전체선택", new Font(Setup.font, Font.BOLD, 16));
		selectAll.addActionListener(this);
		selectAll.setSelected(true);
		topPanel.add(selectAll, topPanelSelectAll);
		
		selectDelete = new ButtonType1(20, 6, 5, "X 선택삭제", 16);
		selectDelete.addActionListener(this);
		topPanel.add(selectDelete, topPanelSelectDelete);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(bottomPanelLayout);
		bottomPanel.setBackground(Setup.white);
		add(bottomPanel, gbc_bottomPanel);

		orderPrice = new JLabel();
		orderPrice.setFont(new Font(Setup.font, Font.BOLD, 22));
		bottomPanel.add(orderPrice, bottomPanelPrice);

		JPanel bottomButtonPanel = new JPanel();
		bottomButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		bottomButtonPanel.setBackground(Setup.white);
		bottomPanel.add(bottomButtonPanel, bottomButtonBagcon);

		order = new ButtonType1(25, 8, 5, "주문하기", 16);
		order.addActionListener(this);
		shopping = new ButtonType1(30, 8, 5, "계속 쇼핑하기", 16);
		shopping.addActionListener(this);
		bottomButtonPanel.add(order);
		bottomButtonPanel.add(shopping);

		JPanel middlePanel = new JPanel(new BorderLayout());
		add(middlePanel, gbc_middlePanel);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(null);
		middlePanel.add(listPanel);
		
		for (count = 0; count < productCount; count++) { // 패널 사용 전 초기화
			productPanel[count] = new JPanel();
			productPanel[count].setBackground(Setup.white);
			productPanel[count].setLayout(productPanelLayout);
			productImage[count] = new JLabel("");
			productName[count] = new JLabel();
			productName[count].setFont(new Font(Setup.font, Font.BOLD, 18));
			productPrice[count] = new JLabel();
			productPrice[count].setFont(new Font(Setup.font, Font.BOLD, 18));
			productPrice[count].setForeground(Setup.magenta);
			productDetail[count] = new JPanel();
			productDetail[count].setLayout(productDetailLayout);
			productDetail[count].setBackground(Setup.white);
			productCheckBox[count] = new CheckBoxType1();
			productCheckBox[count].addActionListener(this);
			productCheckBox[count].setSelected(true);
			productCountBox[count] = new CountBox(Integer.parseInt(shoppingBasketList.get(count).get(4)));
			productCountBox[count].getMinusButton().addMouseListener(this);
			productCountBox[count].getPlusButton().addMouseListener(this);
			sellerPanel[count] = new JPanel();
			sellerPanel[count].setBackground(Setup.white);
			sellerPanel[count].setLayout(new FlowLayout(FlowLayout.LEFT, 20, 3));
			sellerNameLabels[count] = new JLabel();
			sellerNameLabels[count].setFont(new Font(Setup.font, Font.BOLD, 20));
			productOrderButton[count] = new ButtonType1(20, 5, 5, "주문하기", 15);
			productOrderButton[count].addActionListener(this);
		}
		for (count = 0; count < productCount; count++) { // productLists 배열에 있는 상품들을 모두 출력하기 위한 반복문
			if (count == 0) {
				sellerNameLabels[count].setText(String.format("판매자 : %s", shoppingBasketList.get(count).get(0)));
				sellerPanel[count].add(sellerNameLabels[count]);
				sellerPanel[count].setBounds(59, y_axis, 870, 35);
				listPanel.add(sellerPanel[count]);
				y_axis += 36;
			}
			else {
				if (!shoppingBasketList.get(count - 1).get(0).equals(shoppingBasketList.get(count).get(0))) { // 이전의 판매자와 다른 판매자일 경우 판매자 패널 생성
					y_axis += 5;
					sellerNameLabels[count].setText(String.format("판매자 : %s", shoppingBasketList.get(count).get(0)));
					sellerPanel[count].add(sellerNameLabels[count]);
					sellerPanel[count].setBounds(59, y_axis, 870, 35);
					listPanel.add(sellerPanel[count]);
					y_axis += 36;
				}
			}
			productImage[count].setIcon(Setup.imageSetSize(new ImageIcon(ShoppingBasketDB.productImageLoad(Integer.parseInt(shoppingBasketList.get(count).get(1)))), 100, 100));
			productName[count].setText(shoppingBasketList.get(count).get(2));
			priceSum += Integer.parseInt(shoppingBasketList.get(count).get(3)) * Integer.parseInt(shoppingBasketList.get(count).get(4));
			productPrice[count].setText(String.format("%s원", NumberFormat.getInstance().format(Integer.parseInt(shoppingBasketList.get(count).get(3)))));
			productPanel[count].add(productCheckBox[count], productPanelCheckBox);
			productPanel[count].add(productImage[count], productPanelImage);
			productPanel[count].add(productDetail[count], productPanelDetail);
			productDetail[count].add(productName[count], productPanelName);
			productDetail[count].add(productPrice[count], productPanelPrice);
			productDetail[count].add(productCountBox[count], productPanelCountBox);
			productPanel[count].add(productOrderButton[count], productPanelButton);
			productPanel[count].setBounds(59, y_axis, 870, 120);
			listPanel.add(productPanel[count]);
			y_axis += 121;
		}
		orderPrice.setText(String.format("총 주문금액 : %s원", NumberFormat.getInstance().format(priceSum)));

		// ScrollPane을 middlePanel에 붙이고 listPanel의 크기 지정하는 작업
		JScrollPane scrollPane = new JScrollPane();
		middlePanel.add(scrollPane);
		scrollPane.setBorder(null);
		Setup.changeScrollBar(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(listPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		listPanel.setPreferredSize(new Dimension(listPanel.getWidth(), y_axis));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(), "주문 / 결제");
		//Setup.lastClickReset();
		for (int i = 0; i < productCount; i++) {

			if (e.getSource() == productCheckBox[i]) {
				boolean isAllSelected = true;
				for (int j = 0; j < productCount; j++)
					if (!productCheckBox[j].isSelected())
						isAllSelected = false;

				if (!productCheckBox[i].isSelected()) {
					selectAll.setSelected(false);
					priceSum -= Integer.parseInt(shoppingBasketList.get(i).get(3)) * Integer.parseInt(shoppingBasketList.get(i).get(4));
				}
				else {
					priceSum += Integer.parseInt(shoppingBasketList.get(i).get(3)) * Integer.parseInt(shoppingBasketList.get(i).get(4));
				}
				if (isAllSelected)
					selectAll.setSelected(true);
				orderPrice.setText(String.format("총 주문금액 : %s원", NumberFormat.getInstance().format(priceSum)));
			}
			
			if (e.getSource() == selectDelete) {
				if (productCheckBox[i].isSelected())
					ShoppingBasketDB.deleteShoppingBasketList(Setup.CustomerNum, Integer.parseInt(shoppingBasketList.get(i).get(1)));
				Setup.changePanel(Frame.contentLayeredPanel, new ShoppingBasket());
			}
		}

		for (int count = 0; count < productCount; count++) {
			int prnum;
			if (e.getSource() == productOrderButton[count]) {
				prnum = Integer.parseInt(shoppingBasketList.get(count).get(1));
				Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(Arrays.asList(prnum)));
			}
		}

		if (e.getSource() == selectAll) {
			if (selectAll.isSelected())
				for (int count = 0; count < productCount; count++) {
					if (!productCheckBox[count].isSelected()) {
						priceSum += Integer.parseInt(shoppingBasketList.get(count).get(3)) * Integer.parseInt(shoppingBasketList.get(count).get(4));
						productCheckBox[count].setSelected(true);
					}
				}
			else {
				for (int count = 0; count < productCount; count++) {
					if (productCheckBox[count].isSelected()) {
						priceSum -= Integer.parseInt(shoppingBasketList.get(count).get(3)) * Integer.parseInt(shoppingBasketList.get(count).get(4));
						productCheckBox[count].setSelected(false);
					}
				}
			}
			orderPrice.setText(String.format("총 주문금액 : %s원", NumberFormat.getInstance().format(priceSum)));
		}
		if (e.getSource() == shopping) {
			if (LoginDB.sellerCheck(Setup.CustomerNum)) {
				//SellerMenu.sellerPanel[1].setBackground(Setup.magenta);
				SellerMenu.sellerPanel[3].setBackground(Setup.darkGray);
			}
			else 
			Setup.changePanel(Frame.contentLayeredPanel, new Search("", 0, "전체"), "상품검색");
		}
		if(e.getSource() == order) {
			if(!orderPrice.getText().equals("총 주문금액 : 0원")) {
				List<Integer> prnum = new ArrayList<>();
				for (int count = 0; count < productCount; count++) {
					if(productCheckBox[count].isSelected()) {
						prnum.add(Integer.valueOf(shoppingBasketList.get(count).get(1)));
					}
				}
				Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(prnum));
			}
		}
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
	public void mouseClicked(MouseEvent e) {
		int prnum, prcount;
		for (int i = 0; i < productCount; i++) {
			if (e.getSource() == productCountBox[i].getPlusButton()) {
				prnum = Integer.parseInt(shoppingBasketList.get(i).get(1));
				prcount = Integer.parseInt(shoppingBasketList.get(i).get(4));
				if(prcount == 10) { return; }
				ShoppingBasketDB.updateCount(prcount + 1, prnum);
				shoppingBasketList.get(i).set(4, String.valueOf(prcount+1));
				productCountBox[i].setCountLabel(prcount + 1 + "");
				priceSum += Integer.parseInt(shoppingBasketList.get(i).get(3));
				orderPrice.setText(String.format("총 주문금액 : %s원", NumberFormat.getInstance().format(priceSum)));
			}
			else if (e.getSource() == productCountBox[i].getMinusButton()) {
				prnum = Integer.parseInt(shoppingBasketList.get(i).get(1));
				prcount = Integer.parseInt(shoppingBasketList.get(i).get(4));
				if(prcount == 1) { return; }
				ShoppingBasketDB.updateCount(prcount - 1, prnum);
				shoppingBasketList.get(i).set(4, String.valueOf(prcount-1));
				productCountBox[i].setCountLabel(prcount - 1 + "");
				priceSum -= Integer.parseInt(shoppingBasketList.get(i).get(3));
				orderPrice.setText(String.format("총 주문금액 : %s원", NumberFormat.getInstance().format(priceSum)));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}