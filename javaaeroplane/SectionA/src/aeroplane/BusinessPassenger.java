package aeroplane;

public class BusinessPassenger extends TravellingPassenger {
	
	private final Luxury luxury;

	public BusinessPassenger(String firstname, String surname, int age, Luxury luxury) {
		super(firstname, surname, age);
		this.luxury = luxury;
	}

	@Override
	public String toString() {
		return "Business Passenger: " + getFirstname() + " " + getSurname();
	}
	
	public Luxury getLuxury() {
		return luxury;
	}

}
