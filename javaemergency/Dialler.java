public class Dialler {
  private InputReader ir = new InputReader();

  public boolean call(int i, String m) {
    System.out.println("Simulating the call of number " + i +
         " with message '" + m + "'");
    System.out.println("Should this call be considered successful? (y/n)" );

    return ir.readString().equals("y"); 
  }
}
