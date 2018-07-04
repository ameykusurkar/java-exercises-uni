package aeroplane;

import java.io.IOException;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Program should be invoked with exactly one argument, the name of the data file");
			System.exit(1);
		}
		
		SeatAllocator allocator = new SeatAllocator();
		
		try {
			allocator.allocate(args[0]);
		} catch (IOException e) {
			System.out.println("An IO exception occurred");
			System.exit(1);
		} catch (AeroplaneFullException e) {
			System.out.println("Unable to allocate all passengers");
		}

		System.out.println(allocator);
		
		System.out.println(allocator.numPassengers());

		// Lucky day for some economy passengers
		allocator.upgrade();
		
		System.out.println(allocator.numPassengers());
		
		System.out.println(allocator);
		
	}
	
	// Returns the number of adults in a passenger set
	private static <T extends Passenger> int countAdults(Set<T> ts) {
		
		int numAdults = 0;
		
		for (T t : ts) {
			
			if (t.isAdult()) {
				numAdults++;
			}
		}
		
		return numAdults;
	}
	
}
