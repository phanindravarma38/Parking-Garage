package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import cs414.a4.phanisag.bo.AdminBO;
import cs414.a4.phanisag.utils.ComponentNames;
import cs414.a4.phanisag.utils.ReportDuration;

public class ReportSubmitActionListener implements ActionListener {
	JComboBox<ReportDuration> reportDuration = null;
	@Override
	public void actionPerformed(ActionEvent arg0) {

		JButton reportButton = (JButton)arg0.getSource();
		for(Component component: reportButton.getParent().getComponents()){
			if(component != null && component.getName() !=null && component.getName().equals(ComponentNames.REPORT_DURATION)){
				reportDuration = (JComboBox)component;
			}
		}
		AdminBO adminbo = new AdminBO();
		adminbo.generateReport((ReportDuration)reportDuration.getSelectedItem());
	}

	private boolean validate() {

		int reporttype = reportDuration.getSelectedIndex();
		boolean validate = true;
		if (reporttype == 0) {
			JOptionPane.showMessageDialog(null, "Select Proper Report Type",
					"Report type Error", JOptionPane.ERROR_MESSAGE);
			validate = false;
		}
		return validate;

	}

}
