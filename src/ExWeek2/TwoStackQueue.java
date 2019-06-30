package ExWeek2;


import GenericStack.LinkedGenericStack;
import Queues.GenericQueue;

public class TwoStackQueue<T> {
    private LinkedGenericStack<T> in;
    private LinkedGenericStack<T> out;

    public void enqueue(T item) {
        in.push(item);
    }

    public T dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.pop();
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }


}
