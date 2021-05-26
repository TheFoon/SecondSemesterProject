package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ReportDefectPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ReportDefectPanel() {
		setBounds(0, 0, 504, 339);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Report Defect Panel");
		lblNewLabel.setBounds(189, 24, 132, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Defect type");
		lblNewLabel_1.setBounds(126, 59, 67, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Defect location (room name)");
		lblNewLabel_2.setBounds(126, 115, 67, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Description");
		lblNewLabel_3.setBounds(126, 171, 67, 14);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(126, 84, 132, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 140, 132, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Report");
		btnNewButton.setBounds(402, 305, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Abort");
		btnNewButton_1.setBounds(303, 305, 89, 23);
		add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 198, 236, 96);
		add(textArea);
	}
}
