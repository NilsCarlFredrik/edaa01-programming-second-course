package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> newLast = new QueueNode<E>(e);
		if (size == 0) {
			newLast.next = newLast;
		} else {
			newLast.next = last.next;
			last.next = newLast;
		}
		last = newLast;
		size++;
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (size == 0) {
			return null;
		} else {
			return last.next.element;
		}
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (size == 0) {
			return null;
		}
		QueueNode<E> temp = last.next;
		last.next = last.next.next;
		size--;
		if (size == 0) {
			last = null;
		}
		return temp.element;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q) {
		if (this == q) {
			throw new IllegalArgumentException();
		}
		
		QueueNode<E> temp = null;
		if (last == null) {
			last = q.last;
			size = q.size;
		} else if (q.last != null) {
			temp = q.last.next;
			q.last.next = last.next;
			last.next = temp;
			last = q.last;
			size += q.size;
		}
		q.last = null;
		q.size = 0;
	}
	
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			this.element = x;
			next = null;
		}
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int counter;
		
		private QueueIterator() {
			pos = last;
			counter = 0;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return counter < size;
		} 

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			counter++;
			pos = pos.next;
			return pos.element;
		}
		
	}

}
