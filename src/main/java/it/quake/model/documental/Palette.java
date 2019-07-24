package it.quake.model.documental;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * General class for item's palette
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "palette")
public class Palette {

    @Id
    @Column(name = "id_palette")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPalette; //Identifier number of palette

    @NotNull
    @Size(max = 45)
    @Column(name = "name")
    private String name; //Name of palette

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category; //Category of palette

    @ManyToMany
    @JoinTable(
            name = "palette_palette_value",
            joinColumns = @JoinColumn(name = "id_palette"),
            inverseJoinColumns = @JoinColumn(name = "id_palette_value"))
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PaletteValue> paletteValues = new ArrayList<>(); //List of palette for the main item

    @ManyToMany(mappedBy = "palettes")
    @JsonBackReference
    private List<MainItem> mainItems = new ArrayList<>(); //List of main item with that palette

    @ManyToMany
    @JoinTable(
            name = "palette_palette_disabled",
            joinColumns = @JoinColumn(name = "id_palette"),
            inverseJoinColumns = @JoinColumn(name = "id_palette_disabled"))
    @JsonBackReference
    private List<Palette> palettesDisabled = new ArrayList<>(); //List of palette disactivated when a palette will be choosen

    /*Constructor*/

    public Palette() {
    }

    public Palette(@NotNull @Size(max = 45) String name, Category category, List<PaletteValue> paletteValues, List<MainItem> mainItems, List<Palette> palettesDisabled) {
        this.name = name;
        this.category = category;
        this.paletteValues = paletteValues;
        this.mainItems = mainItems;
        this.palettesDisabled = palettesDisabled;
    }

    public Palette(Integer idPalette, @NotNull @Size(max = 45) String name,Category category, List<PaletteValue> paletteValues, List<MainItem> mainItems, List<Palette> palettesDisabled) {
        this.idPalette = idPalette;
        this.name = name;
        this.category = category;
        this.paletteValues = paletteValues;
        this.mainItems = mainItems;
        this.palettesDisabled = palettesDisabled;
    }

    /*Getters and Setters*/

    public Integer getIdPalette() {
        return idPalette;
    }

    public void setIdPalette(Integer idPalette) {
        this.idPalette = idPalette;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<PaletteValue> getPaletteValues() {
        return paletteValues;
    }

    public void setPaletteValues(List<PaletteValue> paletteValues) {
        this.paletteValues = paletteValues;
    }

    public List<MainItem> getMainItems() {
        return mainItems;
    }

    public void setMainItems(List<MainItem> mainItems) {
        this.mainItems = mainItems;
    }

    public List<Palette> getPalettesDisabled() {
        return palettesDisabled;
    }

    public void setPalettesDisabled(List<Palette> palettesDisabled) {
        this.palettesDisabled = palettesDisabled;
    }
}
