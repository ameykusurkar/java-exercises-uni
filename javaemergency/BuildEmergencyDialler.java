
public class BuildEmergencyDialler {
	
	public static void main(String[] args) {
		
		Location location = new Location(2, 6);
		EmergencyDialler ed = new AvgEmergencyDialler(location, new Dialler());
		
		Person contact1 = new Person("Jensen", 4, 2, -9);
		
		Group contact2 = new Group("DaGroup");
		contact2.add(new Person("Jamil", 3, 0, 32));
		
		Group subgroup = new Group("DatGroup");
		subgroup.add(new Person("Ji", 5, -4, -9));
		subgroup.add(new Person("Jane", 2, -4, 1));
		contact2.add(subgroup);
		
		Group contact3 = new Group("DaGroup2");
		contact3.add(new Person("Joe", 1, 2, 3));
		
		ed.addToEmergencyContactList(contact1);
		ed.addToEmergencyContactList(contact2);
		ed.addToEmergencyContactList(contact3);
		
		ed.emergency();
		
		
	}

}
