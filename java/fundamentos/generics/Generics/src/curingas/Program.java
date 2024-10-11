package curingas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {


        /*
         * T => generics
         * T extends (superclass) => generics delimitados
         * ? => curinga
         * ? extends (superclass) || ? super (subclass) => curinga delimitado
         */

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(1.32, 2.321, 3.432, 4.453);
        List<Object> myObjs = new ArrayList<>();

        copy(myInts, myObjs);
        printList(myObjs);

        myObjs.add("Maria");
        myObjs.add("João");

        copy(myDoubles, myObjs);
        printList(myObjs);

        //Aceita qualquer lista que seja subtipo de Number => Integer, Double, Long...
        List<? extends Number> covariancia = myDoubles;
//        covariancia.add(3.43); //get OK - put ERROR
        Number n = covariancia.getFirst();
        System.out.println(n);
        printList(covariancia);

        //Aceita qualquer lista que seja supertipo de Number => Object
        List<? super Number> contravariancia = myObjs;
        contravariancia.add(3.234);
//        n = contravariancia.getFirst(); // get ERROR = put OK
        printList(contravariancia);

    }

    private static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
    }

    //<?> Aceita qualquer lista, put ERROR
    public static void printList(List<?> list) {
        list.forEach(x -> System.out.println(x + " "));
        System.out.println();
    }
}
