public class IntList {
    // Lists of integers (coarse!)

    public int head;
    public IntList tail;

    IntList(int head, IntList tail) {
        this.head = head;
        this.tail = tail;
    }

    public void printList(int n) {
        // prints the first n elements of the list

        if (n <= 0) {
            System.out.println();
            return;
        }

        System.out.print(head + " ");
        if (tail == null) // it's a one element list
            System.out.println();
        else
            tail.printList(n - 1);
    }

    public void concat (IntList l) {
        // appends this list to l

        if (tail == null)
            this.tail = l;
        else tail.concat(l);
    }

    public void loop () {
        // appends this list to itself thus creating a loop!

        this.concat(this); // this!!!
    }
}