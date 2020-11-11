/***************************
 * Fibonacci Finder
 * @author: Ross Parsons
 ***************************/
package q1;
public class Fib {
    /**
     * constructs a Fib object that can the n-th value in a Fibonacci sequence
     * @param f0 the first number of the fibonacci sequence. (This Fibonacci sequence begins with numbers defined by the user).
     * @param f1 the second number of the fibonacci sequence.
    */
    public Fib(int f0, int f1)
    {
        this.f0 = f0;
        this.f1 = f1;
    }

    /**
     * Computes F(n) using an ***iterative*** algorithm
     * @param n is the n-th value in the Fibonacci sequence.
     * @return the n-th value.
     */
    public int f(int n)
    {
        try {
            if(n < 0){
                throw new Exception("n must be greater than 0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            int first = f0;  // first term
            int second = f1; // second term
            int temp = first + second;  // is the term fN (following f0, f1)

            // set i = first + second, we want to find the nth term starting from
            // the nth term already known, which is f0 + f1. n will always be greater than i
            for(int i = first + second; i < n; i++)
            {
                temp = first + second;
                first = second;
                second = temp;
            }
            return temp;
        }
    }

    /**
     * Computes F(n) using a ***recursive*** algorithm.
     * Fibonacci sequence is defined by the recursive formula F(n) = F(n-1) + F(n-2).
     * @param n is the n-th value in the Fibonacci sequence.
     * @return the n-th value.
     */
    public int fRec(int n) {

        // base case
        if (n == f0 || n == f1 || n < 0) {
            return 1;
        }
        // recursive step
        return fRec(n - 1) + fRec(n - 2);
    }

    private int f0;
    private int f1;


    public static void main(String[] args) {

        // get numbers F(0) and F(1) from args[0] and args[1].
        try {
            if(args.length != 3){
                throw new Exception("must provide 3 arguments(f0, f1, n)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            int f0 = Integer.parseInt(args[0]);
            int f1 = Integer.parseInt(args[1]);

            // get n from args[2]:
            int n = Integer.parseInt(args[2]);

            // create a Fib object with params F(0) and F(1)
            Fib f = new Fib(f0, f1);

            // calculate F(n) and display with System.out.println() using the iterative methode f(i)
            System.out.println("Iterative: " + f.f(n));

            // calculate F(n) and display with System.out.println() using the recursive methode fRec(i)
            System.out.println("Recursive: " + f.fRec(n));
        }
    }
}
