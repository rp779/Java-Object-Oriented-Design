/**
 * Custom Exception
 * @author Ross Parsons
 * */
package q6_3;

public class LessThanZeroException extends RuntimeException{
    public LessThanZeroException(){}
    public LessThanZeroException(String reason){super(reason);}
}
