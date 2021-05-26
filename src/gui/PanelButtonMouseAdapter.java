package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PanelButtonMouseAdapter extends MouseAdapter {
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
