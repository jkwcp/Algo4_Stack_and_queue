package string;

public class ResizingArrayStackOfStrings implements StackOfStrings {
    private String[] s;
    private int N;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
        N = 0;
    }

    public void push(String item) {
        if (N == s.length) resizing(s.length * 2);
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        if (N > 0 && N == s.length / 4) resizing(s.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resizing(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++){
            copy[i] = s[i];
        }

        s = copy;
    }


}
