package cs414.a4.phanisag.model;

import java.util.Date;

import cs414.a4.phanisag.utils.Roles;

public abstract class User {
	
	protected String firstname;
	protected String lastname;
	protected String username;
	protected String password;
	
	protected Roles role;
	
	protected String email;
	protected String phone;
	protected boolean enabled;
	

	
	protected Address address;
	
	public abstract void setRole(Roles role);
	public abstract Roles getRole();
}
