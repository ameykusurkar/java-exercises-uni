public class TestPerson {
	static public void main(String[] args) {
		Person p = new Person("Seb", 3, 4, 5);
		if (p.getTelephoneNumber()!=3) {
			System.out.println("Failed number");
			return;
		}	
			
		if (p.getAddress().getX() != 4 || p.getAddress().getY() !=5) {
			System.out.println("Failed location");
			return;
		}
		System.out.println("Succeeded test!");
	}
}
