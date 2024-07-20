public class TestQueue {
    public static void main(String[] args) { 
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
}
