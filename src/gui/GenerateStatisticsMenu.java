package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Iterator;

import control.ItemCtr;
import control.SaleCtr;
import model.Item;
import model.Sale;
import model.SalesLineItem;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerateStatisticsMenu extends JFrame {

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
					GenerateStatisticsMenu frame = new GenerateStatisticsMenu();
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
	public GenerateStatisticsMenu() {
		
		setTitle("Main menu");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{426, 0};
		gbl_contentPane.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Generate Statistics");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Sales");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSales();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Low stock products");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Notification sent");
				sendNotification();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	
	private void showSales() {
		SaleCtr saleCtr = new SaleCtr();
		String path = "C:\\Users\\tamas\\Desktop\\1st semester project\\Code\\notifications\\Sales.txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			for(Sale sale: saleCtr.getSales()) {
				bw.write("ID: "+ sale.getId()+" | Price: "+sale.getPrice()+"\nContents:\n");
				for(SalesLineItem sli: sale.getSalesLineItems()) {
					bw.write(sli.getItem().getName()+" x "+ sli.getQuantity()+"\nSubtotal: "+sli.getSubtotal()+"\n");
				}
			}
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendNotification() {
		ItemCtr itemCtr = new ItemCtr();
		String path = "C:\\Users\\tamas\\Desktop\\1st semester project\\Code\\notifications\\LowStockProducts.txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			ArrayList<Item> items = itemCtr.getAll();
			Iterator<Item> iterator = items.iterator();
			
			while(iterator.hasNext()) {
				Item item = iterator.next();
				if(item.isLowOnStock()) {
					bw.write("Product name: "+item.getName()+ " | Product barcode: "+item.getBarcode()+" | Current stock: "+item.getStock()+"\n");
				}
			}
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
