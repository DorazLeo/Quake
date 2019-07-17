package it.quake.repository;

import it.quake.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "user" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of Users
     */
    public List<User> findAll();

    /**
     * Run query like insert into ...
     *
     * @param user User
     * @return User saved
     */
    public User save(User user);

    /**
     * Run query like Delete from ...
     *
     * @param user User to delete
     */
    public void delete(User user);
}