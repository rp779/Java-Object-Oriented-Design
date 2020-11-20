/**
 * @author: Ross Parsons
 * */

package GenericsAndLambdas;

public class LengthFun implements Functor<Integer, String>
{
    public LengthFun(){}

    /**
     * @return length (Integer) of String s
     * */
    public Integer apply(String s){
        return s.length();
    }


    public static void main(String[] args) {
        LengthFun lf = new LengthFun();
        System.out.println(lf.apply("Ross"));
        Functor<Integer, String> fn = (String s) -> s.length();
        System.out.println("Using lambda, (length should be 4): " + fn.apply("Ross"));
    }
}
