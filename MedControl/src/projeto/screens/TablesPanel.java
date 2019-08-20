package projeto.screens;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class TablesPanel extends JPanel{
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	
	public TablesPanel() {
		initComponents();
	}
	
	public void initComponents() {
		setBounds(0, 40, screen.width, screen.height-40);
		setLayout(null);
		setOpaque(false);
		setVisible(false);
	}
}
