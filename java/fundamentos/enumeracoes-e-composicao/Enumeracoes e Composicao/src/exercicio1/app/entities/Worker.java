package exercicio1.app.entities;

import exercicio1.app.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.*;

public class Worker {

    private String name;
    private WorkerLevel leve;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel leve, Double baseSalary, Department department) {
        this.name = name;
        this.leve = leve;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLeve() {
        return leve;
    }

    public void setLeve(WorkerLevel leve) {
        this.leve = leve;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return Collections.unmodifiableList(contracts);
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        double sum = baseSalary;
        for (HourContract c : contracts) {
            LocalDate date = c.getLocalDate();
            int c_year = date.getYear();
            int c_month = date.getMonthValue();
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", leve=" + leve +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                ", contracts=" + contracts +
                '}';
    }
}
