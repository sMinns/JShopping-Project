package gui.contents.main;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import system.Setup;

public class Home extends JPanel {
	private JPanel[] categoryPanels = new JPanel[15];
	private JLayeredPane layer = new JLayeredPane();
	private JPanel thisPanel = Setup.lastClickPanel;
	private final int loopDelay = 100;
	private int categorynum = 0;
	public Home() {
		
		layer.setLayout(new CardLayout());
		
		for(int i = 0; i < 15; i++) {
			categoryPanels[i] = new JPanel();
			categoryPanels[i].add(new JLabel("카테고리" + i));
			layer.add(categoryPanels[i]);
		}
		this.add(layer);
		
		
		// ChangePanel MultiThread
			new Thread(()->{
				try {
					while(Setup.lastClickPanel == thisPanel) {
						changePane();
						categorynum++;
						if(categorynum == 15) { categorynum = 0; }
			        	 Thread.sleep(loopDelay);
			         }
			      }catch(Exception a) {
			      }
			}).start();
		
	}
	public void changePane() {
		layer.removeAll();
		layer.add(categoryPanels[categorynum]);
		layer.repaint();
		layer.revalidate();
	}
}
