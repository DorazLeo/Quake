package it.quake.repository;

import it.quake.model.PaletteOrdered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "palette_ordered" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface PaletteOrderedRepository extends CrudRepository<PaletteOrdered, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of ordered palette
     */
    public List<PaletteOrdered> findAll();

    /**
     * Run query like insert into ...
     *
     * @param paletteOrdered Palette ordered
     * @return Ordered palette saved
     */
    public PaletteOrdered save(PaletteOrdered paletteOrdered);

    /**
     * Run query like Delete from ...
     *
     * @param paletteOrdered Oredered palette to delete
     */
    public void delete(PaletteOrdered paletteOrdered);
}