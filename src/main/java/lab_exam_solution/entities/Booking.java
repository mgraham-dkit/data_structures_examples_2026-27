package lab_exam_solution.entities;

import java.time.LocalDateTime;

public class Booking {
    private static int bookingCount;

    private final int bookingId;
    private final  LocalDateTime bookingDate;
    private final Screening screening;
    private final Customer customer;

    public Booking(Screening screening, Customer customer) {
        if(customer == null){
            throw new IllegalArgumentException("All bookings must be for a specific customer");
        }

        if(screening == null){
            throw new IllegalArgumentException("All bookings must be for a specific screening");
        }

        Booking.bookingCount++;
        this.bookingId = bookingCount;
        bookingDate = LocalDateTime.now();

        this.screening = screening;
        this.customer = customer;
    }

    public int getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public Screening getScreening() {
        return screening;
    }

    public Customer getCustomer() {
        return customer;
    }
}
