package it.quake.controller;

import it.quake.model.Role;
import it.quake.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for roles
 *
 * @author Christopher Leofreddi
 */
@RequestMapping("role")
@Controller
public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    /**
     * Method for get every object from "role" table
     *
     * @return List of roles
     * @throws Exception
     */
    @RequestMapping(value = "/getAllRoles", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<Role> loadRoles() throws Exception {
        return roleRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param role Role
     * @return Role saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveRole", method = RequestMethod.POST, produces = {"application/json"})
    public Role saveRole(@RequestBody Role role) throws Exception {
        return roleRepository.save(role);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param role Role
     * @throws Exception
     */
    @RequestMapping(value = "/deleteRole", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteRole(@RequestBody Role role) throws Exception {
        roleRepository.delete(role);
    }

}
