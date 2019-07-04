package it.quake.model;

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
 * General class for configurable item
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "palette")
public class Palette {

    @Id
    @NotNull
    @Column(name = "id_main_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //Identifier number of palette

    @NotNull
    @Size(max = 45)
    @Column(name = "name")
    private String name; //Name of palette

    @Size(max = 500)
    @Column(name = "visibility_condition")
    private String visibilityCondition; //Visibility condition of palette

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

    /**
     * Default constructor
     */
    public Palette() {
    }

    /**
     * Constructor used to save a new palette without category, visibility condition and main item list
     *
     * @param name Name of palette
     */
    public Palette(@NotNull @Size(max = 45) String name) {
        this.name = name;
    }

    /**
     * Constructor used to save a new palette without category, main item list and palette values
     *
     * @param name                Name of palette
     * @param visibilityCondition Visibility condition of palette
     */
    public Palette(@NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition) {
        this.name = name;
        this.visibilityCondition = visibilityCondition;
    }

    /**
     * Constructor used to save a new palette without visibility condition, main item list, and palette values
     *
     * @param name     Name of palette
     * @param category Category of palette
     */
    public Palette(@NotNull @Size(max = 45) String name, Category category) {
        this.name = name;
        this.category = category;
    }

    /**
     * Constractor used to save a new palette without main item list and palette values
     *
     * @param name                Name of palette
     * @param visibilityCondition Visibility condition of palette
     * @param category            Category of palette
     */
    public Palette(@NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition, Category category) {
        this.name = name;
        this.visibilityCondition = visibilityCondition;
        this.category = category;
    }

    /**
     * Constructor used to save a new palette
     *
     * @param name                Name of palette
     * @param visibilityCondition Visibility condition of palette
     * @param category            Category of palette
     * @param paletteValues       List of palette's values
     * @param mainItems           List of main item with that palette
     */
    public Palette(@NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition, Category category, List<PaletteValue> paletteValues, List<MainItem> mainItems) {
        this.name = name;
        this.visibilityCondition = visibilityCondition;
        this.category = category;
        this.paletteValues = paletteValues;
        this.mainItems = mainItems;
    }

    /**
     * Constructor used to update a palette
     *
     * @param id                  Identifier number of palette
     * @param name                Name of palette
     * @param visibilityCondition Visibility condition of palette
     * @param category            Category of palette
     */
    public Palette(@NotNull int id, @NotNull @Size(max = 45) String name, @Size(max = 500) String visibilityCondition, Category category) {
        this.id = id;
        this.name = name;
        this.visibilityCondition = visibilityCondition;
        this.category = category;
    }



    /*Getters and Setters*/

    /**
     * Getter of palette's identifier number
     *
     * @return Identifier number of palette
     */
    public int getId() {
        return id;
    }

    /**
     * Setter of palette's identifier number
     *
     * @param id Identifier number of palette
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter of palette's name
     *
     * @return Name of palette
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of palette's name
     *
     * @param name Name of palette
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of palette's visibility condition
     *
     * @return Visibility condition of palette
     */
    public String getVisibilityCondition() {
        return visibilityCondition;
    }

    /**
     * Setter of palette's visibility condition
     *
     * @param visibilityCondition Visibility condition of palette
     */
    public void setVisibilityCondition(String visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }

    /**
     * Getter of palette's category
     *
     * @return Category of palette
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setter of palette's category
     *
     * @param category Category of palette
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Getter of palette's values
     * @return Values of palette
     */
    public List<PaletteValue> getPaletteValues() {
        return paletteValues;
    }

    /**
     * Setter of palette's values
     * @param paletteValues Values of palette
     */
    public void setPaletteValues(List<PaletteValue> paletteValues) {
        this.paletteValues = paletteValues;
    }

    /**
     * Getter of list item with the palette
     * @return List of main items
     */
    public List<MainItem> getMainItems() {
        return mainItems;
    }

    /**
     * Setter of list item with the palette
     * @param mainItems List of main items
     */
    public void setMainItems(List<MainItem> mainItems) {
        this.mainItems = mainItems;
    }
}
