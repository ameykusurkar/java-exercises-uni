package turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import turtle.util.Pen;
import turtle.util.Rotation;
import turtle.util.Tuple;

public class Main {
	
	///*** Instance Variables ***///
	private static Scanner sc;
	private static PrintStream ps;
	private static TurtleInterpreter interpreter;
	
	///*** Constants ***///
	private static final int BASIC_ANGLE = 45;
	
	
    public static void main(String[] args) throws FileNotFoundException {
    	
    	// Sets the input/output streams
    	if (setIO(args) == -1) {
    		return;
    	}
    	
    	interpreter = new TurtleInterpreter();
    	
    	while (sc.hasNext()) {
    		
    		String command = sc.next();
    		
    		switch(command) {
    		
    		case "paper":
    			
    			doPaper();
    			break;
    			
    		case "new":
    			
    			doNew("");
    			break;
    			
    		case "pen":
    			
    			doPen();
    			break;
    			
			case "move":
				
				doMove();
				break;
    			
    		case "left":
    			
    			doRotation(Rotation.LEFT);
    			break;
    			
    		case "right":
    			
    			doRotation(Rotation.RIGHT);
    			break;
    			
    		case "show":
    			
    			doShow();
    			break;
    			
    		default:
    			System.out.println("\"" + command + "\"" + 
    					Error.INVALID_COMMAND);
    			return;
    		}
    		
    		sc.nextLine();
    	}
    	
    }
    
	private static void doShow() {
		
		ps.println(interpreter);
	}

	private static void doRotation(Rotation r) {
		
		String name = sc.next();

		// Turtle does not exist
		if (!interpreter.hasTurtle(name)) {
			System.out.println(("\"" + name + "\""
					+ Error.NONEXISTENT_TURTLE));
			return;
		}
		
		int angle;
		
		// To get angle
		if (sc.hasNextInt()) {
			angle = sc.nextInt();
		} else {
			System.out.println(Error.EXPECTED_INT);
			return;
		}
		
		// Invalid angle
		if (angle < 0) {
			System.out.println(Error.INVALID_ANGLE);
			return;
		}
		
		interpreter.execRotation(name, angle / BASIC_ANGLE, 
				r);
	}

	private static void doMove() {
		
		String name = sc.next();

		// Turtle does not exist
		if (!interpreter.hasTurtle(name)) {
			System.out.println("\"" + name + "\""
					+ Error.NONEXISTENT_TURTLE);
			return;
		}
		
		int distance;
		
		// To get distance
		if (sc.hasNextInt()) {
			distance = sc.nextInt();
		} else {
			System.out.println(Error.EXPECTED_INT);
			return;
		}
		
		// Invalid distance
		if (distance < 0) {
			System.out.println(Error.INVALID_DIST);
			return;
		}
		
		interpreter.execMove(name, distance);
		
	}

	private static void doPen() {
		
		/*
		for (String t : interpreter.turtles.keySet()) {
			System.out.println(t);
		}
		System.out.println("END");
		*/
		
		
		String name = sc.next();
		
		// Turtle does not exist
		if (!interpreter.hasTurtle(name)) {
			System.out.println("\"" + name + "\"" 
					+ Error.NONEXISTENT_TURTLE);
			return;
		}
		
		String state = sc.next();
		
		switch (state) {
		
		case "up":
			interpreter.changePen(name, Pen.UP);
			break;
			
		case "down":
			interpreter.changePen(name, Pen.DOWN);
			break;
			
		default:
			if (state.length() == 1 && state.charAt(0) != ' ') {
				interpreter.changeBrush(name, state.charAt(0));
			} else {
				System.out.println("\"" + state + "\"" 
						+ Error.INVALID_BRUSH);
				return;
			}
		}
		
	}

	private static Turtle doNew(String prefix) {
		
		String type = sc.next();
		
		Turtle t;
		String name;
		int x, y;
		
		switch (type) {
		
		case "cluster":
			Tuple<String, Turtle> clust = makeCluster(prefix);
			name = clust.getX();
			t = clust.getY();
			break;
		case "normal":
		case "bouncy": 
		case "reflecting": 
		case "continuous":
		case "wrapping":
			
			name = prefix + sc.next();
			
			// To get x
			if (sc.hasNextInt()) {
				x = sc.nextInt();
			} else {
				System.out.println(Error.EXPECTED_INT); 
				return null;
			}
			
			// To get y
			if (sc.hasNextInt()) {
				y = sc.nextInt();
			} else {
				System.out.println(Error.EXPECTED_INT); 
				return null;
			}
			
			// Invalid point
			if (!interpreter.onGrid(x, y)) {
				System.out.println(Error.NOT_ON_PAPER); 
				return null;
			}
			
			t = interpreter.makeTurtle(type, x, y);
			break;
			
		default:
			System.out.println("\"" + type + "\"" 
					+ Error.INVALID_TYPE);
			return null;
		}
		
		
		interpreter.addTurtle(name, t);
		return t;
		
	}

	private static void doPaper() {
		
		int width, height;
		
		// To get width
		if (sc.hasNextInt()) {
			width = sc.nextInt();
		} else {
			System.out.println(Error.EXPECTED_INT);
			return;
		}
		
		// To get height
		if (sc.hasNextInt()) {
			height = sc.nextInt();
		} else {
			System.out.println(Error.EXPECTED_INT);
			return;
		}
		
		// Invalid dimensions
		if (width <= 0 || height <= 0) {
			System.out.println(Error.INVALID_DIMS);
			return;
		}
		
		interpreter.execPaper(width, height);
	}

	private static Tuple<String, Turtle> makeCluster(String prefix) {
		
		String name = prefix + sc.next();
		int size;
		
		// To get size
		if (sc.hasNextInt()) {
			size = sc.nextInt();
		} else {
			System.out.println(Error.EXPECTED_INT);
			return null;
		}
		
		// Invalid size
		if (size < 0) {
			System.out.println(Error.INVALID_CLUSTER_SIZE);
			return null;
		}
		
		sc.nextLine();
		
		Turtle[] turtles = new Turtle[size];
		
		for (int i = 0; i < size; i++) {
			
			String command = sc.next();
			
			if (!command.equals("new")) {
				System.out.println(Error.EXPECTED_NEW);
				return null;
			} else {
				
				Turtle newTurtle = doNew(name + ".");
				
					turtles[i] = newTurtle;
			}	
		}
		
		Turtle t = TurtleInterpreter.makeClusterTurtle(turtles);
		
		return new Tuple<String, Turtle>(name, t);
	}

	private static int setIO(String[] args) throws FileNotFoundException {

		switch (args.length) {

		// Read and write to console
		case 0:
			sc = new Scanner(System.in);
			ps = new PrintStream(System.out);
			return 0;

		// Read from file, write to console
		case 1:
			sc = new Scanner(new File(args[0]));
			ps = new PrintStream(System.out);
			return 0;

		// Read and write to file
		case 2:
			sc = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			return 0;

		default:
			System.out.println(Error.INCORRECT_NUM_ARGS);
			return -1;
		}

	}
}
