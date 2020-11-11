/**
 * @author: Ross Parsons
 */
package q2;
import java.util.Arrays;

public class NVector implements Cloneable{

    private int dimension;
    private double[] v;

    /**
    * Creates a vector of doubles with size dimension and fills with 0.0's
    * @param dimension size of vector to be created
    * @precondition: dimension > 0
    * @postcondition: an NVector object is created
    * @invariant: None
    * */
    public NVector(int dimension)
    {
        assert dimension > 0 : "initial value must be greater than 0";
        this.dimension = dimension;
        this.v = new double[dimension];
        Arrays.fill(v, 0);
    }

    /**
    * Takes another NVector and copies all data from "other"
    * @param: NVector other
    * @precondition: an NVector object exists
    * @postcondition: a new NVector object is instantiated
    * @invariant: None
    * */
    public NVector (NVector other){
        // create a new array with same size as NVector other
        double[] array = new double[other.length()];

        // pull out the double[] from NVector other
        double[] oldValues = other.getVector();

        for (int i = 0; i < other.length(); i++)
        {
            array[i] = oldValues[i];
        }
        this.v = array;
        this.dimension = array.length;
    }


    /**
    * Takes another NVector and copies all data from "other"
    * @param: NVector other
    * @precondition: an NVector object exists
    * @postcondition: a new NVector object is instantiated
    * @invariant: None
    * */
    public NVector(double...d)
    {
        double[] array = new double[d.length];
        for(int i = 0; i < d.length; i++)
        {
            array[i] = d[i];
        }
        this.v = array;
        this.dimension = d.length;
    }

    /**
    * getVector() returns an array of type double representation from the NVector object
    * @param: None
    * @precondition: an NVector object exists, getV() is called on this object
    * @postcondition: double[] v is returned to caller
    * @invariant: None
    * */
    public double[] getVector()
    {
        return v;
    }

    /**
    * length() returns size/length of NVector object
    * @param: None
    * @return size of NVector object
    * @precondition: an NVector object exists
    * @postcondition: caller of this function receives size of NVector object
    * @invariant: None
    * */
    public int length()
    {
        return this.dimension;
    }

    /**
     * get() returns value of double at index i in the NVector object
     * @param i an index
     * @return the value at index i
     * @precondition: an NVector object exists
     * @postcondition:  value of double at index i in the NVector object is returned
     * @invariant: None
     */
    public double get(int i)
    {
        return this.v[i];
    }

    /**
     * Implement the cloneable interface so that objects of type NVector can be cloned
     * @return a clone of the NVector object
     * @throws: CloneNotSupportedException
     * @precondition NVector object exists
     * @postcondition an NVector object is cloned
     * @invariant The new NVector object that was cloned points to different object than
     * the object that was cloned.
     */

    public NVector add(NVector other) throws ArrayIndexOutOfBoundsException, AssertionError
    {
        try {
            assert this.dimension == other.dimension;
        }catch (AssertionError e) {
            System.out.println("NVector objects must be of same length.");
            e.printStackTrace();
        }
        double[] array = new double[other.length()];
        for (int i = 0; i < other.length(); i++)
        {
            array[i] = other.get(i) + this.get(i);
        }

        return new NVector(array);
    }

    /**
     * @precondition: an NVector object exists
     * @postcondition: the same NVector object exists with no additional variable referring to it
     * @invariant: none
     * @param: none
     * @return a clone of the object is returned
     * @throws: CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    /**
     * equals() compares two NVector objects
     * @param: other an NVector object
     * @return boolean
     * @precondition: an NVector object exists
     * @postcondition: none
     * @invariant: none
     */
    public boolean equals(NVector other)
    {
        // first test that the lengths are equal
        if (this.length() == other.length())
        {
            // then test if the contents of the arrays in the NVector objects are equal
            if (Arrays.equals(this.v, other.v)) return true;
        }
        return false;
    }

    /**
     * set() returns a new copy of an NVector with just one element changed
     * @param: i an index
     * @param: x a double value to set the value of index i to
     * @return an NVector object with single value changed.
     * @precondition: an NVector object exists
     * @postcondition: none
     * @invariant: none
     */
    public NVector set(int i, double x) throws CloneNotSupportedException {
        NVector vector = (NVector)this.clone();
        vector.v[i] = x;
        return vector;
    }

    /**
     * sprod() returns a double with the scalar product of this vector and another NVector
     * @param: none
     * @return a String representation of an NVector object
     * @precondition: an NVector object exists
     * @postcondition: none
     * @invariant: none
     */
    public double sprod(NVector other)
    {
        assert this.length() == other.length() : "both NVector object must have same length";

        double scalar = 0;
        for(int i = 0; i < this.length(); i++)
        {
            scalar += this.get(i) * other.get(i);
        }
        return scalar;
    }

    /**
     * toString() returns a String representation of an NVector object
     * @param: none
     * @return a String representation of an NVector object
     * @precondition: an NVector object exists
     * @postcondition: none
     * @invariant: none
     */

    @Override
    public String toString()
    {
        String s = "[ ";
        for(int i = 0; i < this.length(); i++)
        {
            s += this.get(i) + " ";
        }
        s += "]";
        return s;
    }
}

/**
 * The NVectorTest class uses a main() method to test functions of the NVector class. Unit testing done
 * with JUnit5 can be found in test/q2/NVectorTest.
 * Declared as not public so it can be ran from here. Otherwise seperate file NVectorTestMain will need to be created.
 * There is already a seperate test file that uses JUnit5. I want to cut back on amount of reduntant files to be submitted.
 */
class NVectorTestMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        // test constructor that sets length to argument and fills with zeros
        System.out.println("testing zero fill constructor");
        NVector vec1 = new NVector(10);
        System.out.println(vec1);

        // test constructor that creates a NVector object from another NVector object
        System.out.println("testing copy constructor");
        NVector vec2 = new NVector(vec1);
        System.out.println(vec2);

        // test VARARG constructor (make 2 NVector objects so i can test add() method)
        System.out.println("testing vararg constructor");
        NVector vec3 = new NVector(1.2, 4.9, 6.0, 4.7);
        NVector vec4 = new NVector(3.4, 6.9, 4.3, 9.0);
        System.out.println(vec3);
        System.out.println(vec4);

        // test add() method
        System.out.println("testing add()");
        NVector vec5 = vec3.add(vec4);
        System.out.println(vec5);

        // test get() method
        System.out.println("testing get()");
        for(int i = 0; i < vec5.length(); i++)
        {
            // printing out each element in an NVector using get()
            System.out.print(vec5.get(i) + " ");
        }

        // testing length() method: should output 4:
        System.out.println("testing length()");
        System.out.println(vec4.length());

        // use set() method to set the first index value to 9999
        System.out.println("testing set()");
        vec5.set(0, 9999);
        System.out.println("vec5 should have 9999 in as its first element:");
        System.out.println(vec5);

        // test sprod() method
        System.out.println("testing sprod()");
        double a = 1, b = 2, c = -3, d = 4;

        NVector x = new NVector(a, b);
        NVector y = new NVector(c, d);

        double scalar = x.sprod(y);
        System.out.println("scalar of x and y: " + scalar);

        System.out.println("testing toString()");
        NVector vec6 = new NVector(1.0, 2.0, 3.0, 4.0, 5.0);
        String result = vec6.toString();
        System.out.println(result);
    }
}

