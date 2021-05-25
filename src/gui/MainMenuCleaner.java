package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ItemCtr;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainMenuCleaner extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuCleaner frame = new MainMenuCleaner();
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
	public MainMenuCleaner() {
		
		setTitle("Main menu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{426, 0};
		gbl_contentPane.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btn_housing_units = new JButton("Housing Units");
		btn_housing_units.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHousingUnitMenu();
			}
		});
		btn_housing_units.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btn_housing_units = new GridBagConstraints();
		gbc_btn_housing_units.insets = new Insets(0, 0, 5, 0);
		gbc_btn_housing_units.gridx = 0;
		gbc_btn_housing_units.gridy = 2;
		contentPane.add(btn_housing_units, gbc_btn_housing_units);
		
		JButton btn_cleaners = new JButton("Cleaners");
		btn_cleaners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//showCleanerMenu();
			}
		});
		btn_cleaners.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btn_cleaners = new GridBagConstraints();
		gbc_btn_cleaners.insets = new Insets(0, 0, 5, 0);
		gbc_btn_cleaners.gridx = 0;
		gbc_btn_cleaners.gridy = 4;
		contentPane.add(btn_cleaners, gbc_btn_cleaners);
		
		JButton btn_shifts = new JButton("Shifts");
		btn_shifts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//showShiftMenu();
			}
		});
		btn_shifts.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btn_shifts = new GridBagConstraints();
		gbc_btn_shifts.insets = new Insets(0, 0, 5, 0);
		gbc_btn_shifts.gridx = 0;
		gbc_btn_shifts.gridy = 6;
		contentPane.add(btn_shifts, gbc_btn_shifts);
		
		JButton btn_tasks = new JButton("Tasks");
		btn_tasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//showTaskMenu();
			}
		});
		btn_tasks.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btn_tasks = new GridBagConstraints();
		gbc_btn_tasks.insets = new Insets(0, 0, 5, 0);
		gbc_btn_tasks.gridx = 0;
		gbc_btn_tasks.gridy = 7;
		contentPane.add(btn_tasks, gbc_btn_tasks);
	}
	
	protected void showHousingUnitMenu() {
		// TODO Auto-generated method stub
		
	}

	private void registerSale() {
		try {
			RegisterSaleDialog dialog = new RegisterSaleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showItemMenu() {
		try {
			ItemMenu dialog = new ItemMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
