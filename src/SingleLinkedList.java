public class SingleLinkedList {
    private int len;
    private Node head;
    private Node tail;

    private void firstAppend(int v) {
        Node n = new Node(v);
        head = n;
        tail = n;
        ++len;
    }

    public void tailAppend (int v) {
        if (len == 0) {
            firstAppend(v);
        } else {
            Node n = new Node(v);
            tail.setNext(n);
            ++len;
        }
    }
    public void headAppend (int v) {
        if (len == 0) {
            firstAppend(v);
        } else {
            Node n = new Node(v);
            n.setNext(head);
            head = n;
            ++len;
        }
    }
}
