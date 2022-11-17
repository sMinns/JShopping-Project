package gui.contents.main;

import custom.ButtonType1;
import custom.SearchBar;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class SellerManagement extends JPanel {
	private String[][] str = {
			{"123", "헤니스","김길동", "010-1234-1234", "g2g3234@naver.com", "110-21-12345"},
			{"543", "삼성전자", "기미김", "010-1234-1234", "ad1d125@naver.com", "054-971-8935"},
			{"654", "현대", "스이니", "010-1234-1234", "g54jh45@naver.com", "110-21-12345"},
			{"765", "도그아이", "지니디", "010-1234-1234", "k67l6l@naver.com", "054-971-8935"},
			{"373", "김치찌개", "키밈니", "010-1234-1234", "2n223@naver.com", "786-33-00664"},
			{"17683", "불닭볶음면", "히히리", "010-1234-1234", "rwreq355@naver.com", "786-33-00664"},
			{"765", "제육볶음", "기리리", "010-1234-1234", "yy4532@naver.com", "786-33-00664"},
			{"1345", "신라면", "홍김디", "010-1234-1234", "i67i7454@naver.com", "786-33-00664"},
			{"126", "오징어짬뽕", "김티니", "010-1234-1234", "23rqqq223@naver.com", "786-33-00664"},
			{"133", "레몬돈가스", "이름미", "010-1234-1234", "t43t43yq3@naver.com", "786-33-00664"},
			{"123", "", "에이프릴", "010-1234-1234", "m565m5@naver.com", "786-33-00664"},
			{"543", "베니즈", "기미김", "010-1234-1234", "z46z463@naver.com", "786-33-00664"},
			{"654", "푸르미", "스이니", "010-1234-1234", "m67m76m4@naver.com", "786-70-00335"},
			{"765", "딩동펫", "지니디", "010-1234-1234", "h534h3@naver.com", "786-70-00335"},
			{"373", "노마진", "키밈니", "1010-1234-1234", "m56m64@naver.com", "786-70-00335"},
			{"17683", "지앤비", "히히리", "010-1234-1234", "li44@naver.com", "786-70-00335"},
			{"765", "에티펫", "기리리", "010-1234-1234", "o4o4o9i@naver.com", "786-70-00335"},
			{"1345", "반려세상", "홍김디", "010-1234-1234", "lkjyk87k@naver.com", "786-70-00335"},
			{"126", "바잇미", "김티니", "010-1234-1234", "l0980990@naver.com", "786-70-00335"},
			{"133", "옥희독희", "이름미", "010-1234-1234", "k56k4@naver.com", "786-70-00335"}
	};
	private JPanel[] sellerPanels = new JPanel[str.length];
	private JLabel[][] sellerInfoLabel = new JLabel[str.length][7];
	private JLabel[] sellerTitleLabel = new JLabel[7];
	private String[] sellerTitletext = {"고객번호", "판매자명", "상호/대표자", "연락처", "이메일", "사업자등록번호", "관리"};
	private Font font1 = new Font(Setup.font, Font.BOLD, 16);
	private Font font2 = new Font(Setup.font, Font.BOLD, 14);
	public SellerManagement() {
		//SellerManagement Panel Layout
			GridBagLayout sellerPanelLayout = new GridBagLayout();
			sellerPanelLayout.columnWidths = new int[]{0, 0};
			sellerPanelLayout.rowHeights = new int[]{50, 30, 0, 0};
			sellerPanelLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			sellerPanelLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(sellerPanelLayout);

		//Seller SearchBar
			JPanel sellerSearchBarPanel = new JPanel();
			GridBagConstraints sellerBagCon = new GridBagConstraints();
			sellerBagCon.fill = GridBagConstraints.BOTH;
			this.add(sellerSearchBarPanel, sellerBagCon);
			sellerSearchBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			JPanel searchBarPanel = new SearchBar(50, 40, "판매자명 검색");
			sellerSearchBarPanel.add(searchBarPanel);

		//Seller Title
			JPanel sellerTitlePanel = new JPanel();
			sellerTitlePanel.setBackground(Setup.white);
			GridBagConstraints cmTitle = new GridBagConstraints();
			sellerBagCon.gridy = 1;
			sellerBagCon.insets = new Insets(0, 0, 1, 0);
			this.add(sellerTitlePanel, sellerBagCon);

			GridBagLayout sellerTitleLayout = new GridBagLayout();
			sellerTitleLayout.columnWidths = new int[]{70, 120, 90, 170, 240, 140, 130, 0};
			sellerTitleLayout.rowHeights = new int[]{0, 0};
			sellerTitleLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			sellerTitleLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			sellerTitlePanel.setLayout(sellerTitleLayout);

		//Title Text for loop
		for (int i = 0; i < sellerTitletext.length; i++) {
			sellerTitleLabel[i] = new JLabel(sellerTitletext[i]);
			sellerTitleLabel[i].setFont(font2);
			sellerTitlePanel.add(sellerTitleLabel[i]);
		}

		//SellerContent
			sellerBagCon.gridy = 2;
			sellerBagCon.insets = new Insets(0, 0, 0, 0);
			JPanel sellerContentPanel = new JPanel();
			sellerContentPanel.setLayout(new CardLayout());
			this.add(sellerContentPanel, sellerBagCon);

			JPanel sellerListPanel = new JPanel();
			sellerListPanel.setLayout(null);

		//SellerList ScrollPanel Setting
			JScrollPane sellerScrollPanel = new JScrollPane();
			sellerScrollPanel.setBorder(null);
			sellerContentPanel.add(sellerScrollPanel);
			Setup.changeScrollBar(sellerScrollPanel);
			sellerScrollPanel.setViewportView(sellerListPanel);

		//Seller List for loop
		for (int i = 0; i < str.length; i++) {
			sellerPanels[i] = new JPanel();
			sellerPanels[i].setBounds(0, i*40, 970, 40);
			if(i % 2 == 1) { sellerPanels[i].setBackground(Setup.white); }
			GridBagLayout sellerLayout = new GridBagLayout();
			sellerLayout.columnWidths = new int[]{70, 120, 90, 170, 240, 140, 130, 0};
			sellerLayout.rowHeights = new int[]{0, 0};
			sellerLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			sellerLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			sellerPanels[i].setLayout(sellerLayout);

			sellerListPanel.add(sellerPanels[i]);
			for (int j = 0; j < str[0].length+1; j++) {
				if(j == 6) {
					sellerPanels[i].add(new ButtonType1(22, 3,  5,"삭제", 12));
				}else {
					sellerInfoLabel[i][j] = new JLabel();
					sellerInfoLabel[i][j].setText(str[i][j]);
					sellerInfoLabel[i][j].setFont(font2);
					sellerPanels[i].add(sellerInfoLabel[i][j]);
				}
			}
		}
		//ScrollView Panel SizeSetting
		sellerListPanel.setPreferredSize(new Dimension(sellerListPanel.getWidth(),40*str.length));
	}
}
