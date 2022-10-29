import java.awt.EventQueue;

import gui.common.Frame;
import system.Setup;

public class JShopping {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame.frame = new Frame();
					Frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
