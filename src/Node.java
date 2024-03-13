public class Node {
    private int value;
    private Node pre;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public void setPre(Node n) {
        pre = n;
    }
    
    public void setNext(Node n) {
        next = n;
    }

    public void setValue(int v) {
        value = v;
    }

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
