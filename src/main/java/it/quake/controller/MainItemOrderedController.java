package it.quake.controller;

import it.quake.model.MainItemOrdered;
import it.quake.repository.MainItemOrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for main items ordered
 * @author Christopher Leofreddi
 */
@RequestMapping("mainItemOrdered")
@Controller
public class MainItemOrderedController {
    @Autowired
    MainItemOrderedRepository mainItemOrderedRepository;

    /**
     * Method for get every object from "main_item_ordered" table
     *
     * @return List of main items ordered
     * @throws Exception
     */
    @RequestMapping(value = "/getAllMainItemOrdered", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<MainItemOrdered> loadMainItemsOrdered() throws Exception {
        return mainItemOrderedRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param mainItemOrdered Main item ordered
     * @return Main item ordered saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveMainItemOrdered", method = RequestMethod.POST, produces = {"application/json"})
    public MainItemOrdered saveMainItemOrdered(@RequestBody MainItemOrdered mainItemOrdered) throws Exception {
        return mainItemOrderedRepository.save(mainItemOrdered);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param mainItemOrdered Main item ordered
     * @throws Exception
     */
    @RequestMapping(value = "/deleteMainItemOrdered", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteMainItemOrdered(@RequestBody MainItemOrdered mainItemOrdered) throws Exception {
        mainItemOrderedRepository.delete(mainItemOrdered);
    }

}
