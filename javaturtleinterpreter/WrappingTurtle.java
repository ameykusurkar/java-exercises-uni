package turtle.implementations;

import turtle.Paper;
import turtle.util.Tuple;

public class WrappingTurtle extends AbstractTurtle {

	public WrappingTurtle(int x, int y, Paper paper) {
		super(x, y, paper);
	}

	protected void boundaryCase(Tuple<Integer, Integer> mov) {
		
		Tuple<Integer, Integer> pos = getPosition();
		
		Tuple<Integer, Integer> newPos = new Tuple<Integer, Integer> 
			(pos.getX() + mov.getX(), pos.getY() + mov.getY());
		
		// Wraps x coordinate if out of paper
		if (newPos.getX() < 0) {
			newPos.setX(paper.getWidth() + newPos.getX());
		} else if (newPos.getX() >= paper.getWidth()) {
			newPos.setX(paper.getWidth() - newPos.getX());
		}
		
		// Wraps y coordinate if out of paper
		if (newPos.getY() < 0) {
			newPos.setY(paper.getHeight() + newPos.getY());
		} else if (newPos.getY() >= paper.getHeight()) {
			newPos.setY(paper.getHeight() - newPos.getY());
		}
		
		setPosition(newPos.getX(), newPos.getY());
		
		mark();
	}
	
	

}
