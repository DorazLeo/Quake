package it.quake.controller;

import it.quake.model.documental.MainItem;
import it.quake.repository.documental.MainItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("mainItem")
@Controller
public class MainItemController {
    @Autowired
    MainItemRepository mainItemRepository;

    /**
     * Method for get every object from main_item table
     *
     * @return List of main item
     * @throws Exception
     */
    @RequestMapping(value = "/getAllMainItems", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<MainItem> loadMainItems() throws Exception {
        return mainItemRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param mainItem Main ittem
     * @return Main item saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveMainItem", method = RequestMethod.POST, produces = {"application/json"})
    public MainItem saveMainItem(@RequestBody MainItem mainItem) throws Exception {
        return mainItemRepository.save(mainItem);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param mainItem Main item
     * @throws Exception
     */
    @RequestMapping(value = "/deleteMainItem", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteMainItem(@RequestBody MainItem mainItem) throws Exception {
        mainItemRepository.delete(mainItem);
    }

}
