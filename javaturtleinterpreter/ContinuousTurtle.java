package turtle.implementations;

import turtle.Paper;
import turtle.util.Tuple;

public class ContinuousTurtle extends AbstractTurtle {

	public ContinuousTurtle(int x, int y, Paper paper) {
		super(x, y, paper);
	}

	protected void boundaryCase(Tuple<Integer, Integer> mov) {
		
		moveTurtle(mov);
		
		if (isOnGrid()) {
			mark();
		}
	}

}
