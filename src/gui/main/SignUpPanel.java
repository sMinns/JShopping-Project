package gui.main;

import javax.swing.JPanel;

import preset.CustomButton;
import preset.CustomTextField;

public class SignUpPanel extends JPanel {

	public SignUpPanel() {
		add(new CustomTextField(20));
		add(new CustomTextField(10));
		add(new CustomButton(100, "·Î±×ÀÎ"));
	}
}
