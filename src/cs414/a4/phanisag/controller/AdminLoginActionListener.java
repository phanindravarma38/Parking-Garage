package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cs414.a4.phanisag.bo.AdminBO;
import cs414.a4.phanisag.gui.AdminGUI;
import cs414.a4.phanisag.gui.ReportGUI;
import cs414.a4.phanisag.utils.ComponentNames;

public class AdminLoginActionListener implements ActionListener {

	JTextField username = null;
	JPasswordField password = null;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton loginButton = (JButton) arg0.getSource();
		System.out.println(loginButton);

		for (Component component : loginButton.getParent().getComponents()) {
			if(component.getName() != null &&component.getName().equals(ComponentNames.ADMIN_USERNAME)){
				username = (JTextField)component;
			}
			if(component.getName() != null &&component.getName().equals(ComponentNames.ADMIN_PASSWORD)){
				password = (JPasswordField)component;
			}
		}
		
		
		AdminBO adminBo = new AdminBO();
		if(validate() && adminBo.doLogin(username.getText(), password.getText())){
			AdminGUI.dispose();
			ReportGUI.openReport();
		}else{
			AdminGUI.dispose();
			JOptionPane.showMessageDialog(null,
					"Incorrect Credentials", "Input Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean validate(){

		
		String username = this.username.getText().trim();
		String password = this.password.getText().trim();
		
		boolean validate = true;
		
		
		if(username.equals("")){
			JOptionPane.showMessageDialog(null, "Username cannot be empty","Username Error",JOptionPane.ERROR_MESSAGE);
			validate = false;
			
		}else if(password.equals("")){
			JOptionPane.showMessageDialog(null, "Password cannot be empty","Password Error",JOptionPane.ERROR_MESSAGE);
			validate = false;
		}
		
		return validate;
		
	
	}
}
