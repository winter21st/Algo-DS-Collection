public class ResizingArrayStack {

    private String[] array;
    private int n;

    public ResizingArrayStack() {
        array = new String[1];
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
            expand();
        array[n++] = v;
    }

    private void expand() {
        String[] temp = new String[array.length * 2];
        for (int i = 0; i < n; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    private void shrink() {
        String[] temp = new String[array.length / 2];
        for (int i = 0; i < n; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public String pop() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        if (n == array.length / 4)
            shrink();
        String item = array[--n];
        array[n] = null;
        return item;
    }

}