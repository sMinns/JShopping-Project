package gui.contents.main;

import custom.ButtonType1;
import custom.TextFieldType1;
import custom.onlyNumberTextField;
import event.SellerApplicationEvent;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class SellerApplication extends JPanel {
	private JTextField sellertextField, shoptextField, emailtextField;
	private JFormattedTextField phonetextField, phonetextField2, phonetextField3,
			businessnumtextField, businessnumtextField2, businessnumtextField3;
	private JButton sellerAppButton;
	JLabel sellerDesLabel, shopDesLabel, phoneDesLabel, emailDesLabel, businessnumDesLabel;
	public SellerApplication() {
		SellerApplicationEvent sellerApplicationEvent = new SellerApplicationEvent(this);
		this.setLayout(null);
			this.setBackground(Setup.bgLightGray);
		// 판매자명
			JPanel sellerName = new JPanel();
			sellerName.setBounds(278, 35, 407, 100);
			sellerName.setOpaque(false);
			sellerName.setLayout(null);
			this.add(sellerName);
	
			JLabel sellerLabel = new JLabel("판매자명");
			sellerLabel.setBounds(6, 15, 133, 15);
			sellerName.add(sellerLabel);
			sellerLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			sellerLabel.setForeground(Setup.darkGray);
	
			sellerDesLabel = new JLabel("* 필수 입력 정보입니다.");
			sellerDesLabel.setBounds(10, 80, 165, 15);
			sellerDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			sellerDesLabel.setForeground(Setup.magenta);
			sellerName.add(sellerDesLabel);
	
			sellertextField = new TextFieldType1(60, 2, "", 10);
			sellertextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			sellertextField.setBounds(0, 35, 407, 44);
			sellerName.add(sellertextField);
	
		// 상호 / 대표자
	
			JPanel shopName = new JPanel();
			shopName.setBounds(278, 135, 407, 100);
			shopName.setLayout(null);
			shopName.setOpaque(false);
			this.add(shopName);
	
			JLabel shopLabel = new JLabel("상호 / 대표자");
			shopLabel.setBounds(6, 15, 124, 15);
			shopLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			shopLabel.setForeground(Setup.darkGray);
			shopName.add(shopLabel);
	
			shopDesLabel = new JLabel("* 필수 입력 정보입니다.");
			shopDesLabel.setBounds(10, 80, 165, 15);
			shopDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			shopDesLabel.setForeground(Setup.magenta);
			shopName.add(shopDesLabel);
	
			shoptextField = new TextFieldType1(60, 2, "", 15);
			shoptextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			shoptextField.setBounds(0, 35, 407, 44);
			shopName.add(shoptextField);
	
		// 연락처
	
			JPanel phoneNumber = new JPanel();
			phoneNumber.setBounds(278, 235, 407, 100);
			phoneNumber.setLayout(null);
			phoneNumber.setOpaque(false);
			this.add(phoneNumber);
	
			JLabel phoneLabel = new JLabel("연락처");
			phoneLabel.setBounds(6, 15, 50, 15);
			phoneNumber.add(phoneLabel);
			phoneLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			phoneLabel.setForeground(Setup.darkGray);
	
			phoneDesLabel = new JLabel("* 필수 입력 정보입니다.");
			phoneDesLabel.setBounds(10, 80, 165, 15);
			phoneNumber.add(phoneDesLabel);
			phoneDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			phoneDesLabel.setForeground(Setup.magenta);
	
			phonetextField = new onlyNumberTextField(60, 2, 3, "");
			phonetextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			phonetextField.setBounds(0, 35, 112, 44);
			phoneNumber.add(phonetextField);

			phonetextField2 = new onlyNumberTextField(60, 2, 4, "");
			phonetextField2.setFont(new Font(Setup.font, Font.PLAIN, 12));
			phonetextField2.setBounds(147, 36, 112, 44);
			phoneNumber.add(phonetextField2);
	
			phonetextField3 = new onlyNumberTextField(60, 2, 4, "");
			phonetextField3.setFont(new Font(Setup.font, Font.PLAIN, 12));
			phonetextField3.setBounds(295, 36, 112, 44);
			phoneNumber.add(phonetextField3);
	
			JLabel phoneHyphen = new JLabel("-");
			phoneHyphen.setBounds(125, 50, 22, 15);
			phoneHyphen.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			phoneHyphen.setForeground(Setup.darkGray);
		phoneNumber.add(phoneHyphen);
	
			JLabel phonehyphen2 = new JLabel("-");
			phonehyphen2.setBounds(272, 50, 22, 15);
			phonehyphen2.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			phonehyphen2.setForeground(Setup.darkGray);
		phoneNumber.add(phonehyphen2);
	
		// 이메일
	
			JPanel email = new JPanel();
			email.setBounds(278, 335, 407, 100);
			email.setLayout(null);
			email.setOpaque(false);
			this.add(email);
	
			JLabel emailLabel = new JLabel("Email");
			emailLabel.setBounds(6, 15, 50, 15);
			emailLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			emailLabel.setForeground(Setup.darkGray);
		email.add(emailLabel);

			emailDesLabel = new JLabel("* 필수 입력 정보입니다.");
			emailDesLabel.setBounds(10, 80, 165, 15);
			email.add(emailDesLabel);
			emailDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			emailDesLabel.setForeground(Setup.magenta);
			emailtextField = new TextFieldType1(60, 2, "", 30);
			emailtextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			emailtextField.setBounds(0, 35, 407, 44);
			email.add(emailtextField);
	
		// 사업자 등록 번호
	
			JPanel businessnum = new JPanel();
			businessnum.setBounds(278, 435, 407, 100);
			businessnum.setLayout(null);
			businessnum.setOpaque(false);
			this.add(businessnum);
	
			JLabel businessnumLabel = new JLabel("사업자 등록 번호");
			businessnumLabel.setBounds(6, 15, 121, 15);
			businessnumLabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			businessnumLabel.setForeground(Setup.darkGray);
		businessnum.add(businessnumLabel);

			businessnumDesLabel = new JLabel("* 필수 입력 정보입니다.");
			businessnumDesLabel.setBounds(10, 80, 221, 15);
			businessnumDesLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			businessnumDesLabel.setForeground(Setup.magenta);
		businessnum.add(businessnumDesLabel);

			businessnumtextField = new onlyNumberTextField(60, 2, 3, "");
			businessnumtextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			businessnumtextField.setBounds(0, 35, 112, 44);
			businessnum.add(businessnumtextField);

			businessnumtextField2 = new onlyNumberTextField(60, 2, 3, "");
			businessnumtextField2.setFont(new Font(Setup.font, Font.PLAIN, 12));
			businessnumtextField2.setBounds(147, 36, 80, 44);
			businessnum.add(businessnumtextField2);

			businessnumtextField3 = new onlyNumberTextField(60, 2, 6, "");
			businessnumtextField3.setFont(new Font(Setup.font, Font.PLAIN, 12));
			businessnumtextField3.setBounds(261, 36, 146, 44);
			businessnum.add(businessnumtextField3);
	
			JLabel businessnumHyphen = new JLabel("-");
			businessnumHyphen.setBounds(125, 50, 22, 15);
			businessnumHyphen.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			businessnumHyphen.setForeground(Setup.darkGray);
		businessnum.add(businessnumHyphen);
	
			JLabel businessnumhyphen2 = new JLabel("-");
			businessnumhyphen2.setBounds(240, 50, 32, 15);
			businessnumhyphen2.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			businessnumhyphen2.setForeground(Setup.darkGray);
		businessnum.add(businessnumhyphen2);
	
		// 신청하기 버튼
	
			JPanel sellerAppButtonPanel = new JPanel();
			sellerAppButtonPanel.setBounds(278, 591, 407, 46);
			sellerAppButtonPanel.setOpaque(false);
			this.add(sellerAppButtonPanel);
	
			sellerAppButton = new ButtonType1(25, 7, 7, "신청하기", 16);
			sellerAppButton.addActionListener(sellerApplicationEvent);
			sellerAppButton.setFont(new Font(Setup.font, Font.BOLD, 16));
		sellerAppButtonPanel.add(sellerAppButton);
	
		// 신청서 확인 라벨
	
			JPanel joinPanel = new JPanel();
			joinPanel.setBounds(278, 558, 407, 23);
			joinPanel.setLayout(null);
			joinPanel.setOpaque(false);
			this.add(joinPanel);
	
			JLabel noAccLabel = new JLabel("신청서 내용을 확인하였으며, 정보 제공 등에 동의 합니다.");
			noAccLabel.setBounds(57, 10, 300, 15);
			joinPanel.add(noAccLabel);
			noAccLabel.setForeground(Setup.darkGray);
			noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));
	}

	public String getSellertextField() {
		return sellertextField.getText();
	}

	public void focusSellertextField() {
		sellertextField.requestFocus();
	}

	public String getShoptextField() {
		return shoptextField.getText();
	}

	public void focusShoptextField() {
		shoptextField.requestFocus();
	}

	public String getEmailtextField() {
		return emailtextField.getText();
	}

	public void focusEmailtextField() {
		emailtextField.requestFocus();
	}

	public String getPhonetextField() {
		return phonetextField.getText();
	}

	public void focusPhonetextField() {
		phonetextField.requestFocus();
	}

	public String getPhonetextField2() {
		return phonetextField2.getText();
	}

	public String getPhonetextField3() {
		return phonetextField3.getText();
	}

	public String getBusinessnumtextField() {
		return businessnumtextField.getText();
	}

	public void focusBusinessnumtextField() {
		businessnumtextField.requestFocus();
	}

	public String getBusinessnumtextField2() {
		return businessnumtextField2.getText();
	}

	public String getBusinessnumtextField3() {
		return businessnumtextField3.getText();
	}

	public JButton getSellerAppButton() {
		return sellerAppButton;
	}

	public void setSellerDesLabel(String text) {
		sellerDesLabel.setText(text);
	}

	public void setShopDesLabel(String text) {
		shopDesLabel.setText(text);
	}

	public void setPhoneDesLabel(String text) {
		phoneDesLabel.setText(text);
	}

	public void setEmailDesLabel(String text) {
		emailDesLabel.setText(text);
	}

	public void setBusinessnumDesLabel(String text) {
		businessnumDesLabel.setText(text);
	}
}
