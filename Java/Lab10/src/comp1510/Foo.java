package comp1510;

public class Foo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("no arguments were given.");
        }
        else {
            for (String a : args) {
                System.out.println(a);
            }
        }
    }
}