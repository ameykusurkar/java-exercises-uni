package turtle.implementations;

import turtle.Paper;
import turtle.util.Tuple;

public class BouncyTurtle extends AbstractTurtle {
	
	public BouncyTurtle(int x, int y, Paper paper) {
		super(x, y, paper);
	}

	protected void boundaryCase(Tuple<Integer, Integer> mov) {
		
		setDirection(getDirection().turnBack());
		mark();
	}

}
