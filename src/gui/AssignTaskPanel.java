package gui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AssignTaskPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AssignTaskPanel() {
		setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(null);
		layeredPane.setBounds(0, 45, 450, 255);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_91146321162800");
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_91164732975900");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(167, 11, 118, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(295, 11, 118, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(28, 15, 129, 14);
		add(lblNewLabel);
		
	}
}
