package cs414.a4.phanisag.gui;


import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cs414.a4.phanisag.controller.ReportSubmitActionListener;
import cs414.a4.phanisag.utils.ComponentNames;
import cs414.a4.phanisag.utils.ReportDuration;



public class ReportGUI extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();

	// JLabel

	private JLabel reportTypeLabel = new JLabel("Report Type");
	
	
	private JComboBox<ReportDuration> reportTypeComboBox = new JComboBox<ReportDuration>(ReportDuration.values());
	
	
	private JButton downloadButton = new JButton("Download Report");
	
	
	static JFrame f;

	public ReportGUI() {

		doTheLayout();
		reportTypeComboBox.setName(ComponentNames.REPORT_DURATION);
		
		downloadButton
		.addActionListener(new ReportSubmitActionListener());


	} // end of constructor



	

	private void doTheLayout()
	{

		try {

			GridBagLayout gbl = new GridBagLayout();
			setLayout(gbl);

			gbc.insets = new Insets(10, 10, 10, 10);

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(reportTypeLabel, gbc);
			
			
			
			gbc.gridx = 1;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(reportTypeComboBox, gbc);
			
			
			
			
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.WEST;
			add(downloadButton, gbc);
			

		} catch (Exception e) {

		}

	}// end of Layout method


	public static void openReport() {

		f = new JFrame("Reports");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add(new ReportGUI());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		// f.setSize(400, 200);
		f.setVisible(true);

	}

}
