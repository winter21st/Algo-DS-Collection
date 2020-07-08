public class LinkedListQueue {

    private Node first;
    private Node last;

    private class Node {
        String value;
        Node next;

        public Node(String v) {
            value = v;
            next = null;
        }
    }

    public LinkedListQueue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String v) {
        Node node = new Node(v);
        var temp = last;
        last = node;
        if (isEmpty())
            first = last;
        else
            temp.next = last;
    }

    public String dequeue() {

        if (isEmpty()) return "Empty";
        var item = first.value;
        first = first.next;
        return item;
    }

}