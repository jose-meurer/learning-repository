import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        /*
         * HashSet = mais rapido, porem nao ordenado
         * TreeSet = lento, porem ordenado com compareTo ou comparator
         * LinkedHashSet = intermediario, porem ordenado na ordem que foi adicionado
         * */

        set.add("Carro");
        set.add("Mesa");
        set.add("Cachorro");
        set.add("Gato");
        set.add("Melancia");

        set.removeIf(x -> x.charAt(0) == 'G');

        set.forEach(System.out::println);

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //Junta tudo
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //Igualdade que tem nas duas listas
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        //Diferença das duas listas
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    }
}