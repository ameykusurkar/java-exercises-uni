package aeroplane;

public class CrewMember extends Passenger {

	public CrewMember(String firstname, String surname) {
		super(firstname, surname);
	}

	@Override
	public boolean isAdult() {
		return true;
	}

	@Override
	public String toString() {
		return "Crew Member: " + getFirstname() + " " + getSurname();
	}

}
