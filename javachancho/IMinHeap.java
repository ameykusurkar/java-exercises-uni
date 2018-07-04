/**
 * Interface for a min-heap abstract data type. The ADT is sorted according to
 * the natural ordering of its elements (see java.lang.Comparable). Some
 * methods are provided which allow the user access to the least item within 
 * the collection, and obtain information about the size of the heap.
 * 
 * All elements inserted into a min-heap must implement the Comparable
 * interface. All min-heap implementation classes must provide a void
 * constructor (with no arguments) that creates an empty min-heap, sorted
 * according to the natural ordering of its elements.
 * 
 */
public interface IMinHeap<T extends Comparable<T>> {

	// add an element to the appropriate position of this min-heap.
	// throw a HeapException if there is no more space on the heap.
	public void add(T element) throws HeapException;

	// remove and return the least element from this min-heap.
	public T removeMin();

	// return the least element in this min-heap.
	public T getMin();

	// return true if this min-heap is empty.
	public boolean isEmpty();

	// return the number of elements in this min-heap.
	public int size();

}