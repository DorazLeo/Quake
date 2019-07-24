package it.quake.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.quake.model.documental.Palette;
import it.quake.model.documental.PaletteValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of palette ordered include in the item
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "palette_ordered")
public class PaletteOrdered {

    @Id
    @Column(name = "id_palette_ordered")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaletteOrdered; //Identifier number of palette ordered

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_palette", nullable = false)
    private Palette palette;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_palette_value", nullable = false)
    private PaletteValue paletteValue;

    @ManyToMany(mappedBy = "paletteOrdereds")
    @JsonBackReference
    private List<MainItemOrdered> mainItemOrdereds = new ArrayList<>(); //Every main items orderd that have a this palette

    /*Constructor*/
    public PaletteOrdered() {
    }

    public PaletteOrdered(Palette palette, PaletteValue paletteValue, List<MainItemOrdered> mainItemOrdereds) {
        this.palette = palette;
        this.paletteValue = paletteValue;
        this.mainItemOrdereds = mainItemOrdereds;
    }

    public PaletteOrdered(Integer idPaletteOrdered, Palette palette, PaletteValue paletteValue, List<MainItemOrdered> mainItemOrdereds) {
        this.idPaletteOrdered = idPaletteOrdered;
        this.palette = palette;
        this.paletteValue = paletteValue;
        this.mainItemOrdereds = mainItemOrdereds;
    }

    /*Getters and Setters*/

    public Integer getIdPaletteOrdered() {
        return idPaletteOrdered;
    }

    public void setIdPaletteOrdered(Integer idPaletteOrdered) {
        this.idPaletteOrdered = idPaletteOrdered;
    }

    public Palette getPalette() {
        return palette;
    }

    public void setPalette(Palette palette) {
        this.palette = palette;
    }

    public PaletteValue getPaletteValue() {
        return paletteValue;
    }

    public void setPaletteValue(PaletteValue paletteValue) {
        this.paletteValue = paletteValue;
    }

    public List<MainItemOrdered> getMainItemOrdereds() {
        return mainItemOrdereds;
    }

    public void setMainItemOrdereds(List<MainItemOrdered> mainItemOrdereds) {
        this.mainItemOrdereds = mainItemOrdereds;
    }
}
