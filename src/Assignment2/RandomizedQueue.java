package Assignment2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == array.length ) resize(size * 2);

        array[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();

        int i = StdRandom.uniform(size);

        Item temp = array[i];

        if (i != size - 1) {
            array[i] = array[size - 1];
        }

        array[size - 1] = null;
        size--;

        if (!isEmpty() && size == array.length / 4) {
            resize(array.length/2);
        }

        return temp;

    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) throw new NoSuchElementException();

        int i = StdRandom.uniform(size);

        return array[i];

    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        private int current = 0;
        private final Item[] temp;

        public RandomIterator() {
            temp = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            StdRandom.shuffle(temp);
        }

        public boolean hasNext() { return current < size; }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return temp[current++];
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }


    // unit testing (optional)
    public static void main(String[] args) {
        RandomizedQueue<String> deque = new RandomizedQueue<>();
        deque.enqueue("aa");
        deque.enqueue("bb");
        deque.enqueue("cc");
        deque.enqueue("dd");
        deque.dequeue();
        deque.dequeue();
        deque.dequeue();
        deque.dequeue();
        // deque.dequeue();
        StdOut.print("size:"+deque.size());
    }
}
