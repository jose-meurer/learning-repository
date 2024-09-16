package exercicio1.app.entities;

import java.time.LocalDate;

public class HourContract {

    private LocalDate localDate;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public HourContract(LocalDate localDate, Double valuePerHour, Integer hours) {
        this.localDate = localDate;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double totalValue() {
        return valuePerHour * hours;
    }

    @Override
    public String toString() {
        return "HourContract{" +
                "localDate=" + localDate +
                ", valuePerHour=" + valuePerHour +
                ", hours=" + hours +
                '}';
    }
}