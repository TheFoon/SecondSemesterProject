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

public class ManagerDashboardFrame extends JFrame {

	private JPanel contentPane;
	
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerDashboardFrame frame = new ManagerDashboardFrame();
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
	public ManagerDashboardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setTitle("Manager Dashboard");
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
		
		ImageIcon img_logo = new ImageIcon("src/res/logo.png");
		JLabel lblIconLogo = new JLabel(scaleImage(img_logo.getImage(), 118, 41));
		lblIconLogo.setBounds(10, 11, 140, 88);
		panelMenu.add(lblIconLogo);
		
		
		//the panel names need to be renamed as soon as possible
		JPanel assign_task_button = new JPanel();
		createOptionPanel(assign_task_button, 110, "Assign task", "res/manager_dashboard/assign_task.png");
		panelMenu.add(assign_task_button);
		
		JPanel manage_shifts_button = new JPanel();
		createOptionPanel(manage_shifts_button, 140, "Manage shifts", "res/manager_dashboard/manage_shifts.png");
		panelMenu.add(manage_shifts_button);
		
		JPanel manage_tasks_button = new JPanel();
		createOptionPanel(manage_tasks_button, 170, "Manage tasks", "res/manager_dashboard/manage_tasks.png");
		panelMenu.add(manage_tasks_button);
		
		JPanel manage_cleaners_button = new JPanel();
		createOptionPanel(manage_cleaners_button, 200, "Manage cleaners", "res/manager_dashboard/manage_cleaners.png");
		panelMenu.add(manage_cleaners_button);
		
		JPanel manage_housing_units = new JPanel();
		createOptionPanel(manage_housing_units, 230, "Manage units", "res/manager_dashboard/manage_housing_units.png");
		panelMenu.add(manage_housing_units);
		
		JPanel exit_button = new JPanel();
		createOptionPanel(exit_button, 260, "Exit", "src/res/exit.png");
		panelMenu.add(exit_button);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(170, 11, 504, 339);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel assign_task_panel = new AssignTaskPanel();
		layeredPane.add(assign_task_panel, "assign_task_panel");
		assign_task_panel.setLayout(null);
		
		JPanel manage_shifts_panel = new JPanel();
		layeredPane.add(manage_shifts_panel, "manage_shifts_panel");
		manage_shifts_panel.setLayout(null);
		
		JLabel lbl_manage_shift_not_implemented = new JLabel("Shifts panel not yet implemented");
		lbl_manage_shift_not_implemented.setBounds(135, 159, 208, 14);
		manage_shifts_panel.add(lbl_manage_shift_not_implemented);
		
		JPanel manage_tasks_panel = new JPanel();
		layeredPane.add(manage_tasks_panel, "manage_tasks_panel");
		manage_tasks_panel.setLayout(null);
		
		JLabel lbl_manage_tasks_not_implemented = new JLabel("Tasks panel not yet implemented");
		lbl_manage_tasks_not_implemented.setBounds(170, 152, 174, 14);
		manage_tasks_panel.add(lbl_manage_tasks_not_implemented);
		
		//listeners here so we can access the variables defined above
		addMouseListenerToPanel(assign_task_button, assign_task_panel);
		
		addMouseListenerToPanel(manage_shifts_button, manage_shifts_panel);
		
		addMouseListenerToPanel(manage_tasks_button, manage_tasks_panel);
		
		
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


