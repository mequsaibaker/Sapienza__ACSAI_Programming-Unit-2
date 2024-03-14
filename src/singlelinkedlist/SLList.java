package singlelinkedlist;

public class SLList {
    private int len;
    private SLLNode head;
    private SLLNode tail;

    //Constructors
    public SLList (SLLNode head) {
        
    }

    //Add methods
    public void addHead(SLLNode n) {
        n.setNext(head);
        head = n;
    }
}
