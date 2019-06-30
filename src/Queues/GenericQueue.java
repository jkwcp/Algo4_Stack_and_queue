package Queues;

public interface GenericQueue<T> {
    void enqueue(T t);
    T dequeue();
    boolean isEmpty();
    int size();
}
