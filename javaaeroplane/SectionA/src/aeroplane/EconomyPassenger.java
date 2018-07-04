package aeroplane;

public class EconomyPassenger extends TravellingPassenger {

	public EconomyPassenger(String firstname, String surname, int age) {
		super(firstname, surname, age);
	}

	@Override
	public String toString() {
		return "Economy Passenger: " + getFirstname() + " " + getSurname();
	}

}
