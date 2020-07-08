import java.util.Iterator;

public class LinkedListStack<T> implements Iterable<T> {

    private Node top;

    private class Node {
        T value;
        Node next;

        public Node(T v) {
            value = v;
            next = null;
        }
    }

    public LinkedListStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T v) {
        Node node = new Node(v);
        if (isEmpty())
            top = node;
        else {
            node.next = top.next;
            top = node;
        }
    }

    public T pop() {
        if (isEmpty())
            throw new NullPointerException();
        var item = top.value;
        top = top.next;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<T> {

        private Node current = top;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.value;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("1 ");
        stack.push("2 ");
        stack.push("3 ");
        stack.push("4 ");
        stack.push("5 ");
        stack.push("6 ");
    }

}