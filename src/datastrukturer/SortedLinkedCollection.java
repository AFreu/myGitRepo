

package datastrukturer;

import java.util.*;



/**
 * An implementation of a collection as a singly linked list.
 * The collection is sorted with the smallest element first and may contain duplicates.
 * @author Anton Freudenthaler & Erik Pihl
 *
 * @param <E> The generic datatype to put in the collection.
 */
public class SortedLinkedCollection<E extends Comparable<? super E>> 
				extends LinkedCollection<E>  {
	
	public SortedLinkedCollection(){
		super();
	}
	
	/**
	 * Adds element to the collection and keeps the natural order.
	 * 
	 */
	public boolean add(E element){
		if ( element == null ){
		    throw new NullPointerException();
		} else if(head == null ||  head.element.compareTo(element) >= 0) {
		    head = new Entry( element, head );
		    return true;
		} else {
			Entry node = head;
			while(node.next != null && node.next.element.compareTo(element) < 0){
				node = node.next;
			}
			node.next = new Entry(element, node.next);
			return true;
		}
		
	}
	/**
	 * Returns element if element is in the collection otherwise null.
	 */
	public E get(E element){
		if(element != null){
			Iterator<E> iter = super.iterator();
			while(iter.hasNext() ){
				E e = iter.next();
				int jfr = e.compareTo(element);
				if(jfr == 0){
					return e;
				} else if (jfr > 0){
					break;
				}
			}
		}
		return null;
	}
	
	




}
