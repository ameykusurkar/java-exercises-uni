package turtle;

import turtle.util.Pen;
import turtle.util.Rotation;

public interface Turtle {

	public void changePenState(Pen p);
	
	public void changeBrush(char ch);
	
	public void rotateTurtle(Rotation r, int n);
	
	public void move(int n);
	
}
