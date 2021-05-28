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
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class CleanerDashboardFrame extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	private String res = "res/cleaner_dashboard/";
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
		setBounds(100, 100, 700, 400);
		setTitle("Cleaner Dashboard");
		setResizable(false);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 160, 361);
		panelMenu.setBackground(new Color(128, 128, 128));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		ImageIcon img_logo = new ImageIcon("res/logo.png");
		JLabel lbl_icon_logo = new JLabel(scaleImage(img_logo.getImage(), 118, 41));
		lbl_icon_logo.setBounds(10, 11, 140, 88);
		panelMenu.add(lbl_icon_logo);
		
		
		//the panel names need to be renamed as soon as possible
		JPanel panel_report_defect = new JPanel();
		createOptionPanel(panel_report_defect, 110, "Report defect", "report_defect.png");
		panelMenu.add(panel_report_defect);
		
		JPanel panel_shifts = new JPanel();
		createOptionPanel(panel_shifts, 140, "Shifts", "shifts.png");
		panelMenu.add(panel_shifts);
		
		JPanel panel_tasks = new JPanel();
		createOptionPanel(panel_tasks, 170, "Tasks", "tasks.png");
		panelMenu.add(panel_tasks);
		
		JPanel panel_settings = new JPanel();
		createOptionPanel(panel_settings, 200, "Settings", "settings.png");
		panelMenu.add(panel_settings);
		
		JPanel panel_exit = new JPanel();
		createOptionPanel(panel_exit, 230, "Exit", "exit.png");
		panelMenu.add(panel_exit);
		panel_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame frame = new LoginFrame();
				frame.setVisible(true);
				closeDashboard();
			}
		});
		
		createLayeredPane();
		
		JPanel report_defect_panel = new ReportDefectPanel();
		layeredPane.add(report_defect_panel, "report_defect_panel");
		
		JPanel shifts_panel = new ShiftsPanel();
		layeredPane.add(shifts_panel, "shifts_panel");
		
		JPanel tasks_panel = new TasksPanel();
		layeredPane.add(tasks_panel, "tasks_panel");
		
		JPanel settings_panel = new JPanel();
		layeredPane.add(settings_panel, "settings_panel");
		
		
		addMouseListenerToPanel(panel_report_defect, report_defect_panel);
		addMouseListenerToPanel(panel_shifts, shifts_panel);
		addMouseListenerToPanel(panel_tasks, tasks_panel);
		
		
	}
	
	protected void closeDashboard() {
		this.dispose();
		
	}

	//           Next time we should create a new class for this to avoid confusion
	//                                         |
	//                                         v
	private void addMouseListenerToPanel(JPanel button_panel, JPanel panel) {
		button_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switchPanels(panel);
			
			}
		});
	}
	
	private void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	private void setUpOptionPanel(String label_name, JPanel panel, String img_name) {
		JLabel label = new JLabel(label_name);
		label.setFont(new Font("Ubuntu Mono", Font.BOLD, 11));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(52, 9, 98, 14);
		panel.add(label);
		
		ImageIcon img = new ImageIcon(res + img_name);
		JLabel lbl_icon = new JLabel(scaleImage(img.getImage(), 21, 21));
		lbl_icon.setBounds(8, 0, 46, 30);
		panel.add(lbl_icon);
		
	}

	private ImageIcon scaleImage(Image image, int w, int h) {
		Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(scaled);
	}
	
	private void createOptionPanel(JPanel panel, int y, String label_name, String img_name) {
		panel.addMouseListener(new PanelButtonMouseAdapter(panel));
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, y, 160, 30);
		panel.setLayout(null);
		setUpOptionPanel(label_name, panel, img_name);
	}

	private void createLayeredPane() {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(170, 11, 504, 339);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
	}
}


