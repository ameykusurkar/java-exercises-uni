

public abstract class EmergencyDialler {
	
	protected PriorityQueue<Contact> queue;
	protected Location location;
	private Dialler dialler;
	
	public EmergencyDialler(Location location, Dialler dialler) {
		this.location = location;
		this.dialler = dialler;
		queue = new LinkedListPriorityQueue<Contact>();
	}
	
	// Returns the first successful contact
	public Contact emergency() {
		while (!queue.isEmpty()) {
			Contact curr = queue.dequeue();
			if (contactIsFree(curr)) {
				return curr;
			}
		}
		return null;
	}
	
	private boolean contactIsFree(Contact c) {
		for (Person p : c.getPeople()) {
			if (!dialler.call(p.getTelephoneNumber(),
												"Help me " + p.getName())) {
				return false;
			}
		}
		return true;
	}
	
	public abstract void addToEmergencyContactList(Contact c);

}
