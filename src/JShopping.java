import java.awt.EventQueue;

import javax.swing.JFrame;

import gui.common.Frame;
import gui.common.Intro;
import gui.contents.sub.Statistics;
import system.Setup;

import static database.Database.makeConnection;

public class JShopping {
	public static void main(String[] args) {
		try {
			JFrame intro = new Intro();
			makeConnection();
			Thread.sleep(1500);
			intro.dispose();
			Frame.frame = new Frame();
			Frame.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}