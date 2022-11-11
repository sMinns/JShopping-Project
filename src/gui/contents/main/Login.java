package gui.contents.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import custom.ButtonType1;
import custom.ComboBoxType1;
import custom.SearchBar;
import custom.TextFieldType1;
import gui.common.Frame;
import gui.menu.CustomerMenu;
import system.Setup;

public class Login extends JPanel {
	public Login() {
		//로그인
		JLabel label = new JLabel("로그인");
		this.add(label);
	}
}
