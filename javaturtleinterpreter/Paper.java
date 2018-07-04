package turtle;

public class Paper {
	
	///*** Instance variables ***///
	private final char[][] grid;
	
	///*** Constants ***///
	private final static char DEFAULT_CHAR = ' ';
	
	///*** Constructor ***///
	public Paper(int width, int height) {
		assert width > 0 && height > 0 : "Dimensions cannot be negative";
		
		grid = new char[height][width];

		// Sets default values in grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = DEFAULT_CHAR;
			}
		}
	}
	
	///*** Methods ***///
	
	public int getWidth() {
		return grid[0].length;
	}
	
	public int getHeight() {
		return grid.length;
	}
	
	public boolean onGrid(int x, int y) {
		return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
	}
	
	public void mark(int x, int y, char symbol) {
		
		if (onGrid(x, y)) {
			grid[y][x] = symbol;
		}
	}
	
	public String toString() {
		String result = "";
		
		for (int i = grid.length-1; i >= 0; i--) {
			result += new String(grid[i]) + "\n";
		}
		
		return result;
	}

	public char[][] getGrid() {
		char[][] result = new char[grid.length][grid[0].length];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = grid[i][j];
			}
		}
		
		return result;
	}
	

}
