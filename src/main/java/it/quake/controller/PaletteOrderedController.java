package it.quake.controller;

import it.quake.model.PaletteOrdered;
import it.quake.repository.PaletteOrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for palette ordered
 *
 * @author Christopher Leofreddi
 */
@RequestMapping("paletteOrdered")
@Controller
public class PaletteOrderedController {

    @Autowired
    PaletteOrderedRepository paletteOrderedRepository;

    /**
     * Method for get every object from "palette_ordered" table
     *
     * @return List of palettes ordered
     * @throws Exception
     */
    @RequestMapping(value = "/getAllPalettesOrdered", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<PaletteOrdered> loadPalettesOrdered() throws Exception {
        return paletteOrderedRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param paletteOrdered Palette ordered
     * @return Palette ordered saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST, produces = {"application/json"})
    public PaletteOrdered savePaletteOrdered(@RequestBody PaletteOrdered paletteOrdered) throws Exception {
        return paletteOrderedRepository.save(paletteOrdered);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param paletteOrdered Palette ordered
     * @throws Exception
     */
    @RequestMapping(value = "/deletePaletteOrdered", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deletePaletteOrdered(@RequestBody PaletteOrdered paletteOrdered) throws Exception {
        paletteOrderedRepository.delete(paletteOrdered);
    }

}
