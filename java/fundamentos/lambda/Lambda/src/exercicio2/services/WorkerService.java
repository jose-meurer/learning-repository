package exercicio2.services;

import exercicio2.entities.Worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class WorkerService<T extends Worker> {

    public WorkerService() {
    }

    public List<T> filterBySalary(List<T> list, Predicate<T> predicate) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Lista vazia");
        }

//        List<T> workers = new ArrayList<>();
//        for (T work : list) {
//            if (predicate.test(work)) {
//                workers.add(work);
//            }
//        }
//        return workers;

        return list.stream().filter(predicate).toList();
    }

    public List<String> workerToEmail(List<T> list) {
        return list.stream().map(x -> x.getEmail()).sorted(Comparator.comparing(String::toUpperCase)).toList();
    }

    public double sumSalary(List<T> list, Predicate<T> predicate) {
//        double sum = 0.0;
//        for(T work : list) {
//            if (predicate.test(work)) {
//                sum += work.getSalary();
//            }
//        }
//        return sum;
        return list.stream().filter(predicate).map(Worker::getSalary).reduce(0.0, Double::sum);
    }
}
