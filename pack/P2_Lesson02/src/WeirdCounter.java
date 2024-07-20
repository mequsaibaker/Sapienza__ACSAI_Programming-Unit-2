public class WeirdCounter {
    // weird implementation of a counter

    private int mystery = -5;
    // Note: it's private!

    public void tic () {
        System.out.println("tic ");
        mystery = mystery - 1;
    }
    // each time the tic method is called the counter increments by one

    public int get () { // returns the current value of the counter
        return - (mystery + 5);
    }
}