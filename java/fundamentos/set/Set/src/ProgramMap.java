import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProgramMap {
    public static void main(String[] args) {

        Map<Product, Double> stock = new HashMap<>();

        Product p1 = new Product("Tv", 900.0);
        Product p2 = new Product("Notebook", 1200.00);
        Product p3 = new Product("Tablet", 1100.00);

        stock.put(p1, 100.0);
        stock.put(p2, 500.0);
        stock.put(p3, 300.0);

        Product ps = new Product("Tv", 9000.0);

        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));

        //Exemplo 2

        Map<String, String> cookies = new LinkedHashMap<>();

        cookies.put("username", "jose");
        cookies.put("email", "jose@gmail.com");
        cookies.put("phone", "99112233");
        cookies.put("age", "20");

        cookies.remove("age");
        cookies.put("email", "josemeurer@gmail.com");

        System.out.println("ALL COOKIES: ");
        cookies.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
