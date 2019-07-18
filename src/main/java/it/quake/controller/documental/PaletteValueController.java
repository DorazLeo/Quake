package it.quake.controller.documental;

import it.quake.model.documental.PaletteValue;
import it.quake.repository.documental.PaletteValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for palette values
 * @author Christopher Leofreddi
 */
@RequestMapping("paletteValue")
@Controller
public class PaletteValueController {
    @Autowired
    PaletteValueRepository paletteValueRepository;

    /**
     * Method for get every object from "palette_value" table
     *
     * @return List of palette value
     * @throws Exception
     */
    @RequestMapping(value = "/getAllPaletteValues", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<PaletteValue> loadPaletteValues() throws Exception {
        return paletteValueRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param paletteValue Palette value
     * @return Palette value saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/savePaletteValue", method = RequestMethod.POST, produces = {"application/json"})
    public PaletteValue savePaletteValue(@RequestBody PaletteValue paletteValue) throws Exception {
        return paletteValueRepository.save(paletteValue);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param paletteValue Palette value
     * @throws Exception
     */
    @RequestMapping(value = "/deletePaletteValue", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deletePaletteValue(@RequestBody PaletteValue paletteValue) throws Exception {
        paletteValueRepository.delete(paletteValue);
    }

}
