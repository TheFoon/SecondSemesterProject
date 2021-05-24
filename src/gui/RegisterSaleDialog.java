package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;
import control.SaleCtr;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Insets;

public class RegisterSaleDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JList<SalesLineItem> list;
	private DefaultListModel<SalesLineItem> listRepresentation;
	
	private SaleCtr saleCtr = new SaleCtr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterSaleDialog dialog = new RegisterSaleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterSaleDialog() {
		setTitle("Registering Sale");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 218, 1, 0 };
		gbl_contentPanel.rowHeights = new int[] { 1, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			list = new JList<>();
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 5, 0);
			gbc_list.anchor = GridBagConstraints.NORTHWEST;
			gbc_list.gridx = 1;
			gbc_list.gridy = 0;
			contentPanel.add(list, gbc_list);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton showButton = new JButton("Refresh");
				showButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						init();
					}
				});
				{
					JButton removeButton = new JButton("Remove");
					removeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							removeItem();
						}
					});
					{
						JButton btnNewButton = new JButton("Add");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								showAddItemDialog();
							}
						});
						{
							JButton btnNewButton_1 = new JButton("Confirm");
							btnNewButton_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									registerSale();
								}
							});
							buttonPane.add(btnNewButton_1);
						}
						buttonPane.add(btnNewButton);
					}
					buttonPane.add(removeButton);
				}
				showButton.setActionCommand("OK");
				buttonPane.add(showButton);
				getRootPane().setDefaultButton(showButton);
			}
		}

		init();
	}
	
	private void removeItem() {
		SalesLineItem sli = list.getSelectedValue();
		int index = list.getSelectedIndex();

		if (index >= 0 && index < listRepresentation.getSize()) {
			listRepresentation.remove(index);
			saleCtr.removeSalesLineItem(sli);
		}
	}

	/*
	private void showUpdateItemDialog() {
		SalesLineItem sli = list.getSelectedValue();
		int index = list.getSelectedIndex();
		if (index >= 0 && index < listRepresentation.getSize()) {
			try {
				UpdateItemDialog dialog = new UpdateItemDialog(sli);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			listRepresentation.set(index, sli);
		}

	}
	*/
	
	private void init() {
		listRepresentation = new DefaultListModel<SalesLineItem>();
		ArrayList<SalesLineItem> modelList = saleCtr.getSalesLineItems();
		listRepresentation.addAll(modelList);
		
		list.setModel(listRepresentation);
		list.setCellRenderer(new SalesLineItemListCellRenderer());
	}
	
	private void showAddItemDialog() {
		try {
			AddItemDialog dialog = new AddItemDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerSale() {
		if(!listRepresentation.isEmpty()) {
			saleCtr.registerSale();
			JOptionPane.showMessageDialog(this, "The sale was successfully registered.", "Success", JOptionPane.INFORMATION_MESSAGE);
			init();
		} else {
			JOptionPane.showMessageDialog(this, "Please add items first!", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
