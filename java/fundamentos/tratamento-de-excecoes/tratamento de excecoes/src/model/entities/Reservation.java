package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkin, LocalDate chechout) {
        validateDate(checkin, chechout);

        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = chechout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    private void validateDate (LocalDate checkin, LocalDate checkout){
        LocalDate now = LocalDate.now();
        if (checkin.isBefore(now)) {
            throw new DomainException("Reservation dates must be future dates.");
        }

        if(checkin.isAfter(checkout)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
    }

    public void updateDates(LocalDate checkin, LocalDate checkout) {
        LocalDate now = LocalDate.now();

        if (checkin.isBefore(now) || checkout.isBefore(now)) {
            throw new DomainException("Reservation dates for update must be future dates.");
        }

        if (checkout.isBefore(checkin)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }

        this.checkin = checkin;
        this.checkout = checkout;

    }

    public Long duration() {
        Duration duration = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
        return duration.toDays();
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + dtf.format(checkin) + ", check-out: " + dtf.format(checkout) +  ", " + duration() + " nights.";
    }
}
