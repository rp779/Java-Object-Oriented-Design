/**
 * @author: Ross Parsons
 * */
package GenericsAndLambdas;

public class MRExampleWithLambdas {

    public static void main(String[] args) {
        // initialize list with non-empty Strings
        MyList<String> ls = new MyList<>();
        String[] stuff = new String[]{"Ross", "Bike", "Keyboard", "Globe", "Airplane"};
        for(String s: stuff){ls.add(s);}

        Functor<Integer, String> fo1 = (String s) -> s.length();
        Functor2<Integer, Integer, Integer> fo2 = (Integer x, Integer y) -> x + y;
        System.out.println("ls.map().reduce(): " + ls.map(fo1).reduce(fo2, ls.get(0).length()));
    }
}
