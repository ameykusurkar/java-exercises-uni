package turtle;

import java.util.HashMap;
import java.util.Map;

import turtle.implementations.BouncyTurtle;
import turtle.implementations.ClusterTurtle;
import turtle.implementations.ContinuousTurtle;
import turtle.implementations.NormalTurtle;
import turtle.implementations.ReflectingTurtle;
import turtle.implementations.WrappingTurtle;
import turtle.util.Pen;
import turtle.util.Rotation;

public class TurtleInterpreter {
	
	///*** Instance variables ***///
	private Paper paper;
	private Map<String, Turtle> turtles;
	
	///*** Constructor ***///
	public TurtleInterpreter() {
		this.paper = new Paper(10, 10);
		this.turtles = new HashMap<String, Turtle>();
	}

	///*** Methods ***///
	
	public String toString() {
		return paper.toString();
	}
	
	public boolean onGrid(int x, int y) {
		return paper.onGrid(x, y);
	}
	
	public void execPaper(int width, int height) {
		paper = new Paper(width, height);
		turtles = new HashMap<String, Turtle>();
	}
	
	public Turtle makeTurtle(String type, int x, int y) {
		
		Turtle t = null;
		
		switch (type) {
		
		case "normal":
			t = new NormalTurtle(x, y, paper);
			//turtles.put(name, t);
			break;
			
		case "bouncy":
			t = new BouncyTurtle(x, y, paper);
			//turtles.put(name, t);
			break;
		
		case "reflecting":
			t = new ReflectingTurtle(x, y, paper);
			//turtles.put(name, t);
			break;
			
		case "continuous":
			t = new ContinuousTurtle(x, y, paper);
			//turtles.put(name, t);
			break;
			
		case "wrapping":
			t = new WrappingTurtle(x, y, paper);
			//turtles.put(name, t);
			break;
			
		default:
			System.out.println("Not possible.");
		}
		
		return t;
	}
	
	public boolean hasTurtle(String name) {
		return turtles.containsKey(name);
	}
	
	public void changePen(String name, Pen p) {
		assert hasTurtle(name) : "Turtle does not exist";
		
		turtles.get(name).changePenState(p);
	}

	public void changeBrush(String name, char ch) {
		assert hasTurtle(name) : "Turtle does not exist";
		
		turtles.get(name).changeBrush(ch);
		
	}

	public void execMove(String name, int distance) {
		assert hasTurtle(name) : "Turtle does not exist";
		
		turtles.get(name).move(distance);
		
	}

	public void execRotation(String name, int n, Rotation r) {
		assert hasTurtle(name) : "Turtle does not exist";
		
		turtles.get(name).rotateTurtle(r, n);
		
	}

	public static Turtle makeClusterTurtle(Turtle[] turtles) {
		
		Turtle cluster = new ClusterTurtle(turtles);
		return cluster;
	}

	public void addTurtle(String name, Turtle t) {
		
		turtles.put(name, t);
	}
	
	
}
