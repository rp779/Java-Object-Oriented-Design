/**
 * @author: Ross Parsons
 * */

package GenericsAndLambdas;

public class MRExample{

    public static void main(String[] args) {

        // initialize list with non-empty Strings
        MyList<String> lst = new MyList<>();
        String[] stuff = new String[]{"Ross", "Bike", "Keyboard", "Globe", "Airplane"};
        for(String s: stuff){lst.add(s);}

        LengthFun fo = new LengthFun();
        MyList<Integer> li = lst.map(fo);
        System.out.println(li);
    }
}
