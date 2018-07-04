/**
 * Thrown when an attempt is made to add an element to a MinHeap and 
 * there is no more space in the underlying array representation.   
 */
@SuppressWarnings("serial")
public class HeapException extends RuntimeException{

	public HeapException(String message){
		super(message);
	}
} 