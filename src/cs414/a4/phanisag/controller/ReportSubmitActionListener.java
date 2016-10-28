package cs414.a4.phanisag.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import cs414.a4.phanisag.bo.AdminBO;
import cs414.a4.phanisag.utils.ComponentNames;
import cs414.a4.phanisag.utils.ReportDuration;

public class ReportSubmitActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JComboBox<ReportDuration> reportDuration = null;
		
		JButton reportSubmit = (JButton)arg0.getSource();
		for(Component component: reportSubmit.getComponents()){
			if(component.getName().equals(ComponentNames.REPORT_DURATION)){
				reportDuration = (JComboBox)component;
			}
		}
		
		ReportDuration reportDurationOption = (ReportDuration)reportDuration.getSelectedItem();
		AdminBO adminbo = new AdminBO();
		adminbo.generateReport(reportDurationOption);
		
	}

}
