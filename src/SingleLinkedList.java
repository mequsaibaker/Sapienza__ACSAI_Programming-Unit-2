import java.util.Arrays;

public class SingleLinkedList {
    private final int LOWER_BOUND_IND = 0;
    private int len;
    private Node head;
    private Node tail;

    //Constructors
    public SingleLinkedList() {

    }

    public SingleLinkedList(int[] list) {
        createLinkedList(list);
    }

    //---Hidden Implementations for Constructors
    private void createLinkedList(int[] list) {
        head = null;
        tail = null;
        for(int i = 0; i < list.length; i++) {
            tailAppend(list[i]);
        }
    }

    //Getters
    public Node head() {
        return this.head;
    }
    
    public Node tail() {
        return this.tail;
    }

    public int len() {
        return this.len;
    }

    //Append methods
    public void firstAppend(int v) {
        Node n = new Node(v);
        head = n;
        tail = n;
        ++this.len;
    }

    public void headAppend (int v) {
        if (this.len == 0) {
            firstAppend(v);
        } else {
            Node n = new Node(v);
            n.setNext(head);
            head = n;
            ++this.len;
        }
    }

    public void tailAppend (int v) {
        if (this.len == 0) {
            firstAppend(v);
        } else {
            Node n = new Node(v);
            tail.setNext(n);
            tail = n;
            ++this.len;
        }
    }
    
    //Remove methods
    public Node headRemove () {
        Node result = head;
        head = head.next();
        return result;
    }

    public Node tailRemove () {
        Node result = null;
        int before_the_last_ind = len - 2;
        try {
            Node n = getNode(before_the_last_ind);
            n.setNext(null);
            result = tail;
            tail = n;
        } catch (LinkedListIndexOutOfBoundException e) {
            System.out.println("LinkedListIndexOutOfBoundException");
        }
        return result;
    }

    //Node Searching methods
    public Node getNode (int ind) throws LinkedListIndexOutOfBoundException {
        return getNode(head, ind, len, LOWER_BOUND_IND);
    }

    //toString method
    @Override
    public String toString() {
        String result = toString(head);
        return result;
    }

    //--- Hidden Implementation for toStrinf method
    private String toString(Node n) {
        String result = n.value() + " ";
        if (n.next() != null) {
            result += toString(n.next()) + " ";
        }
        return result;
    }

    //Private internal method for getting an ind starting from a point
    private Node getNode (Node n, int ind, int len, int lower_bound_ind) throws LinkedListIndexOutOfBoundException {
        int upper_bound_ind = len - 1;
        if ((ind < lower_bound_ind) | (ind > upper_bound_ind)) {
            throw new LinkedListIndexOutOfBoundException();
        }

        if (ind == 0) {
            return n;
        } else {
            return getNode(n.next(), --ind, len, lower_bound_ind);
        }
    }

    

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList(new int[]{1,2,3,4,5});
        System.out.println(list.toString());
        
    }
}
