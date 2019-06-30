package Bag;

import java.util.Iterator;

//No implements allowed for interface.

//Bag: order doesn't matter
//Implementation: stack without pop or queue without dequeue
public interface GenericBag<T>  {
    void add(T t);
    int size();
}
