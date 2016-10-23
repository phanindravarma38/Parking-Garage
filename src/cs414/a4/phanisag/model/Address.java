package cs414.a4.phanisag.model;

public class Address {

	private String addressType;
	private String line1;
	private String line2;
	
	private String city;
	private String state;
	private String country;
	private String zip;
	public String getAddressType() {
		return addressType;
	}
	public String getLine1() {
		return line1;
	}
	public String getLine2() {
		return line2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getZip() {
		return zip;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
