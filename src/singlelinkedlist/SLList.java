package singlelinkedlist;

import org.w3c.dom.Node;

public class SLList {
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

    private void addFirst(SLLNode n) {
        this.head = n;
        this.tail = n;
        ++this.len;
    }

    //Search methods
    private SLLNode getNode(SLLNode start_n, int ind) {
        if (ind == 0) {
            return start_n;
        }
        getNode(start_n.getNext(), --ind);
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
