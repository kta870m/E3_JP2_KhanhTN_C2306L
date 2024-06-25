package Repository;
import Entity.*;
import Generic.IGeneric;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static Global.parseDate.parseDateTime;

public class BookingService implements IGeneric<Booking>{
    public static List<Booking> bookings;
    public static List<Room> rooms;
    public static List<Customer> customers;
    public static Map<Room, Double> totalPrice;


    public void displayTotalRoomPrice(){
        totalPrice = new HashMap<>();
        Map<RoomType, Long> roomHoursMap = bookings.stream()
                .collect(Collectors.groupingBy(
                        b -> b.getRoom().getRoomType(),
                        Collectors.summingLong(b -> Duration.between(b.getCheck_in_datetime(), b.getCheck_out_datetime()).toHours())
                ));
        Iterator<Map.Entry<RoomType, Long>> iterator = roomHoursMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<RoomType, Long> entry = iterator.next();
            bookings.stream()
                    .filter(bk->bk.getRoom().getRoomType().equals(entry.getKey()))
                    .map(bk->totalPrice.put(bk.getRoom(), entry.getValue() * bk.getRoom().getPrice_per_hours()))
                    .toList();
        }
        Iterator<Map.Entry<Room, Double>> iterator2 = totalPrice.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Room, Double> entry = iterator2.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public Optional<Map.Entry<Room, Double>> displayMaxPayPrice(){
        return totalPrice.entrySet().stream()
                .collect(Collectors.maxBy(Map.Entry.comparingByValue()));
    }

    public List<Map.Entry<String, List<Booking>>> findByCusName(String Keyword){
        return bookings.stream()
                .collect(Collectors.groupingBy(b->b.getCustomer().getCus_name()))
                .entrySet().stream().filter(mk-> mk.getKey().contains(Keyword)).toList();
    }

    public List<Map.Entry<String, List<Booking>>> findByCustomerPhone(String Phone){
        return bookings.stream()
                .collect(Collectors.groupingBy(b->b.getCustomer().getCus_phone()))
                .entrySet().stream().filter(mk-> mk.getKey().contains(Phone)).toList();
    }

    public List<Map.Entry<String, List<Booking>>> findByRoomId(String id){
        return bookings.stream()
                .collect(Collectors.groupingBy(b->b.getRoom().getId()))
                .entrySet().stream().filter(mk-> mk.getKey().contains(id)).toList();
    }
    
    @Override
    public void add() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String roomId, cusId, checkIn, checkOut;
        int bookId;
        Room room = null;
        RoomRepo rp = new RoomRepo();
        boolean flag;
        CustomerRepo cp = new CustomerRepo();
        Customer cus = null;

        try{
            System.out.print("Enter Booking Id: ");
            bookId = Integer.parseInt(bf.readLine());
            do{
                System.out.print("Enter Room Type: ");
                roomId =  bf.readLine();
                switch (roomId){
                    case "S":
                    case"s":
                        room = rp.getByType(RoomType.S);
                        flag = false;
                        break;
                    case "D":
                    case "d":
                        room = rp.getByType(RoomType.D);
                        flag=false;
                        break;
                    case "Q":
                    case "q":
                        room = rp.getByType(RoomType.Q);
                        flag = false;
                        break;
                    case "T":
                    case "t":
                        room = rp.getByType(RoomType.T);
                        flag = false;
                        break;
                    case "Qd":
                        room = rp.getByType(RoomType.Qd);
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        flag = true;
                        break;
                }
            }while (flag);
            do{
                System.out.print("Enter Customer Id: ");
                cusId = bf.readLine();
                if(cp.findById(cusId)==null){
                    System.out.println("Cannot find Customer");
                    flag = true;
                }else{
                    cus = cp.findById(cusId);
                    flag = false;
                }
            }while (flag);
            System.out.print("Enter Check in Date: ");
            checkIn = bf.readLine();
            LocalDateTime checkInDateTime = parseDateTime(checkIn);
            System.out.print("Enter Check Out Date: ");
            checkOut = bf.readLine();
            LocalDateTime checkOutDateTime = parseDateTime(checkOut);
            Booking booking1 = new Booking(bookId, room, cus, checkInDateTime, checkOutDateTime);
            bookings.add(booking1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Booking findById(String Keyword) {
        return null;
    }

    @Override
    public void delete(Booking booking) {

    }

}
