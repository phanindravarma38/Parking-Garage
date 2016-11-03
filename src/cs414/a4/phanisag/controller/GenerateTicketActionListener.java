package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cs414.a4.phanisag.bo.AdminBO;
import cs414.a4.phanisag.bo.AttendantBO;
import cs414.a4.phanisag.gui.UserGUI;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.Vehicle;
import cs414.a4.phanisag.utils.ComponentNames;

public class GenerateTicketActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		AttendantBO attendantBO = new AttendantBO();

		JButton generateTicketButton = (JButton) e.getSource();
		JTextField generatedTicketNumberTextArea = null;
		JLabel numberOfAvailableCars = null;
		JTextField customerNameTextArea = null;
		JTextField vehiclePlateNumber = null;

		for (Component component : generateTicketButton.getParent()
				.getComponents()) {
	 
	if(component != null && component.getName() != null){
			if (component.getName().equals(
					ComponentNames.GENERATE_TICKET_NUMBER_TEXT_AREA)) {
				generatedTicketNumberTextArea = (JTextField) component;
			}
			if (component.getName().equals(
					ComponentNames.NUMBER_OF_AVAILABLE_CARS_LABEL)) {
				numberOfAvailableCars = (JLabel) component;
			}
			if (component.getName().equals(
					ComponentNames.CUSTOMER_NAME_TEXT_AREA)) {
				customerNameTextArea = (JTextField) component;
			}
			if (component.getName().equals(
					ComponentNames.VEHICLE_PLATE_NUMBER_TEXT_AREA)) {
				vehiclePlateNumber = (JTextField) component;
			}
		}}

		Vehicle vehicle = new Vehicle();
		vehicle.setPlateNumber(vehiclePlateNumber.getText());

		Attendant attendant = new Attendant();

		Customer customer = new Customer();
		if (customerNameTextArea != null
				&& customerNameTextArea.getText() != null
				&& !customerNameTextArea.getText().isEmpty()) {
			customer.setFirstname(customerNameTextArea.getText().split(" ")[0]);
			if (customerNameTextArea.getText().split(" ").length > 1)
				customer.setLastname(customerNameTextArea.getText().split(" ")[1]);

		}
		customer.setVehicle(vehicle);
		int ticketNumber = attendantBO.issueTicket(customer, attendant);
		if (ticketNumber == 0) {
			generatedTicketNumberTextArea.setText("generate failed.");
		} else {
			generatedTicketNumberTextArea.setText(ticketNumber + "");
			numberOfAvailableCars.setText("Number of Available Lots = "
					+ new AdminBO().getLotCapacity());
		}
		if (UserGUI.numberOfAvailableSpaces <= 0) {
			generateTicketButton.setEnabled(false);
		}
	}
	}



