public class TestCounter {
    // just a main to test a Counter

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        c1.tic();
        c1.tic();
        c1.tic();
        System.out.println("counter c1 counts " + c1.get());

        c2.tic();
        c2.tic();
        System.out.println("counter c2 counts " + c2.get());
        System.out.println("...while c1 still counts " + c1.get());
    }
}