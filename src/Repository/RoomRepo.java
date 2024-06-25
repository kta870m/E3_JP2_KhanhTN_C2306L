package Repository;

import Entity.Room;
import Entity.RoomType;
import Generic.IGeneric;

import java.util.List;

public class RoomRepo implements IGeneric<Room> {
    public static List<Room> rooms;

    @Override
    public void add() {

    }

    @Override
    public Room findById(String Keyword) {
        return null;
    }

    public Room getByType(RoomType rp){
        return rooms.stream()
                .filter(r->r.getRoomType().equals(rp))
                .findFirst().orElse(null);
    }

    @Override
    public void delete(Room room) {

    }
}
