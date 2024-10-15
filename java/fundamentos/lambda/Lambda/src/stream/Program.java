package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {

        List<Integer> list= Arrays.asList(3, 5, 6, 10, 20, 30);
        Stream<Integer> st1 = list.stream();
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("José", "Maria", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(20).toArray()));

        Stream<Long> st4 = Stream.iterate(new Long[]{0L, 1L}, x -> new Long[]{x[1], x[0] + x[1]}).map(x -> x[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));

    }
}
