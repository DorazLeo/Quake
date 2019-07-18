package it.quake.controller;

import it.quake.model.Address;
import it.quake.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for addresses
 * @author Christopher Leofreddi
 */
@RequestMapping("address")
@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    /**
     * Method for get every object from "address" table
     *
     * @return List of addresses
     * @throws Exception
     */
    @RequestMapping(value = "/getAllAddresses", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<Address> loadAddresses() throws Exception {
        return addressRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param address Address
     * @return Address saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveAddress", method = RequestMethod.POST, produces = {"application/json"})
    public Address saveAddress(@RequestBody Address address) throws Exception {
        return addressRepository.save(address);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param address Address
     * @throws Exception
     */
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteAddress(@RequestBody Address address) throws Exception {
        addressRepository.delete(address);
    }

}
