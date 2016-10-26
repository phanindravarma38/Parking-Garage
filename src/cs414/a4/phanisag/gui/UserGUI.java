package cs414.a4.phanisag.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import cs414.a4.phanisag.controller.GenerateTicketActionListener;
import cs414.a4.phanisag.controller.InRadioButtonActionListener;
import cs414.a4.phanisag.controller.OutRadioButtonActionListener;
import cs414.a4.phanisag.controller.PayButtonActionListener;
import cs414.a4.phanisag.utils.ComponentNames;

public class UserGUI extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();

	public static int numberOfAvailableCars = 3;
	// JLabel

	private JLabel inLabel;
	private JLabel outLabel;
	private JLabel vehiclePlateNumber;
	private JLabel ticketNumber;
	private JLabel plateNumberLabel = new JLabel("Enter Plate No");

	private JLabel numberofAvailableCars = new JLabel(
			"Number of Available Lots = " + numberOfAvailableCars);

	private JLabel paymentDetailsLabel = new JLabel("PAYMENT DETAILS");
	private JLabel generateTicketNumberLabel = new JLabel(
			"Generated Ticket Number");

	JRadioButton inRadioButton = new JRadioButton("IN");

	JRadioButton outRadioButton = new JRadioButton("OUT");

	// JTextBox

	private JTextField vehiclePlateTextArea = new JTextField(10);
	private JTextField ticketNumberTextArea = new JTextField(10);
	private JTextField plateNumberTextArea = new JTextField(10);
	private JTextField generateTicketNumberTextArea = new JTextField(10);

	// JButton

	private JButton generateTicketButton = new JButton("Generate Ticket");

	private JButton specialPermissionButton = new JButton("Special Permission");

	private JButton payButton = new JButton("Pay");

	static JFrame f;

	public UserGUI() {

		initGUI();
		doTheLayout();
		addActionListeners();

		inLabel.setName(ComponentNames.IN_LABEL);
		outLabel.setName(ComponentNames.OUT_LABEL);
		vehiclePlateNumber.setName(ComponentNames.VEHICLE_PLATE_NUMBER_LABEL);
		ticketNumber.setName(ComponentNames.TICKET_NUMBER_LABEL);
		plateNumberLabel.setName(ComponentNames.PLATE_NUMBER_LABEL);

		numberofAvailableCars
				.setName(ComponentNames.NUMBER_OF_AVAILABLE_CARS_LABEL);

		paymentDetailsLabel.setName(ComponentNames.PAYMENT_DETAILS_LABEL);
		generateTicketNumberLabel
				.setName(ComponentNames.GENERATE_TICKET_NUMBER_LABEL);

		inRadioButton.setName(ComponentNames.IN_RADIO_BUTTON);

		outRadioButton.setName(ComponentNames.OUT_RADIO_BUTTON);

		// JTextBox

		vehiclePlateTextArea
				.setName(ComponentNames.VEHICLE_PLATE_NUMBER_TEXT_AREA);
		ticketNumberTextArea.setName(ComponentNames.TICKET_NUMBER_TEXT_AREA);
		plateNumberTextArea.setName(ComponentNames.PLATE_NUMBER_TEXT_AREA);
		generateTicketNumberTextArea
				.setName(ComponentNames.GENERATE_TICKET_NUMBER_TEXT_AREA);

		// JButton

		generateTicketButton.setName(ComponentNames.GENERATE_TICKET_BUTTON);

		specialPermissionButton
				.setName(ComponentNames.SPECIAL_PERMISSION_BUTTON);

		payButton.setName(ComponentNames.PAY_BUTTON);

	} // end of constructor

	static void dispose() {

		if (f != null)
			f.dispose();

	}

	private void initGUI() {

		inLabel = new JLabel("IN");
		inRadioButton.setFont(new Font("Serif", Font.BOLD, 24));

		numberofAvailableCars.setFont(new Font("Serif", Font.BOLD, 20));

		outLabel = new JLabel("OUT");
		outRadioButton.setFont(new Font("Serif", Font.BOLD, 24));

		vehiclePlateNumber = new JLabel("Enter Vehicle Plate No");
		ticketNumber = new JLabel("Enter Ticket No");

		generateTicketButton.setPreferredSize(new Dimension(150, 30));
		specialPermissionButton.setPreferredSize(new Dimension(150, 30));

		ButtonGroup group = new ButtonGroup();
		group.add(inRadioButton);
		group.add(outRadioButton);

		generateTicketNumberTextArea.setEditable(false);

		disableAllFields();

	}// end of creating objects method

	private void disableAllFields() {

		vehiclePlateTextArea.setEnabled(false);
		ticketNumberTextArea.setEnabled(false);
		plateNumberTextArea.setEnabled(false);
		payButton.setEnabled(false);
		generateTicketButton.setEnabled(false);
		specialPermissionButton.setEnabled(false);
	}

	private void doTheLayout() {

		try {

			GridBagLayout gbl = new GridBagLayout();
			setLayout(gbl);

			gbc.insets = new Insets(10, 10, 10, 10);

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(inRadioButton, gbc);

			gbc.gridx = 2;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(numberofAvailableCars, gbc);

			gbc.gridx = 4;
			gbc.gridy = 0;
			gbc.anchor = GridBagConstraints.WEST;
			add(outRadioButton, gbc);

			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;
			add(vehiclePlateNumber, gbc);

			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;
			add(vehiclePlateTextArea, gbc);

			gbc.gridx = 3;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;
			add(ticketNumber, gbc);

			gbc.gridx = 4;
			gbc.gridy = 1;
			gbc.anchor = GridBagConstraints.EAST;
			add(ticketNumberTextArea, gbc);

			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.EAST;
			add(generateTicketNumberTextArea, gbc);

			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.EAST;
			add(generateTicketNumberLabel, gbc);

			gbc.gridx = 1;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.EAST;
			add(generateTicketButton, gbc);

			gbc.gridx = 3;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.EAST;
			add(plateNumberLabel, gbc);

			gbc.gridx = 4;
			gbc.gridy = 2;
			gbc.anchor = GridBagConstraints.EAST;
			add(plateNumberTextArea, gbc);

			gbc.gridx = 1;
			gbc.gridy = 4;
			gbc.anchor = GridBagConstraints.EAST;
			add(specialPermissionButton, gbc);

			gbc.gridx = 4;
			gbc.gridy = 3;
			gbc.anchor = GridBagConstraints.WEST;
			add(payButton, gbc);

		} catch (Exception e) {

		}

	}// end of Layout method

	public void addActionListeners() {
		generateTicketButton
				.addActionListener(new GenerateTicketActionListener());
		payButton.addActionListener(new PayButtonActionListener());
		inRadioButton.addActionListener(new InRadioButtonActionListener());
		outRadioButton.addActionListener(new OutRadioButtonActionListener());
	}

	public static void main(String[] args) {

		f = new JFrame("Parking System");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add(new UserGUI());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		f.setResizable(false);
		// f.setSize(400, 200);
		f.setVisible(true);

	}

}
