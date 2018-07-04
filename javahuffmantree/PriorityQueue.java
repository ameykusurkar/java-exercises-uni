public class PriorityQueue<E extends Comparable<E>> implements PriorityQueueInterface<E>{

	private E[] items;    //a heap of HuffmanTrees
	private final static int max_size = 256;
	private int size;    //number of HuffManTrees in the heap.
	
	
	public PriorityQueue( ) {
        // constructor which creates an empty heap
		items = (E[]) new Comparable[max_size];
		size = 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int getSize(){
		return size;
	}

	public E getMin(){
		E root = null;
		if (!isEmpty()) root = items[0];
		return root;
	}
	
	public void add(E newEntry) throws PriorityQueueException {
		
		if (size == max_size) {
			throw new PriorityQueueException("Queue is full");
		}
		
		items[size] = newEntry;
		
		int parent = (size - 1) / 2;
		int child = size;
		
		// Checks if child value is smaller than parent value
		while (items[child].compareTo(items[parent]) < 0) {
			
			// Swaps child and parent value
			E temp = items[child];
			items[child] = items[parent];
			items[parent] = temp;
			
			// Goes up the tree for next iteration
			child = parent;
			parent = (parent - 1) / 2;
		}
		
		size++;
	}
 				
 	public E removeMin(){
	// post: Removes the minimum valued item from the PriorityQueue
		E root = null;
		if (!isEmpty()){
			root = items[0];
			items[0] = items[size-1];
			size--;
			heapRebuild(0);
		}
		return root;
	}
	
	private void heapRebuild(int root){
		
		if (!isLeaf(root)) {
			
			// Index of left child
			int child = (2 * root) + 1;
			
			// Compares with right child, index of child becomes the smaller child
			if (child + 1 < size && items[child + 1].compareTo(items[child]) < 0) {
				child++;
			}
			
			// If root value is larger, swaps with smaller child
			if (items[root].compareTo(items[child]) > 0) {
				// Swaps root with larger child
				E temp = items[child];
				items[child] = items[root];
				items[root] = temp;
				
				heapRebuild(child);
			}
		}
		
	}
	
	private boolean isLeaf(int index) {
		return (index * 2) + 1 > size - 1;
	}
}
