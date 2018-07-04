import java.util.Iterator;


public class LinkedListPriorityQueue<T> implements PriorityQueue<T> {
	
	private Node<T> head;
	
	public LinkedListPriorityQueue() {
		this.head = null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class PriorityIterator implements Iterator<T> {
		
		private Node<T> current;
		
		public PriorityIterator() {
			current = head;
		}

		@Override
		public boolean hasNext() {
			return current == null;
		}

		@Override
		public T next() {
			T result = current.getValue();
			current = current.getNext();
			return result;
		}

		@Override
		public void remove() {
		}
		
	}

	@Override
	public void add(double priority, T element) {		
		Node<T> newNode = new Node<T>(priority, element);
		head = addNode(newNode, head);
	}

	// Recursively compares priority of newNode to rest of the queue
	// and returns the ordered queue
	private Node<T> addNode(Node<T> newNode, Node<T> node) {
		if (node == null) {
			return newNode;
		} else if (newNode.getPriority() <= node.getPriority()) {
			newNode.setNext(node);
			return newNode;
		} else {
			node.setNext(addNode(newNode, node.getNext()));
			return node;
		}
	}

	@Override
	public T dequeue() {
		if (!isEmpty()) {
			T result = head.getValue();
			head = head.getNext();
			return result;
		} else {
			throw new RuntimeException("No elements in queue");
		}
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}
