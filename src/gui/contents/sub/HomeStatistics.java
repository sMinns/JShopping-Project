package gui.contents.sub;

import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeStatistics extends JPanel {
	private JPanel[] agePanel = new JPanel[5];
	private JLabel[] ageLabel = new JLabel[5];
	private JPanel statPanel;
	public HomeStatistics(List<Integer> nums) {
		this.setBackground(Setup.bgLightGray);
		
		GridBagLayout gbl_this = new GridBagLayout();
		gbl_this.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_this.rowHeights = new int[]{70, 0, 50, 50, 0};
		gbl_this.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_this.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_this);
		
		JPanel HomeStatTitlePanel = new JPanel();
		HomeStatTitlePanel.setBackground(Setup.white);
		GridBagConstraints homeStatCon = new GridBagConstraints();
		homeStatCon.insets = new Insets(0, 0, 0, 0);
		homeStatCon.gridwidth = 7;
		homeStatCon.fill = GridBagConstraints.BOTH;
		homeStatCon.gridx = 0;
		homeStatCon.gridy = 0;
		this.add(HomeStatTitlePanel, homeStatCon);
		HomeStatTitlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//Title Text Label
			JLabel TitleTextLabel1 = new JLabel(" 구매자 연령");
			TitleTextLabel1.setFont(new Font(Setup.font, Font.BOLD, 24));
			HomeStatTitlePanel.add(TitleTextLabel1);
			
			JLabel TitleTextLabel2 = new JLabel("(명)");
			TitleTextLabel2.setForeground(Setup.magenta);
			TitleTextLabel2.setFont(new Font(Setup.font, Font.BOLD, 24));
			HomeStatTitlePanel.add(TitleTextLabel2);
		
		//Blank Panel
			JPanel BlankPanel1 = new JPanel();
			BlankPanel1.setBackground(Setup.white);
			homeStatCon.gridwidth = 1;
			homeStatCon.gridy = 1;
			this.add(BlankPanel1, homeStatCon);
			
			JPanel blankPanel2 = new JPanel();
			blankPanel2.setBackground(Setup.white);
			homeStatCon.gridx = 6;
			this.add(blankPanel2, homeStatCon);
		
			homeStatCon.insets = new Insets(0, 0, 2, 0);
			homeStatCon.gridheight = 2;
			homeStatCon.gridx = 1;
			
			JPanel ageBlankPanel1 = new JPanel();
			ageBlankPanel1.setBackground(Setup.white);
			homeStatCon.gridx = 0;
			this.add(ageBlankPanel1, homeStatCon);
			
			JPanel ageBlankPanel2 = new JPanel();
			homeStatCon.gridx = 6;
			homeStatCon.insets = new Insets(0, 0, 2, 0);
			ageBlankPanel2.setBackground(Setup.white);
			this.add(ageBlankPanel2, homeStatCon);
		
		//Stat
			homeStatCon.gridx = 1;
			homeStatCon.gridwidth = 5;
			statPanel = new Statistics(nums);
			this.add(statPanel, homeStatCon);
			
		//연령 표시 age Panel
			JPanel ageblankPanel1 = new JPanel();
			ageblankPanel1.setBackground(Setup.white);
			homeStatCon.gridwidth = 1;
			homeStatCon.insets = new Insets(0, 0, 0, 0);
			homeStatCon.gridx = 0;
			homeStatCon.gridy = 3;
			this.add(ageblankPanel1, homeStatCon);
			
			
			for(int i = 0; i < 5; i++) {
				agePanel[i] = new JPanel();
				agePanel[i].setBackground(Setup.white);
				homeStatCon.gridx = i+1;
				this.add(agePanel[i], homeStatCon);
				
				ageLabel[i] = new JLabel((i+1)*10 + "대");
				ageLabel[i].setFont(new Font(Setup.font, Font.BOLD, 18));
				agePanel[i].add(ageLabel[i]);
			}
			
			JPanel ageblankPanel2 = new JPanel();
			ageblankPanel2.setBackground(new Color(255, 255, 255));
			homeStatCon.gridx = 6;
			this.add(ageblankPanel2, homeStatCon);
	}

	public JPanel getStatPanel() {
		return statPanel;
	}
}
