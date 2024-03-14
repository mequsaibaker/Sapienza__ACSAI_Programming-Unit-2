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

    public void headAppend (int[] v_list) {
        SingleLinkedList list = new SingleLinkedList(v_list);
        list.getNode(list.len() - 1).setNext(this.head);
        head = list.head;
    }

    public void tailAppend (int[] v_list) {
        SingleLinkedList list = new SingleLinkedList(v_list);
        tail.setNext(list.head());
        this.tail = list.tail();
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

    //---Hidden Implementation for Append methods
    private void firstAppend(int v) {
        Node n = new Node(v);
        head = n;
        tail = n;
        ++this.len;
    }
    
    //Remove methods
    public Node headRemove () {
        Node result = head;
        head = head.next();
        --this.len;
        return result;
    }

    public Node tailRemove () {
        Node result = null;
        int before_the_last_ind = len - 2;
        Node n = getNode(before_the_last_ind);
        n.setNext(null);
        result = this.tail;
        this.tail = n;
        --this.len;
        return result;
    }

    public Node indexRemove (int ind) {
        if (this.len == 0) {
            return null;
        }
        if (this.len == 1) {
            return this.headRemove();
        }
        if (ind == 0) {
            return this.headRemove();
        }
        if (ind == this.len - 1) {
            return this.tailRemove();
        }
        Node n = this.getNode(ind);
        Node n_pre = this.getNode(ind - 1);
        n_pre.setNext(n.next());
        return n;
    }

    //Node Searching methods
    public Node getNode (int ind) {
        try {
            return getNode(head, ind, len, LOWER_BOUND_IND);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean inList (Node start, Node n) {
        if (start == n) {
            return true;
        }
        if (start.next() != null) {
            inList(start.next(), n);
        }
        return false;
    }

    //---Hidden Implementation for Node Searching methods
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

    //toString method
    @Override
    public String toString() {
        String result = toString(head);
        return result;
    }

    //--- Hidden Implementation for toString method
    private String toString(Node n) {
        String result = n.value() + " ";
        if (n.next() != null) {
            result += toString(n.next()) + " ";
        }
        return result;
    }  

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList(new int[]{1,2,3,4,5});
        SingleLinkedList list2 = new SingleLinkedList(new int[]{10});
        System.out.println(list.toString());
        System.out.println(list.headRemove().value());;
        System.out.println(list.toString());
        
        System.out.println("list len = " + list.len());
        System.out.println("list ind 0 = " + list.getNode(0).value());
        System.out.println("list ind last = " + list.getNode(list.len()-1).value());
        System.out.println(list.tailRemove().value());;
        System.out.println("Exception!");
        
        System.out.println(list.toString());
        list.headAppend(20);
        list.tailAppend(70);
        System.out.println(list.toString());
        list.headAppend(new int[] {11, 12, 13});
        System.out.println(list.toString());
        list.tailAppend(new int[]{22,23,24,25});
        System.out.println(list.toString());
        list.indexRemove(3);
        System.out.println(list.toString());
    }
}
