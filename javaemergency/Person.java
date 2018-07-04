import java.util.Set;
import java.util.HashSet;

public class Person implements Contact {
 private String name;
 private int number;
 private Location address;

 public Person(String _name, int _number, int locationX, int locationY){
   name = _name;
   number = _number;
   address = new Location(locationX, locationY);
 }
 
 public int getTelephoneNumber(){
   return number;
 }
 
 public Location getAddress(){
   return address;
 }

 public Set<Person> getPeople(){
   Set<Person> s = new HashSet<Person>();
   s.add(this);
   return s;
 }

 public String getName(){
   return name;
 }

 public int size() {
   return 1;
 }

}
