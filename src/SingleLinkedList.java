import java.util.Arrays;

import org.junit.Test.None;

public class SingleLinkedList {
    private final int LOWER_BOUND_IND = 0;
    private int len;
    private Node head;
    private Node tail;

    public SingleLinkedList() {

    }

    public SingleLinkedList(int[] list) {
        createLinkedList(list);
    }

    public int len() {
        return len;
    }

    public void firstAppend(int v) {
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

    public void tailRemove () {
        int before_the_last_ind = len - 2;
        try {
            Node n = getNode(before_the_last_ind);
            n.setNext(null);
            tail = n;
        } catch (LinkedListIndexOutOfBoundException e) {
            System.out.println("LinkedListIndexOutOfBoundException");
        }
    }

    public Node getNode (int ind) throws LinkedListIndexOutOfBoundException {
        return getNode(head, ind);
    }

    @Override
    public String toString() {
        String result = print(head);
        return result;
    }
    private String print(Node n) {
        if (n.next() == null) {
            System.out.println(n.value());
        } else {
            System.out.println(print(n.next()));
        }
        return "";
    }

    private Node getNode (Node n, int ind) throws LinkedListIndexOutOfBoundException {
        int upper_bound_ind = len - 1;
        if ((ind < LOWER_BOUND_IND) | (ind > upper_bound_ind)) {
            throw new LinkedListIndexOutOfBoundException();
        }

        if (ind == 0) {
            return n;
        } else {
            return getNode(n.next(), --ind);
        }
    }

    private void createLinkedList(int[] list) {
            tailAppend(list[0]);
            if (list.length > LOWER_BOUND_IND +1) {
                createLinkedList(Arrays.copyOfRange(list, 1, list.length));
            }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList(new int[]{1,2,3,4,5});
        System.out.println(list.toString());
        
    }
}
