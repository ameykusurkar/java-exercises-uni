import java.util.Set;


public class AvgEmergencyDialler extends EmergencyDialler {

	public AvgEmergencyDialler(Location location, Dialler dialler) {
		super(location, dialler);
	}

	@Override
	public void addToEmergencyContactList(Contact c) {
		queue.add(getPriority(c), c);
	}

	// Returns average distance of the group from the emergency
	private double getPriority(Contact c) {
		Set<Person> people = c.getPeople();
		double totalDistance = 0;
		for (Person p : people) {
			totalDistance += p.getAddress().distanceTo(location);
		}
		return totalDistance / people.size();
	}

}
