package singlelinkedlist;

public class SLLNode {
    private int value;
    private SLLNode next;

    //Constructers
    public SLLNode(int value) {
        this.value = value;
    }

    public SLLNode(int value, SLLNode next) {
        this.value = value;
        this.next = next;
    }

    //Setters and Getters
    public int getValue() {
        return value;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    public SLLNode getNext() {
        return next;
    }

    protected void setNext(SLLNode next) {
        this.next = next;
    }

}
