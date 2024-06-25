package Repository;

import Entity.Customer;
import Generic.IGeneric;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepo implements IGeneric<Customer>{
    public static List<Customer> customers;

    @Override
    public void add() {

    }

    @Override
    public Customer findById(String Keyword) {
        return customers.stream()
                .filter(c -> c.getId().equals(Keyword))
                .findFirst()
                .orElse(null);
    }


    @Override
    public void delete(Customer customer) {

    }

}
