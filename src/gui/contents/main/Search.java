package gui.contents.main;

import custom.SearchBar;
import gui.common.Frame;
import gui.contents.sub.ProductDetail;
import gui.contents.sub.SubShoppingBasket;
import system.Setup;
import database.SearchDB;
import database.CategoryDB;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.text.NumberFormat;

public class Search extends JPanel implements ActionListener, MouseListener {
	private List<List<String>> productList;
    private List<String> items = CategoryDB.categoryList();
	private String[] itemsArray = items.toArray(new String[items.size()]);
	private int[] productNum;
	private int productCount;
	private int orderType = 0;
	private JPanel[] productPanel;
	private JPanel[] productDetail;
	private JLabel[] productImage;
	private JLabel[] productName;
	private JLabel[] productCategory;
	private JLabel[] productRegDate;
	private JLabel[] productPrice;
	private JLabel[] sortOptions;
	private JLayeredPane layeredPanel;
	private String text = "";
	private SearchBar search;
	JPanel selectPanel = null;

	public Search(String text, int orderType) {
		this.text = text;
		this.orderType = orderType;
		search = new SearchBar(45, 50, itemsArray, "검색하고 싶은 상품을 입력하세요.", "전체", 15);
		productList = SearchDB.productList(text, orderType);
		productCount = productList.size();
		int count = 0;
		int y_axis = 0;

		productNum = new int[productCount];
		productPanel = new JPanel[productCount];
		productDetail = new JPanel[productCount];
		productImage = new JLabel[productCount];
		productName = new JLabel[productCount];
		productCategory = new JLabel[productCount];
		productRegDate = new JLabel[productCount];
		productPrice = new JLabel[productCount];

		// 사용할 패널의 레이아웃 생성
		GridBagLayout mainPanelLayout = createGBL(new int[] {675, 290}, new int[] {670, 0});
		GridBagLayout topPanelLayout = createGBL(new int[] {675, 0}, new int[] {50, 40, 580});
		GridBagLayout resultPanelLayout = createGBL(new int[] {370, 300}, new int[] {40});
		GridBagLayout productPanelLayout = createGBL(new int[]{110, 550}, new int[]{120, 0});
		GridBagLayout productDetailLayout = createGBL(new int[]{510, 0}, new int[]{10, 25, 25, 25, 25, 10});

		JPanel topPanel = new JPanel();
		JPanel searchBarPanel = new JPanel();
		JPanel resultPanel = new JPanel();
		JPanel resultLabelPanel = new JPanel();
		JPanel sortOptionsPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel productPanelList = new JPanel();
		layeredPanel = new JLayeredPane();
		JScrollPane scrollPane = new JScrollPane();

		JLabel resultLabel = new JLabel();
		String[] sortOptionsName = {"리뷰 많은순", "높은 가격순", "낮은 가격순", "최신순"};
		sortOptions = new JLabel[4];
		//패널의 배경색 설정
		searchBarPanel.setBackground(Setup.white);
		resultPanel.setBackground(Setup.white);
		resultLabelPanel.setBackground(Setup.white);
		sortOptionsPanel.setBackground(Setup.white);

		setLayout(mainPanelLayout);
		topPanel.setLayout(topPanelLayout);
		resultPanel.setLayout(resultPanelLayout);
		// 사용할 패널들의 GBC 설정
		GridBagConstraints topPanelGBC = createGBC(0, 0, new int[]{0, 0, 0, 5}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints searchBarPanelGBC = createGBC(0, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints resultPanelGBC = createGBC(0, 1, new int[]{0, 0, 1, 0}, GridBagConstraints.BOTH, GridBagConstraints.WEST);
		GridBagConstraints resultLabelPanelGBC = createGBC(0, 0, new int[]{0, 10, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints sortOptionsPanelGBC = createGBC(1, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER);
		GridBagConstraints middlePanelGBC = createGBC(0, 2, new int[]{0, 0, 3, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints layeredPanelGBC = createGBC(1, 0, new int[]{0, 0, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		// productPanel 내부의 레이블과 패널에 대한 GBC 설정
		GridBagConstraints productPanelImage = createGBC(0, 0, new int[]{0, 10, 0, 0}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelDetail = createGBC(1, 0, new int[]{0, 5, 0, 5}, GridBagConstraints.BOTH, GridBagConstraints.CENTER);
		GridBagConstraints productPanelName = createGBC(0, 1, new int[]{0, 0, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelCategory = createGBC(0, 2, new int[]{0, 0, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelRegDate = createGBC(0, 3, new int[]{0, 0, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);
		GridBagConstraints productPanelPrice = createGBC(0, 4, new int[]{0, 0, 0, 0}, GridBagConstraints.NONE, GridBagConstraints.WEST);

		add(topPanel, topPanelGBC);
		topPanel.add(searchBarPanel, searchBarPanelGBC);
		topPanel.add(resultPanel, resultPanelGBC);
		topPanel.add(middlePanel, middlePanelGBC);

		searchBarPanel.add(search);
		search.getTextField().addActionListener(this);
		search.getSearchButtonLabel().addMouseListener(this);

		resultPanel.add(resultLabelPanel, resultLabelPanelGBC);
		resultLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));
		if (text != "")
			resultLabel.setText(String.format("'%s'에 대한 검색결과", text));
		resultLabel.setFont(new Font(Setup.font, Font.BOLD, 15));
		resultLabelPanel.add(resultLabel);
		resultPanel.add(sortOptionsPanel, sortOptionsPanelGBC);
		sortOptionsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
		for (int i = 0; i < 4; i++) {
			sortOptions[i] = new JLabel(sortOptionsName[i]);
			sortOptions[i].setFont(new Font(Setup.font, Font.BOLD, 12));
			sortOptions[i].addMouseListener(this);
			sortOptionsPanel.add(sortOptions[i]);
		}

		middlePanel.setLayout(new BorderLayout());
		middlePanel.add(productPanelList, BorderLayout.CENTER);
		middlePanel.add(scrollPane);
		productPanelList.setLayout(null);
		// 패널 초기화
		for (count = 0; count < productCount; count++) {
			productPanel[count] = new JPanel();
			productPanel[count].setLayout(productPanelLayout);
			productPanel[count].addMouseListener(this);
			productPanel[count].setBackground(Setup.white);
			productDetail[count] = new JPanel();
			productDetail[count].setLayout(productDetailLayout);
			productDetail[count].setOpaque(false);
			productImage[count] = new JLabel("");
			productName[count] = new JLabel();
			productName[count].setFont(new Font(Setup.font, Font.BOLD, 18));
			productCategory[count] = new JLabel();
			productCategory[count].setFont(new Font(Setup.font, Font.BOLD, 15));
			productRegDate[count] = new JLabel();
			productRegDate[count].setFont(new Font(Setup.font, Font.BOLD, 15));
			productPrice[count] = new JLabel();
			productPrice[count].setFont(new Font(Setup.font, Font.BOLD, 18));
			productPrice[count].setForeground(Setup.magenta);
		}
		// 패널 추가
		for (count = 0; count < productCount; count++) {
			productNum[count] = Integer.parseInt(productList.get(count).get(0));
			productImage[count].setIcon(Setup.imageSetSize(new ImageIcon(SearchDB.productImageLoad(productNum[count])), 110, 110));
			productName[count].setText(productList.get(count).get(1));
			productCategory[count].setText(productList.get(count).get(2));
			productRegDate[count].setText(String.format("등록일 : %s", productList.get(count).get(3).replace('-', '.')));
			productPrice[count].setText(String.format("%s원", NumberFormat.getInstance().format(Integer.parseInt(productList.get(count).get(4)))));
			productPanel[count].add(productImage[count], productPanelImage);
			productPanel[count].add(productDetail[count], productPanelDetail);
			productDetail[count].add(productName[count], productPanelName);
			productDetail[count].add(productCategory[count], productPanelCategory);
			productDetail[count].add(productRegDate[count], productPanelRegDate);
			productDetail[count].add(productPrice[count], productPanelPrice);
			productPanel[count].setBounds(0, y_axis, 668, 120);
			productPanelList.add(productPanel[count]);
			y_axis += 121;
		}

		scrollPane.setBorder(null);
		Setup.changeScrollBar(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(productPanelList);
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		productPanelList.setPreferredSize(new Dimension(productPanelList.getWidth(), y_axis));
		scrollPane.setBorder(BorderFactory.createLineBorder(Setup.white, 1));

		add(layeredPanel, layeredPanelGBC);
		if (Setup.CustomerNum != 0) // 로그인 된 경우
			layeredPanel.add(new SubShoppingBasket(Setup.CustomerNum, layeredPanel));
		else // 로그인되지 않은 경우
			layeredPanel.add(new SubShoppingBasket());
		layeredPanel.setLayout(new CardLayout(0, 0));
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < productCount; i++) {
			if(e.getSource() == productPanel[i]) {
				if (e.getSource() == selectPanel) {
					selectPanel.setBorder(null);
					selectPanel = null;
					if (Setup.CustomerNum == 0) // 로그인되어 있지 않은 경우
						Setup.changePanel(layeredPanel, new SubShoppingBasket());
					else // 로그인 된 경우
						Setup.changePanel(layeredPanel, new SubShoppingBasket(Setup.CustomerNum, layeredPanel));
				}
				else {
					if (selectPanel != null) 
						selectPanel.setBorder(null);
					selectPanel = productPanel[i];
					productPanel[i].setBorder(BorderFactory.createLineBorder(Setup.magenta, 1));
					Setup.changePanel(layeredPanel, new ProductDetail(productList.get(i), layeredPanel, selectPanel));
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == search.getSearchButtonLabel()) {
			if(search.getTextField().getText().equals("검색하고 싶은 상품을 입력하세요."))
				text = "";
			else
				text = search.getTextField().getText();
			Setup.changePanel(Frame.contentLayeredPanel, new Search(text, orderType));
        }
		for (orderType = 0; orderType < 4; orderType++) {
			if (e.getSource() == sortOptions[orderType]) {
				System.out.println(SearchDB.productList(text, orderType));
				System.out.println(orderType);
				Setup.changePanel(Frame.contentLayeredPanel, new Search(text, orderType));
			}

		}				
    }
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search.getTextField()) {
			if(search.getTextField().getText().equals("검색하고 싶은 상품을 입력하세요."))
				text = "";
			else
				text = search.getTextField().getText();
            Setup.changePanel(Frame.contentLayeredPanel, new Search(text, orderType));
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
}