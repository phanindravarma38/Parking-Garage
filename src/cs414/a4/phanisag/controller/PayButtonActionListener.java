package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cs414.a4.phanisag.gui.Payment;
import cs414.a4.phanisag.utils.ComponentNames;

public class PayButtonActionListener implements ActionListener {

	private JTextField ticketNumberTextArea;
	private JTextField plateNumberTextArea;

	public void actionPerformed(java.awt.event.ActionEvent evt) {

		JButton payButton = (JButton) evt.getSource();

		for (Component component : payButton.getParent().getComponents()) {
			if (component.getName().equals(
					ComponentNames.TICKET_NUMBER_TEXT_AREA)) {
				ticketNumberTextArea = (JTextField) component;
			}
			if (component.getName().equals(
					ComponentNames.PLATE_NUMBER_TEXT_AREA)) {
				plateNumberTextArea = (JTextField) component;
			}
		}

		if (validatePay()) {

			Payment.openPayment();
		}

	}

	private boolean validatePay() {
		boolean isValidData = true;

		String ticketNumber = ticketNumberTextArea.getText().trim();
		String plateNumber = plateNumberTextArea.getText().trim();

		if (ticketNumber.equals("")) {
			JOptionPane.showMessageDialog(null,
					"Ticket Number cannot be blank", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			ticketNumberTextArea.setText("");
			ticketNumberTextArea.grabFocus();
			isValidData = false;
		} else if (ticketNumber.length() != 6) {
			JOptionPane.showMessageDialog(null,
					"Ticket Number must contain 6 digits", "Input Error",
					JOptionPane.ERROR_MESSAGE);
			ticketNumberTextArea.setText("");
			ticketNumberTextArea.grabFocus();
			isValidData = false;
		} else if (plateNumber.equals("")) {
			JOptionPane.showMessageDialog(null, "Plate Number cannot be blank",
					"Input Error", JOptionPane.ERROR_MESSAGE);
			plateNumberTextArea.setText("");
			plateNumberTextArea.grabFocus();
			isValidData = false;
		} else if (true) {

			if (plateNumber.contains("-")) {
				if (ticketNumber.length() != 7) {
					JOptionPane.showMessageDialog(null,
							"Plate Number must contain 7 digits",
							"Input Error", JOptionPane.ERROR_MESSAGE);
					plateNumberTextArea.setText("");
					plateNumberTextArea.grabFocus();
					isValidData = false;
				}
			} else if (plateNumber.length() != 6) {
				JOptionPane.showMessageDialog(null,
						"Plate Number must contain 6 digits", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				plateNumberTextArea.setText("");
				plateNumberTextArea.grabFocus();
				isValidData = false;
			}

		}

		return isValidData;
	}

}
