public class A {

    // in this example we force Java to reveal the default value of type int

    public int a;
    public int b = a;

    public A(int v) {
        a = v;
    }
}