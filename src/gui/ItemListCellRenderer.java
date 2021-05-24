package gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Item;

public class ItemListCellRenderer extends JLabel implements ListCellRenderer<Item> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {

        setText(value.getName());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
        	if(value.isLowOnStock()) {
        		setBackground(list.getBackground().RED);
        	} else {
        		setBackground(list.getBackground());
        	}
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
	}
}
