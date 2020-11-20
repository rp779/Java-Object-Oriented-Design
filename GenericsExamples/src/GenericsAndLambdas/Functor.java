/**
 * @author: Ross Parsons
 * */

package GenericsAndLambdas;

public interface Functor<R,T> {
    /**
     * apply() runs some computation on param of type T and returns
     * a value of type R
     * */
    public R apply(T param);
}
