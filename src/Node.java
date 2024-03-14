public class Node {
    private int value;
    private Node pre;
    private Node next;

    //Constructors
    public Node(int value) {
        this.value = value;
    }

    //Setters
    public void setPre(Node n) {
        this.pre = n;
    }
    
    public void setNext(Node n) {
        this.next = n;
    }

    public void setValue(int v) {
        this.value = v;
    }

    //Getters
    public Node pre() {
        return this.pre;
    }

    public Node next() {
        return this.next;
    }

    public int value() {
        return this.value;
    }
}
