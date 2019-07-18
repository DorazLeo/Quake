package it.quake.controller.documental;

import it.quake.model.documental.Palette;
import it.quake.repository.documental.PaletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for palettes
 * @author Christopher Leofreddi
 */
@RequestMapping("palette")
@Controller
public class PaletteController {
    @Autowired
    PaletteRepository paletteRepository;

    /**
     * Method for get every object from "palette" table
     *
     * @return List of palettes
     * @throws Exception
     */
    @RequestMapping(value = "/getAllPalettes", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<Palette> loadPalettes() throws Exception {
        return paletteRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param palette Palette
     * @return Palette saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/savePalette", method = RequestMethod.POST, produces = {"application/json"})
    public Palette savePalette(@RequestBody Palette palette) throws Exception {
        return paletteRepository.save(palette);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param palette Palette
     * @throws Exception
     */
    @RequestMapping(value = "/deletePalette", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deletePalette(@RequestBody Palette palette) throws Exception {
        paletteRepository.delete(palette);
    }

}
