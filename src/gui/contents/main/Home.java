package gui.contents.main;

import database.CategoryDB;
import database.HomeDB;
import gui.contents.sub.HomeProduct;
import gui.contents.sub.HomeStatistics;
import gui.contents.sub.Statistics;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Home extends JPanel {
	private JPanel thisPanel = Setup.lastClickPanel, ProductPanel, topProducts, bottomProducts;
	private JLabel homeTitleText;
	private JTextArea[] productNames = new JTextArea[6];
	private final int loopDelay = 3000;
	private int categorynum = 0;
	public static JPanel statPanel;
	private List<Integer> homeProductList;
	private List<String> productNametext;
	private ImageIcon[] images = new ImageIcon[6];
	private String[] categorys = CategoryDB.categoryList().toArray(new String[0]);
	private int[][] nums = new int[15][5];
	private int[] maxnum = new int[15];
	public Home() {
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				nums[i][j] = (int) (Math.random() * 15);
				if(nums[i][j] > maxnum[i]) { maxnum[i] = nums[i][j]; }
			}
		}
		homeProductList = HomeDB.homeProductList(categorynum+1);
		productNametext = HomeDB.returnHomeProductName(homeProductList);
		for (int i = 0; i < 6; i++) {
			images[i] = new ImageIcon(HomeProduct.class.getResource("/images/nullimage.png"));
		}

		this.setOpaque(false);
		this.setBackground(Setup.white);
		
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
			JLayeredPane layer = new JLayeredPane();
			layer.setLayout(new CardLayout());
			this.add(layer, HomeBagCon);
			ProductPanel = new ProductHome();
			layer.add(ProductPanel);
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
							//delay
							Thread.sleep(loopDelay);
							categorynum++;
							if(categorynum == 15) { categorynum = 0; }
							//stat
								Setup.changePanel(statPanel, new Statistics(nums[categorynum], maxnum[categorynum]));
							//product
								productRotaion();
							ProductPanel = new ProductHome();
							ProductPanel.setLayout(new GridLayout(2, 1, 2, 2));
							Setup.changePanel(layer, ProductPanel);
				         }
				      }catch(Exception a) {
				      }
				}
			}
			Thread rotationThread = new RotationThread();
			rotationThread.start();
	}
	
	private void productRotaion() {
		homeProductList = HomeDB.homeProductList(categorynum+1);
		productNametext = HomeDB.returnHomeProductName(homeProductList);
		homeTitleText.setText(categorys[categorynum]);

	}
	
	private class ProductHome extends JPanel {
		private ProductHome() {
			this.setOpaque(false);
			this.setBackground(Setup.white);
			//TopProducts Panel ( 위쪽 3개 )
				topProducts = new JPanel();
				topProducts.setBackground(Setup.white);
				this.add(topProducts);
				topProducts.setLayout(new GridLayout(1, 0, 0, 0));
			
			//BottomProducts Panel ( 아래쪽 3개 )
				bottomProducts = new JPanel();
				bottomProducts.setBackground(Setup.white);
				this.add(bottomProducts);
				bottomProducts.setLayout(new GridLayout(1, 0, 0, 0));

			//상품 추가
			for(int i = 0; i < 6; i++) {
				productNames[i] = new JTextArea();
				if(i < 3) {
					topProducts.add(new HomeProduct(productNames[i], homeProductList.get(i), productNametext.get(i), true));
				}else {
					bottomProducts.add(new HomeProduct(productNames[i], homeProductList.get(i), productNametext.get(i), false));
				}
			}
		}
	}
	
	private class TitleBar extends JPanel {
		private TitleBar() {
			this.setBackground(Setup.white);
			this.setLayout(new CardLayout(0, 0));
		
			homeTitleText = new JLabel(categorys[categorynum]);
			homeTitleText.setBackground(Setup.white);
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

