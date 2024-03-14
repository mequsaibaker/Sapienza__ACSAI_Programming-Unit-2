package singlelinkedlist;

public class SLList {
    private int len;
    private SLLNode head;
    private SLLNode tail;

    //Constructors
    public SLList () {

    }

    public SLList (SLLNode head) {
        this.head = head;
    }

    //Add methods
    public void addHead(SLLNode n) {
        n.setNext(head);
        head = n;
    }

    //Setters and Getters
    public int getLen() {
        return len;
    }

    // public void setLen(int len) {
    //     this.len = len;
    // }

    public SLLNode getHead() {
        return head;
    }

    public void setHead(SLLNode head) {
        this.head = head;
    }

    public SLLNode getTail() {
        return tail;
    }

    public void setTail(SLLNode tail) {
        this.tail = tail;
    }
}
