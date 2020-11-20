package MyQueuePackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LQueue<E> implements MyQueue<E> {

    private LinkedList<E> lst;

    /**
     * public constructor
     * */
    public LQueue(){
        this.lst = new LinkedList<>();
    }


    /**
     * head(): returns the top of the queue element or throw NoSuchElementException if empty
     * @return: E the element at the top of the queue
     * @postcondition */
    @Override
    public E head() throws NoSuchElementException {
        // getFirst() is a LinkedList method that returns the element at the head,
        // but does not remove the element. If the list is empty, null is returned.
        return this.lst.getFirst();
    }

    /**
     * dequeue(): remove and return the top of the queue element or throw NoSuchElementException if empty
     * @postcondition
     * @return E the element at the top of the queue */
    @Override
    public E dequeue() throws NoSuchElementException{
        // uses the LinkedList's remove() method that removes and returns the element at the list's head.
        return this.lst.remove();
    }

    /**
     * Adds an element to the queue
     * @param e Element of queue
     * @postcondition size() > 0
     */
    public void enqueue(E e) {
        // using LinkedList's built in add() method
        this.lst.add(e);
    }

    /**
     * size(): returns the size of the queue
     * @return value indicating the size of the queue */
    @Override
    public int size() {
        // uses LinkedList's built in size() method that returns the number of elements in this list.
        return this.lst.size();
    }

    /**
     * isEmpty(): returns true if the queue is empty
     * @return boolean indicating wether or not the queue is empty */
    @Override
    public boolean isEmpty() {
        // using LinkedList's built in isEmpty() method
        return this.lst.isEmpty();
    }

    /**
     * addAll(): add elements to this queue from a collection c of E references
     * @param c a Collection of E subtypes */
    @Override
    public void addAll(Collection<? extends E> c) {
        Iterator iter = c.iterator();
        E e = null;
        while (iter.hasNext()){
            e = (E) iter.next();
            this.enqueue(e);
        }
    }
}
