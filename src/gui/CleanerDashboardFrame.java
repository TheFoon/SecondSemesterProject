package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import java.awt.Font;
import java.awt.SystemColor;

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
		panel_report_defect.setBorder(new LineBorder(Color.BLACK));
		panel_report_defect.setBackground(new Color(105, 105, 105));
		panel_report_defect.setBounds(0, 110, 160, 30);
		panelMenu.add(panel_report_defect);
		panel_report_defect.setLayout(null);
		
		JLabel lbl_report_defect = new JLabel("Report defect");
		lbl_report_defect.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		lbl_report_defect.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_report_defect.setBounds(52, 9, 98, 14);
		panel_report_defect.add(lbl_report_defect);
		
		ImageIcon img_report_defect = new ImageIcon("src/res/report_defect.png");
		JLabel lbl_report_defect_icon = new JLabel(scaleImage(img_report_defect.getImage(), 21, 21));
		lbl_report_defect_icon.setBounds(10, 0, 46, 30);
		panel_report_defect.add(lbl_report_defect_icon);
		
		JPanel panel_shifts = new JPanel();
		panel_shifts.setBorder(new LineBorder(Color.BLACK));
		panel_shifts.setBackground(new Color(105, 105, 105));
		panel_shifts.setBounds(0, 140, 160, 30);
		panelMenu.add(panel_shifts);
		panel_shifts.setLayout(null);
		
		ImageIcon img_shifts = new ImageIcon("src/res/shifts.png");
		JLabel lbl_shifts_icon = new JLabel(scaleImage(img_shifts.getImage(), 21, 21));
		lbl_shifts_icon.setBounds(8, 0, 46, 30);
		panel_shifts.add(lbl_shifts_icon);
		
		JLabel lbl_shifts = new JLabel("Shifts");
		lbl_shifts.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		lbl_shifts.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_shifts.setBounds(52, 9, 98, 14);
		panel_shifts.add(lbl_shifts);
		
		JPanel panel_tasks = new JPanel();
		panel_tasks.setBorder(new LineBorder(Color.BLACK));
		panel_tasks.setBackground(new Color(105, 105, 105));
		panel_tasks.setBounds(0, 170, 160, 30);
		panelMenu.add(panel_tasks);
		panel_tasks.setLayout(null);
		
		ImageIcon img_tasks = new ImageIcon("src/res/tasks.png");
		JLabel lbl_tasks_icon = new JLabel(scaleImage(img_tasks.getImage(), 21, 21));
		lbl_tasks_icon.setBounds(8, 0, 46, 30);
		panel_tasks.add(lbl_tasks_icon);
		
		JLabel lbl_tasks = new JLabel("Tasks");
		lbl_tasks.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tasks.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		lbl_tasks.setBounds(54, 9, 98, 14);
		panel_tasks.add(lbl_tasks);
		
		JPanel panel_settings = new JPanel();
		panel_settings.setBorder(new LineBorder(Color.BLACK));
		panel_settings.setBackground(new Color(105, 105, 105));
		panel_settings.setBounds(0, 200, 160, 30);
		panelMenu.add(panel_settings);
		panel_settings.setLayout(null);
		
		ImageIcon img_settings = new ImageIcon("src/res/settings.png");
		JLabel lbl_settings_icon = new JLabel(scaleImage(img_settings.getImage(), 21, 21));
		lbl_settings_icon.setBounds(8, 0, 46, 30);
		panel_settings.add(lbl_settings_icon);
		
		JLabel lbl_settings = new JLabel("Settings");
		lbl_settings.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_settings.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		lbl_settings.setBounds(54, 9, 98, 14);
		panel_settings.add(lbl_settings);
		
		JPanel panel_settings_1 = new JPanel();
		panel_settings_1.setLayout(null);
		panel_settings_1.setBorder(new LineBorder(Color.BLACK));
		panel_settings_1.setBackground(SystemColor.controlDkShadow);
		panel_settings_1.setBounds(0, 230, 160, 30);
		panelMenu.add(panel_settings_1);
		
		ImageIcon img_exit = new ImageIcon("src/res/exit.png");
		JLabel lbl_exit_icon = new JLabel(scaleImage(img_exit.getImage(), 21, 21));
		lbl_exit_icon.setBounds(8, 0, 46, 30);
		panel_settings_1.add(lbl_exit_icon);
		
		JLabel lbl_exit = new JLabel("Exit");
		lbl_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exit.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		lbl_exit.setBounds(54, 9, 98, 14);
		panel_settings_1.add(lbl_exit);
	}

	private ImageIcon scaleImage(Image image, int w, int h) {
		Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(scaled);
	}
}
