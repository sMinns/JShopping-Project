package gui.contents.main;

import custom.ButtonType1;
import custom.RadioType1;
import custom.TextFieldType1;
import custom.onlyNumberTextField;
import gui.contents.sub.DesDateCalendar;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Calendar;

public class OrderPage extends JPanel implements ActionListener, MouseListener {
	private JTextField recipient_textField, address_textField_1, address_textField_2, shipping_Request_textField,
			delivery_desired_date_textField, expiration_date_textField_1, cvc_number_textField,
			expiration_date_textField_2, password_textField;

	private JPanel order_list_main_panel, shipping_information_panel, delivery_title_panel, delivery_panel, payment_information_panel,
			payment_method_panel, final_payment_amount_title_panel, final_payment_amount_panel_1, final_payment_amount_panel_2, calender_panel,
			oder_page_panel, order_list_Panel, paytype_panel;
	private JRadioButton credit_card_RadioButton, mobile_phone_payment_RadioButton;
	private CardLayout cl_paytype_panel;
	private JButton agreement;
	private String[][] str = {
			{"/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전","가나다" , "0", "1", "422100"},
			{"/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화","나이키", "0", "1", "123350"},
			{"/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화","나이키", "3000", "1", "45654"}
	};
	private JPanel[] productPanel = new JPanel[str.length];
	private JPanel[][] productInfoPanel = new JPanel[str.length][str[1].length];
	private JLabel[][] productInfoLabel = new JLabel[str.length][str[1].length];
	private JTextArea[] productNameTextArea = new JTextArea[str.length];

	private Font[] font = { new Font(Setup.font, Font.BOLD, 12), new Font(Setup.font, Font.BOLD, 15),
			new Font(Setup.font, Font.BOLD, 16),new Font(Setup.font, Font.BOLD, 17), new Font(Setup.font, Font.PLAIN, 15)};

	private JLabel[] product_titleLabel = new JLabel[5], cardInfoLabel = new JLabel[4];
	private String[] product_titleText = { "상품정보", "판매자", "배송비", "수량", "상품 금액" };
	private int[] product_titleX = { 158, 388, 502, 613, 716 }, cardNumTextFieldX = { 151, 258, 365, 473 }, mobileTextFieldx = {151, 273, 395};

	private JFormattedTextField[] cardNumberTextField = new JFormattedTextField[4], phoneNumTextField = new JFormattedTextField[3];
	private JLabel calendarLabel;
	private boolean openCalendar = false;
	public OrderPage() {
		Setup.changeInsets(10,10,10,6);
		setSize(new Dimension(975, 670));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setLayout(null);

		oder_page_panel = new JPanel();
		oder_page_panel.setBounds(0, 0, 189, 210);
		oder_page_panel.setPreferredSize(new Dimension(500, 1080+(str.length*91)));
		oder_page_panel.setLayout(null);

		JScrollPane oder_page_scroll_panel = new JScrollPane(oder_page_panel);
		Setup.changeScrollBar(oder_page_scroll_panel);
		oder_page_scroll_panel.setBorder(null);
		oder_page_scroll_panel.setSize(975, 670);
		this.add(oder_page_scroll_panel);
		oder_page_panel.setLayout(null);

		calender_panel = new JPanel();
		calender_panel.setBounds(215, 414+(str.length*91), 270, 240);
		calender_panel.setPreferredSize(new Dimension(190, 210));
		oder_page_panel.add(calender_panel);
		calender_panel.setVisible(false);
		calender_panel.setLayout(null);

		productInfo();
		order_list_Panel.setPreferredSize(new Dimension(order_list_Panel.getWidth(),91*str.length-1));
		addressInfo();
		deliveryInfo();
		paymentInfo();
		finalPriceInfo();

		JPanel cal = new DesDateCalendar(delivery_desired_date_textField, calender_panel);
		calender_panel.add(cal);

		JLabel agreement_text = new JLabel("주문 내용을 확인하였으며, 정보 제공 등에 동의합니다.");
		agreement_text.setHorizontalAlignment(SwingConstants.CENTER);
		agreement_text.setFont(font[1]);
		agreement_text.setBounds(63, 930+(str.length*91), 823, 23);
		oder_page_panel.add(agreement_text);

		agreement = new ButtonType1(22, 2, 5, "주문하기", 18);
		agreement.setBounds(399, 971+(str.length*91), 132, 44);
		oder_page_panel.add(agreement);
	}

	public void addProductInfo(int i, GridBagConstraints productListBagCon) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		for(int j = 0; j < str[i].length; j++ ) {
			FlowLayout layout = new FlowLayout(1, 3, 32);
			productInfoPanel[i][j] = new JPanel();
			productInfoPanel[i][j].setBackground(Setup.white);
			this.productPanel[i].add(productInfoPanel[i][j], productListBagCon);
			productInfoLabel[i][j] = new JLabel();
			productInfoLabel[i][j].setFont(font[4]);
			if(j != 1) {
				if(j == 0) {
					layout.setHgap(5);
					layout.setVgap(5);
					productInfoLabel[i][j].setIcon(Setup.imageSetSize(
							new ImageIcon(OrderPage.class.getResource(str[i][0])),80,80));
				}else if(j == 2) {
					productInfoLabel[i][j].setText(str[i][j]);
				}else if(j == 3) {
						productInfoLabel[i][j].setText("무료");
				}else if(j == 4) {
					productInfoLabel[i][j].setText(str[i][j]);
				}else if(j == 5) {
					String text = formatter.format(Integer.parseInt(str[i][j]));
					productInfoLabel[i][j].setFont(font[2]);
					productInfoLabel[i][j].setForeground(Setup.magenta);
					productInfoLabel[i][j].setText(text + "원");
				}
				productInfoPanel[i][j].add(productInfoLabel[i][j]);
				productInfoPanel[i][j].setLayout(layout);
			}else {
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.anchor = GridBagConstraints.WEST;
				productInfoPanel[i][j].setLayout(new GridBagLayout());
				productNameTextArea[i] = new JTextArea(1, 15);
				productNameTextArea[i].setEditable(false);
				productNameTextArea[i].setText(str[i][j]);
				productNameTextArea[i].setOpaque(false);
				productNameTextArea[i].setLineWrap(true);
				productNameTextArea[i].setFont(font[2]);
				productInfoPanel[i][j].add(productNameTextArea[i], gbc);
			}
		}
	}

	//배송지 정보
	public void addressInfo() {
		JLabel[] attributeLabel = new JLabel[4];
		int[] attributeY = {0, 12, 61, 110};
		String[] text = {"배송지 정보", "받으시는 분", "연락처", "주소"};
		JPanel addressInfoTitlePanel = new backgroundPanel(63, 65+(str.length*91), 823, 40);
		oder_page_panel.add(addressInfoTitlePanel);

		shipping_information_panel = new backgroundPanel(63, 107+(str.length*91), 823, 162);
		oder_page_panel.add(shipping_information_panel);

		for (int i = 0; i < 4; i++) {
			attributeLabel[i] = new JLabel(text[i]);
			if(i == 0) {
				attributeLabel[i].setFont(font[3]);
				addressInfoTitlePanel.add(attributeLabel[i]);
			}else {
				attributeLabel[i].setFont(font[2]);
				shipping_information_panel.add(attributeLabel[i]);
			}
			attributeLabel[i].setBounds(12, attributeY[i], 119, 38);
		}
		oder_page_panel.add(addressInfoTitlePanel);

		recipient_textField = new TextFieldType1(22, 2, "",20);
		recipient_textField.setFont(font[4]);
		recipient_textField.setColumns(10);
		recipient_textField.setBounds(151, 13, 631, 40);
		shipping_information_panel.add(recipient_textField);

		for(int i = 0; i < 3; i++) {
			int limit = 4;
			if(i == 0) { limit = 3; }
			phoneNumTextField[i] = new onlyNumberTextField(22, 2, limit, "");
			phoneNumTextField[i].setFont(font[4]);
			phoneNumTextField[i].setColumns(10);
			phoneNumTextField[i].setBounds(mobileTextFieldx[i], 59, 110, 40);
			shipping_information_panel.add(phoneNumTextField[i]);
		}

		address_textField_1 = new TextFieldType1(22, 2, "", 50);
		address_textField_1.setFont(font[4]);
		address_textField_1.setColumns(10);
		address_textField_1.setBounds(151, 106, 320, 40);
		shipping_information_panel.add(address_textField_1);

		address_textField_2 = new TextFieldType1(22, 2, "",50);
		address_textField_2.setFont(font[4]);
		address_textField_2.setColumns(10);
		address_textField_2.setBounds(476, 106, 306, 40);
		shipping_information_panel.add(address_textField_2);
	}
	public void productInfo() {
		JPanel column_panel = new backgroundPanel(63, 22, 823, 35);
		oder_page_panel.add(column_panel);

		for(int i = 0; i < 5; i++) {
			product_titleLabel[i] = new JLabel(product_titleText[i]);
			product_titleLabel[i].setFont(font[1]);
			product_titleLabel[i].setBounds(product_titleX[i], 10, 65, 15);
			column_panel.add(product_titleLabel[i]);
		}

		order_list_main_panel = new JPanel();
		order_list_main_panel.setBounds(63, 60, 823, (str.length*91));
		oder_page_panel.add(order_list_main_panel);
		order_list_main_panel.setLayout(null);

		//productListMainPanel
		JPanel order_list_sub_Panel = new JPanel();
		order_list_sub_Panel.setBounds(0, 0, 824, (str.length*90)+70);
		GridBagConstraints productBagCon = new GridBagConstraints();
		productBagCon.insets = new Insets(0, 0, 0, str.length);
		productBagCon.fill = GridBagConstraints.BOTH;
		order_list_main_panel.add(order_list_sub_Panel);

		GridBagLayout gbl_order_list_sub_Panel = new GridBagLayout();
		gbl_order_list_sub_Panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_order_list_sub_Panel.rowHeights = new int[]{50, 25, 0, 0, 0, 0};
		gbl_order_list_sub_Panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_order_list_sub_Panel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		order_list_sub_Panel.setLayout(gbl_order_list_sub_Panel);

		//Product List
		order_list_Panel = new JPanel();
		order_list_Panel.setLayout(null);

		GridBagConstraints gbc_order_scroll_Panel = new GridBagConstraints();
		gbc_order_scroll_Panel.fill = GridBagConstraints.BOTH;
		gbc_order_scroll_Panel.gridheight = str.length;
		gbc_order_scroll_Panel.gridwidth = 6;
		gbc_order_scroll_Panel.gridy = 0;
		order_list_sub_Panel.add(order_list_Panel, gbc_order_scroll_Panel);

		int a = 6;
		for(int i = 0; i < str.length; i++) {

			productPanel[i] = new JPanel();
			productPanel[i].setBounds(0, 10, 673, 90);
			order_list_Panel.add(productPanel[i]);
			GridBagLayout productListLayout = new GridBagLayout();
			productListLayout.columnWidths = new int[]{80, 270, 100, 135, 40, 130};
			productListLayout.rowHeights = new int[]{0, 1};
			productListLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			productListLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			productPanel[i].setLayout(productListLayout);
			productPanel[i].setBounds(0, i * 90 + i, 829, 90);

			GridBagConstraints productListBagCon = new GridBagConstraints();
			productListBagCon.fill = GridBagConstraints.BOTH;
			order_list_Panel.add(productPanel[i]);
			//addProductInfo
			addProductInfo(i, productListBagCon);
		}
	}
	//배송
	public void deliveryInfo() {
		Calendar c = Calendar.getInstance();
		int selectYear = c.get(Calendar.YEAR);
		int selectMonth = c.get(Calendar.MONTH) + 1;
		int selectDay = c.get(Calendar.DATE) + 2;

		JLabel[] attributeLabel = new JLabel[3];
		int[] attributeY = {0, 12, 61};
		String[] text = {"배송", "배송 요청사항", "배송 희망일"};

		delivery_title_panel = new backgroundPanel(63, 273+(str.length*91), 823, 40);
		oder_page_panel.add(delivery_title_panel);

		delivery_panel = new backgroundPanel(63, 315+(str.length*91), 823, 114);
		oder_page_panel.add(delivery_panel);

		for (int i = 0; i < 3; i++) {
			attributeLabel[i] = new JLabel(text[i]);
			if(i == 0) {
				attributeLabel[i].setFont(font[3]);
				delivery_title_panel.add(attributeLabel[i]);
			}else {
				attributeLabel[i].setFont(font[2]);
				delivery_panel.add(attributeLabel[i]);
			}
			attributeLabel[i].setBounds(12, attributeY[i], 119, 38);
		}

		shipping_Request_textField = new TextFieldType1(22, 2, "",50);
		shipping_Request_textField.setFont(font[4]);
		shipping_Request_textField.setColumns(10);
		shipping_Request_textField.setBounds(151, 13, 631, 40);
		delivery_panel.add(shipping_Request_textField);

		delivery_desired_date_textField = new TextFieldType1(22, 2, "",15);
		delivery_desired_date_textField.setEditable(false);
		delivery_desired_date_textField.setForeground(Setup.darkGray);
		delivery_desired_date_textField.setText(selectYear + ". " + selectMonth + ". " + selectDay);
		delivery_desired_date_textField.setFont(font[4]);
		delivery_desired_date_textField.setColumns(10);
		delivery_desired_date_textField.setBounds(151, 61, 144, 40);
		delivery_panel.add(delivery_desired_date_textField);
		delivery_desired_date_textField.addMouseListener(this);

		calendarLabel = new JLabel("");
		calendarLabel.setIcon(new ImageIcon(OrderPage.class.getResource("/images/calendar.png")));
		calendarLabel.setBounds(301, 61, 40, 38);
		delivery_panel.add(calendarLabel);
		calendarLabel.addMouseListener(this);
	}

	// 결제 정보
	public void paymentInfo() {
		payment_information_panel =  new backgroundPanel(63, 433+(str.length*91), 823, 40);
		oder_page_panel.add(payment_information_panel);

		JLabel payment_information = new JLabel("결제 정보");
		payment_information.setFont(font[3]);
		payment_information.setBounds(12, 0, 119, 38);
		payment_information_panel.add(payment_information);

		payment_method_panel = new JPanel();
		payment_method_panel.setLayout(null);
		payment_method_panel.setBackground(Setup.white);
		payment_method_panel.setBounds(63, 474+(str.length*91), 823, 40);
		oder_page_panel.add(payment_method_panel);

		JLabel payment_method_text = new JLabel("결제 방법");
		payment_method_text.setFont(font[2]);
		payment_method_text.setBounds(12, 2, 82, 34);
		payment_method_panel.add(payment_method_text);

		paytype_panel = new JPanel();
		paytype_panel.setBackground(Setup.white);
		paytype_panel.setBounds(63, 515+(str.length*91), 823, 205);
		oder_page_panel.add(paytype_panel);
		paytype_panel.setLayout(new CardLayout(0, 0));
		cl_paytype_panel = (CardLayout) paytype_panel.getLayout();

		credit_card_RadioButton = new RadioType1("신용카드", font[0]);
		credit_card_RadioButton.setSelected(true);
		credit_card_RadioButton.setBackground(Setup.white);
		credit_card_RadioButton.setBounds(157, 0, 82, 40);
		payment_method_panel.add(credit_card_RadioButton);
		credit_card_RadioButton.addActionListener(this);

		mobile_phone_payment_RadioButton = new RadioType1("휴대폰 결제", new Font(Setup.font, Font.BOLD, 12));
		mobile_phone_payment_RadioButton.addActionListener(this);

		mobile_phone_payment_RadioButton.setBackground(Setup.white);
		mobile_phone_payment_RadioButton.setBounds(318, 0, 121, 40);
		payment_method_panel.add(mobile_phone_payment_RadioButton);

		ButtonGroup groupRd = new ButtonGroup();
		groupRd.add(credit_card_RadioButton);
		groupRd.add(mobile_phone_payment_RadioButton);

		paytype_panel.add(new CardPanel(), "card");
		paytype_panel.add(new mobilePanel(), "mobile");
	}

	public void finalPriceInfo() {
		DecimalFormat formatter = new DecimalFormat("###,###");
		JLabel[] attributeLabel = new JLabel[4];
		JLabel[] valueLabel = new JLabel[4];
		Font fontt = new Font(Setup.font, Font.PLAIN, 16);
		int[] attributeY = {0, 0, 30};
		int[] valueY = {0, 8, 39};
		int sumprice = 0;
		String[] text = {"최종 결제 금액", "총 상품 가격", "배송비"};

		final_payment_amount_title_panel = new backgroundPanel(63, 724+(str.length*91), 823, 40);
		oder_page_panel.add(final_payment_amount_title_panel);

		final_payment_amount_panel_1 = new backgroundPanel(63, 765+(str.length*91), 823, 72);
		oder_page_panel.add(final_payment_amount_panel_1);

		final_payment_amount_panel_2 = new backgroundPanel(63, 838+(str.length*91), 823, 38);
		oder_page_panel.add(final_payment_amount_panel_2);

		for(int i = 0; i < str.length; i++) {
			sumprice += Integer.parseInt(str[i][5]);
		}

		for (int i = 0; i < 3; i++) {
			attributeLabel[i] = new JLabel(text[i]);
			if (i == 0) {
				attributeLabel[i].setFont(font[3]);
				final_payment_amount_title_panel.add(attributeLabel[i]);
			} else {
				attributeLabel[i].setFont(font[2]);
				final_payment_amount_panel_1.add(attributeLabel[i]);

				valueLabel[i] = new JLabel(formatter.format(sumprice) + " 원");
				valueLabel[i].setHorizontalAlignment(SwingConstants.RIGHT);
				valueLabel[i].setFont(fontt);
				valueLabel[i].setBounds(112, valueY[i], 109, 23);
				final_payment_amount_panel_1.add(valueLabel[i]);
			}
			attributeLabel[i].setBounds(12, attributeY[i], 119, 38);
		}
		valueLabel[2].setText("0 원");
		attributeLabel[3] = new JLabel("총 상품 가격");
		attributeLabel[3].setFont(font[2]);
		attributeLabel[3].setBounds(12, 0, 92, 36);
		final_payment_amount_panel_2.add(attributeLabel[3]);

		valueLabel[3] = new JLabel(formatter.format(sumprice) + " 원");
		valueLabel[3].setHorizontalAlignment(SwingConstants.RIGHT);
		valueLabel[3].setFont(font[2]);
		valueLabel[3].setBounds(112, 0, 109, 36);
		final_payment_amount_panel_2.add(valueLabel[3]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == credit_card_RadioButton) {
			cl_paytype_panel.show(paytype_panel,"card");
		}else if(e.getSource() == mobile_phone_payment_RadioButton) {
			cl_paytype_panel.show(paytype_panel,"mobile");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == calendarLabel || e.getSource() == delivery_desired_date_textField) {
			openCalendar = true;
			Setup.changePanel(calender_panel, new DesDateCalendar(delivery_desired_date_textField, calender_panel));
			calender_panel.setVisible(true);
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }

	class backgroundPanel extends JPanel {
		public backgroundPanel(int x, int y, int width, int height) {
			this.setLayout(null);
			this.setBackground(Setup.white);
			this.setBounds(x, y, width, height);
		}
	}

	class CardPanel extends JPanel {
		private int[] cardInfoY = { 10, 59, 106, 153 };
		private String[] cardText = { "카드번호", "유효기간", "CVC번호", "비밀번호" };
		public CardPanel() {
			this.setLayout(null);
			this.setBackground(Setup.white);

			for(int i = 0; i < 4; i++) {
				cardInfoLabel[i] = new JLabel(cardText[i]);
				cardInfoLabel[i].setFont(font[2]);
				cardInfoLabel[i].setBounds(12, cardInfoY[i], 88, 40);
				this.add(cardInfoLabel[i]);

				cardNumberTextField[i] = new onlyNumberTextField(22, 2, 4, "0000");
				cardNumberTextField[i].setColumns(10);
				cardNumberTextField[i].setBounds(cardNumTextFieldX[i], 13, 103, 40);
				cardNumberTextField[i].setFont(font[4]);
				this.add(cardNumberTextField[i]);
			}

			expiration_date_textField_1 = new TextFieldType1(22, 2, "",2);
			expiration_date_textField_1.setFont(font[4]);
			expiration_date_textField_1.setColumns(10);
			expiration_date_textField_1.setBounds(151, 59, 103, 40);
			this.add(expiration_date_textField_1);

			JLabel mounth = new JLabel("월");
			mounth.setFont(font[0]);
			mounth.setBounds(258, 73, 18, 15);
			this.add(mounth);

			expiration_date_textField_2 = new TextFieldType1(22, 2, "",2);
			expiration_date_textField_2.setFont(font[4]);
			expiration_date_textField_2.setColumns(10);
			expiration_date_textField_2.setBounds(278, 59, 103, 40);
			this.add(expiration_date_textField_2);

			JLabel year = new JLabel("년");
			year.setFont(font[0]);
			year.setBounds(387, 73, 18, 15);
			this.add(year);

			cvc_number_textField = new TextFieldType1(22, 2, "",3);
			cvc_number_textField.setFont(font[0]);
			cvc_number_textField.setColumns(10);
			cvc_number_textField.setBounds(151, 105, 103, 40);
			this.add(cvc_number_textField);

			JLabel three_digits = new JLabel("3자리");
			three_digits.setFont(font[0]);
			three_digits.setBounds(258, 120, 103, 15);
			this.add(three_digits);

			password_textField = new TextFieldType1(22, 2, "",6);
			password_textField.setFont(font[4]);
			password_textField.setColumns(10);
			password_textField.setBounds(151, 153, 103, 40);
			this.add(password_textField);

			JLabel first_two_digits = new JLabel("앞의 2자리 수");
			first_two_digits.setFont(font[0]);
			first_two_digits.setBounds(258, 168, 103, 15);
			this.add(first_two_digits);
		}
	}

	class mobilePanel extends JPanel {
		JFormattedTextField[] mobilePhoneTextField = new JFormattedTextField[3];
		public mobilePanel() {
			this.setLayout(null);
			this.setBackground(Setup.white);

			JLabel mobile_phone_number_1 = new JLabel("전화번호");
			mobile_phone_number_1.setFont(new Font(Setup.font, Font.BOLD, 16));
			mobile_phone_number_1.setBounds(12, 10, 88, 40);
			this.add(mobile_phone_number_1);

			for(int i = 0; i < 3; i++) {
				int limit = 4;
				if(i == 0) { limit = 3; }
				mobilePhoneTextField[i] = new onlyNumberTextField(22, 2, limit, "");
				mobilePhoneTextField[i].setFont(font[4]);
				mobilePhoneTextField[i].setColumns(10);
				mobilePhoneTextField[i].setBounds(mobileTextFieldx[i], 13, 110, 40);
				this.add(mobilePhoneTextField[i]);
			}
		}
	}

	public boolean isOpenCalendar() {
		return openCalendar;
	}

	public void setOpenCalendar(boolean f) {
		this.openCalendar = f;
	}
}