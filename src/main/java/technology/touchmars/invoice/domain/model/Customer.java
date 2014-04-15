package technology.touchmars.invoice.domain.model;

import java.util.Map;

public class Customer {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Map<String, String> notes;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Map<String, String> getNotes() {
		return notes;
	}
	public void setNotes(Map<String, String> notes) {
		this.notes = notes;
	}
}
