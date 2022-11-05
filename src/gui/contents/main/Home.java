package gui.contents.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import gui.contents.sub.HomeProduct;
import gui.contents.sub.HomeStatistics;
import gui.contents.sub.Statistics;
import system.Setup;

public class Home extends JPanel {
	private JPanel thisPanel = Setup.lastClickPanel;
	private JLabel homeTitleText;
	private JTextArea[] productNames = new JTextArea[6];
	private final int loopDelay = 1000;
	private int categorynum = 0;
	public static JPanel statPanel;
	private String[] categorys = {"패션의류", "뷰티", "출산/유아동", "식품", "주방용품", "생활용품", "홈인테리어",
			"가전디지털", "스포츠/레저", "자동차용품", "도서/음반/DVD", "완구/취미", "문구/오피스", "반려동물용품", "헬스/건강식품" };
	private int[][] nums = new int[15][5];
	private int[] maxnum = new int[15];
	public Home() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				nums[i][j] = (int) (Math.random() * 15);
				if(nums[i][j] > maxnum[i]) { maxnum[i] = nums[i][j]; }
			}
			
		}
		this.setOpaque(false);
		this.setBackground(new Color(255, 255, 255));
		
		//homePanel Layout
			GridBagLayout homePanelLayout = new GridBagLayout();
			homePanelLayout.columnWidths = new int[]{45, 570, 0, 0};
			homePanelLayout.rowHeights = new int[]{65, 0, 0, 0};
			homePanelLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			homePanelLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
			this.setLayout(homePanelLayout);
		
		//TitlePanel ( 카테고리명 )
			GridBagConstraints HomeBagCon = new GridBagConstraints();
			HomeBagCon.gridwidth = 3;
			HomeBagCon.insets = new Insets(0, 0, 2, 6);
			HomeBagCon.fill = GridBagConstraints.BOTH;
			HomeBagCon.gridx = 0;
			HomeBagCon.gridy = 0;
			JPanel title = new TitleBar();
			this.add(title, HomeBagCon);
			title.setLayout(new CardLayout(0, 0));
		
			
		//SideBarPanel ( 추천상품 )
			HomeBagCon.gridwidth = 1;
			HomeBagCon.gridheight = 2;
			HomeBagCon.insets = new Insets(0, 0, 0, 2);
			HomeBagCon.gridy = 1;
			JPanel side = new SideBar();
			this.add(side, HomeBagCon);
			side.setLayout(new CardLayout(0, 0));
		
			
		//ProductsPanel ( 상품목록패널 )
			HomeBagCon.insets = new Insets(0, 0, 0, 5);
			HomeBagCon.gridx = 1;
			JPanel ProductPanel = new ProductHome();
			this.add(ProductPanel, HomeBagCon);
			ProductPanel.setLayout(new GridLayout(2, 1, 2, 2));
		
		//statPanel ( 통계 패널 )
			HomeBagCon.insets = new Insets(0, 0, 0, 5);
			HomeBagCon.gridx = 2;
			this.add(new HomeStatistics(nums[0], maxnum[0]), HomeBagCon);
			
		// ChangePanel MultiThread
			class RotationThread extends Thread {
				public void run() {
					try {
						while(Setup.lastClickPanel == thisPanel) {
							categorynum++;
							if(categorynum == 15) { categorynum = 0; }
							//stat
								Setup.changePanel(statPanel, new Statistics(nums[categorynum], maxnum[categorynum]));
							//product
								productRotaion();
							//delay
				        	 Thread.sleep(loopDelay);
				         }
				      }catch(Exception a) {
				      }
				}
			}
			Thread rotationThread = new RotationThread();
			rotationThread.start();
			
			
		
	}
	
	private void productRotaion() {
		String testName = categorys[categorynum] + categorys[categorynum] + categorys[categorynum] + categorys[categorynum];
		homeTitleText.setText(categorys[categorynum]);
		for(int i = 0; i < 6; i++) {
			productNames[i].setText(testName + (int)(Math.random() * 20));
		}
	}
	
	private class ProductHome extends JPanel {
		private ProductHome() {
			this.setOpaque(false);
			this.setBackground(Setup.white);
			//TopProducts Panel ( 위쪽 3개 )
				JPanel topProducts = new JPanel();
				topProducts.setBackground(Setup.white);
				this.add(topProducts);
				topProducts.setLayout(new GridLayout(1, 0, 0, 0));
			
			//BottomProducts Panel ( 아래쪽 3개 )
				JPanel bottomProducts = new JPanel();
				bottomProducts.setBackground(Setup.white);
				this.add(bottomProducts);
				bottomProducts.setLayout(new GridLayout(1, 0, 0, 0));
		
			//상품 추가
				String productName = categorys[categorynum] + categorys[categorynum] + categorys[categorynum] + categorys[categorynum];
				for(int i = 0; i < 3; i++) {
					productNames[i] = new JTextArea();
					productNames[i+3] = new JTextArea();
					topProducts.add(new HomeProduct(productNames[i], productName + (int)(Math.random() * 20), true));
					bottomProducts.add(new HomeProduct(productNames[i+3], productName + (int)(Math.random() * 20), false));
				}
		}
	}
	
	private class TitleBar extends JPanel {
		private TitleBar() {
			this.setBackground(Setup.white);
			this.setLayout(new CardLayout(0, 0));
		
			homeTitleText = new JLabel(categorys[categorynum]);
			homeTitleText.setBackground(new Color(255, 255, 255));
			homeTitleText.setFont(new Font(Setup.font, Font.BOLD, 36));
			homeTitleText.setHorizontalAlignment(SwingConstants.CENTER);
			this.add(homeTitleText);
		
		}
	}
	
	private class SideBar extends JPanel {
		private SideBar() {
			this.setBackground(Setup.white);
			JLabel sideBarText = new JLabel("<html><body><center>추<br>천<br>상<br>품</center></body></html>");
			sideBarText.setBackground(Setup.white);
			sideBarText.setFont(new Font("맑은 고딕", Font.BOLD, 24));
			this.add(sideBarText);
			sideBarText.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}

}

