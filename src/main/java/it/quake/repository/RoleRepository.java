package it.quake.repository;

import it.quake.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "role" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of Roles
     */
    public List<Role> findAll();

    /**
     * Run query like insert into ...
     *
     * @param role User
     * @return Role saved
     */
    public Role save(Role role);

    /**
     * Run query like Delete from ...
     *
     * @param role Role to delete
     */
    public void delete(Role role);
}