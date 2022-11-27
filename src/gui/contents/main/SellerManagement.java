package gui.contents.main;

import custom.ButtonType1;
import custom.SearchBar;
import database.SellerManagementDB;
import gui.common.Frame;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SellerManagement extends JPanel implements MouseListener, ActionListener {
	private List<List<String>> str;
	private JPanel[] sellerPanels;
	private JLabel[][] sellerInfoLabel;
	private JLabel[] sellerTitleLabel = new JLabel[7];
	private String[] sellerTitletext = {"고객번호", "판매자명", "상호/대표자", "연락처", "이메일", "사업자등록번호", "관리"};
	private Font font1 = new Font(Setup.font, Font.BOLD, 16);
	private Font font2 = new Font(Setup.font, Font.BOLD, 14);
	private JButton[] deleteButton;
	SearchBar searchBar;
	String text;
	public SellerManagement(String text) {
		this.text = text;
		str = SellerManagementDB.sellerList(text);
		sellerPanels = new JPanel[str.size()];
		sellerInfoLabel = new JLabel[str.size()][7];
		deleteButton = new JButton[str.size()];
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
			searchBar = new SearchBar(50, 40, "판매자명 검색");
			if(!text.equals("")) {
				searchBar.setTextField(text);
				searchBar.getTextField().setFont(new Font(Setup.font, Font.PLAIN, 12));
			}
			searchBar.getTextField().addActionListener(this);
			searchBar.getSearchButtonLabel().addMouseListener(this);
			JPanel searchBarPanel = searchBar;
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
		for (int i = 0; i < str.size(); i++) {
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
			for (int j = 0; j < 7; j++) {
				if(j == 6) {
					deleteButton[i] = new ButtonType1(22, 3, 5, "삭제", 12);
					deleteButton[i].addActionListener(this);
					sellerPanels[i].add(deleteButton[i]);
				}else {
					sellerInfoLabel[i][j] = new JLabel();
					sellerInfoLabel[i][j].setText(str.get(i).get(j));
					sellerInfoLabel[i][j].setFont(font2);
					sellerPanels[i].add(sellerInfoLabel[i][j]);
				}
			}
		}
		//ScrollView Panel SizeSetting
		sellerListPanel.setPreferredSize(new Dimension(sellerListPanel.getWidth(),40*str.size()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < deleteButton.length; i++) {
			if(e.getSource() == deleteButton[i]) {
				if(SellerManagementDB.deleteData(Integer.parseInt(str.get(i).get(0)))) {
					Setup.changePanel(Frame.contentLayeredPanel, new SellerManagement(text));
				}
			}
		}

		if(e.getSource() == searchBar.getTextField()) {
			if(searchBar.getTextField().getText().equals("판매자명 검색")) {
				text = "";
			}else {
				text = searchBar.getTextField().getText();
			}
			Setup.changePanel(Frame.contentLayeredPanel, new SellerManagement(text));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == searchBar.getSearchButtonLabel()) {
			if(searchBar.getTextField().getText().equals("판매자명 검색")) {
				text = "";
			}else {
				text = searchBar.getTextField().getText();
			}
			Setup.changePanel(Frame.contentLayeredPanel, new SellerManagement(text));
		}
	}

	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }

}
