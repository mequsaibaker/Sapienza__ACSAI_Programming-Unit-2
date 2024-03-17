/*
 * developed by Qusai Baker
 */

public class Queue {
    public static void main(String[] args) { //I tweaked the main method a bit to resolve some syntax errors which were existed in the original main
        // tests queues
        Queue c = new Queue();
        c.revolution();
        if (c.isEmpty())
            System.out.println("empty queue!"); // it should!
        try {
            c.insert(7);
            c.insert(9);
            System.out.println(c.extract()); // prints 7
            c.estrai();
            c.estrai(); // throws an exception
        } catch (EmptyQueueException e) {
            System.out.println("excetion caught!");
        }
        c.insert(77);
        c.insert(99);
        c.revolution();
        try {
            System.out.println(c.extract()); // prints 99
        } catch (EmptyQueueException e) {
            System.out.println("excetion caught!");
        }
    }

    DoublyLinkedList list;

    public Queue() {
        list = new DoublyLinkedList();
    }

    public int getLen() {
        return list.getLen();
    }

    public boolean isEmpty() {
        if (list.getLen() == 0) {
            return true;
        }
        return false;
    }

    public void insert(int v) {
        list.addTail(v);
    }

    public int extract() throws EmptyQueueException { //This method is the same as estrai(). I repeated the implementation because of the test in "main" function
        try {
            return list.removeHead();
        } catch (EmptyLinkedListException e) {
            throw new EmptyQueueException();
        }
    }

    public int estrai() throws EmptyQueueException { //This method is the same as extract(). I repeated the implementation because of the test in "main" function
        try {
            return list.removeHead();
        } catch (EmptyLinkedListException e) {
            throw new EmptyQueueException();
        }
    }

    public void revolution() {
        list.reverseList();
    }

    //implementing list node class and linked list class as an underlying data structure for the queue implementation
    private class DoublyLinkedList {
        private int len;
        private Node head;
        private Node tail;

        int getLen() {
            return len;
        }

        void addTail(int v) {
            if (len == 0) {
                addFirst(v);
            } else {
                Node n = new Node(v);
                n.setPre(tail);
                tail.setNext(n);
                tail = n;
                ++len;
            }
        }

        int removeHead() throws EmptyLinkedListException {
            if (len == 0) {
                throw new EmptyLinkedListException();
            }
            int result = head.getValue();
            if (len == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPre(null);
            }
            --len;
            return result;
        }

        void reverseList() {
            reverse(tail);
            Node temp = tail;
            head = tail;
            tail = temp;
        }

        //implemented private methods for internal DoublyLinkedList class use only
        private void addFirst(int v) {
            Node n = new Node(v);
            head = n;
            tail = n;
            ++len;
        }

        private void reverse(Node n) {
            if (n != null) {
                Node temp = n.getNext();
                n.setNext(n.getPre());
                n.setPre(temp);
                reverse(n.getNext());
            }
        }
    }

    private class Node {
        private int value;
        private Node next;
        private Node pre;

        Node(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Node getPre() {
            return pre;
        }

        void setPre(Node pre) {
            this.pre = pre;
        }
    }

    //implementing the reuired exceptions
    private class EmptyQueueException extends EmptyLinkedListException {

    }

    private class EmptyLinkedListException extends Exception {

    }
}
