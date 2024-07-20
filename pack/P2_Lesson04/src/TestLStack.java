public class TestLStack {
    public static void main(String[] args) {
        // plays with list stacks

        ListStack l = new ListStack();
        //l.push(42);
        System.out.println((l.is_empty())? "empty list!" : "");

        l.push(6);
        l.push(3);
        try {
            l.pop();
            // l.pop();
            System.out.println(l.pop());
            }
        catch (EmptyStackException e) {
            System.out.println("exception!!!");
        }
    }
}