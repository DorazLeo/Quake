package it.quake.controller;

import it.quake.model.Nation;
import it.quake.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for nations
 * @author Christopher Leofreddi
 */
@RequestMapping("nation")
@Controller
public class NationController {
    @Autowired
    NationRepository nationRepository;

    /**
     * Method for get every object from "nation" table
     *
     * @return List of nations
     * @throws Exception
     */
    @RequestMapping(value = "/getAllNations", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<Nation> loadNations() throws Exception {
        return nationRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param nation Nation
     * @return Nation saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveNations", method = RequestMethod.POST, produces = {"application/json"})
    public Nation saveNation(@RequestBody Nation nation) throws Exception {
        return nationRepository.save(nation);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param nation Nation
     * @throws Exception
     */
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteNation(@RequestBody Nation nation) throws Exception {
        nationRepository.delete(nation);
    }

}
