package aeroplane;

import java.util.NoSuchElementException;

public class Seat {

	private final int row;
	private final char column;
	
	public static final int FINAL_ROW = 50;
	public static final char FINAL_COLUMN = 'F'; 
	
	public Seat(int row, char column) {
		assert 1 <= row && row <= FINAL_ROW : "Invalid row";
		assert 'A' <= column && column <= FINAL_COLUMN : "Invalid column";
		
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "" + row + column;
	}
	
	public boolean isEmergencyExit() {
		
		// 1, 10, 30 are the emergency rows
		return row == 1 || row == 10 || row == 30;
	}
	
	public boolean hasNext() {
		return !(row == FINAL_ROW && column == FINAL_COLUMN);
	}
	
	public Seat next() {
		
		if (!hasNext()) {
			throw new NoSuchElementException();
		} else {
			int newRow = row;
			char newColumn = (char) (column + 1);
			
			// Goes to next row if it goes past end of row
			if (newColumn > FINAL_COLUMN) {
				newColumn = 'A';
				newRow++;
			}
			
			return new Seat(newRow, newColumn);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Seat)) {
			
			return false;
			
		} else {
		
		Seat seat = (Seat) obj;
		return this.row == seat.row && this.column == seat.column;
		
		}
	}
	
	@Override
	public int hashCode() {
		
		// (FINAL_COLUMN - 'A' + 1) is the length of a row
		return row * (FINAL_COLUMN - 'A' + 1) + column;
	}

	public int getRow() {
		return row;
	}
	
}
