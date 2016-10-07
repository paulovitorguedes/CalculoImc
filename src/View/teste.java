package View;

import javax.swing.JPanel;
import javax.swing.JSpinner;

public class teste extends JPanel {

	/**
	 * Create the panel.
	 */
	public teste() {
		setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(144, 95, 64, 27);
		add(spinner);

	}
}
