package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cs414.a4.phanisag.bo.AttendantBO;
import cs414.a4.phanisag.gui.UserGUI;
import cs414.a4.phanisag.model.Attendant;
import cs414.a4.phanisag.model.Customer;
import cs414.a4.phanisag.model.Vehicle;
import cs414.a4.phanisag.utils.ComponentNames;
import cs414.a4.phanisag.utils.Roles;

public class GenerateTicketActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		AttendantBO attendantBO = new AttendantBO();
		
		JButton generateTicketButton = (JButton)e.getSource();
		JTextField generatedTicketNumberTextArea = null;
		JLabel numberOfAvailableCars = null;
		for(Component component: generateTicketButton.getParent().getComponents()){
			if(component.getName().equals(ComponentNames.GENERATE_TICKET_NUMBER_TEXT_AREA)){
				generatedTicketNumberTextArea  = (JTextField)component;
			}
			if(component.getName().equals(ComponentNames.NUMBER_OF_AVAILABLE_CARS_LABEL)){
				numberOfAvailableCars = (JLabel)component;
			}
		}
		
		
		Vehicle vehicle = new Vehicle();
		vehicle.setPlateNumber("");
		
		Attendant attendant = new Attendant();
		attendant.setRole(Roles.ATTENDANT);
		
		Customer customer = new Customer();
		customer.setVehicle(vehicle);
		int ticketNumber = attendantBO.issueTicket(customer, attendant);
		generatedTicketNumberTextArea.setText(ticketNumber + "");
		
		numberOfAvailableCars.setText("Number of Available Lots = " + --UserGUI.numberOfAvailableCars);
		if(UserGUI.numberOfAvailableCars <= 0){
			generateTicketButton.setEnabled(false);
		}
	}

}
