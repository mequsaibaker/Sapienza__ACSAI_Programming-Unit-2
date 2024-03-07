public class SillySum {

    public static void main(String[] args) {
        // program execution starts with method main

        System.out.print("32 + 4 = "); // prints a string, no new line
        System.out.println(doIt(32, 4)); // prints the value returned by method doIt
    }

    public static int doIt (int x, int y) {
        // computation of x + y... silly as promised!

        int result = x;
        while (y > 0) {
            result++;
            y--;
        }
        return result;
    }
}
