


public interface PriorityQueue<T> extends Iterable<T> {
	
	// Adds the element into the queue based on its priority
	// Elements with higher priority are added to the front of the queue
	public void add(double priority, T element);
	
	// Deletes and returns the element of highest priority in the queue
	// Throws a RuntimeException if there are no elements to dequeue
	public T dequeue();
	
	// Returns true iff the queue has no elements
	public boolean isEmpty();

}
