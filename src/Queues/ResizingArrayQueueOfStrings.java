package Queues;

public class ResizingArrayQueueOfStrings implements QueueOfStrings {
    private String[] s;
    int head;
    int tail;

    public ResizingArrayQueueOfStrings() {
        s = new String[1];
        head = 0;
        tail = 0;
    }

    public void enqueue(String item) {
        if (tail == s.length) {

        }
        s[tail] = item;
        tail++;
    }

    public String dequeue() {
        String item = s[head];
        s[head] = null;
        head++;
        return item;
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public int size() {
        return tail - head;
    }

    public void resizing(int capacity) {
        String[] copy = new String[capacity];

        for (int i = 0; i < tail - head; i++) {
            copy[i] = s[head + i];
        }

        s = copy;
    }
}
