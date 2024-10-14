import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Set<Product> set = new HashSet<>();

        set.add(new Product("Tv", 900.0));
        set.add(new Product("Car", 55000.00));
        set.add(new Product("Notebook", 1230.00));

        //Set usa equals e HashCode para comparar igualdade, caso a classe nao tenha, usa os valores referencia na memoria
        Product prod = new Product("Notebook", 1230.00);

        System.out.println(set.contains(prod));

    }
}
