package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cs414.a4.phanisag.utils.ComponentNames;

public class OutRadioButtonActionListener implements ActionListener {

	private JTextField vehiclePlateTextArea;
	private JTextField ticketNumberTextArea;
	private JTextField plateNumberTextArea;
	private JTextField customerName;

	private JButton generateTicketButton;
	private JButton payButton;
	private JButton specialPermissionButton;

	public void actionPerformed(java.awt.event.ActionEvent evt) {

		JRadioButton outRadioButton = (JRadioButton) evt.getSource();
		for (Component component : outRadioButton.getParent().getComponents()) {
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

		enableOutFields();

	}

	private void enableOutFields() {

		vehiclePlateTextArea.setEnabled(false);
		ticketNumberTextArea.setEnabled(true);
		plateNumberTextArea.setEnabled(true);
		payButton.setEnabled(true);
		generateTicketButton.setEnabled(false);
		specialPermissionButton.setEnabled(false);
		customerName.setEnabled(false);
	}

}
