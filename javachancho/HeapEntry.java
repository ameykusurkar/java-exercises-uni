/**
 * The HeapEntry class provides three basic functions:
 * 
 *   1. It wraps an object.
 * 
 *   2. It associates an integer called 'position' with the wrapped object.
 * 
 *   3. It defines a natural ordering between HeapEntry<T> objects based
 *      solely on the value of the 'position' field. The defined ordering 
 *      follows the natural ordering on integers.
 * 
 * Note: this class has a natural ordering that is inconsistent with equals(..),  
 * i.e. For some instances a, b of class HeapEntry, 
 * 		(a.equals(b)) is not the same as (a.compareTo(b)==0)  
 */
public class HeapEntry<T> implements Comparable<HeapEntry<T>> {

	private T item; // the wrapped object
	private int position; // the wrapped object's positions

	public HeapEntry(T item, int position) {
		this.item = item;
		this.position = position;
	}

	// return the wrapped object
	public T getItem() {
		return item;
	}
	
	// return the 'position' associated with the object
	public int getPosition() {
		return position;
	}

	// returns a negative integer, zero, or a positive integer as this
	// HeapEntry<T> is less than, equal to, or greater than the specified
	// HeapEntry<T>.
	public int compareTo(HeapEntry<T> item) {
		return position - item.position;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HeapEntry)) {
			return false;
		}

		HeapEntry<?> heapEntry = (HeapEntry<?>) obj;
		return (position == heapEntry.position) && (item.equals(heapEntry.item));
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 31 + (item == null ? 0 : item.hashCode());
		hash = hash * 31 + position;
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Position ");
		sb.append(position);
		sb.append(": Item ");
		sb.append(item);
		return sb.toString();
	}
}