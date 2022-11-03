package gui.contents.main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import system.Setup;

public class Home extends JPanel {
	private JPanel thisPanel = Setup.lastClickPanel;
	private JLabel homeTitleText;
	private JTextArea[] productNames = new JTextArea[6];
	private final int loopDelay = 1000;
	private int categorynum = 0;
	private String[] categorys = {"�м��Ƿ�", "��Ƽ", "���/���Ƶ�", "��ǰ", "�ֹ��ǰ", "��Ȱ��ǰ", "Ȩ���׸���",
			"����������", "������/����", "�ڵ�����ǰ", "����/����/DVD", "�ϱ�/���", "����/���ǽ�", "�ݷ�������ǰ", "�ｺ/�ǰ���ǰ" };
	public Home() {
		this.setOpaque(false);
		this.setBackground(new Color(255, 255, 255));
		
		
		//homePanel Layout
			GridBagLayout homePanelLayout = new GridBagLayout();
			homePanelLayout.columnWidths = new int[]{45, 570, 0, 0};
			homePanelLayout.rowHeights = new int[]{65, 0, 0, 0};
			homePanelLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			homePanelLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
			this.setLayout(homePanelLayout);
		
		//TitlePanel ( ī�װ��� )
			JPanel homeTitlePanel = new JPanel();
			homeTitlePanel.setBackground(Setup.white);
			GridBagConstraints HomeBagCon = new GridBagConstraints();
			HomeBagCon.gridwidth = 3;
			HomeBagCon.insets = new Insets(0, 0, 2, 8);
			HomeBagCon.fill = GridBagConstraints.BOTH;
			HomeBagCon.gridx = 0;
			HomeBagCon.gridy = 0;
			this.add(homeTitlePanel, HomeBagCon);
			homeTitlePanel.setLayout(new CardLayout(0, 0));
		
			homeTitleText = new JLabel(categorys[categorynum]);
			homeTitleText.setBackground(new Color(255, 255, 255));
			homeTitleText.setFont(new Font(Setup.font, Font.BOLD, 36));
			homeTitleText.setHorizontalAlignment(SwingConstants.CENTER);
			homeTitlePanel.add(homeTitleText);
		
			
		//SideBarPanel ( ��õ��ǰ )
			JPanel sideBar = new JPanel();
			sideBar.setBackground(Setup.white);
			HomeBagCon.gridwidth = 1;
			HomeBagCon.gridheight = 2;
			HomeBagCon.insets = new Insets(0, 0, 0, 2);
			HomeBagCon.gridy = 1;
			this.add(sideBar, HomeBagCon);
			sideBar.setLayout(new CardLayout(0, 0));
			
			JLabel sideBarText = new JLabel("<html><body><center>��<br>õ<br>��<br>ǰ</center></body></html>");
			sideBarText.setBackground(Setup.white);
			sideBarText.setFont(new Font("���� ���", Font.BOLD, 24));
			sideBar.add(sideBarText);
			sideBarText.setHorizontalAlignment(SwingConstants.CENTER);
		
			
		//ProductsPanel ( ��ǰ����г� )
			JPanel productsPanel = new JPanel();
			productsPanel.setOpaque(false);
			productsPanel.setBackground(Setup.white);
	
			HomeBagCon.insets = new Insets(0, 0, 0, 5);
			HomeBagCon.gridx = 1;
			this.add(productsPanel, HomeBagCon);
			productsPanel.setLayout(new GridLayout(2, 1, 2, 2));
			
			//TopProducts Panel ( ���� 3�� )
				JPanel topProducts = new JPanel();
				topProducts.setBackground(Setup.white);
				productsPanel.add(topProducts);
				topProducts.setLayout(new GridLayout(1, 0, 0, 0));
			
			//BottomProducts Panel ( �Ʒ��� 3�� )
				JPanel bottomProducts = new JPanel();
				bottomProducts.setBackground(Setup.white);
				productsPanel.add(bottomProducts);
				bottomProducts.setLayout(new GridLayout(1, 0, 0, 0));
		
			//��ǰ �߰�
				String productName = categorys[categorynum] + categorys[categorynum] + categorys[categorynum] + categorys[categorynum];
				for(int i = 0; i < 3; i++) {
					productNames[i] = new JTextArea();
					productNames[i+3] = new JTextArea();
					topProducts.add(new HomeProduct(productNames[i], productName + (int)(Math.random() * 20), true));
					bottomProducts.add(new HomeProduct(productNames[i+3], productName + (int)(Math.random() * 20), false));
				}
		
		//statPanel ( ��� �г� )
			JPanel statPanel = new JPanel();
			statPanel.setBackground(Setup.white);
			HomeBagCon.insets = new Insets(0, 0, 0, 8);
			HomeBagCon.gridx = 2;
			this.add(statPanel, HomeBagCon);
		
		
		
		// ChangePanel MultiThread
			new Thread(()->{
				try {
					while(Setup.lastClickPanel == thisPanel) {
						categorynum++;
						if(categorynum == 15) { categorynum = 0; }
						String testName = categorys[categorynum] + categorys[categorynum] + categorys[categorynum] + categorys[categorynum];
						homeTitleText.setText(categorys[categorynum]);
						for(int i = 0; i < 6; i++) {
							productNames[i].setText(testName + (int)(Math.random() * 20));
						}
						
			        	 Thread.sleep(loopDelay);
			         }
			      }catch(Exception a) {
			      }
			}).start();
		
	}
	

}

class HomeProduct extends JPanel implements MouseListener {
	private String text;
	public HomeProduct(JTextArea textArea, String text, boolean top) {
		this.text = text;
		this.setOpaque(false);
		
		//Layout
			GridBagLayout gbl_panel_11 = new GridBagLayout();
			if(top) {
				gbl_panel_11.rowHeights = new int[]{70, 150, 0, 0};
			}else {
				gbl_panel_11.rowHeights = new int[]{30, 150, 0, 0};
			}
			gbl_panel_11.columnWidths = new int[]{116, 0};
			gbl_panel_11.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			
			this.setLayout(gbl_panel_11);
		
		//Image
			JPanel imagePanel = new JPanel();
			imagePanel.setOpaque(false);
			GridBagConstraints gbc_panel_16 = new GridBagConstraints();
			gbc_panel_16.insets = new Insets(0, 0, 5, 0);
			gbc_panel_16.fill = GridBagConstraints.BOTH;
			gbc_panel_16.gridx = 0;
			gbc_panel_16.gridy = 1;
			this.add(imagePanel, gbc_panel_16);
			
			JLabel imageLabel = new JLabel("");
			imagePanel.add(imageLabel);
			imageLabel.setIcon(Setup.imageSetSize(new ImageIcon(HomeProduct.class.getResource("/images/nullimage.png")),150,150));
			imageLabel.addMouseListener(this);
		
		//Text
			JPanel textPanel = new JPanel();
			textPanel.setLayout(null);
			textPanel.setOpaque(false);
			GridBagConstraints gbc_panel_21 = new GridBagConstraints();
			gbc_panel_21.fill = GridBagConstraints.BOTH;
			gbc_panel_21.gridx = 0;
			gbc_panel_21.gridy = 2;
			this.add(textPanel, gbc_panel_21);
			
			textArea.setFont(new Font(Setup.font, Font.BOLD, 12));
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			textArea.setBounds(20, 5, 150, 56);
			textArea.addMouseListener(this);
			textPanel.add(textArea);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(text + "Click");
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}