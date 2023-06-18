package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) {
			throw new NullPointerException("can not insert null");
		}
		if (find(element)) {
			return false;
		}
		LLNode<E> toAdd = new LLNode<E>(element);
		toAdd.prev = tail.prev;
		toAdd.next = tail;
		toAdd.prev.next = toAdd;
		tail.prev = toAdd;
		size += 1;
		return true;
	}

	private boolean find(E element) {
		for (int i = 0; i < size; i++) {
			if (this.get(i) == element) {
				return true;
			}
		}
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("check out of bonds");
		}
		return getNode(index).data;
	}

	private LLNode<E> getNode(int index) {
		LLNode<E> find = head.next;
		for ( int i = 0; find != tail && i < index; i++ ) {
			//index超过tail时返回tail，调用时需要校验index是否超出边界
			find = find.next;
		}
		return find;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("check out of bonds");
		}
		if (element == null) {
			throw new NullPointerException("cannot add null");
		}
		LLNode<E> oriNode = getNode(index);
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev = oriNode.prev;
		newNode.next = oriNode;
		oriNode.prev = newNode;
		newNode.prev.next = newNode;
		size = size + 1;
	}


	/** Return the size of the list */
	public int size() 
	{
		LLNode<E> curr = head.next;
		int cnt;
		for (cnt = 0; curr != tail; cnt++) {
			curr = curr.next;
		}
		return cnt;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("check out of bonds");
		}
		LLNode<E> toRemove = getNode(index);
		toRemove.prev.next = toRemove.next;
		toRemove.next.prev = toRemove.prev;
		toRemove.next = null;
		toRemove.prev = null;
		size = size - 1;
		return toRemove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("check out of bonds");
		}
		if (element == null) {
			throw new NullPointerException("cannot add null");
		}
		LLNode<E> oriNode = getNode(index);
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.prev = oriNode.prev;
		newNode.next = oriNode.next;
		oriNode.prev.next = newNode;
		oriNode.next.prev = newNode;
		oriNode.prev = null;
		oriNode.next = null;
		return oriNode.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
