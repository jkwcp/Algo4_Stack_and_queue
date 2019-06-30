package Bag;


import java.util.Iterator;

public class LinkedGenericBag<T> implements GenericBag<T>, Iterable<T> {
    private Node first;
    private int size;

    private class Node {
        private T t;
        private Node next;
    }

    public void add(T t) {
        Node temp = first;
        first.t = t;
        first.next = temp;
        size++;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        private Node current = first;
        public boolean hasNext() { return current != null; }

        public void remove() { /* not supported */}

        public T next() {
            T t = current.t;
            current = current.next;
            return t;
        }
    }
}
