package it.quake.utilities;

import it.quake.model.PaletteOrdered;
import it.quake.repository.documental.PaletteRepository;
import it.quake.repository.documental.PaletteValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class for parse visibility conditions of palette and palette values
 *
 * @author Christopher Leofreddi
 */
public class VisibilityConditionParser {

    @Autowired
    static PaletteRepository paletteRepository;

    @Autowired
    static PaletteValueRepository paletteValueRepository;


    public static final String VISIBLE = "VISIBLE";
    public static final String INVISIBLE = "INVISIBLE";

    /**
     * Method for parse string of visibility or invisibility condition.
     * The string has to be congruent with this pattern "id_palette=value_palette__id_palette2=value_palette2__...".
     * Before the first condition the string can have a "{&&}" for the logic "AND" or "{||}" for the logic "OR"; in this
     * case the string will be like "{&&}1=2__3=4" or "{||}1=2__3=4"; the "OR" operator will be the default operator.
     *
     * @param paletteOrderedList List of palette already ordered by the user
     * @param condition The String condition
     * @return If is parsing for visibility will return true if have to be visible and false if have to be invisible,
     * else if is parsing for invisibility will return true if have to be invisible and false if have to be visible.
     */
    public static boolean parseVisibilityStringForPalette(List<PaletteOrdered> paletteOrderedList, String condition) {
        String logicOperator = condition.substring(1, 3);
        String[] conditions = condition.split("__");
        switch (logicOperator) {
            case "||":
                for(String cond : conditions){
                    int idPalette = Integer.parseInt(cond.split("=")[0]);
                    int idValue = Integer.parseInt(cond.split("=")[0]);
                    for(PaletteOrdered paletteOrdered : paletteOrderedList){
                        if(paletteOrdered.getName().equals(paletteRepository.findPaletteByIdPalette(idPalette).getName())
                                && paletteOrdered.getValue().equals(paletteValueRepository.findByIdPaletteValue(idValue))){
                            return true;
                        }
                    }
                }
                return false;
            case "&&":
                for(String cond : conditions){
                    int idPalette = Integer.parseInt(cond.split("=")[0]);
                    int idValue = Integer.parseInt(cond.split("=")[0]);
                    for(PaletteOrdered paletteOrdered : paletteOrderedList){
                        if(!paletteOrdered.getName().equals(paletteRepository.findPaletteByIdPalette(idPalette).getName())
                                && !paletteOrdered.getValue().equals(paletteValueRepository.findByIdPaletteValue(idValue))){
                            return false;
                        }
                    }
                }
                return true;
        }
        return true;
    }

}
