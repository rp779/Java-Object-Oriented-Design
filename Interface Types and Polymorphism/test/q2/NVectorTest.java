/**
 * @author: Ross Parsons
 */

package q2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * JUnit5 unit tests for vararg constructor, equals(), get(), add(), sprod(), and toString()
 */
class NVectorTest {

    @Test
    void NVector()
    {
        System.out.println("run vararg constructor test");
        NVector x = new NVector(1.0, 2.0, 3.0, 4.0, 5.0);
        String result = x.toString();
        Assert.assertTrue(result.equals("[ 1.0 2.0 3.0 4.0 5.0 ]") );
    }

    @Test
    void testGet() {
        System.out.println("run test get");
        double a = 1, b = 2;

        NVector x = new NVector(a, b);

        double result = x.get(0);

        // the 0th element in x is in fact 1
        Assert.assertTrue(result == 1);
    }

    @Test
    void testAdd() {
        System.out.println("run test add");
        double a = 1, b = 2, c = -3, d = 4;

        NVector x = new NVector(a, b);
        NVector y = new NVector(c, d);

        NVector result = x.add(y);

        NVector expected = new NVector(-2, 6);

        // test condition using the equals() method:
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    void testEquals() {
        System.out.println("run test equals");
        double a = 1, b = 2;

        NVector x = new NVector(a, b);
        NVector y = new NVector(a, b);

        // test condition using the equals() method:
        Assert.assertTrue(x.equals(y));
    }

    @Test
    void testSprod() {
        System.out.println("run test sprod");
        double a = 1, b = 2, c = -3, d = 4;

        NVector x = new NVector(a, b);
        NVector y = new NVector(c, d);

        // the scalar product of x and y is in fact 5.0
        Assert.assertTrue(x.sprod(y) == 5.0);
    }

    @Test
    void testToString() {
        System.out.println("run test toString");
        NVector x = new NVector(1.0, 2.0, 3.0, 4.0, 5.0);
        String result = x.toString();
        Assert.assertTrue(result.equals("[ 1.0 2.0 3.0 4.0 5.0 ]") );
    }
}