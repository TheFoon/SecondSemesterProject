package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;
import control.ItemCtr;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListItemDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	private JList<Item> list;
	private DefaultListModel<Item> listRepresentation;
	
	private ItemCtr itemCtr = new ItemCtr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListItemDialog dialog = new ListItemDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListItemDialog() {
		setTitle("List Products");
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help Contents");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 218, 1, 0 };
		gbl_contentPanel.rowHeights = new int[] { 1, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			list = new JList<>();
			GridBagConstraints gbc_list = new GridBagConstraints();
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
				JButton showButton = new JButton("Update");
				showButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						showUpdateItemDialog();
					}
				});
				{
					JButton removeButton = new JButton("Remove");
					removeButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							removeItem();
						}
					});
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
		Item item = list.getSelectedValue();
		int index = list.getSelectedIndex();

		if (index >= 0 && index < listRepresentation.getSize()) {
			listRepresentation.remove(index);
			itemCtr.removeByBarcode(item.getBarcode());
		}
	}

	private void showUpdateItemDialog() {
		Item item = list.getSelectedValue();
		int index = list.getSelectedIndex();
		if (index >= 0 && index < listRepresentation.getSize()) {
			try {
				UpdateItemDialog dialog = new UpdateItemDialog(item.getBarcode());
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			listRepresentation.set(index, item);
		}

	}
	
	private void init() {
		listRepresentation = new DefaultListModel<Item>();
		ArrayList<Item> modelList = itemCtr.getAll();
		listRepresentation.addAll(modelList);
		
		list.setModel(listRepresentation);
		list.setCellRenderer(new ItemListCellRenderer());
	}

}
