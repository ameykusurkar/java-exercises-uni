package turtle;

public enum Error {
	
	///*** Error Messages ***///
	INCORRECT_NUM_ARGS ("Incorrect number of arguments."),
	INVALID_COMMAND (" is not a valid command."),
	INVALID_DIMS ("Invalid Dimensions for paper."),
	NOT_ON_PAPER ("Point is not on the paper."),
	EXPECTED_INT ("Expected integer argument."),
	NONEXISTENT_TURTLE (" does not exist"),
	INVALID_BRUSH (" is an invalid brush symbol"),
	INVALID_DIST ("Invalid distance for movement."),
	INVALID_ANGLE ("Invalid angle for rotation."),
	INVALID_TYPE (" is not a valid turtle type."),
	INVALID_CLUSTER_SIZE ("Invalid cluster size"),
	EXPECTED_NEW ("Expected new Turtle.");
	
	
	///*** Instance variables ***///
	private String message;
	
	///*** Constructor ***///
	Error(String message) {
		this.message = message;
	}
	
	///*** Methods ***///
	public String toString() {
		return message;
	}

}
