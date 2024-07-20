public class TestA {

    public static void main(String[] args) {

        // the b attribute of an A object is initialised with the value of attribute a,
        // which is initialiseb by the value passed to the constructor

        A x = new A (7);
        System.out.println(x.b); // what does it print?
    }
}