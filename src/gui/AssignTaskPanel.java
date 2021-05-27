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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignTaskPanel extends JPanel {
	
	JLayeredPane layeredPane;

	/**
	 * Create the panel.
	 */
	public AssignTaskPanel() {
		setBackground(Color.GRAY);
		setForeground(Color.GRAY);
		setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.GRAY);
		layeredPane.setBorder(null);
		layeredPane.setBounds(0, 45, 504, 301);
		add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel auto_assign_tasks_panel = new JPanel();
		layeredPane.add(auto_assign_tasks_panel, "name_91146321162800");
		
		JPanel manual_assign_task_panel = new ManualAssignTaskPanel();
		layeredPane.add(manual_assign_task_panel, "name_91164732975900");
		
		JButton btn_auto_assign = new JButton("Auto assign");
		btn_auto_assign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(auto_assign_tasks_panel);
			}
		});
		btn_auto_assign.setBounds(167, 11, 118, 23);
		add(btn_auto_assign);
		
		JButton btn_manual_assign = new JButton("Manual assign");
		btn_manual_assign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(manual_assign_task_panel);
			}
		});
		btn_manual_assign.setBounds(295, 11, 118, 23);
		add(btn_manual_assign);
		
		JLabel lbl_assign_task = new JLabel("Assign task");
		lbl_assign_task.setBounds(28, 15, 129, 14);
		add(lbl_assign_task);
		
	}

	protected void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
}
