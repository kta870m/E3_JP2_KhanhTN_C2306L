package Generic;

import Entity.Booking;

import java.util.List;

public interface IGeneric<T> {
    void add();
    T findById(String Keyword);
    void delete(T t);
}
