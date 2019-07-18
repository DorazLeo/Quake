package it.quake.controller;

import it.quake.model.User;
import it.quake.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for users
 *
 * @author Christopher Leofreddi
 */
@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    /**
     * Method for get every object from "user" table
     *
     * @return List of roles
     * @throws Exception
     */
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<User> loadUsers() throws Exception {
        return userRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param user User
     * @return User saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = {"application/json"})
    public User saveUser(@RequestBody User user) throws Exception {
        return userRepository.save(user);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param user User
     * @throws Exception
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteUser(@RequestBody User user) throws Exception {
        userRepository.delete(user);
    }

}
