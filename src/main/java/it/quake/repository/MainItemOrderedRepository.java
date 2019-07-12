package it.quake.repository;

import it.quake.model.MainItemOrdered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "main_item_ordered" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface MainItemOrderedRepository extends CrudRepository<MainItemOrdered, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of ordered main item
     */
    public List<MainItemOrdered> findAll();

    /**
     * Run query like insert into ...
     *
     * @param mainItemOrdered Main item ordered
     * @return Ordered main item saved
     */
    public MainItemOrdered save(MainItemOrdered mainItemOrdered);

    /**
     * Run query like Delete from ...
     *
     * @param mainItemOrdered Oredered main item to delete
     */
    public void delete(MainItemOrdered mainItemOrdered);
}