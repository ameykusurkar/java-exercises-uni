package aeroplane;

public abstract class Passenger {

	private final String firstname;
	private final String surname;
	
	public abstract boolean isAdult();
	
	public abstract String toString();
	
	public Passenger(String firstname, String surname) {
		this.firstname = firstname;
		this.surname = surname;
	}
	
	protected String getFirstname() {
		return firstname;
	}
	
	protected String getSurname() {
		return surname;
	}
	
}
