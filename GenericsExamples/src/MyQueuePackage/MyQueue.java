package MyQueuePackage;

import java.util.Collection;

public interface MyQueue<E> {
    /**
     * head(): returns the top of the queue element or throw NoSuchElementException if empty
     * @return: E the element at the top of the queue
     * */
    E head();

    /**
     * dequeue(): remove and return the top of the queue element or throw NoSuchElementException if empty
     * @return E the element at the top of the queue
     * */
    E dequeue();

    /**
     * enqueue(): add an element to the queueadd an element to the queue
     * */
    void enqueue(E e);

    /**
     * size(): returns the size of the queue
     * */
    int size();

    /**
     * isEmpty(): returns true if the queue is empty
     * */
    boolean isEmpty();

    /**
     * adaAll(): add elements to this queue from a collection c of E references
     * @param c a Collection of E subtypes
     * */
    void addAll(Collection<? extends E> c);

}
