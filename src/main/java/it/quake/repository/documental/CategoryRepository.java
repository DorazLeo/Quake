package it.quake.repository.documental;

import it.quake.model.documental.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "category" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of category
     */
    public List<Category> findAll();

    /**
     * Run query like Insert into ...
     *
     * @param category Category
     * @return Category saved
     */
    public Category save(Category category);

    /**
     * Run query like Delete from ...
     *
     * @param category Category
     */
    public void delete(Category category);


}