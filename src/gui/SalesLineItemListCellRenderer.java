package gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.SalesLineItem;

public class SalesLineItemListCellRenderer extends JLabel implements ListCellRenderer<SalesLineItem> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends SalesLineItem> list, SalesLineItem value, int index, boolean isSelected,
			boolean cellHasFocus) {

        setText("Product: "+value.getItem().getName()+" Quantity: "+value.getQuantity());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
	}
}
