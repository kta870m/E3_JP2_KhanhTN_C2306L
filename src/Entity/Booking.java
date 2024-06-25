package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private int id;
    private Room room;
    private Customer customer;
    private LocalDateTime check_in_datetime;
    private LocalDateTime check_out_datetime;

    public Booking(int id, Room room, Customer customer, LocalDateTime check_in_datetime, LocalDateTime check_out_datetime) {
        this.id = id;
        this.check_out_datetime = check_out_datetime;
        this.check_in_datetime = check_in_datetime;
        this.customer = customer;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCheck_in_datetime() {
        return check_in_datetime;
    }

    public void setCheck_in_datetime(LocalDateTime check_in_datetime) {
        this.check_in_datetime = check_in_datetime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCheck_out_datetime() {
        return check_out_datetime;
    }

    public void setCheck_out_datetime(LocalDateTime check_out_datetime) {
        this.check_out_datetime = check_out_datetime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + room +
                ", customer=" + customer +
                ", check_in_datetime=" + check_in_datetime +
                ", check_out_datetime=" + check_out_datetime +
                '}';
    }
}
