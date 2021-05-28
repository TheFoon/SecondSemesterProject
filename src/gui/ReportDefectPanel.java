package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.DefectController;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportDefectPanel extends JPanel {
	
	private DefectController defect_controller;
	
	private JTextField txt_defect_type;
	private JTextField txt_defect_location;
	private JTextArea txt_area_description;

	/**
	 * Create the panel.
	 */
	public ReportDefectPanel() {
		setBounds(0, 0, 504, 339);
		setVisible(true);
		setLayout(null);
		
		defect_controller = new DefectController();
		
		JLabel lblNewLabel = new JLabel("Report Defect Panel");
		lblNewLabel.setBounds(189, 24, 132, 14);
		add(lblNewLabel);
		
		JLabel lbl_defect_type = new JLabel("Defect type");
		lbl_defect_type.setBounds(126, 59, 67, 14);
		add(lbl_defect_type);
		
		JLabel lbl_defect_location = new JLabel("Defect location (room name)");
		lbl_defect_location.setBounds(126, 115, 195, 14);
		add(lbl_defect_location);
		
		JLabel lbl_description = new JLabel("Description");
		lbl_description.setBounds(126, 171, 67, 14);
		add(lbl_description);
		
		txt_defect_type = new JTextField();
		txt_defect_type.setBounds(126, 84, 162, 20);
		add(txt_defect_type);
		txt_defect_type.setColumns(10);
		
		txt_defect_location = new JTextField();
		txt_defect_location.setBounds(126, 140, 162, 20);
		add(txt_defect_location);
		txt_defect_location.setColumns(10);
		
		JButton btn_report = new JButton("Report");
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportDefect();
			}
		});
		btn_report.setBounds(306, 305, 89, 23);
		add(btn_report);
		
		JButton btn_abort = new JButton("Abort");
		btn_abort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abortDefect();
			}
		});
		btn_abort.setBounds(405, 305, 89, 23);
		add(btn_abort);
		
		txt_area_description = new JTextArea();
		txt_area_description.setBounds(126, 198, 236, 96);
		add(txt_area_description);
	}

	protected void reportDefect() {
		
		String type = txt_defect_type.getText();
		String room_name = txt_defect_location.getText();
		String description = txt_area_description.getText();
		
		if(checkStringInput(type)  && 
		checkStringInput(room_name) && 
		checkStringInput(description)) {
			defect_controller.reportDefect(type, description, room_name);
			System.out.println("Defect successfully reported");
			JOptionPane.showMessageDialog(this, "Defect successfully reported", "Success", JOptionPane.INFORMATION_MESSAGE);
			abortDefect();
		} else {
			System.out.println("One of the fields do not contain information");
		}
		
	}

	protected void abortDefect() {
		txt_defect_type.setText(null);
		txt_defect_location.setText(null);
		txt_area_description.setText(null);
	}
	
	/**
	* Takes in a string and checks if it is a valid input for processing
	*/
	private boolean checkStringInput(String input) {
		boolean return_value = false;
		if(!input.trim().isEmpty()) {
			return_value = true;	
		}
		return return_value;
	}
}
