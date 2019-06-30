package string;

// Stack overflows when N exceeds the capacity
// Require user to provide capacity
//
public class FixedCapacityStackOfStrings implements StackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity){
        s = new String[capacity];
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        return s[--N];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }
}
