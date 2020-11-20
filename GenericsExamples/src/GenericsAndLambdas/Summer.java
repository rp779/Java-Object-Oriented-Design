package GenericsAndLambdas;

import java.util.ArrayList;
import java.util.Arrays;

public class Summer implements Functor2<Integer, Integer, Integer> {

    private MyList<Integer> lst;
    public Summer(MyList list){
        this.lst = list;
    }


    @Override
    public Integer apply(Integer param1, Integer param2) {
        return param1 + param2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, -1, 1, 4));
        MyList<Integer> lst = new MyList<>();
        for(int i = 0; i < list.size(); i++){lst.add(list.get(i));}
        Summer summer = new Summer(lst);
        System.out.println("With 'Summer' object: " + lst.reduce(summer, 0));

        Functor2<Integer, Integer, Integer> lambdaFun = (param1, param2) -> param1 + param2;
        System.out.println("With lambda function: " + lst.reduce(lambdaFun, 0));

    }
}
