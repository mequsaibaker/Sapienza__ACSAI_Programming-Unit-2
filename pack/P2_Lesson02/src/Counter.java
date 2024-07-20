public class Counter {
    // implements a counter

    int mystery = 0;
    // initial value of the counter. Not good yet: mystery should be private!

    public void tic () {
        System.out.println("tic ");
        mystery++;
    }
    // each time the tic method is called the counter increments by one

    public int get () { // returns the current value of the counter
        return mystery;
    }
}