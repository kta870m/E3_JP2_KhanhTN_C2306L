import Entity.Booking;
import Entity.Customer;
import Entity.Room;
import Entity.RoomType;
import Repository.BookingService;
import Repository.CustomerRepo;
import Repository.RoomRepo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;
import static Global.parseDate.parseDateTime;


public class Main {
    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<Room>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        int choice;

        rooms.add(new Room(8, RoomType.S, "RS001"));
        rooms.add(new Room(12, RoomType.D, "RD001"));
        rooms.add(new Room(35, RoomType.Q, "RQ002"));
        rooms.add(new Room(12.5, RoomType.T, "RT001"));
        rooms.add(new Room(20.5, RoomType.Qd, "RQ001"));

        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("001" ,"84125325346457","Mr.Linus Tovaldo"));
        customers.add(new Customer("002","91124235346467", "Mr.Bill"));
        customers.add(new Customer("003","911423534646","Mr.Turing"));

        List<Booking> bookings = new ArrayList<Booking>();
        bookings.add(new Booking(1, rooms.get(0), customers.get(0), LocalDateTime.of(2023, 3, 15, 9, 30, 15), LocalDateTime.of(2023,3,16,12,30,45)));
        bookings.add(new Booking(2, rooms.get(0), customers.get(1), LocalDateTime.of(2023,6,9,19,30,25),LocalDateTime.of(2023,6,10,11,25,15)));
        bookings.add(new Booking(3, rooms.get(1), customers.get(1), LocalDateTime.of(2023,3,11, 10,10,5),LocalDateTime.of(2023,3,13,11,5,10)));
        bookings.add(new Booking(4, rooms.get(3), customers.get(2), LocalDateTime.of(2023,11,11,11,11,15),LocalDateTime.of(2023,11,13,11,15,15)));
        bookings.add(new Booking(5, rooms.get(3), customers.get(0), LocalDateTime.of(2023,10,25,9,20,25),LocalDateTime.of(2023,10,26,12,25,30)));
        bookings.add(new Booking(6, rooms.get(2), customers.get(0), LocalDateTime.of(2023,8,18,12,25,35),LocalDateTime.of(2023,8,19,11,35,20)));
        bookings.add(new Booking(7, rooms.get(0), customers.get(0), LocalDateTime.of(2023, 3, 15, 9, 30, 15), LocalDateTime.of(2023,3,16,12,30,45)));

        BookingService bs = new BookingService();
        CustomerRepo cp = new CustomerRepo();
        RoomRepo rp = new RoomRepo();

        rp.rooms = rooms;
        cp.customers = customers;
        bs.bookings = bookings;
        bs.rooms = rooms;
        bs.customers = customers;



        try{
            do{
                System.out.println("1 - Add New Bookings");
                System.out.println("2 - Delete Bookings");
                System.out.println("3 - Find Bookings by Keyword");
                System.out.println("4 - Display All ");
                System.out.println("5 - Display max ");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(bf.readLine());
                switch(choice){
                    case 1:
                        bs.add();
                        bookings.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter Customer Name: ");
                        String cusName = bf.readLine();
                        System.out.print("Enter Phone Number: ");
                        String cusNum = bf.readLine();
                        System.out.print("Enter Room Id: ");
                        String roomId = bf.readLine();
                        System.out.println("=== Search By Customer Name ===");
                        System.out.println(bs.findByCusName(cusName));
                        System.out.println("=== Search By Customer Phone ===");
                        bs.findByCustomerPhone(cusNum).forEach(System.out::println);
                        System.out.println("=== Search By Room Id ===");
                        bs.findByRoomId(roomId).forEach(System.out::println);
                        break;
                    case 4:
                        bs.displayTotalRoomPrice();
                        break;
                    case 5:
                        System.out.println(bs.displayMaxPayPrice());
                        break;
                }
            }while(!flag);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }
}