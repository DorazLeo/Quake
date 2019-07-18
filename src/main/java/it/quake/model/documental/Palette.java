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

    @Size(max = 500)
    @Column(name = "visibility_condition")
    private String visibilityCondition; //Visibility condition is a pattern string containing one or more condition for make visible the palette

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

    /*Constructor*/

    public Palette() {
    }

    public Palette(@NotNull @Size(max = 45) String name) {
        this.name = name;
    }

    public Palette(@NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition) {
        this.name = name;
        this.visibilityCondition = visibilityCondition;
    }

    public Palette(@NotNull @Size(max = 45) String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Palette(@NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition, Category category) {
        this.name = name;
        this.visibilityCondition = visibilityCondition;
        this.category = category;
    }

    public Palette(@NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition, Category category, List<PaletteValue> paletteValues, List<MainItem> mainItems) {
        this.name = name;
        this.visibilityCondition = visibilityCondition;
        this.category = category;
        this.paletteValues = paletteValues;
        this.mainItems = mainItems;
    }

    public Palette(@NotNull Integer idPalette, @NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition, Category category) {
        this.idPalette = idPalette;
        this.name = name;
        this.visibilityCondition = visibilityCondition;
        this.category = category;
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

    public String getVisibilityCondition() {
        return visibilityCondition;
    }

    public void setVisibilityCondition(String visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
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
}
