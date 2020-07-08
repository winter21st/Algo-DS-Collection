public class FixedArrayStack {

    private String[] array;
    private int n;

    public FixedArrayStack(int capacity) {
        array = new String[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == array.length;
    }

    public void push(String v) {
        if (isFull())
            throw new ArrayIndexOutOfBoundsException();
        array[n++] = v;
    }

    public String pop() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        String item = array[--n];
        array[n] = null;
        return item;
    }

}