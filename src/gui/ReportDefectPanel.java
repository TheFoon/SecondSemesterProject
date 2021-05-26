package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ReportDefectPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReportDefectPanel() {
		setBounds(0, 0, 504, 339);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Report Defect Panel");
		lblNewLabel.setBounds(165, 150, 235, 14);
		add(lblNewLabel);
	}

}
