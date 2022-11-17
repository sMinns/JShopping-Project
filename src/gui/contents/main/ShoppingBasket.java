package gui.contents.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import custom.ButtonType1;
import gui.common.Frame;
import system.Setup;

public class ShoppingBasket extends JPanel {

	public ShoppingBasket() {
		//장바구니
		JLabel label = new JLabel("장바구니");
		this.add(label);
	}
}
