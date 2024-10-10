import java.util.ArrayList;
import java.util.List;

public class PrintServiceGenerics<T> {

    private List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
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
