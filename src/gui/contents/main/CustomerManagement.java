package gui.contents.main;

import custom.ButtonType1;
import custom.SearchBar;
import system.Setup;

import javax.swing.*;
import java.awt.*;

public class CustomerManagement extends JPanel {
	private String[][] str = {
			{"123", "asd24312", "가나다라마", "김길동", "1999. 10. 05", "g2g3234@naver.com", "2022. 11. 01"},
	{"543", "fdgdf4553", "fdgdf4553", "기미김", "2000. 11. 23", "ad1d125@naver.com", "2022. 11. 01"},
	{"654", "kjhhm24312", "kjhhm24312", "스이니", "2011. 03. 25", "g54jh45@naver.com", "2022. 11. 01"},
	{"765", "ahgfnmd765", "ahgfnmd765", "지니디", "2661. 05. 21", "k67l6l@naver.com", "2022. 11. 01"},
	{"373", "jhgj46", "jhgj46", "키밈니", "1962. 07. 21", "2n223@naver.com", "2022. 11. 01"},
	{"17683", "nfgn12", "김치지디", "히히리", "1976. 04. 21", "rwreq355@naver.com", "2022. 11. 01"},
	{"765", "asdn412", "기미미니", "기리리", "1987. 02. 12", "yy4532@naver.com", "2022. 11. 01"},
	{"1345", "ak6k4312", "라마", "홍김디", "1936. 12. 31", "i67i7454@naver.com", "2022. 11. 01"},
	{"126", "a43hh312", "a43hh312", "김티니", "2001. 04. 01", "23rqqq223@naver.com", "2022. 11. 01"},
	{"133", "456hh12", "456hh12", "이름미", "2020. 05. 23", "t43t43yq3@naver.com", "2022. 11. 01"},
	{"123", "asd24312", "가나다라마", "김길동", "1999. 10. 05", "m565m5@naver.com", "2022. 11. 01"},
	{"543", "fdgdf4553", "fdgdf4553", "기미김", "2000. 11. 23", "z46z463@naver.com", "2022. 11. 01"},
	{"654", "kjhhm24312", "kjhhm24312", "스이니", "2011. 03. 25", "m67m76m4@naver.com", "2022. 11. 01"},
	{"765", "ahgfnmd765", "ahgfnmd765", "지니디", "2661. 05. 21", "h534h3@naver.com", "2022. 11. 01"},
	{"373", "jhgj46", "jhgj46", "키밈니", "1962. 07. 21", "m56m64@naver.com", "2022. 11. 01"},
	{"17683", "nfgn12", "김치지디", "히히리", "1976. 04. 21", "li44@naver.com", "2022. 11. 01"},
	{"765", "asdn412", "기미미니", "기리리", "1987. 02. 12", "o4o4o9i@naver.com", "2022. 11. 01"},
	{"1345", "ak6k4312", "라마", "홍김디", "1936. 12. 31", "lkjyk87k@naver.com", "2022. 11. 01"},
	{"126", "a43hh312", "a43hh312", "김티니", "2001. 04. 01", "l0980990@naver.com", "2022. 11. 01"},
	{"133", "456hh12", "456hh12", "이름미", "2020. 05. 23", "k56k4@naver.com", "2022. 11. 01"}
	};
	private JPanel[] customerPanels = new JPanel[str.length];
	private JLabel[][] customerInfoLabel = new JLabel[str.length][8];
	private JLabel[] cmTitleLabel = new JLabel[8];
	private String[] cmTitletext = {"고객번호", "아이디", "닉네임", "이름", "생년월일", "이메일", "가입일자", "관리"};
	private Font font1 = new Font(Setup.font, Font.BOLD, 16);
	private Font font2 = new Font(Setup.font, Font.BOLD, 14);
	public CustomerManagement() {
		//CustomerManagement Panel Layout
			GridBagLayout cmMainPanelLayout = new GridBagLayout();
			cmMainPanelLayout.columnWidths = new int[]{0, 0};
			cmMainPanelLayout.rowHeights = new int[]{50, 30, 0, 0};
			cmMainPanelLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			cmMainPanelLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.setLayout(cmMainPanelLayout);

		//CustomerSearchBar
			JPanel cmSearchBarPanel = new JPanel();
			GridBagConstraints cmBagCon = new GridBagConstraints();
			cmBagCon.fill = GridBagConstraints.BOTH;
			this.add(cmSearchBarPanel, cmBagCon);
			cmSearchBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			JPanel searchBarPanel = new SearchBar(50, 40, "고객번호, 아이디, 이름 검색");
			cmSearchBarPanel.add(searchBarPanel);

		//CustomerTitle
			JPanel cmTitlePanel = new JPanel();
			cmTitlePanel.setBackground(Setup.white);
			GridBagConstraints cmTitle = new GridBagConstraints();
			cmBagCon.gridy = 1;
			cmBagCon.insets = new Insets(0, 0, 1, 0);
			this.add(cmTitlePanel, cmBagCon);

			GridBagLayout cmTitleLayout = new GridBagLayout();
			cmTitleLayout.columnWidths = new int[]{80, 120, 120, 100, 100, 220, 80, 100, 7};
			cmTitleLayout.rowHeights = new int[]{0, 0};
			cmTitleLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			cmTitleLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			cmTitlePanel.setLayout(cmTitleLayout);

			//Title Text for loop
				for (int i = 0; i < cmTitletext.length; i++) {
					cmTitleLabel[i] = new JLabel(cmTitletext[i]);
					cmTitleLabel[i].setFont(font2);
					cmTitlePanel.add(cmTitleLabel[i]);
				}

		//CustomerContent
		cmBagCon.gridy = 2;
		JPanel customerContentPanel = new JPanel();
		customerContentPanel.setLayout(new CardLayout());
		this.add(customerContentPanel, cmBagCon);

		JPanel customerListPanel = new JPanel();
		customerListPanel.setLayout(null);

		//CustomerList ScrollPanel Setting
			JScrollPane customerScrollPanel = new JScrollPane();
			customerScrollPanel.setBorder(null);
			customerContentPanel.add(customerScrollPanel);
			Setup.changeScrollBar(customerScrollPanel);
			customerScrollPanel.setViewportView(customerListPanel);

		//Customer List for loop
			for (int i = 0; i < str.length; i++) {
				customerPanels[i] = new JPanel();
				customerPanels[i].setBounds(0, i*40, 970, 40);
				if(i % 2 == 1) { customerPanels[i].setBackground(Setup.white); }
				GridBagLayout customerLayout = new GridBagLayout();
				customerLayout.columnWidths = new int[]{80, 120, 120, 100, 100, 220, 80, 100};
				customerLayout.rowHeights = new int[]{0, 0};
				customerLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				customerLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
				customerPanels[i].setLayout(customerLayout);

				customerListPanel.add(customerPanels[i]);
				for (int j = 0; j < str[0].length+1; j++) {
					if(j == 7) {
						customerPanels[i].add(new ButtonType1(22, 3,  5,"삭제", 12));
					}else {
						customerInfoLabel[i][j] = new JLabel();
						customerInfoLabel[i][j].setText(str[i][j]);
						customerInfoLabel[i][j].setFont(font2);
						customerPanels[i].add(customerInfoLabel[i][j]);
					}
				}
			}
		//ScrollView Panel SizeSetting
		customerListPanel.setPreferredSize(new Dimension(customerListPanel.getWidth(),40*str.length));
	}
}
