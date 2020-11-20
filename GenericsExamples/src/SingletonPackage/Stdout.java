/**
 * @author Ross Parsons
 * Singleton pattern for Java class Stdout
 * */

package SingletonPackage;

public class Stdout {
    /**
     * Stdout is a singleton class.
     * */

    private Stdout(){}

    public void printline(String s){
        System.out.println(s);
    }
    public static Stdout getInstance(){return instance;}

    private static Stdout instance = new Stdout();


    public static void main(String[] args) {
        Stdout s1 = Stdout.getInstance();
        s1.printline("String ONE");

        Stdout s2 = Stdout.getInstance();
        s2.printline("String TWO");

        System.out.print("s1 == s2? ");
        System.out.println(s1 == s2);

        System.out.print("s1.equals(s2)? ");
        System.out.println(s1.equals(s2));
    }
}
