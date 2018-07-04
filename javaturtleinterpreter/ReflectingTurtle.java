package turtle.implementations;

import turtle.Paper;
import turtle.util.Direction;
import turtle.util.Tuple;

public class ReflectingTurtle extends AbstractTurtle {
	
	public ReflectingTurtle(int x, int y, Paper paper) {
		super(x, y, paper);
	}

	protected void boundaryCase(Tuple<Integer, Integer> mov) {
		
		switch (getDirection()) {
		
		// Turn 180 degrees for NORTH, SOUTH, EAST, WEST
		case NORTH:
		case SOUTH:
		case EAST:
		case WEST:
			setDirection(getDirection().turnBack());
			return;
		default:
		}
		
		Tuple<Integer, Integer> vec = getDirection().getMovement();
		
		// Projected position of the turtle
		// to see which boundary it will leave
		Tuple<Integer, Integer> tempPos = new Tuple<Integer, Integer> 
			(getPosition().getX() + vec.getX(), 
				getPosition().getY() + vec.getY());
		
		// If its x-coordinate goes out of grid
		if (tempPos.getX() < 0
				|| tempPos.getX() >= paper.getWidth()) {
			// xMov reflected, yMov unchanged
			
			Direction newDir = Direction.newDirection(vec.getX() * -1,
					vec.getY());
				
			moveTurtle(new Tuple<Integer, Integer>(0, mov.getY()));

			setDirection(newDir);
		}
		
		// If its y-coordinate goes out of grid
		if (tempPos.getY() < 0
				|| tempPos.getY() >= paper.getHeight()) {
			// xMov unchanged, yMov reflected

			Direction newDir = Direction.newDirection(vec.getX(), vec.getY()
					* -1);
			
			moveTurtle(new Tuple<Integer, Integer>(mov.getX(), 0));

			setDirection(newDir);
		}
		
		mark();
	}

}
