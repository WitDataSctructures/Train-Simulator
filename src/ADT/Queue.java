package ADT;

/**
 * Comp 2071
 * Lab 03: Queues
 * Due: February 23rd, 2016
 * Group #: 15
 * <p>
 * A class that implements a queue
 *
 * @author Jake Mathews
 * @author Ford Polia
 * @author Darrien Kennedy
 */

public class Queue<T> {
    private Node<T> firstNode = null;
    private Node<T> lastNode = null;

    public Queue() {
        firstNode = null;
        lastNode = null;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    /** Adds a new entry to the back of this queue.
     @param newEntry  An object to be added. */
    public void enqueue(T anEntry) {
        Node newNode = new Node(anEntry, null, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    /**
     * Removes and returns the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty before the operation.
     */
    public T dequeue() {
        T front = getFront();
        assert firstNode != null;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null;
        }

        return front;
    }

    /**
     * Retrieves the entry at the front of this queue.
     *
     * @return The object at the front of the queue.
     * @throws EmptyQueueException if the queue is empty.
     */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("No elements in the Queue.");
        } else {
            return firstNode.getData();
        }
    }

    /**
     * Detects whether this queue is empty.
     *
     * @return True if the queue is empty, or false otherwise.
     */
    public boolean isEmpty() {
        if (firstNode == null && lastNode == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes all entries from this queue.
     */
    public void clear() {
        firstNode = null;
        lastNode = null;
    }
}