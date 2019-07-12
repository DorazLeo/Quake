package it.quake.repository;

import it.quake.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface for run query on "address" table
 *
 * @author Christopher Leofreddi
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    /**
     * Run query like Select * from...
     *
     * @return List of address
     */
    public List<Address> findAll();

    /**
     * Run query like insert into ...
     *
     * @param address Palette
     * @return Address saved
     */
    public Address save(Address address);

    /**
     * Run query like Delete from ...
     *
     * @param address Address to delete
     */
    public void delete(Address address);
}