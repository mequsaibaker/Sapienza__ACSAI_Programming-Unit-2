package singlelinkedlist;

public class SLList {
    private final int IND_LOWER_BOUND = 0;
    private int len;
    private SLLNode head;
    private SLLNode tail;

    //Constructors
    public SLList () {

    }

    // public SLList (SLLNode head) {
    //     this.head = head;
    // }

    public SLList (int[] v_list) {
        createSLList(v_list);
    }

    private void createSLList (int[] v_list) {
        for(int i = v_list.length - 1; i >= 0; i--) {
            addHead(v_list[i]);
        }
    }

    //Add methods
    public void addHead(int v) {
        SLLNode n = new SLLNode(v);
        if (len == 0) {
            this.addFirst(n);
        } else {
            n.setNext(this.head);
            this.head = n;
            ++this.len;
        }
    }

    public void addTail(int v) {
        SLLNode n = new SLLNode(v);
        if (len == 0) {
            this.addFirst(n);
        } else {
            this.tail.setNext(n);
            this.tail = n;
            ++this.len;
        }
    }

    public void insert(int v, int ind) {
        if (ind == 0) {
            addHead(v);
        } else if  (ind == len - 1) {
            addTail(v);
        } else {
            SLLNode new_pre = getNode(ind - 1);
            SLLNode n = new SLLNode(v);
            n.setNext(new_pre.getNext());
            new_pre.setNext(n);
        }
    }

    private void addFirst(SLLNode n) {
        this.head = n;
        this.tail = n;
        ++this.len;
    }

    //Remove methods
    public void removeHead() {
        
    }

    //Search methods
    public SLLNode getNode(int ind) {
        try {
            return getNode(head, ind, len, IND_LOWER_BOUND);
        } catch (Exception e) {
            return null;
        }
    }

    private SLLNode getNode(SLLNode start_n, int ind, int len, int ind_lower_bound)  throws SLLIndexOutOfBoundException {
        int ind_upper_bound = len - 1;
        if (ind < ind_lower_bound | ind > ind_upper_bound) {
            throw new SLLIndexOutOfBoundException();
        }
        if (ind == 0) {
            return start_n;
        }
        return getNode(start_n.getNext(), --ind, len, ind_lower_bound);
    }

    //Setters and Getters
    public int getLen() {
        return len;
    }

    private void setLen(int len) {
        this.len = len;
    }

    public SLLNode getHead() {
        return head;
    }

    private void setHead(SLLNode head) {
        this.head = head;
    }

    public SLLNode getTail() {
        return tail;
    }

    private void setTail(SLLNode tail) {
        this.tail = tail;
    }
}
