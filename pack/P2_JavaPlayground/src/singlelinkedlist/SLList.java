package singlelinkedlist;

import java.util.EmptyStackException;

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

    public void addHead(int[] v_list) {
        SLList list = new SLList(v_list);
        list.getTail().setNext(head);
        head = list.getHead();
        this.len += list.len;
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

    public void addTail(int[] v_list) {
        SLList list = new SLList(v_list);
        tail.setNext(list.getHead());
        tail = list.getTail();
        this.len += list.len;
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
            ++len;
        }
    }

    private void addFirst(SLLNode n) {
        this.head = n;
        this.tail = n;
        ++this.len;
    }

    //Remove methods
    public void removeHead() throws EmptyStackException {
        if (len == 0) {
            throw new EmptyStackException();
        }
        if (len == 1 | len == 2) {
            head = head.getNext();
            tail = head;
            --len;
        } else {
            head = head.getNext();
            --len;
        }
    }

    public void removeTail() throws EmptyStackException {
        if (len == 0) {
            throw new EmptyStackException();
        }
        else if (len == 1) {
            removeHead();
        }
        else if (len == 2) {
            tail = head;
            --len;
        } else {
            SLLNode n = getNode(len - 2);
            n.setNext(null);
            tail = n;
            --len;
        }
    }
    public void remove(int ind) {
        if (ind == 0) {
            removeHead();
        } else if (ind == len - 1) {
            removeTail();
        } else if (ind == 1) {
            SLLNode n = getNode(ind);
            SLLNode pre_n = getNode(ind - 1);
            pre_n.setNext(n.getNext());
        }
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

    //View methods
    @Override
    public String toString() {
        return toString(head);
    }

    private String toString(SLLNode start_n) {
        String result = "";
        if (start_n.getNext() == null) {
            result += start_n.getValue() + " ";
        } else {
            result += start_n.getValue() + " " + toString(start_n.getNext());
        }
        return result;
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

    public void setHead(SLLNode head) {
        this.head = head;
    }

    public SLLNode getTail() {
        return tail;
    }

    public void setTail(SLLNode tail) {
        this.tail = tail;
    }

    public static void main(String[] args) {
        SLList list = new SLList(new int[]{1,2,3,4,5});
        System.out.println(list.len +": " + list.toString());
        list.addHead(10);
        System.out.println(list.len +": " + list.toString());
        list.addTail(20);
        System.out.println(list.len +": " + list.toString());
        list.insert(50, 3);
        System.out.println(list.len +": " + list.toString());
        list.addHead(new int[]{41, 42, 43, 44});
        System.out.println(list.len +": " + list.toString());
        list.addTail(new int[]{99, 88, 77, 66});
        System.out.println(list.len +": " + list.toString());
        list.removeHead();
        list.removeHead();
        System.out.println(list.len +": " + list.toString());
        list.removeTail();
        list.removeTail();
        System.out.println(list.len +": " + list.toString());
    }
}
