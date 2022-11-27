package gui.contents.main;

import custom.ButtonType1;
import custom.SearchBar;
import database.CustomerManagementDB;
import gui.common.Frame;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class CustomerManagement extends JPanel implements ActionListener, MouseListener {
	private List<List<String>> str;
	private JPanel[] customerPanels;
	private JLabel[][] customerInfoLabel;
	private JLabel[] cmTitleLabel = new JLabel[8];
	private String[] cmTitletext = {"고객번호", "아이디", "닉네임", "이름", "생년월일", "이메일", "가입일자", "관리"};
	private Font font1 = new Font(Setup.font, Font.BOLD, 16);
	private Font font2 = new Font(Setup.font, Font.BOLD, 14);
	private JButton[] deleteButton;
	private SearchBar searchBar;
	private String text;
	public CustomerManagement(String text) {
		this.text = text;
		str = CustomerManagementDB.customerList(text);
		customerPanels = new JPanel[str.size()];
		customerInfoLabel = new JLabel[str.size()][8];
		deleteButton = new JButton[str.size()];
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
			searchBar = new SearchBar(50, 40, "고객번호, 아이디, 이름 검색");
			if(!text.equals("")) {
				searchBar.setTextField(text);
				searchBar.getTextField().setFont(new Font(Setup.font, Font.PLAIN, 12));
			}
			searchBar.getTextField().addActionListener(this);
			searchBar.getSearchButtonLabel().addMouseListener(this);
			JPanel searchBarPanel = searchBar;
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
			for (int i = 0; i < str.size(); i++) {
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
				for (int j = 0; j < 8; j++) {
					if(j == 7) {
						deleteButton[i] = new ButtonType1(22, 3,  5,"삭제", 12);
						deleteButton[i].addActionListener(this);
						customerPanels[i].add(deleteButton[i]);
					}else {
						customerInfoLabel[i][j] = new JLabel();
						customerInfoLabel[i][j].setText(str.get(i).get(j));
						customerInfoLabel[i][j].setFont(font2);
						customerPanels[i].add(customerInfoLabel[i][j]);
					}
				}
			}
		//ScrollView Panel SizeSetting
		customerListPanel.setPreferredSize(new Dimension(customerListPanel.getWidth(),40*str.size()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < str.size(); i++) {
			if(e.getSource() == deleteButton[i]) {
				if(CustomerManagementDB.deleteCustomer(Integer.parseInt(str.get(i).get(0)))) {
					Setup.changePanel(Frame.contentLayeredPanel, new CustomerManagement(text));
				}
			}
		}

		if(e.getSource() == searchBar.getTextField()) {
			if(searchBar.getTextField().getText().equals("고객번호, 아이디, 이름 검색")) {
				text = "";
			}else {
				text = searchBar.getTextField().getText();
			}
			Setup.changePanel(Frame.contentLayeredPanel, new CustomerManagement(text));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(searchBar.getTextField().getText().equals("고객번호, 아이디, 이름 검색")) {
			text = "";
		}else {
			text = searchBar.getTextField().getText();
		}
		Setup.changePanel(Frame.contentLayeredPanel, new CustomerManagement(text));
	}

	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}
