package cs414.a4.phanisag.model;

import cs414.a4.phanisag.utils.Roles;

public class Attendant{

	
	private int attendantId;
	
	private static int i = 1;
	
	public Attendant(){
		attendantId = i;
		i++;
	}
	
	public int getAttendantId() {
		return attendantId;
	}

	public void setAttendantId(int attendantId) {
		this.attendantId = attendantId;
	}


}
