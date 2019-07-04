package it.quake.repository;

import it.quake.model.MainItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "main_item" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface MainItemRepository extends CrudRepository<MainItem, Long> {

    /**
     * Run query like Select * from...
     * @return List of main item
     */
    public List<MainItem> findAll();

    /**
     * Run query like insert into ...
     * @param mainItem Main item
     * @return Main item saved
     */
    public MainItem save(MainItem mainItem);
}