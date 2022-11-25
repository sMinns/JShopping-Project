package gui.contents.main;

import custom.ButtonType1;
import custom.TextFieldType1;
import custom.onlyNumberTextField;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class SellerApplication extends JPanel {

	public SellerApplication() {
			this.setLayout(null);

		// 판매자명
			JPanel sellerName = new JPanel();
			sellerName.setBounds(278, 35, 407, 100);
			this.add(sellerName);
			sellerName.setLayout(null);
	
			JLabel sellerlabel = new JLabel("판매자명");
			sellerlabel.setBounds(6, 15, 133, 15);
			sellerName.add(sellerlabel);
			sellerlabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			sellerlabel.setForeground(Setup.darkGray);
	
			JLabel sellerDeslabel = new JLabel("* 판매자명을 입력해주세요.");
			sellerDeslabel.setBounds(10, 80, 165, 15);
			sellerName.add(sellerDeslabel);
			sellerDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			sellerDeslabel.setForeground(Setup.magenta);
	
			JTextField sellertextField = new TextFieldType1(60, 2, "", 10);
			sellertextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			;
			sellertextField.setBounds(0, 35, 407, 44);
			sellerName.add(sellertextField);
	
		// 상호 / 대표자
	
			JPanel shopName = new JPanel();
			shopName.setBounds(278, 135, 407, 100);
			this.add(shopName);
			shopName.setLayout(null);
	
			JLabel shoplabel = new JLabel("상호 / 대표자");
			shoplabel.setBounds(6, 15, 124, 15);
			shopName.add(shoplabel);
			shoplabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			shoplabel.setForeground(Setup.darkGray);
	
			JLabel shopDeslabel = new JLabel("* 상호 / 대표자를 입력해주세요.");
			shopDeslabel.setBounds(10, 80, 165, 15);
			shopName.add(shopDeslabel);
			shopDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			shopDeslabel.setForeground(Setup.magenta);
	
			JTextField shoptextField = new TextFieldType1(60, 2, "", 15);
			shoptextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			;
			shoptextField.setBounds(0, 35, 407, 44);
			shopName.add(shoptextField);
	
		// 연락처
	
			JPanel phoneNumber;
			phoneNumber = new JPanel();
			phoneNumber.setBounds(278, 235, 407, 100);
			this.add(phoneNumber);
			phoneNumber.setLayout(null);
	
			JLabel phonelabel;
			phonelabel = new JLabel("연락처");
			phonelabel.setBounds(6, 15, 50, 15);
			phoneNumber.add(phonelabel);
			phonelabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			phonelabel.setForeground(Setup.darkGray);
	
			JLabel phoneDeslabel;
			phoneDeslabel = new JLabel("* 연락처를 입력해주세요.");
			phoneDeslabel.setBounds(10, 80, 165, 15);
			phoneNumber.add(phoneDeslabel);
			phoneDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			phoneDeslabel.setForeground(Setup.magenta);
	
			JFormattedTextField phonetextField = new onlyNumberTextField(60, 2, 3, "");
			phonetextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			;
			phonetextField.setBounds(147, 36, 112, 44);
			phoneNumber.add(phonetextField);

		JFormattedTextField phonetextField2 = new onlyNumberTextField(60, 2, 4, "");
			phonetextField2.setFont(new Font(Setup.font, Font.PLAIN, 12));
			;
			phonetextField2.setBounds(295, 36, 112, 44);
			phoneNumber.add(phonetextField2);
	
			JFormattedTextField phonetextField3 = new onlyNumberTextField(60, 2, 4, "");
			phonetextField3.setFont(new Font(Setup.font, Font.PLAIN, 12));
			;
			phonetextField3.setBounds(0, 35, 112, 44);
			phoneNumber.add(phonetextField3);
	
			JLabel phoneHyphen = new JLabel("-");
			phoneHyphen.setBounds(125, 50, 22, 15);
			phoneNumber.add(phoneHyphen);
			phoneHyphen.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			phoneHyphen.setForeground(Setup.darkGray);
	
			JLabel phonehyphen2 = new JLabel("-");
			phonehyphen2.setBounds(272, 50, 22, 15);
			phoneNumber.add(phonehyphen2);
			phonehyphen2.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			phonehyphen2.setForeground(Setup.darkGray);
	
		// 이메일
	
			JPanel email;
			email = new JPanel();
			email.setBounds(278, 335, 407, 100);
			this.add(email);
			email.setLayout(null);
	
			JLabel emaillabel;
			emaillabel = new JLabel("Email");
			emaillabel.setBounds(6, 15, 50, 15);
			email.add(emaillabel);
			emaillabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			emaillabel.setForeground(Setup.darkGray);
			JLabel emailDeslabel;
			emailDeslabel = new JLabel("* 이메일을 입력해주세요.");
			emailDeslabel.setBounds(10, 80, 165, 15);
			email.add(emailDeslabel);
			emailDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			emailDeslabel.setForeground(Setup.magenta);
			JTextField emailtextField;
			emailtextField = new TextFieldType1(60, 2, "", 30);
			emailtextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			emailtextField.setBounds(0, 35, 407, 44);
			email.add(emailtextField);
	
		// 사업자 등록 번호
	
			JPanel businessnum;
			businessnum = new JPanel();
			businessnum.setBounds(278, 435, 407, 100);
			this.add(businessnum);
			businessnum.setLayout(null);
	
			JLabel businessnumlabel;
			businessnumlabel = new JLabel("사업자 등록 번호");
			businessnumlabel.setBounds(6, 15, 121, 15);
			businessnum.add(businessnumlabel);
			businessnumlabel.setFont(new Font(Setup.font, Font.BOLD, 14));
			businessnumlabel.setForeground(Setup.darkGray);
	
			JLabel businessnumDeslabel;
			businessnumDeslabel = new JLabel("* 사업자 등록 번호를 입력해주세요.");
			businessnumDeslabel.setBounds(10, 80, 221, 15);
			businessnum.add(businessnumDeslabel);
			businessnumDeslabel.setFont(new Font(Setup.font, Font.BOLD, 11));
			businessnumDeslabel.setForeground(Setup.magenta);

			JFormattedTextField businessnumtextField = new onlyNumberTextField(60, 2, 3, "");
			businessnumtextField.setFont(new Font(Setup.font, Font.PLAIN, 12));
			businessnumtextField.setBounds(0, 35, 112, 44);
			businessnum.add(businessnumtextField);

			JFormattedTextField businessnumtextField2 = new onlyNumberTextField(60, 2, 3, "");
			businessnumtextField2.setFont(new Font(Setup.font, Font.PLAIN, 12));
			businessnumtextField2.setBounds(147, 36, 80, 44);
			businessnum.add(businessnumtextField2);

			JFormattedTextField businessnumtextField3 = new onlyNumberTextField(60, 2, 6, "");
			businessnumtextField3.setFont(new Font(Setup.font, Font.PLAIN, 12));
			businessnumtextField3.setBounds(261, 36, 146, 44);
			businessnum.add(businessnumtextField3);
	
			JLabel businessnumHyphen = new JLabel("-");
			businessnumHyphen.setBounds(125, 50, 22, 15);
			businessnum.add(businessnumHyphen);
			businessnumHyphen.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			businessnumHyphen.setForeground(Setup.darkGray);
	
			JLabel businessnumhyphen2 = new JLabel("-");
			businessnumhyphen2.setBounds(240, 50, 32, 15);
			businessnum.add(businessnumhyphen2);
			businessnumhyphen2.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
			businessnumhyphen2.setForeground(Setup.darkGray);
	
		// 신청하기 버튼
	
			JPanel sellerbtnPanel = new JPanel();
			sellerbtnPanel.setBounds(278, 591, 407, 46);
			this.add(sellerbtnPanel);
	
			JButton sellerFindBtn = new ButtonType1(25, 7, 7, "신청하기", 16);
			sellerbtnPanel.add(sellerFindBtn);
			sellerFindBtn.setFont(new Font(Setup.font, Font.BOLD, 16));
	
		// 신청서 확인 라벨
	
			JPanel joinPanel = new JPanel();
			joinPanel.setBounds(278, 558, 407, 23);
			this.add(joinPanel);
			joinPanel.setLayout(null);
	
			JLabel noAccLabel = new JLabel("신청서 내용을 확인하였으며, 정보 제공 등에 동의 합니다.");
			noAccLabel.setBounds(57, 10, 300, 15);
			joinPanel.add(noAccLabel);
			noAccLabel.setForeground(Setup.darkGray);
			noAccLabel.setFont(new Font(Setup.font, Font.BOLD, 11));

	}
}
