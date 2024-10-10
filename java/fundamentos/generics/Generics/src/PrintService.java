import java.util.ArrayList;
import java.util.List;

public class PrintService {

    private List<Integer> list = new ArrayList<>();

    public void addValue(Integer value) {
        list.add(value);
    }

    public Integer first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return list.getFirst();
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!list.isEmpty()) {
            stringBuilder.append(list.getFirst());
        }
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(", ").append(list.get(i));
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
