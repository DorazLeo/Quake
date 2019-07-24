package it.quake.utilities;

import it.quake.model.MainItemOrdered;
import it.quake.model.PaletteOrdered;
import it.quake.model.documental.Category;
import it.quake.model.documental.Palette;
import it.quake.repository.PaletteOrderedRepository;
import it.quake.repository.documental.PaletteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Class for parse visibility conditions of palette and palette values
 *
 * @author Christopher Leofreddi
 */
public class VisibilityConditionParser {

    @Autowired
    static PaletteOrderedRepository paletteOrderedRepository;

    @Autowired
    static PaletteRepository paletteRepository;

    public static final String VISIBLE = "VISIBLE";
    public static final String INVISIBLE = "INVISIBLE";

    /**
     * Method for parse string of visibility or invisibility condition.
     * The string has to be congruent with this pattern "id_palette=value_palette__id_palette2=value_palette2__...".
     * Before the first condition the string can have a "{&&}" for the logic "AND" or "{||}" for the logic "OR"; in this
     * case the string will be like "{&&}idPalette=idValue__"; the "OR" operator will be the default operator.
     *
     * @param mainItemOrdered Main item already ordered by the user
     * @param category the category
     * @return If is parsing for visibility will return true if have to be visible and false if have to be invisible,
     * else if is parsing for invisibility will return true if have to be invisible and false if have to be visible.
     */
    public static List<Palette> parseVisibilityStringForPalette(MainItemOrdered mainItemOrdered, Category category) {

        List<Palette> palettesCategory = paletteRepository.findByCategory(category);
//        for(PaletteOrdered paletteOrdered : mainItemOrdered.getPaletteOrdereds()){
//            for(Palette paletteCategory : palettesCategory){
//                if(paletteCategory.getIdPalette().equals())
//            }
//        }

        return null;
    }

}
