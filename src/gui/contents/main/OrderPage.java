package gui.contents.main;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import gui.contents.sub.DesDateCalendar;
import system.Setup;
import custom.*;
import system.Setup;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import static javax.swing.JOptionPane.*;
public class OrderPage extends JPanel {
	private JPanel contentPane;
	private JTextField recipient_textField;
	private JTextField contact_textField_1;
	private JTextField address_textField_1;
	private JTextField address_textField_2;
	private JTextField shipping_Request_textField;
	private JTextField delivery_desired_date_textField;
	private JTextField card_number_textField_1;
	private JTextField expiration_date_textField_1;
	private JTextField cvc_number_textField;
	private JTextField card_number_textField_2;
	private JTextField card_number_textField_3;
	private JTextField card_number_textField_4;
	private JTextField expiration_date_textField_2;
	private JTextField password_textField;
	private JPanel order_list_main_panel;
	private JPanel shipping_information_panel;
	private JPanel delivery_title_panel;
	private JPanel delivery_panel;
	private JPanel payment_information_panel;
	private JPanel payment_method_panel;
	private JPanel final_payment_amount_title_panel;
	private JPanel final_payment_amount_panel_1;
	private JPanel final_payment_amount_panel_2;
	private JLabel agreement_text;
	private ButtonType1 agreement;
	private JLabel label7;
	private JPanel calender_panel;
	private JTextField contact_textField_2;
	private JTextField contact_textField_3;
	private DecimalFormat formatter = new DecimalFormat("###,###");
	private String[][] str = {
            {"/images/nullimage.png", "미즈노 신상 입고 정품 런닝화 축구화 모음전","가나다" , "0", "1", "422100"},
            {"/images/nullimage.png", "낫소 챔피언 축구화 아동 성인용 풋살화 축구화","나이키", "0", "1개", "123350"},
            {"/images/nullimage.png", "상품평3D 트리볼라 인체공학 디자인 축구화 풋살화 족구화","나이키", "3000", "1개", "45654"}
    };
    private String[] productTitleText = {" ", "상품정보", "판매자", "배송비", "수량", "상품금액"};
    private JScrollPane productScrollPanel;
	private TextFieldType1 TextField;
	private RadioType1 RadioButton;
    private JPanel[] productPanel = new JPanel[str.length];
    private JPanel[][] productInfoPanel = new JPanel[str.length][str[1].length];
    private JLabel[][] productInfoLabel = new JLabel[str.length][str[1].length];
    private JTextArea[] productNameTextArea = new JTextArea[str.length];
    private JLabel[] productTitleLabel = new JLabel[6];
    private JPanel selectPanel= null;
    private JLayeredPane detailPanel;
    private Font font1 = new Font(Setup.font, Font.BOLD, 16);
    private Font font2 = new Font(Setup.font, Font.BOLD, 12);
    private Font font3 = new Font(Setup.font, Font.PLAIN, 16);
    private Font font4 = new Font(Setup.font, Font.BOLD, 14);
	JPanel shipping_information_title_panel;
	JPanel oder_page_panel;
	JPanel paytype_panel;
	DesDateCalendar calender_main_panel;
	JPanel jp_label, jp_btn;
	JLabel label;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JButton btn ;
	int count =1;
	GridBagLayout Gbag = new GridBagLayout();
	GridBagConstraints gbc1;
	DecimalFormat decFormat = new DecimalFormat("###,###");
	
	public OrderPage() {
		//주문 / 결제 창
		setSize(new Dimension(975, 670));
		contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setLayout(null);
	  
		oder_page_panel = new JPanel();
		oder_page_panel.setBounds(0, 0, 189, 210);
		oder_page_panel.setPreferredSize(new Dimension(500, 1080+(str.length*91)));
		oder_page_panel.setVisible(true);
		oder_page_panel.setLayout(null);
		
		JScrollPane oder_page_scroll_panel = new JScrollPane(oder_page_panel);
        Setup.changeScrollBar(oder_page_scroll_panel);
		oder_page_scroll_panel.setLocation(0, 0);
		oder_page_scroll_panel.setSize(975, 670);
	    add(oder_page_scroll_panel, "pay");
		oder_page_panel.setLayout(null);
		//setUndecorated(true);
		
		calender_panel = new JPanel();
		calender_panel.setBounds(215, 414+(str.length*91), 189, 210);
		calender_panel.setPreferredSize(new Dimension(190, 210));
		oder_page_panel.add(calender_panel);
		calender_panel.setVisible(false);
		calender_panel.setLayout(null);
		
		/*
		calender_main_panel = new DesDateCalendar();
		calender_panel.add(calender_main_panel);
		calender_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calender_panel.setVisible(false);
			}
		});
		*/
		
		JPanel column_panel = new JPanel();
		column_panel.setBackground(new Color(255, 255, 255));
		column_panel.setBounds(63, 22, 823, 35);
		oder_page_panel.add(column_panel);
		column_panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("상품정보");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(font4);
		lblNewLabel_7.setBounds(150, 10, 57, 15);
		column_panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("배송비");
		lblNewLabel_7_1.setFont(font4);
		lblNewLabel_7_1.setBounds(502, 10, 57, 15);
		column_panel.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("수량");
		lblNewLabel_7_2.setFont(font4);
		lblNewLabel_7_2.setBounds(613, 10, 57, 15);
		column_panel.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("상품금액");
		lblNewLabel_7_3.setFont(font4);
		lblNewLabel_7_3.setBounds(720, 10, 57, 15);
		column_panel.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_4 = new JLabel("판매자");
		lblNewLabel_7_4.setFont(font4);
		lblNewLabel_7_4.setBounds(383, 10, 57, 15);
		column_panel.add(lblNewLabel_7_4);
		
		order_list_main_panel = new JPanel();
		order_list_main_panel.setBounds(61, 60, 825, (str.length*91));
		oder_page_panel.add(order_list_main_panel);
		order_list_main_panel.setLayout(null);
		
		//productListMainPanel
        JPanel order_list_sub_Panel = new JPanel();
        order_list_sub_Panel.setBounds(0, 0, 840, (str.length*90)+70);
        GridBagConstraints productBagCon = new GridBagConstraints();
        productBagCon.insets = new Insets(0, 0, 0, str.length);
        productBagCon.fill = GridBagConstraints.BOTH;
        setLayout(null);
        order_list_main_panel.add(order_list_sub_Panel);

        GridBagLayout gbl_order_list_sub_Panel = new GridBagLayout();
        gbl_order_list_sub_Panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_order_list_sub_Panel.rowHeights = new int[]{50, 25, 0, 0, 0, 0};
        gbl_order_list_sub_Panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_order_list_sub_Panel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        order_list_sub_Panel.setLayout(gbl_order_list_sub_Panel);

        //Product Scroll
        JScrollPane order_scroll_Panel = new JScrollPane();
        order_scroll_Panel.setBorder(null);
        Setup.changeScrollBar(order_scroll_Panel);

        GridBagConstraints gbc_order_scroll_Panel = new GridBagConstraints();
        gbc_order_scroll_Panel.fill = GridBagConstraints.BOTH;
        gbc_order_scroll_Panel.gridheight = str.length;
        gbc_order_scroll_Panel.gridwidth = 6;
        gbc_order_scroll_Panel.gridy = 0;
        order_list_sub_Panel.add(order_scroll_Panel, gbc_order_scroll_Panel);

        //Product List
        JPanel order_list_Panel = new JPanel();
        order_list_Panel.setLayout(null);
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
            productPanel[i].setBounds(0, i*90+i, 829, 90);

            GridBagConstraints productListBagCon = new GridBagConstraints();
            productListBagCon.fill = GridBagConstraints.BOTH;
            order_list_Panel.add(productPanel[i]);
            //addProductInfo
            addProductInfo(i, productListBagCon);
        }
        order_scroll_Panel.setViewportView(order_list_Panel);
        order_list_Panel.setPreferredSize(new Dimension(order_list_Panel.getWidth(),91*str.length-1));
		
		shipping_information_title_panel = new JPanel();
		shipping_information_title_panel.setLayout(null);
		shipping_information_title_panel.setBackground(Color.WHITE);
		shipping_information_title_panel.setBounds(63, 65+(str.length*91), 823, 40);
		oder_page_panel.add(shipping_information_title_panel);
		
		JLabel shipping_information_title = new JLabel("배송지 정보");
		shipping_information_title.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		shipping_information_title.setBounds(12, 0, 119, 38);
		shipping_information_title_panel.add(shipping_information_title);
		
		shipping_information_panel = new JPanel();
		shipping_information_panel.setBounds(63, 107+(str.length*91), 823, 162);
		oder_page_panel.add(shipping_information_panel);
		shipping_information_panel.setLayout(null);
		shipping_information_panel.setBackground(Color.WHITE);
		
		JLabel recipient = new JLabel("받으시는분");
		recipient.setFont(font1);
		recipient.setBounds(12, 12, 88, 32);
		shipping_information_panel.add(recipient);
		
		JLabel contact = new JLabel("연락처");
		contact.setFont(font1);
		contact.setBounds(12, 61, 88, 28);
		shipping_information_panel.add(contact);
		
		JLabel address = new JLabel("주소");
		address.setFont(font1);
		address.setBounds(12, 110, 88, 28);
		shipping_information_panel.add(address);
		
		recipient_textField = new TextFieldType1(22, 2, "",20);
		recipient_textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		recipient_textField.setColumns(10);
		recipient_textField.setBounds(151, 13, 631, 40);
		shipping_information_panel.add(recipient_textField);
		
		contact_textField_1 = new TextFieldType1(22, 2, "",3);
		contact_textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contact_textField_1.setColumns(10);
		contact_textField_1.setBounds(151, 59, 110, 40);
		shipping_information_panel.add(contact_textField_1);
		
		contact_textField_2 = new TextFieldType1(22, 2, "",4);
		contact_textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contact_textField_2.setColumns(10);
		contact_textField_2.setBounds(273, 59, 110, 40);
		shipping_information_panel.add(contact_textField_2);
		
		contact_textField_3 = new TextFieldType1(22, 2, "",4);
		contact_textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contact_textField_3.setColumns(10);
		contact_textField_3.setBounds(395, 59, 110, 40);
		shipping_information_panel.add(contact_textField_3);
		
		address_textField_1 = new TextFieldType1(22, 2, "",50);
		address_textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		address_textField_1.setColumns(10);
		address_textField_1.setBounds(151, 106, 320, 40);
		shipping_information_panel.add(address_textField_1);
		
		address_textField_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//주소검색창
			}
		});
		
		address_textField_2 = new TextFieldType1(22, 2, "",50);
		address_textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		address_textField_2.setColumns(10);
		address_textField_2.setBounds(476, 106, 306, 40);
		shipping_information_panel.add(address_textField_2);
		
		delivery_title_panel = new JPanel();
		delivery_title_panel.setLayout(null);
		delivery_title_panel.setBackground(Color.WHITE);
		delivery_title_panel.setBounds(63, 273+(str.length*91), 823, 40);
		oder_page_panel.add(delivery_title_panel);
		
		JLabel delivery_title = new JLabel("배송");
		delivery_title.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		delivery_title.setBounds(12, 0, 119, 38);
		delivery_title_panel.add(delivery_title);
		
		delivery_panel = new JPanel();
		delivery_panel.setLayout(null);
		delivery_panel.setBackground(Color.WHITE);
		delivery_panel.setBounds(63, 315+(str.length*91), 823, 114);
		oder_page_panel.add(delivery_panel);
		
		JLabel delivery_Request_text = new JLabel("배송요청사항");
		delivery_Request_text.setFont(font1);
		delivery_Request_text.setBounds(12, 13, 120, 40);
		delivery_panel.add(delivery_Request_text);
		
		JLabel delivery_desired_date_text = new JLabel("배송 희망일");
		delivery_desired_date_text.setFont(font1);
		delivery_desired_date_text.setBounds(12, 63, 132, 38);
		delivery_panel.add(delivery_desired_date_text);
		
		shipping_Request_textField = new TextFieldType1(22, 2, "",50);
		shipping_Request_textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		shipping_Request_textField.setColumns(10);
		shipping_Request_textField.setBounds(151, 13, 631, 40);
		delivery_panel.add(shipping_Request_textField);
		
		delivery_desired_date_textField = new TextFieldType1(22, 2, "",10);
		delivery_desired_date_textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		delivery_desired_date_textField.setColumns(10);
		delivery_desired_date_textField.setBounds(151, 61, 144, 40);
		delivery_panel.add(delivery_desired_date_textField);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_8.setIcon(new ImageIcon(OrderPage.class.getResource("/images/calendar.png")));
		lblNewLabel_8.setBounds(300, 63, 24, 38);
		delivery_panel.add(lblNewLabel_8);
		
		payment_information_panel = new JPanel();
		payment_information_panel.setLayout(null);
		payment_information_panel.setBackground(Color.WHITE);
		payment_information_panel.setBounds(63, 433+(str.length*91), 823, 40);
		oder_page_panel.add(payment_information_panel);
		
		JLabel payment_information = new JLabel("결제 정보");
		payment_information.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		payment_information.setBounds(12, 0, 119, 38);
		payment_information_panel.add(payment_information);
		
		payment_method_panel = new JPanel();
		payment_method_panel.setLayout(null);
		payment_method_panel.setBackground(Color.WHITE);
		payment_method_panel.setBounds(63, 474+(str.length*91), 823, 40);
		oder_page_panel.add(payment_method_panel);
		
		JLabel payment_method_text = new JLabel("결제 방법");
		payment_method_text.setFont(font1);
		payment_method_text.setBounds(12, 0, 82, 34);
		payment_method_panel.add(payment_method_text);
		
		paytype_panel = new JPanel();
		paytype_panel.setBackground(Color.WHITE);
		paytype_panel.setBounds(63, 515+(str.length*91), 823, 205);
		oder_page_panel.add(paytype_panel);
		paytype_panel.setLayout(new CardLayout(0, 0));
		CardLayout cl_paytype_panel = (CardLayout) paytype_panel.getLayout();
		
		JRadioButton credit_card_RadioButton = new RadioType1("신용카드",font2);
		credit_card_RadioButton.setSelected(true);
		credit_card_RadioButton.setBackground(new Color(255, 255, 255));
		credit_card_RadioButton.setBounds(157, -2, 82, 40);
		payment_method_panel.add(credit_card_RadioButton);
		credit_card_RadioButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cl_paytype_panel.show(paytype_panel,"card");
			}
		});
		
		RadioType1 mobile_phone_payment_RadioButton = new RadioType1("휴대폰 결제", new Font("맑은 고딕", Font.BOLD, 12));
        mobile_phone_payment_RadioButton.setBackground(Color.WHITE);
        mobile_phone_payment_RadioButton.setBounds(318, -2, 121, 40);
        payment_method_panel.add(mobile_phone_payment_RadioButton);
        mobile_phone_payment_RadioButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cl_paytype_panel.show(paytype_panel,"pone");
			}
		});
		
		ButtonGroup groupRd = new ButtonGroup();
		groupRd.add(credit_card_RadioButton);
        groupRd.add(mobile_phone_payment_RadioButton);
        
		JPanel credit_card_panel = new JPanel();
		paytype_panel.add(credit_card_panel, "card");
		credit_card_panel.setLayout(null);
		credit_card_panel.setBackground(Color.WHITE);
		
		JLabel card_number_text = new JLabel("카드번호");
		card_number_text.setFont(font1);
		card_number_text.setBounds(12, 10, 88, 40);
		credit_card_panel.add(card_number_text);
		
		JLabel expiration_date_text = new JLabel("유효기간");
		expiration_date_text.setFont(font1);
		expiration_date_text.setBounds(12, 65, 88, 28);
		credit_card_panel.add(expiration_date_text);
		
		JLabel cvc_number_text = new JLabel("CVC번호");
		cvc_number_text.setFont(font1);
		cvc_number_text.setBounds(12, 107, 88, 28);
		credit_card_panel.add(cvc_number_text);
		
		JLabel password_text = new JLabel("비밀번호");
		password_text.setFont(font1);
		password_text.setBounds(12, 155, 88, 28);
		credit_card_panel.add(password_text);
		
		card_number_textField_1 = new TextFieldType1(22, 2, "",4);
		card_number_textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		card_number_textField_1.setColumns(10);
		card_number_textField_1.setBounds(151, 13, 103, 40);
		credit_card_panel.add(card_number_textField_1);
		
		card_number_textField_2 = new TextFieldType1(22, 2, "",4);
		card_number_textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		card_number_textField_2.setColumns(10);
		card_number_textField_2.setBounds(258, 13, 103, 40);
		credit_card_panel.add(card_number_textField_2);
		
		card_number_textField_3 = new TextFieldType1(22, 2, "",4);
		card_number_textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		card_number_textField_3.setColumns(10);
		card_number_textField_3.setBounds(365, 13, 103, 40);
		credit_card_panel.add(card_number_textField_3);
		
		card_number_textField_4 = new TextFieldType1(22, 2, "",4);
		card_number_textField_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		card_number_textField_4.setColumns(10);
		card_number_textField_4.setBounds(473, 13, 103, 40);
		credit_card_panel.add(card_number_textField_4);
		
		expiration_date_textField_1 = new TextFieldType1(22, 2, "",2);
		expiration_date_textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		expiration_date_textField_1.setColumns(10);
		expiration_date_textField_1.setBounds(151, 59, 103, 40);
		credit_card_panel.add(expiration_date_textField_1);
		
		JLabel mounth = new JLabel("월");
		mounth.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mounth.setBounds(258, 73, 18, 15);
		credit_card_panel.add(mounth);
		
		expiration_date_textField_2 = new TextFieldType1(22, 2, "",2);
		expiration_date_textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		expiration_date_textField_2.setColumns(10);
		expiration_date_textField_2.setBounds(278, 59, 103, 40);
		credit_card_panel.add(expiration_date_textField_2);
		
		JLabel year = new JLabel("년");
		year.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		year.setBounds(387, 73, 18, 15);
		credit_card_panel.add(year);
		
		cvc_number_textField = new TextFieldType1(22, 2, "",3);
		cvc_number_textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cvc_number_textField.setColumns(10);
		cvc_number_textField.setBounds(151, 105, 103, 40);
		credit_card_panel.add(cvc_number_textField);
		
		JLabel three_digits = new JLabel("3자리");
		three_digits.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		three_digits.setBounds(258, 120, 103, 15);
		credit_card_panel.add(three_digits);
		
		password_textField = new TextFieldType1(22, 2, "",6);
		password_textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		password_textField.setColumns(10);
		password_textField.setBounds(151, 153, 103, 40);
		credit_card_panel.add(password_textField);
		
		JLabel first_two_digits = new JLabel("앞의 2자리 수");
		first_two_digits.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		first_two_digits.setBounds(258, 168, 103, 15);
		credit_card_panel.add(first_two_digits);
		
		JPanel mobile_phone_payment_panel = new JPanel();
		mobile_phone_payment_panel.setLayout(null);
		mobile_phone_payment_panel.setBackground(Color.WHITE);
		paytype_panel.add(mobile_phone_payment_panel, "pone");
		
		JLabel mobile_phone_number_1 = new JLabel("전화번호");
		mobile_phone_number_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		mobile_phone_number_1.setBounds(12, 10, 88, 32);
		mobile_phone_payment_panel.add(mobile_phone_number_1);
		
		TextFieldType1 mobile_phone_number_textField_1_1 = new TextFieldType1(22, 2, "",3);
		mobile_phone_number_textField_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mobile_phone_number_textField_1_1.setColumns(10);
		mobile_phone_number_textField_1_1.setBounds(151, 13, 103, 40);
		mobile_phone_payment_panel.add(mobile_phone_number_textField_1_1);
		
		JLabel middle_characters_1_1 = new JLabel("-");
		middle_characters_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		middle_characters_1_1.setBounds(259, 20, 15, 15);
		mobile_phone_payment_panel.add(middle_characters_1_1);
		
		TextFieldType1 mobile_phone_number_textField_2_1 = new TextFieldType1(22, 2, "",4);
		mobile_phone_number_textField_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mobile_phone_number_textField_2_1.setColumns(10);
		mobile_phone_number_textField_2_1.setBounds(272, 13, 103, 40);
		mobile_phone_payment_panel.add(mobile_phone_number_textField_2_1);
		
		JLabel middle_characters_2_1 = new JLabel("-");
		middle_characters_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		middle_characters_2_1.setBounds(380, 20, 15, 15);
		mobile_phone_payment_panel.add(middle_characters_2_1);
		
		TextFieldType1 mobile_phone_number_textField_3_1 = new TextFieldType1(22, 2, "",4);
		mobile_phone_number_textField_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mobile_phone_number_textField_3_1.setColumns(10);
		mobile_phone_number_textField_3_1.setBounds(393, 12, 103, 40);
		mobile_phone_payment_panel.add(mobile_phone_number_textField_3_1);
		
		final_payment_amount_title_panel = new JPanel();
		final_payment_amount_title_panel.setLayout(null);
		final_payment_amount_title_panel.setBackground(Color.WHITE);
		final_payment_amount_title_panel.setBounds(63, 724+(str.length*91), 823, 40);
		oder_page_panel.add(final_payment_amount_title_panel);
		
		JLabel final_payment_amount_title = new JLabel("최종 결제 금액");
		final_payment_amount_title.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		final_payment_amount_title.setBounds(12, 0, 170, 38);
		final_payment_amount_title_panel.add(final_payment_amount_title);
		
		final_payment_amount_panel_1 = new JPanel();
		final_payment_amount_panel_1.setLayout(null);
		final_payment_amount_panel_1.setBackground(Color.WHITE);
		final_payment_amount_panel_1.setBounds(63, 765+(str.length*91), 823, 72);
		oder_page_panel.add(final_payment_amount_panel_1);
		
		JLabel delivery_charge_text = new JLabel("배송비");
		delivery_charge_text.setFont(font1);
		delivery_charge_text.setBounds(12, 39, 92, 28);
		final_payment_amount_panel_1.add(delivery_charge_text);
		
		JLabel final_payment_amount_text_1 = new JLabel("총 상품 가격");
		final_payment_amount_text_1.setFont(font1);
		final_payment_amount_text_1.setBounds(12, 10, 92, 32);
		final_payment_amount_panel_1.add(final_payment_amount_text_1);
		
		int sumprice1 = 0;
		for(int i = 0; i < str.length; i++) {
			sumprice1 += Integer.parseInt(str[i][5]);
		}
		
		int sumprice2 = 0;
		for(int i = 0; i < str.length; i++) {
			sumprice2 += Integer.parseInt(str[i][3]);
		}
		
		int sumprice3 = sumprice1 + sumprice2;
		
		JLabel final_payment_amount_number_1 = new JLabel(formatter.format(sumprice1)+"원");
		final_payment_amount_number_1.setHorizontalAlignment(SwingConstants.RIGHT);
		final_payment_amount_number_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		final_payment_amount_number_1.setBounds(112, 15, 109, 23);
		final_payment_amount_panel_1.add(final_payment_amount_number_1);
		
		JLabel delivery_charge_number = new JLabel(formatter.format(sumprice2)+"원");
		delivery_charge_number.setHorizontalAlignment(SwingConstants.RIGHT);
		delivery_charge_number.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		delivery_charge_number.setBounds(112, 44, 109, 20);
		final_payment_amount_panel_1.add(delivery_charge_number);
		
		final_payment_amount_panel_2 = new JPanel();
		final_payment_amount_panel_2.setLayout(null);
		final_payment_amount_panel_2.setBackground(Color.WHITE);
		final_payment_amount_panel_2.setBounds(63, 838+(str.length*91), 823, 48);
		oder_page_panel.add(final_payment_amount_panel_2);
		
		JLabel final_payment_amount_text_2 = new JLabel("총 상품 가격");
		final_payment_amount_text_2.setFont(font1);
		final_payment_amount_text_2.setBounds(12, 0, 92, 48);
		final_payment_amount_panel_2.add(final_payment_amount_text_2);
		
		JLabel final_payment_amount_number_2 = new JLabel(formatter.format(sumprice3)+"원");
		final_payment_amount_number_2.setHorizontalAlignment(SwingConstants.RIGHT);
		final_payment_amount_number_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		final_payment_amount_number_2.setBounds(112, 0, 109, 48);
		final_payment_amount_panel_2.add(final_payment_amount_number_2);
		
		agreement_text = new JLabel("주문 내용을 확인하였으며, 정보 제공 등에 동의합니다.");
		agreement_text.setHorizontalAlignment(SwingConstants.CENTER);
		agreement_text.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		agreement_text.setBounds(63, 935+(str.length*91), 823, 23);
		oder_page_panel.add(agreement_text);

		agreement = new ButtonType1(22, 2, 2, "확인", 12);
		agreement.setFont(font1);
		agreement.setText("확인");
		agreement.setBounds(352, 968+(str.length*91), 232, 50);
		oder_page_panel.add(agreement);
		
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calender_panel.setVisible(true);
			}
		});
	}
	
	public void addProductInfo(int i, GridBagConstraints productListBagCon) {
        for(int j = 0; j < str[i].length; j++ ) {
            FlowLayout layout = new FlowLayout(1, 3, 32);
            productInfoPanel[i][j] = new JPanel();
            productInfoPanel[i][j].setBackground(Setup.white);
            this.productPanel[i].add(productInfoPanel[i][j], productListBagCon);
            productInfoLabel[i][j] = new JLabel();
            productInfoLabel[i][j].setFont(font3);
            
            if(j != 1) {
            	//showMessageDialog(null,str[i][1]);
                if(j == 0) {
                    layout.setVgap(5);
                    productInfoLabel[i][j].setIcon(Setup.imageSetSize(
                            new ImageIcon(OrderPage.class.getResource(str[i][0])),80,80));     
                }else if(j == 2) {
                    productInfoLabel[i][j].setText(str[i][j]);
                }else if(j == 3) {
                	if(Integer.parseInt(str[i][j])==0) {
                		productInfoLabel[i][j].setText("무료");
                	}else {
                		String text = formatter.format(Integer.parseInt(str[i][j]));
                		productInfoLabel[i][j].setText(text + "원");
                	}
                }else if(j == 4) {
                    productInfoLabel[i][j].setText(str[i][j]);
                }else if(j == 5) {
                	String text = formatter.format(Integer.parseInt(str[i][j]));
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
                productNameTextArea[i].setFont(font1);
                productInfoPanel[i][j].add(productNameTextArea[i], gbc);
            }
        }
	}
}