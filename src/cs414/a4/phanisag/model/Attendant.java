package cs414.a4.phanisag.model;

import cs414.a4.phanisag.utils.Roles;

public class Attendant extends User{

	
	private int attendantId;
	
	private static int i = 1;
	private Roles role;
	
	public Attendant(){
		attendantId = i;
		i++;
		role = Roles.ATTENDANT;
	}
	
	public int getAttendantId() {
		return attendantId;
	}

	public void setAttendantId(int attendantId) {
		this.attendantId = attendantId;
	}

	@Override
	public void setRole(Roles role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Roles getRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
