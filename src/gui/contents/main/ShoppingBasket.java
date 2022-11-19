package gui.contents.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import custom.ButtonType1;
import custom.CheckBoxType1;
import custom.CountBox;
import gui.common.Frame;
import system.Setup;

public class ShoppingBasket extends JPanel implements ActionListener {
	public ShoppingBasket() {
		String[][] productLists = {{"가나다라", "/images/nullimage.png", "상품 1", "29800"}, {"가나다라", "/images/nullimage.png", "상품 2", "29800"}, 
								   {"asdsadasd", "/images/nullimage.png", "상품 3", "38000"}, {"asdsadasd", "/images/nullimage.png", "상품 4", "40000"},
								   {"삼성전자", "/images/nullimage.png", "상품 5", "2590000"}, {"ABC마트", "/images/nullimage.png", "상품 6", "1200000"}};
		int count = 0;
		int y_axis = 0;
		int productNum = productLists.length;

		JPanel[] productPanel = new JPanel[productNum];
		JPanel[] sellerPanel = new JPanel[productNum];
		JLabel[] sellerNameLabels = new JLabel[productNum];
		JLabel[] productImage = new JLabel[productNum];
		JPanel[] productDetail = new JPanel[productNum];
		JLabel[] productName = new JLabel[productNum];
		JLabel[] productPrice = new JLabel[productNum];

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
		GridBagConstraints topPanelSelectDelete = createGBC(1, 0, new int[]{3, 0, 0, 80}, GridBagConstraints.NONE, GridBagConstraints.EAST);

		GridBagConstraints gbc_bottomPanel = createGBC(0, 2, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints bottomPanelPrice = createGBC(0, 0, new int[]{0, 0, 0, 10}, GridBagConstraints.NONE, GridBagConstraints.EAST);
		GridBagConstraints bottomButtonBagcon = createGBC(1, 0, new int[]{4, 0, 0, 0}, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);

		GridBagConstraints gbc_middlePanel = createGBC(0, 1, new int[]{0, 0, 5, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelName = createGBC(0, 0, new int[]{10, 0, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelPrice = createGBC(0, 1, new int[]{0, 0, 5, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelCountBox = createGBC(0, 2, new int[]{0, 0, 10, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelCheckBox = createGBC(0, 0, new int[]{0, 3, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.CENTER);
		GridBagConstraints productPanelImage = createGBC(1, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelInfo = createGBC(2, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelButton = createGBC(3, 0, new int[]{3, 0, 0, 0}, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(topPanelLayout);
		topPanel.setBackground(Setup.white);
		add(topPanel, gbc_topPanel);
		
		CheckBoxType1 selectAll = new CheckBoxType1("전체선택", new Font(Setup.font, Font.BOLD, 16));
		topPanel.add(selectAll, topPanelSelectAll);
		
		ButtonType1 selectDelete = new ButtonType1(20, 6, 5, "X 선택삭제", 16);
		topPanel.add(selectDelete, topPanelSelectDelete);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(bottomPanelLayout);
		bottomPanel.setBackground(Setup.white);
		add(bottomPanel, gbc_bottomPanel);

		JLabel orderPrice = new JLabel();
		orderPrice.setText(String.format("총 주문금액 : %s원", NumberFormat.getInstance().format(123456)));
		orderPrice.setFont(new Font(Setup.font, Font.BOLD, 22));
		bottomPanel.add(orderPrice, bottomPanelPrice);

		JPanel bottomButtonPanel = new JPanel();
		bottomButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		bottomButtonPanel.setBackground(Setup.white);
		bottomPanel.add(bottomButtonPanel, bottomButtonBagcon);

		ButtonType1 order = new ButtonType1(25, 8, 5, "주문하기", 16);
		ButtonType1 shopping = new ButtonType1(30, 8, 5, "계속 쇼핑하기", 16);
		bottomButtonPanel.add(order);
		bottomButtonPanel.add(shopping);

		JPanel middlePanel = new JPanel(new BorderLayout());
		add(middlePanel, gbc_middlePanel);
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(null);
		middlePanel.add(listPanel);
		
		while (count < productNum) { // 패널 사용 전 초기화
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
			sellerPanel[count] = new JPanel();
			sellerPanel[count].setBackground(Setup.white);
			sellerPanel[count].setLayout(new FlowLayout(FlowLayout.LEFT, 20, 3));
			sellerNameLabels[count] = new JLabel();
			sellerNameLabels[count].setFont(new Font(Setup.font, Font.BOLD, 20));
			count++;
		}
		count = 0;
		while (count < productNum) { // productLists 배열에 있는 상품들을 모두 출력하기 위한 반복문
			if (count == 0) {
				sellerNameLabels[count].setText(String.format("판매자 : %s", productLists[count][0]));
				sellerPanel[count].add(sellerNameLabels[count]);
				sellerPanel[count].setBounds(59, y_axis, 870, 35);
				listPanel.add(sellerPanel[count]);
				y_axis += 36;
			}
			else {
				if (!productLists[count - 1][0].equals(productLists[count][0])) { // 이전의 판매자와 다른 판매자일 경우 판매자 패널 생성
					y_axis += 5;
					sellerNameLabels[count].setText(String.format("판매자 : %s", productLists[count][0]));
					sellerPanel[count].add(sellerNameLabels[count]);
					sellerPanel[count].setBounds(59, y_axis, 870, 35);
					listPanel.add(sellerPanel[count]);
					y_axis += 36;
				}
			}
			productImage[count].setIcon(Setup.imageSetSize(new ImageIcon(ShoppingBasket.class.getResource(productLists[count][1])), 100, 100));
			productName[count].setText(productLists[count][2]);
			productPrice[count].setText(String.format("%s원", NumberFormat.getInstance().format(Integer.parseInt(productLists[count][3]))));
			productPanel[count].add(new CheckBoxType1(), productPanelCheckBox);
			productPanel[count].add(productImage[count], productPanelImage);
			productPanel[count].add(productDetail[count], productPanelInfo);
			productDetail[count].add(productName[count], productPanelName);
			productDetail[count].add(productPrice[count], productPanelPrice);
			productDetail[count].add(new CountBox(), productPanelCountBox);
			productPanel[count].add(new ButtonType1(20, 5, 5, "주문하기", 15), productPanelButton);
			productPanel[count].setBounds(59, y_axis, 870, 120);
			listPanel.add(productPanel[count]);
			y_axis += 121;
			count++;
		}

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
		Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(), "주문 / 결제");
		Setup.lastClickReset();
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
}