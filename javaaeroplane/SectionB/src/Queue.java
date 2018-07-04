public class Queue<T> implements QueueInterface<T>{
	
	private Node<T> first;
	private Node<T> last;
	
	public boolean isEmpty() {
		return last == null;
	}
	
	//post: Adds the given item to the queue
	public void enqueue(T item) {
		
		Node<T> newNode = new Node<T>(item);
		
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			last = newNode;
		}
		
	}
	
	//post: Removes and returns the head of the queue. It throws an 
	//      exception if the queue is empty.
	public T dequeue() throws QueueException {
		
		if (isEmpty()) {
			
			throw new QueueException("Queue is empty"); 
			
		} else {
			
			Node<T> firstNode = first;
			first = first.getNext();
			
			// If last item in queue was removed, last has to be set to null
			if (first == null) {
				last = null;
			}
			
			return firstNode.getItem();
		}
		
	}
	
}
