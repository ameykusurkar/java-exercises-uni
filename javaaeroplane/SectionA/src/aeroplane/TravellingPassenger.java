package aeroplane;

public abstract class TravellingPassenger extends Passenger {
	
	private final int age;
	
	private static final int ADULT_AGE = 18;

	public TravellingPassenger(String firstname, String surname, int age) {
		super(firstname, surname);
		
		assert age > 0 : "Age must be positive";
		
		this.age = age;
	}

	@Override
	public boolean isAdult() {
		return age >= ADULT_AGE;
	}

	@Override
	public abstract String toString();

}
