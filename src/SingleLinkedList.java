public class SingleLinkedList {
    private final int LOWER_BOUND_IND = 0;
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
    public void headRemove () {
        head = head.next();
    }

    private void getNode (int ind) throws LinkedListIndexOutOfBoundException {
        int upper_bound_ind = len - 1;
        if ((ind < LOWER_BOUND_IND) | (ind > upper_bound_ind)) {
            throw new LinkedListIndexOutOfBoundException();
        }
    }

    public int len() {
        return len;
    }
}
