package ExWeek2;

import GenericStack.LinkedGenericStack;

import java.util.Iterator;

public class StackWithMax<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = null;
        oldFirst.next = first;
        N++;
    }

    public Item pop() {
        Item result = first.item;
        first = first.next;
        N--;
        return result;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    // Support iteration
    // But now showing the inner implementation of the data structure..
    // Iterable interface
    //      Has a method that returns a iterator
    //      hasNext(), next()
    //  for (String s : stack)
    //    stdOut.println(s);
    // is equivlant to:
    //  Iterator<string> i = stack.Iterator();
    //  While (i.hasNext()) {
    //     String s = i.next();
    //     StdOut.println(s);
    public Iterator<Item> iterator() {
        return new listIterator();
    }



    private class listIterator implements Iterator<Item> {
        private Node current = first;

        //public method inside a private (inner) class
        public boolean hasNext() { return current != null; }

        public void remove() { /* not supported */ }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
