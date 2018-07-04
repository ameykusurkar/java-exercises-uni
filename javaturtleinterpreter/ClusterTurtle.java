package turtle.implementations;

import turtle.Turtle;
import turtle.util.Pen;
import turtle.util.Rotation;

public class ClusterTurtle implements Turtle {
	
	///*** Instance Variables ***///
	private final Turtle[] cluster;
	
	///*** Constructor ***///
	public ClusterTurtle(Turtle[] turtles) {
		
		cluster = turtles;
	}

	@Override
	public void changePenState(Pen p) {
		
		for (Turtle t : cluster) {
			t.changePenState(p);
		}
	}

	@Override
	public void changeBrush(char ch) {
		
		for (Turtle t : cluster) {
			t.changeBrush(ch);
		}
	}

	@Override
	public void rotateTurtle(Rotation r, int n) {
		
		for (Turtle t : cluster) {
			t.rotateTurtle(r, n);
		}
	}

	@Override
	public void move(int n) {
		
		for (Turtle t : cluster) {
			t.move(n);
		}
	}
	
	public void setTurtle(int n, Turtle t) {
		assert n >= 0 || n < cluster.length : "Invalid index";
		
		cluster[n] = t;
	}

}
