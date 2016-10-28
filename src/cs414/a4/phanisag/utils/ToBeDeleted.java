package cs414.a4.phanisag.utils;

import java.util.List;

import cs414.a4.phanisag.bo.AdminBO;

public class ToBeDeleted {
	public static void main(String[] args) {
		AdminBO admin = new AdminBO();
		admin.generateReport(ReportDuration.MONTHLY);
	}
}
