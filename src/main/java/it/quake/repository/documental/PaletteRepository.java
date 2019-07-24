package it.quake.repository.documental;

import it.quake.model.documental.Category;
import it.quake.model.documental.Palette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "palette" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface PaletteRepository extends CrudRepository<Palette, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of palette
     */
    public List<Palette> findAll();

    /**
     * Run query like insert into ...
     *
     * @param palette Palette
     * @return Palette saved
     */
    public Palette save(Palette palette);

    /**
     * Run query like Delete from ...
     *
     * @param palette Palette
     */
    public void delete(Palette palette);

    /**
     * Run query like Select * from...where id = ...
     *
     * @param idPalette Palette's identifier number
     * @return Palette
     */
    public Palette findPaletteByIdPalette(int idPalette);

    /**
     *
     * @param category
     * @return
     */
    public List<Palette> findByCategory(Category category);
}