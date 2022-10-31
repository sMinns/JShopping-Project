package gui.contents.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.common.Frame;
import system.Setup;

public class ShoppingBasket extends JPanel implements ActionListener {

	public ShoppingBasket() {
		//장바구니
		JLabel label = new JLabel("장바구니");
		this.add(label);
		
		
		JButton order = new JButton("주문하기");
		order.addActionListener(this);
		this.add(order);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(), "주문 / 결제");
		Setup.lastClickReset();
	}
}
