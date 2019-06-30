package Queues;

// Queue is the first in first out structure
// enqueue: add new entries to the begining
// dequeue: remove entries from the end of the queue
public class LinkedQueueOfStrings implements QueueOfStrings {
    private Node first, last;
    private int N;


    private class Node {
        String s;
        Node next;
    }

    // add the item to the end of the queue
    public void enqueue(String item){
        Node oldLast = last;
        last = new Node();
        last.s = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    // remove the first item in the queue
    public String dequeue() {
        String result = first.s;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }

        N--;

        return result;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
}
