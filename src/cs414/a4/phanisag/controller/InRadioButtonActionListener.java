package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cs414.a4.phanisag.utils.ComponentNames;

public class InRadioButtonActionListener implements ActionListener {

	private JTextField vehiclePlateTextArea;
	private JTextField ticketNumberTextArea;
	private JTextField plateNumberTextArea;

	private JButton generateTicketButton;
	private JButton payButton;
	private JButton specialPermissionButton;
	private JTextField customerName;

	public void actionPerformed(java.awt.event.ActionEvent evt) {

		JRadioButton inRadioButton = (JRadioButton) evt.getSource();
		for (Component component : inRadioButton.getParent().getComponents()) {
			if (component.getName().equals(
					ComponentNames.VEHICLE_PLATE_NUMBER_TEXT_AREA)) {
				vehiclePlateTextArea = (JTextField) component;
			}
			if (component.getName().equals(
					ComponentNames.TICKET_NUMBER_TEXT_AREA)) {
				ticketNumberTextArea = (JTextField) component;
			}
			if (component.getName().equals(
					ComponentNames.PLATE_NUMBER_TEXT_AREA)) {
				plateNumberTextArea = (JTextField) component;
			}
			if (component.getName().equals(ComponentNames.PAY_BUTTON)) {
				payButton = (JButton) component;
			}
			if (component.getName().equals(
					ComponentNames.GENERATE_TICKET_BUTTON)) {
				generateTicketButton = (JButton) component;
			}
			if (component.getName().equals(
					ComponentNames.SPECIAL_PERMISSION_BUTTON)) {
				specialPermissionButton = (JButton) component;
			}
			if (component.getName().equals(ComponentNames.CUSTOMER_NAME_TEXT_AREA)){
				customerName = (JTextField) component;
			}
		}

		enablInFields();

	}

	private void enablInFields() {

		vehiclePlateTextArea.setEnabled(true);
		ticketNumberTextArea.setEnabled(false);
		plateNumberTextArea.setEnabled(false);
		payButton.setEnabled(false);
		generateTicketButton.setEnabled(true);
		specialPermissionButton.setEnabled(true);
		customerName.setEnabled(true);
	}

}
