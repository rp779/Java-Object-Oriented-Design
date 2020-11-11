/***************************
 * Prime Factorizer
 * @author: Ross Parsons
 ***************************/
package q5;

import java.util.ArrayList;

public class PrimeFactorizer {

    /**
     * Constructs a PrimeFactorizer object.
     * @param n is the target number to find the prime factorization of.
     * */
    public PrimeFactorizer(int n)
    {
        this.n = n;
        this.primes = new ArrayList<>();
        this.exponents = new ArrayList<>();
    }

    /**
     * getN() returns n
     * */
    public int getN()
    {
        return this.n;
    }


    /**
     * Compute factorization. Do not repeat operation if it was called before.
     * */
    public void compute() {
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
        int temp = n, val = 2, count;
        while(temp > 1){
            if(isPrime(val)) {
                count = 0;
                while (temp % val == 0) {
                    count++;
                    temp = temp / val;
                }
                if (count > 0) {
                    p.add(val);
                    e.add(count);
                }
            }
            val++;
        }
    }

    /**
     * isPrime() tests if a number is prime.
     * @param n the target number
     * @return boolean
     * */
    private boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return the factors and exponents in two ArrayLists. Call compute() first, if necessary.
     * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
     * This function overwrites the 'n' parameter passed to the constructor.
     * @param n target number
     * @param primes an ArrayList of integers that store the primes.
     * @param exponents an ArrayList of integers that store the exponents.
     */
    public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents)
    {
        PrimeFactorizer p = new PrimeFactorizer(n);
        if(primes == null){
            p.compute();
        }

        primes = (ArrayList<Integer>) p.primes.clone();
        exponents = (ArrayList<Integer>) p.exponents.clone();

    }


    /**
     * Return a string with the "pretty" representation of the prime factorization.
     * For instance, if n is 60, then toString() for the PrimeFactorizer(60) object
     * should be "60 = 2^2*3*5". Call compute() if not done before.
     * @return result which is "pretty" representation of a PrimeFactorizer object.
     */
    public String toString() throws NullPointerException{

        StringBuilder result = new StringBuilder(n + " = ");

        for(int i = 0; i < primes.size(); i++){
            if(i != 0){
                result.append("*");
            }
            if(exponents.get(i) != 1) {
                result.append(primes.get(i)).append("^").append(exponents.get(i));
            } else
                result.append(primes.get(i));

        }
        return result.toString();
    }


    private int n;
    private ArrayList<Integer> primes;
    private ArrayList<Integer> exponents;

}
class PrimeFactorTest {
    public static void main(String [] args){
        PrimeFactorizer p = new PrimeFactorizer(98);
        p.compute();
        System.out.println(p);

        PrimeFactorizer p2 = new PrimeFactorizer(45);
        p2.compute();
        System.out.println(p2);
    }
}
