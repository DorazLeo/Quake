package it.quake.controller;

import it.quake.model.MainItem;
import it.quake.repository.MainItemRepository;
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

    @RequestMapping(value = "/getAllMainItems", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<MainItem> loadMainItems() throws Exception {
        return mainItemRepository.findAll();
    }

    @RequestMapping(value = "/saveMainItem", method = RequestMethod.POST, produces = {"application/json"})
    public MainItem saveMainItem(@RequestBody MainItem mainItem) throws Exception {
        return mainItemRepository.save(mainItem);
    }
}
