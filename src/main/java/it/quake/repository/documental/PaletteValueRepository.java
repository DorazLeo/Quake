package it.quake.repository.documental;

import it.quake.model.documental.PaletteValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "palette_value" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface PaletteValueRepository extends CrudRepository<PaletteValue, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of palette's values
     */
    public List<PaletteValue> findAll();

    /**
     * Run query like insert into ...
     *
     * @param paletteValue Value of palette
     * @return Palette's value saved
     */
    public PaletteValue save(PaletteValue paletteValue);

    /**
     * Run query like Delete from ...
     *
     * @param paletteValue Palette value
     */
    public void delete(PaletteValue paletteValue);
}