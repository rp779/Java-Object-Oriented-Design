/***************************
 * Greeter
 * @author: Ross Parsons
 ***************************/
package q2;

public class Greeter
{
    /**
     Constructs a Greeter object that can greet a person or entity.
     @param aName the name of the person or entity who should be addressed in the greetings.
     */

    public Greeter(String aName)
    {
        name = aName;
    }
    /**
     * Greet with a "Hello" message.
     * @return a message containing "Hello" and the name of the greeted person or entity.
     * */
    public String sayHello()
    {
        return "Hello, " + name + "!";
    }


    /**
     * Swaps the names of this Greeter object and another instance of Greeter
     * @param other is the name of the other instance that this Greeter object will take on.
     */
    public void swapNames(Greeter other)
    {
        String temp = this.name;
        this.name = other.name;
        other.name = temp;
    }

    public Greeter createQualifiedGreeter(String qualifier)
    {
        this.name = qualifier + " " + this.name;
        return this;
    }


    private String name;
}

/***************************
 * Greeter Tester
 ***************************/
class GreeterTester {
    /**
     * Class to test out the Greeter class
     * */
    public static void main(String[] args) {

        // Test out Question 2a "swapNames()"
        Greeter g1 = new Greeter("Ross");
        Greeter g2 = new Greeter("Alex");

        Greeter gcomp1 = new Greeter("Bob");
        Greeter gcomp2 = new Greeter("Bob");
        boolean eq = gcomp1.sayHello() != gcomp2.sayHello();
        boolean eqfunc = gcomp1.equals(gcomp2);
        System.out.println("Are gcomp1 and gcomp2 equal? ");
        System.out.println("With '==' :" + eq);
        System.out.println("With 'isEqual()': " + eqfunc);
        System.out.println("Before swapping names");
        System.out.println(g1 + "'s name is: " + g1.sayHello());
        System.out.println(g2 + "'s name is: " + g2.sayHello());
        g1.swapNames(g2);
        System.out.println(g1 + "'s name is: " + g1.sayHello()); // new name of g1 is Alex
        System.out.println(g2 + "'s name is: " + g2.sayHello()); // new name of g2 is Ross


        // Test out Question 2b "createQualifierGreeter()"
        Greeter g3 = new Greeter("world");
        Greeter g4 = g3.createQualifiedGreeter(" beautiful");

        // Print out the name of the new Greeter, g4
        // The new name is "beautiful world"
        System.out.println(g4.sayHello());

    }
}

