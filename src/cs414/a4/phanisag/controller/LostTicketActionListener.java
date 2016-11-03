package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cs414.a4.phanisag.bo.AttendantBO;
import cs414.a4.phanisag.dao.AttendantDAO;
import cs414.a4.phanisag.gui.PaymentGUI;
import cs414.a4.phanisag.gui.UserGUI;
import cs414.a4.phanisag.utils.ComponentNames;

public class LostTicketActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JButton lostTicketButton = (JButton) arg0.getSource();
		JTextField vehicleNumberTextField = null;
		for (Component component : lostTicketButton.getParent().getComponents()) {
			if (component != null && component.getName() != null) {
				if (component.getName().equals(
						ComponentNames.PLATE_NUMBER_TEXT_AREA)) {
					vehicleNumberTextField = (JTextField) component;
				}
			}
		}
		if (vehicleNumberTextField != null) {
			if (vehicleNumberTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Vehicle number should not be empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				AttendantBO attendantBo = new AttendantBO();
				if(attendantBo.canMakeExit(0, vehicleNumberTextField.getText(),
						true)){
					
					PaymentGUI.setBillAmount(100.00);
					PaymentGUI.openPayment();
				}
				else
					JOptionPane.showMessageDialog(null,
								"Vehicle number does not exist.", "Input Error",
								JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
