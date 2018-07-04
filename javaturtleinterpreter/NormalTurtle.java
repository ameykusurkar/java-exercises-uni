package turtle.implementations;

import turtle.Paper;
import turtle.util.Tuple;

public class NormalTurtle extends AbstractTurtle {
	
	public NormalTurtle(int x, int y, Paper paper) {
		super(x, y, paper);
	}
	
	protected void boundaryCase(Tuple<Integer, Integer> mov) {
		super.mark();
	}
	

}
