package it.quake.repository;

import it.quake.model.Nation;
import it.quake.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "nation" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of nations
     */
    public List<Order> findAll();

    /**
     * Run query like insert into ...
     *
     * @param order Palette
     * @return Nation saved
     */
    public Order save(Order order);

    /**
     * Run query like Delete from ...
     *
     * @param order Nation to delete
     */
    public void delete(Order order);
}