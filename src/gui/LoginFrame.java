package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField passwordField;
	
	private List<Account> accounts = new ArrayList<Account>();
	
	private String username;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 238);
		setTitle("Login");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_login = new JLabel("Login");
		lbl_login.setFont(UIManager.getFont("Panel.font"));
		lbl_login.setBounds(138, 11, 44, 14);
		contentPane.add(lbl_login);
		
		accounts.add(new Account("manager", "pass123"));
		accounts.add(new Account("cleaner", "pass123"));
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton_2.setBounds(92, 157, 124, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(46, 36, 68, 14);
		contentPane.add(lbl_username);
		
		txt_username = new JTextField();
		txt_username.setBounds(46, 61, 220, 20);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(46, 92, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(46, 117, 220, 20);
		contentPane.add(passwordField);
		
		ImageIcon img = new ImageIcon("res/login_panel/username.png");
		JLabel lbl_icon = new JLabel(scaleImage(img.getImage(), 21, 21));
		lbl_icon.setBounds(10, 56, 34, 28);
		contentPane.add(lbl_icon);
		
		ImageIcon img_pswd = new ImageIcon("res/login_panel/password.png");
		JLabel lbl_icon_1 = new JLabel(scaleImage(img_pswd.getImage(), 21, 21));
		lbl_icon_1.setBounds(10, 111, 34, 28);
		contentPane.add(lbl_icon_1);
	}
	
	private ImageIcon scaleImage(Image image, int w, int h) {
		Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(scaled);
	}
	
	private void login() {
		username = txt_username.getText();
		password = new String(passwordField.getPassword());
		
		Account account = new Account(username, password);
		
		if(accounts.contains(account)) {
			System.out.print("login credentials matched");
		} else {
			JOptionPane.showMessageDialog(this, "Your username or password is invalid");
		}
		
	}
	
	private class Account {
		private String username;
		private String password;
		
		public Account(String username, String password) {
			this.username = username;
			this.password = password;
		}

		@Override
		public boolean equals(Object obj) {
			boolean equals = false;
			if(username.equals(((Account)obj).getUsername()) && password.equals(((Account)obj).getPassword())) {
				equals = true;
			}
			return equals;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}
		
	}
}
