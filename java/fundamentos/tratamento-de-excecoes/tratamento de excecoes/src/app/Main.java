package app;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Room number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkin = LocalDate.parse(sc.next(), Reservation.dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkout = LocalDate.parse(sc.next(), Reservation.dtf);

            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("Reservation: " + reservation.toString());

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(sc.next(), Reservation.dtf);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(sc.next(), Reservation.dtf);

            reservation.updateDates(checkin, checkout);
            System.out.println("Reservation: " + reservation.toString());

        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date input");
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }
}
