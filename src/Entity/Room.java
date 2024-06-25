package Entity;

public class Room {
    private String id;
    private RoomType roomType;
    private double price_per_hours;

    public Room(double price_per_hours, RoomType roomType, String id) {
        this.price_per_hours = price_per_hours;
        this.roomType = roomType;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPrice_per_hours() {
        return price_per_hours;
    }

    public void setPrice_per_hours(int price_per_hours) {
        this.price_per_hours = price_per_hours;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", roomType=" + roomType.getLable() +
                ", price_per_hours=" + price_per_hours +
                '}';
    }
}
