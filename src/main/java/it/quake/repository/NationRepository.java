package it.quake.repository;

import it.quake.model.Nation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "nation" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface NationRepository extends CrudRepository<Nation, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of nations
     */
    public List<Nation> findAll();

    /**
     * Run query like insert into ...
     *
     * @param nation Palette
     * @return Nation saved
     */
    public Nation save(Nation nation);

    /**
     * Run query like Delete from ...
     *
     * @param nation Nation to delete
     */
    public void delete(Nation nation);
}