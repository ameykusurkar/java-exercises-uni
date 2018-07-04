import java.util.HashSet;
import java.util.Set;


public class Group implements Contact {
	
	private final String name;
	private Set<Contact> contacts;
	
	public Group(String name) {
		this.name = name;
		this.contacts = new HashSet<Contact>();
	}
	
	public void add(Contact contact) {
		contacts.add(contact);
	}
	
	public void remove(Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public Set<Person> getPeople() {
		Set<Person> people = new HashSet<Person>();
		for (Contact c : contacts) {
			people = mergeSets(people, c.getPeople());
		}
		return people;
	}
	
	// Adds Persons in Set b to Set A
	private Set<Person> mergeSets(Set<Person> a, Set<Person> b) {
		for (Person p : b) {
			a.add(p);
		}
		return a;
	}

	@Override
	public String getName() {
		return name;
	}

}
