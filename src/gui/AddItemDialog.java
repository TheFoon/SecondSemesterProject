package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ItemCtr;
import control.SaleCtr;
import model.Item;
import model.SalesLineItem;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class AddItemDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldBarcode;
	private JTextField textFieldQuantity;
	
	private SaleCtr saleCtr = new SaleCtr();
	private ItemCtr itemCtr = new ItemCtr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddItemDialog dialog = new AddItemDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddItemDialog() {
		setBounds(100, 100, 450, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Barcode:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFieldBarcode = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(textFieldBarcode, gbc_textField);
			textFieldBarcode.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Quantity:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textFieldQuantity = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 2;
			contentPanel.add(textFieldQuantity, gbc_textField_1);
			textFieldQuantity.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addItem();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	private void addItem() {
		String barcode = textFieldBarcode.getText();
		int quantity = 1;
		try {
			quantity = Integer.valueOf(textFieldQuantity.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Incorrect information in one of the fields", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Item item = itemCtr.getItem(barcode);
		
		if(item != null && quantity > 0 && quantity <= item.getStock()) {
			SalesLineItem sli = new SalesLineItem(item, quantity);
			System.out.println(sli.getSubtotal());
			saleCtr.addSalesLineItem(sli);
			JOptionPane.showMessageDialog(this, quantity+ " of the selected product was added to the sale.", "Success", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Incorrect information in one of the fields", "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

}
