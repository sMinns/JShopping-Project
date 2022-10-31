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
		//��ٱ���
		JLabel label = new JLabel("��ٱ���");
		this.add(label);
		
		
		JButton order = new JButton("�ֹ��ϱ�");
		order.addActionListener(this);
		this.add(order);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Setup.changePanel(Frame.contentLayeredPanel, new OrderPage(), "�ֹ� / ����");
		Setup.lastClickReset();
	}
}
