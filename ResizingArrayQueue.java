public class ResizingArrayQueue {

    private String[] array;
    private int head, tail;
    private int size;

    public ResizingArrayQueue() {
        array = new String[1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void enqueue(String v) {
        if (isFull())
            expand();
        array[tail] = v;
        tail = ++tail % array.length;
        size++;
    }

    private void expand() {
        String[] temp = new String[array.length * 2];
        int j = 0;
        for (int i = head; i < size; i++) {
            temp[j++] = array[i % array.length];
        }
        head = 0;
        tail = size;
        array = temp;
    }

    private void shrink() {
        String[] temp = new String[array.length / 2];
        int j = 0;
        for (int i = head; i < size; i++) {
            temp[j++] = array[i % array.length];
        }
        head = 0;
        tail = size;
        array = temp;
    }

    public String dequeue() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        if (size == array.length / 4)
            shrink();
        String item = array[head];
        array[head] = null;
        head = ++head % array.length;
        size--;
        return item;
    }

    public int length() {
        return array.length;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String string : array) {
            s.append(string);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ResizingArrayQueue q = new ResizingArrayQueue();
        q.enqueue("hello ");
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.enqueue("from ");
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.enqueue("the ");
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.enqueue("otter ");
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.dequeue();
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.enqueue("other ");
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.enqueue("side ");
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.dequeue();
        System.out.print(q.toString());
        System.out.print(q.length() + "\n");
        q.dequeue();
        System.out.println(q.toString());
        System.out.print(q.length());
    }
}