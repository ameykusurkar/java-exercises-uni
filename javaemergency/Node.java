public class Node<E> {

	private E value;
	private double priority;
	private Node<E> next;


	public Node(double newPriority, E newValue) {
		
		this.value = newValue;
		this.priority = newPriority;
		next = null;	
	}
	
	public  E getValue() {
		return value;
	}

	public double getPriority(){
		return priority;
	}

	public  Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> nextNode) {
		this.next = nextNode;
	}

	
	public void setValue(E newValue) {
		this.value = newValue;
	}
	
	public void setPriority(double newPriority) {
		this.priority = newPriority;
	}
	
}
