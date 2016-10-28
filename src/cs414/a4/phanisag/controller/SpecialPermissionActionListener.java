package cs414.a4.phanisag.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs414.a4.phanisag.gui.AdminGUI;

public class SpecialPermissionActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AdminGUI.openAdminLogin();
	}

}
