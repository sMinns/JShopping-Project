package gui.contents.main;

import custom.CheckBoxType1;
import custom.ComboBoxType1;
import custom.SearchBar;
import database.OrderManagementDB;
import gui.common.Frame;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

public class OrderManagement extends JPanel implements ActionListener {
	private DecimalFormat formatter = new DecimalFormat("###,###");
	private List<List<String>> data;
	//검색창의 콤보박스 문자열배열
	private String[] SCombolist = {"주문번호","주문자이름","상품평"};
	//상품의 콤보박스 문자열배열
	private String[] PCombolist = {"결제완료","상품준비중","배송중","배송완료"};
	//주문번호 분류의 문자열 배열
	private String[] Ordertitle = { "  주문번호 : ", "주문자 정보", "수량", "상품금액", "배송희망일", "관리" };
	private JComboBox[] buttons;
	private JPanel[][] orderinfoPanel;
	private JLabel[][] orderinfoLabel;
	private JTextArea[] ordernameText;
	private JPanel[][] ordertitlePanel2;
	private JPanel[] orderlistPanel;  // 상품 묶음
	private JPanel[] ordertitlePanel; //타이틀이 들어갈패널
	private JPanel[] orderAddressPanel = new JPanel[OrderManagementDB.ordercount(Setup.CustomerNum)];
	private JLabel[] orderAddressLabel = new JLabel[OrderManagementDB.ordercount(Setup.CustomerNum)];
	private JCheckBox checkBox;
	private Font font1 = new Font(Setup.font, Font.BOLD, 17);
	private Font font2 = new Font(Setup.font, Font.BOLD, 16);
	int ysize=0;

	public OrderManagement(boolean check) {
		data = OrderManagementDB.productList(Setup.CustomerNum, "", check);
		buttons = new JComboBox[data.size()];
		orderinfoPanel = new JPanel[data.size()][9];
		orderinfoLabel = new JLabel[data.size()][9];
		ordernameText = new JTextArea[data.size()]; //상품명
		ordertitlePanel2 = new JPanel[data.size()][9];
		orderlistPanel = new JPanel[data.size()];
		ordertitlePanel =new JPanel[data.size()];

		Setup.changeInsets(0, 0, 0, 6);
		GridBagLayout titleLayout = new GridBagLayout();
		titleLayout.columnWidths = new int[] {362,134,85,114,122,122};
		titleLayout.rowHeights = new int[] {35};

		GridBagConstraints titleGBC = new GridBagConstraints();
		titleGBC.gridx=0;
		titleGBC.gridy=0;
		titleGBC.fill=GridBagConstraints.BOTH;
		GridBagConstraints titletGBC = new GridBagConstraints();
		titletGBC.anchor=GridBagConstraints.WEST;
		titletGBC.fill=GridBagConstraints.BOTH;
		JLabel aa[][] = new JLabel[data.size()][9];

		for(int i=0;i<data.size();i++) {
			ordertitlePanel[i] = new JPanel(); // OrdertitlePanel
			ordertitlePanel[i].setLayout(titleLayout);
			for(int j=0;j<6;j++) {
				titleGBC.gridx=j;
				ordertitlePanel2[i][j] = new JPanel(); // OrdertitlePanel2
				ordertitlePanel2[i][j].setBackground(Setup.white);
				ordertitlePanel2[i][j].setLayout(new GridBagLayout());
				aa[i][j]=new JLabel();
				aa[i][j].setFont(font2);
				if(j == 0) {
					aa[i][j].setFont(font1);
					aa[i][j].setText(Ordertitle[j]+ data.get(i).get(0));
					ordertitlePanel2[i][j].setLayout(new CardLayout());
					ordertitlePanel2[i][j].add(aa[i][j]);
				}else if(j > 1) {
					aa[i][j].setText(Ordertitle[j]);
					ordertitlePanel2[i][j].add(aa[i][j]);
				}
				ordertitlePanel[i].add(ordertitlePanel2[i][j],titleGBC);
			}
		} // 타이틀 패널완성
		GridBagConstraints t4GBC = new GridBagConstraints();
		t4GBC.gridy=1;
		GridBagConstraints t2GBC = new GridBagConstraints();
		t2GBC.fill=GridBagConstraints.HORIZONTAL;
		t2GBC.anchor=GridBagConstraints.WEST;
		for(int i =0; i<data.size();i++) {
			ordernameText[i] = new JTextArea(1,15);
			ordernameText[i].setLineWrap(true);
			for(int j=0;j<9;j++) {
				orderinfoPanel[i][j] = new JPanel();
				orderinfoPanel[i][j].setBackground(Setup.white);
				orderinfoPanel[i][j].setLayout(new GridBagLayout());
				orderinfoLabel[i][j] = new JLabel();
				//주문번호 사진 상품명 주문자이름 주문자연락처4 수량 상품금액 배송희망일 관리
				orderinfoLabel[i][j].setText(data.get(i).get(j));
				orderinfoLabel[i][j].setFont(font2);
				if(j==2) {
					ordernameText[i].setText(data.get(i).get(j));
					ordernameText[i].setEditable(false);
					ordernameText[i].setFont(font2);
					orderinfoPanel[i][j].add(ordernameText[i],t2GBC);
				}else if(j==1) {
					orderinfoLabel[i][j].setText("");
					orderinfoLabel[i][j].setIcon(Setup.imageSetSize
							(new ImageIcon(OrderManagementDB.productImageLoad(Integer.parseInt(data.get(i).get(j)))),80,80));
					orderinfoPanel[i][j].add(orderinfoLabel[i][j]);
				}else if(j==4){
					orderinfoLabel[i][j].setText(data.get(i).get(j));
					orderinfoPanel[i][j-1].add(orderinfoLabel[i][j],t4GBC);

				}else if(j==5){
					orderinfoLabel[i][j].setText(data.get(i).get(j)+"개");
					orderinfoPanel[i][j].add(orderinfoLabel[i][j]);

				}else if(j==6){
					String won = formatter.format(Integer.parseInt(data.get(i).get(j)) * Integer.parseInt(data.get(i).get(j-1)));
					orderinfoLabel[i][j].setText(won+"원");
					orderinfoPanel[i][j].add(orderinfoLabel[i][j]);

				}else if(j==7){
					orderinfoLabel[i][j].setText(data.get(i).get(j).replace("-", ". "));
					orderinfoLabel[i][j].setForeground(Setup.magenta);
					orderinfoPanel[i][j].add(orderinfoLabel[i][j]);

				}else if(j==8){
					buttons[i] = new ComboBoxType1(PCombolist,100,data.get(i).get(j));
					buttons[i].setBorder(BorderFactory.createLineBorder(Setup.checkBoxBorderColor, 2));
					buttons[i].addActionListener(this);
					orderinfoPanel[i][j].add(buttons[i]);

				}else {
					orderinfoPanel[i][j].add(orderinfoLabel[i][j]);
				}

			}
		}
		//OrderManagement Layout
		GridBagLayout OrderManagementLayout = new GridBagLayout();
		OrderManagementLayout.columnWidths = new int[]{985};//메인크기
		OrderManagementLayout.rowHeights = new int[]{685};
		this.setLayout(OrderManagementLayout);

		//MainPanel
		JPanel OrderMainPanel = new JPanel();
		GridBagConstraints OrderMainGBC = new GridBagConstraints();
		OrderMainGBC.fill = GridBagConstraints.BOTH;
		this.add(OrderMainPanel, OrderMainGBC);

		GridBagLayout OrderMainLayout = new GridBagLayout();
		OrderMainLayout.columnWidths = new int[]{985};
		OrderMainLayout.rowHeights = new int[]{50,635};
		OrderMainPanel.setLayout(OrderMainLayout);

		JPanel topPanel = new JPanel();

		GridBagConstraints topBagCon = new GridBagConstraints();
		topBagCon.fill = GridBagConstraints.BOTH;
		topBagCon.gridx = 0;
		topBagCon.gridy = 0;
		OrderMainPanel.add(topPanel, topBagCon);
		//System.out.print("해줘요");
		GridBagLayout topPanelLayout = new GridBagLayout();
		topPanelLayout.columnWidths = new int[]{735, 250};
		topPanel.setLayout(topPanelLayout);

		//SearchBar Panel
		GridBagConstraints SBagCon = new GridBagConstraints();
		SBagCon.insets = new Insets(0,50,0,0);
		JPanel searchBarPanel = new JPanel();

		searchBarPanel.setBackground(Setup.white);
		GridBagConstraints searchBarBagCon = new GridBagConstraints();
		searchBarBagCon.anchor = GridBagConstraints.EAST;

		topPanel.add(searchBarPanel, searchBarBagCon);
		//SearchBar//SearchBar(int size, int limit, String[] items, String text, int fontSize)
		JPanel searchBar = new SearchBar(45, 70, SCombolist," ", "주문번호",15);
		searchBarPanel.add(searchBar);

		//Add Product

		searchBarBagCon.anchor = GridBagConstraints.WEST;
		JPanel CheckBoxPanel = new JPanel();
		CheckBoxPanel.setLayout(new CardLayout());
		searchBarBagCon.gridx = 1;
		searchBarBagCon.insets = new Insets(0,15,0,0);
		topPanel.add(CheckBoxPanel, searchBarBagCon);
		checkBox = new CheckBoxType1("완료된 주문도 보기", font2);
		checkBox.setSelected(check);
		checkBox.addActionListener(this);
		CheckBoxPanel.add(checkBox);
		CheckBoxPanel.setBackground(Setup.white);
		topPanel.setBackground(Setup.white);

		JScrollPane scrollPane = new JScrollPane();
		JPanel orderscp = new JPanel(); // 맨안에
		topBagCon.insets = new Insets(8, 0, 8, 0);
		topBagCon.gridy=1;
		orderscp.setLayout(null);

		JPanel outpanel = new JPanel(); // 젤밖에
		outpanel.setLayout(new CardLayout());
		OrderMainPanel.add(outpanel, topBagCon);
		outpanel.add(scrollPane);

		scrollPane.setBorder(null);
		Setup.changeScrollBar(scrollPane);
		scrollPane.setViewportView(orderscp);

		GridBagLayout listLayout = new GridBagLayout();
		listLayout.columnWidths = new int[] {100,262,134,85,114,122,122};
		listLayout.rowHeights = new int[] {90};
		GridBagConstraints listGBC = new  GridBagConstraints();
		listGBC.gridx=0;
		listGBC.gridy=0;
		listGBC.fill=GridBagConstraints.BOTH;

		int k = 0;
		for(int i=0;i<data.size();i++) {
			if(i == 0 || data.get(i).get(0).equals(data.get(i - 1).get(0))) {
				if(i == 0) {
					orderscp.add(ordertitlePanel[i]);
					ordertitlePanel[i].setBounds(20, ysize, 945, 35);
					ysize+=36;
				}
				orderlistPanel[i]=new JPanel();
				orderlistPanel[i].setLayout(listLayout);
				for(int j=1;j<8;j++) {
					if(j < 4) {
						orderlistPanel[i].add(orderinfoPanel[i][j],listGBC);
						listGBC.gridx++;
					}else {
						orderlistPanel[i].add(orderinfoPanel[i][j+1],listGBC);
						listGBC.gridx++;
					}
				}
				listGBC.gridx=0;
				orderscp.add(orderlistPanel[i]);
				orderlistPanel[i].setBounds(20, ysize, 945, 90);
				ysize+=91;
				if(i == data.size()-1) {
					ysize++;
					orderAddressPanel[k] = new JPanel(new CardLayout());
					orderAddressPanel[k].setBackground(Setup.white);
					orderAddressPanel[k].setBounds(23, ysize, 939, 30);
					orderscp.add(orderAddressPanel[k]);
					ysize += 30;
					orderAddressLabel[k] = new JLabel(" 배송지: " + OrderManagementDB.returnOrderAddress(data.get(i).get(0)));
					orderAddressLabel[k].setFont(new Font(Setup.font, Font.BOLD, 16));
					orderAddressPanel[k].add(orderAddressLabel[k]);
				}
			}else {
				ysize++;
				orderAddressPanel[k] = new JPanel(new CardLayout());
				orderAddressPanel[k].setBackground(Setup.white);
				orderAddressPanel[k].setBounds(23, ysize, 939, 30);
				orderscp.add(orderAddressPanel[k]);
				ysize += 30;
				orderAddressLabel[k] = new JLabel(" 배송지: " + OrderManagementDB.returnOrderAddress(data.get(i-1).get(0)));
				orderAddressLabel[k].setFont(new Font(Setup.font, Font.BOLD, 16));
				orderAddressPanel[k].add(orderAddressLabel[k]);
				k++;
				ysize+=8;
				orderscp.add(ordertitlePanel[i]);
				ordertitlePanel[i].setBounds(20, ysize, 945, 35);
				ysize+=36;
				orderlistPanel[i]=new JPanel();
				orderlistPanel[i].setLayout(listLayout);
				for(int j=1;j<8;j++) {
					if(j < 4) {
						orderlistPanel[i].add(orderinfoPanel[i][j],listGBC);
						listGBC.gridx++;
					}else {
						orderlistPanel[i].add(orderinfoPanel[i][j+1],listGBC);
						listGBC.gridx++;
					}
				}listGBC.gridx=0;
				orderscp.add(orderlistPanel[i]);
				orderlistPanel[i].setBounds(20, ysize, 945, 90);
				ysize+=91;
			}
		}
		orderscp.setPreferredSize(new Dimension(orderscp.getWidth(), ysize));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < data.size(); i++) {
			if(e.getSource() == buttons[i]) {
				OrderManagementDB.updateOrderProductStat((String) buttons[i].getSelectedItem(), Integer.parseInt(data.get(i).get(1)),
						data.get(i).get(0));
				if(!checkBox.isSelected() || ((String) buttons[i].getSelectedItem()).equals("배송완료")) {
					Setup.changePanel(Frame.contentLayeredPanel, new OrderManagement(checkBox.isSelected()));
				}
			}
		}

		if(e.getSource() == checkBox) {
			Setup.changePanel(Frame.contentLayeredPanel, new OrderManagement(checkBox.isSelected()));
		}
	}
}



