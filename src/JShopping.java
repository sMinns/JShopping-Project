import database.Database;
import gui.common.Frame;
import gui.common.Intro;

import javax.swing.*;

import static database.Database.makeConnection;

public class JShopping {
	public static void main(String[] args) {
		try {
			JFrame intro = new Intro();
			Database.con = makeConnection();
			Thread.sleep(1500);
			intro.dispose();
			Frame.frame = new Frame();
			Frame.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}