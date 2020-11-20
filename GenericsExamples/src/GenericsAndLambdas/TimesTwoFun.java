/**
 * TwoTimesFun implements Functor<R,T>
 * @author: Ross Parsons
 * */

package GenericsAndLambdas;

public class TimesTwoFun<R> implements Functor<Integer, Integer>{

    @Override
    public Integer apply(Integer param) {
        // no need to use param.intValue() as this class uses type Integer
        return (2 * param);
    }
}
