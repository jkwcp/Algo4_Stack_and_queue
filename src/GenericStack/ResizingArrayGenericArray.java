package GenericStack;

import edu.princeton.cs.algs4.ResizingArrayQueue;
import java.util.Iterator;


// Question: why not casting but generic??
// Welcome compile time error but denie run-time errors.
// Study point: read generic apis...

// Generic types for primitive types: because item is casted down from objects...
// Wrappers: Integer vs int....etc
// Autoboxing: automatic casting between primitive types and their wrappers
// Behinde-the-scene autoboxing:
//  Stack<Integer> s = new Stack<Integer>();
//  s.
public class ResizingArrayGenericArray<Item> implements GenericStack<Item>, Iterable<Item> {
    private Item[] array;
    private int N;

    public ResizingArrayGenericArray(int capacity){
        // array = new Item[1]; Generic Array creation is not allowed in java
        // 1. why no generic array?
        // you need to understand that Java arrays are covariant but Java generics are not:
        // that is, 𝚂𝚝𝚛𝚒𝚗𝚐[] is a subtype of 𝙾𝚋𝚓𝚎𝚌𝚝[], but 𝚂𝚝𝚊𝚌𝚔<𝚂𝚝𝚛𝚒𝚗𝚐> is not a subtype of 𝚂𝚝𝚊𝚌𝚔<𝙾𝚋𝚓𝚎𝚌𝚝>.
        // 2. Good code has 0 casts...(ugly casts)
        // 3. Compiler will give a warning
        array = (Item[]) new Object[capacity];
        N = 0;

    }

    public void push(Item item) {
        if (N == array.length) {
            resizing(N * 2);
        }
    }

    public Item pop() {
        return null;
    }

    public boolean isEmpty(){
        return false;
    }

    public int size() {
        return 0;
    }

    public void resizing(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int current = N;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        public void remove() {
            /* not supported */
        }

        public Item next() {
            return array[--current];
        }
    }


    public void main(String[] args) {
        ResizingArrayGenericArray<Integer> s = new ResizingArrayGenericArray(10);
        s.push(17);  // s.push(new Integer(17));
        int a = s.pop(); // int a = s.pop().intValue();
    }
}
