package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CleanerDashboardFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CleanerDashboardFrame frame = new CleanerDashboardFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CleanerDashboardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(Color.BLACK));
		panelMenu.setBackground(new Color(128, 128, 128));
		panelMenu.setBounds(0, 0, 160, 361);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		ImageIcon img_logo = new ImageIcon("src/res/logo.png");
		JLabel lblIconLogo = new JLabel(scaleImage(img_logo.getImage(), 118, 41));lblIconLogo.setBounds(10, 11, 140, 88);
		panelMenu.add(lblIconLogo);
		
		JPanel panel_report_defect = new JPanel();
		createOptionPanel(panel_report_defect, 110, "Report defect", "src/res/report_defect.png");
		panelMenu.add(panel_report_defect);
		
		JPanel panel_shifts = new JPanel();
		createOptionPanel(panel_shifts, 140, "Shifts", "src/res/shifts.png");
		panelMenu.add(panel_shifts);
		
		JPanel panel_tasks = new JPanel();
		createOptionPanel(panel_tasks, 170, "Tasks", "src/res/tasks.png");
		panelMenu.add(panel_tasks);
		
		JPanel panel_settings = new JPanel();
		createOptionPanel(panel_settings, 200, "Settings", "src/res/settings.png");
		panelMenu.add(panel_settings);
		
		JPanel panel_exit = new JPanel();
		createOptionPanel(panel_exit, 230, "Exit", "src/res/exit.png");
		panelMenu.add(panel_exit);
	}

	private void setUpOptionPanel(String label_name, JPanel panel, String img_src) {
		JLabel label = new JLabel(label_name);
		label.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(52, 9, 98, 14);
		panel.add(label);
		
		ImageIcon img = new ImageIcon(img_src);
		JLabel lbl_icon = new JLabel(scaleImage(img.getImage(), 21, 21));
		lbl_icon.setBounds(8, 0, 46, 30);
		panel.add(lbl_icon);
		
	}

	private ImageIcon scaleImage(Image image, int w, int h) {
		Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(scaled);
	}
	
	private void createOptionPanel(JPanel panel, int y, String label_name, String img_src) {
		panel.addMouseListener(new PanelButtonMouseAdapter(panel));
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, y, 160, 30);
		panel.setLayout(null);
		setUpOptionPanel(label_name, panel, img_src);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(180, 180, 180));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(105, 105, 105));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(138, 181, 147));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(180, 180, 180));
		}
	}
}


