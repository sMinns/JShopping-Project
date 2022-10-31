package gui.contents.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignUp extends JPanel {

	public SignUp() {
		this.setOpaque(false);
		this.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{320, 392, 0, 0};
		gbl_panel.rowHeights = new int[]{182, 20, 74, 24, 50, 50, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		this.add(panel_4, gbc_panel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(JLabel.LEFT);
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 2;
		this.add(panel_6, gbc_panel_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		panel_6.add(textArea);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 3;
		this.add(panel_7, gbc_panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		panel_7.add(lblNewLabel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel_8.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 4;
		this.add(panel_8, gbc_panel_8);
		
		JTextField textField = new JTextField();
		panel_8.add(textField);
		textField.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 5;
		this.add(panel_9, gbc_panel_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 6;
		this.add(panel_2, gbc_panel_2);
		
	}
}
