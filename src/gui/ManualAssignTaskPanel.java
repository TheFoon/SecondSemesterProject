package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class ManualAssignTaskPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManualAssignTaskPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cleaner");
		lblNewLabel.setBounds(46, 55, 46, 14);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(157, 51, 110, 22);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Shift");
		lblNewLabel_1.setBounds(46, 109, 46, 14);
		add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(157, 105, 110, 22);
		add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Task");
		lblNewLabel_2.setBounds(46, 167, 46, 14);
		add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(157, 163, 110, 22);
		add(comboBox_2);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.setBounds(330, 251, 110, 23);
		add(btnNewButton);

	}
	
	
}
