/**
 * @author: Ross Parsons
 * */

package GenericsAndLambdas;

import java.util.LinkedList;

public class MyList<T> extends LinkedList<T>  {

    private T t = null ;


    /**
     * map -
     * @param fo
     * @return newList
     * */
    public <R> MyList<R> map(Functor<R, T> fo)
    {
        MyList<R> newList = new MyList<>();
        for(int i = 0; i < this.size(); i++)
        {
            // using add method with signature (int index, E element), the apply() method
            // returns the element to be added to the list.
            newList.add(i,fo.apply(this.get(i)));
        }
        return newList;
    }


    /**
     * reduce - the successive cummulative application of the Functor2 apply()
     * function to all elements of the list, beginning with the initial value and
     * the first element of the list.
     * @param fo2 a Functor2 object
     * @param initVal initial starting value
     * @return R the result of appliying the Functor2 object's apply() method on
     * all the elements in the collection
     * */
    public T reduce(Functor2<T, T, T> fo2, T initVal){
        T t;
        t = (T) fo2.apply(this.get(0), initVal);

        for(int i = 1; i < this.size(); i++){
            t = (T) fo2.apply(this.get(i), t);
        }
        return t;
    }

    public static void main(String[] args) {

       TimesTwoFun tt = new TimesTwoFun<>();
       int[] arr = new int[]{-2, 1, 0, 4};
       MyList<Integer> lst = new MyList<Integer>();
       for (int i = 0; i < arr.length; i++)
       {
           lst.add(arr[i]);
       }
       MyList<Integer> object = lst.map(tt);
       System.out.println("Original vals: [-2, 1, 0, 4]\n" + "after tt.apply(): " + object);


       // lambda expression of the Functor<> object
       Functor<Integer, Integer> fo = (Integer elem) -> elem * 2;

       System.out.print("using a lambda expression: [");
       for(int i = 0; i < arr.length; i++)
       {
           if (i == arr.length - 1)
           {
               System.out.print(fo.apply(arr[i])+"]");
               break;
           }
           System.out.print(fo.apply(arr[i]) + ", ");

       }


    }
}
