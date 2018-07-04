package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	
	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException {
		
		Seat current = first;
		boolean reachedLast = false;
		
		while(!reachedLast) {
			
			// Controls the loop ending flag
			reachedLast = current.equals(last);
			
			// Ensures that seat is not taken
			if (!allocation.containsKey(current)) {
				
				// Allocates seat
				if (passenger.isAdult() || !current.isEmergencyExit()) {
					allocation.put(current, passenger);
					return;
				}
			}
			
			// Increments current seat
			if (!reachedLast) {
				current = current.next();
			}
		}
		
		// Exception is thrown if out of range
		throw new AeroplaneFullException();

	}

	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}
	
	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);

		allocateInRange(new CrewMember(firstName, lastName), 
				new Seat(1, 'A'), new Seat(1, Seat.FINAL_COLUMN));
	}

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		
		allocateInRange(new BusinessPassenger(firstName, lastName, age, luxury), 
				new Seat(2, 'A'), new Seat(15, Seat.FINAL_COLUMN));
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		
		allocateInRange(new EconomyPassenger(firstName, lastName, age), 
			new Seat(16, 'A'), new Seat(Seat.FINAL_ROW, Seat.FINAL_COLUMN));
	}
	
	// Upgrades economy passengers to business if possible
	void upgrade() {
		
		Set<Seat> econSeats = getEconSeats();
		
		for (Seat s : econSeats) {
			
			try {
				
				// Allocates business seat to economy passenger
				allocateInRange(allocation.get(s), new Seat(2, 'A'), 
							new Seat(15, Seat.FINAL_COLUMN));
				
				// Removes old seat pairing if upgrade is successful
				allocation.remove(s);
				
			} catch (AeroplaneFullException e) {
				
				// Stops trying to upgrade if business is full
				return;
			}
			
		}
	}
	
	// Returns a set of the economy seats already allocated
	private Set<Seat> getEconSeats() {
		
		Set<Seat> result = new HashSet<Seat>();
		
		for (Seat s : allocation.keySet()) {
			
			int row = s.getRow();
			
			// Checks to see if it is an economy seat
			if (16 <= row && row <= Seat.FINAL_ROW) {
				
				// Adds economy seat to result set
				result.add(s);
			}
		}
		
		return result;
	}

	int numPassengers() {
		return allocation.size();
	}

}
