package turtle.implementations;

import turtle.Paper;
import turtle.Turtle;
import turtle.util.Direction;
import turtle.util.Pen;
import turtle.util.Rotation;
import turtle.util.Tuple;

public abstract class AbstractTurtle implements Turtle {
	
	///*** Instance variables ***///
	private Pen pen;
	private Direction dir;
	private Tuple<Integer, Integer> position;
	private char brush;
	protected final Paper paper;
	
	///*** Constructor ***///
	public AbstractTurtle(int x, int y, Paper paper) {
		this.position = new Tuple<Integer, Integer>(x, y);
		this.dir = Direction.NORTH;
		this.pen = Pen.UP;
		this.brush = '*';
		this.paper = paper;
	}
	
	///*** Methods ***///
	
	public void changePenState(Pen p) {
		pen = p;
	}
	
	public void changeBrush(char ch) {
		brush = ch;
	}
	
	public void rotateTurtle(Rotation r, int n) {
		assert n >= 0 : "Cannot rotate negative number of times";
		
		for (int i = 0; i < n; i++) {
			dir = dir.rotate(r);
		}
	}
	
	protected void mark() {
		
		if (pen == Pen.DOWN) {
			paper.mark(position.getX(), position.getY(), brush);
		}
	}
	
	public void move(int n) {
		assert n >= 0 : "Cannot move negative number of steps";

		Tuple<Integer, Integer> mov;

		for (int i = 0; i < n; i++) {
			
			mov = dir.getMovement();
			
			if (willCrossBoundary(mov)) {
				
				boundaryCase(mov);
				
			} else {

				moveTurtle(mov);
				mark();
			}
		}
	}
	
	// Moves turtle one unit in it's direction vector
	protected void moveTurtle(Tuple<Integer, Integer> mov) {

		position = new Tuple<Integer, Integer>(position.getX()
				+ mov.getX(), position.getY() + mov.getY());
	}
	
	private boolean willCrossBoundary(Tuple<Integer, Integer> mov) {
		
		return !paper.onGrid(position.getX() + mov.getX(), 
				position.getY() + mov.getY());
	}
	
	public boolean isOnGrid() {
		
		return paper.onGrid(position.getX(), position.getY());
	}
	
	protected Tuple<Integer, Integer> getPosition() {
		return position;
	}
	
	protected void setPosition(int x, int y) {
		assert paper.onGrid(x, y) : "Position not on grid";
		
		position = new Tuple<Integer, Integer>(x, y); 
	}
	
	protected Direction getDirection() {
		return dir;
	}
	
	protected void setDirection(Direction dir) {
		this.dir = dir;
	}
	
	// Abstract method which decides 
	// what each type of turtle does at the boundary
	protected abstract void boundaryCase(Tuple<Integer, Integer> mov);
	
}
