package string;

//Every operation takes constant time in worst case
//A stack of N items uses 40 N type
// Node:
//   1. Object Overhead: 16 bytes
//   2. Inner class Extra OverHead: 8 bytes
//   3. Reference to String(item): 8 buytes
//   4. Reference to Node(next):  8 bytes
//   Notice: this accounts for the memory for the stack, not for strings..
public class LinkedStackOfStrings implements StackOfStrings {
    private Node first;
    private int size;

    public LinkedStackOfStrings(){
        first = null;
        size = 0;
    }

    //private inner class
    //access modifier does not matter
    private class Node {
        String item;
        Node next;
    }

    public void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public String pop(){
        //where did the old first go? garbage collection
        String item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return size;
    }
}
