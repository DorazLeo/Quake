package it.quake.model.documental;

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
@Table(name = "main_item")
public class MainItem {

    @Id
    @Column(name = "id_main_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMainItem; //Identifier number of main item

    @NotNull
    @Size(max = 70)
    @Column(name = "name")
    private String name; //Name of main item

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category; //Category of main item

    @ManyToMany
    @JoinTable(
            name = "main_item_palette",
            joinColumns = @JoinColumn(name = "id_main_item"),
            inverseJoinColumns = @JoinColumn(name = "id_palette"))
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Palette> palettes = new ArrayList<>(); //List of palette for the main item

    /* Constructors */

    /**
     * Default constructor
     */
    public MainItem() {
    }

    /**
     * Constructor used to save one main item
     *
     * @param name     Name of main item
     * @param category Category of main item
     * @param palettes List of palette for the main item
     */
    public MainItem(@NotNull @Size(max = 70) String name, Category category, List<Palette> palettes) {
        this.name = name;
        this.category = category;
        this.palettes = palettes;
    }

    /**
     * Constructor used to update one main item
     *
     * @param idMainItem Identifier number of main item
     * @param name       Name of main item
     * @param category   Category of main item
     * @param palettes   List of palette for the main item
     */
    public MainItem(@NotNull Integer idMainItem, @NotNull @Size(max = 70) String name, Category category, List<Palette> palettes) {
        this.idMainItem = idMainItem;
        this.name = name;
        this.category = category;
        this.palettes = palettes;
    }

    /* Getters and Setters*/

    /**
     * Getter for the identifier number of main item
     *
     * @return Identifier number of main item
     */
    public Integer getIdMainItem() {
        return idMainItem;
    }

    /**
     * Setter for the identifier number of main item
     *
     * @param idMainItem Identifier number of main item
     */
    public void setIdMainItem(Integer idMainItem) {
        this.idMainItem = idMainItem;
    }

    /**
     * Getter for the name of main item
     *
     * @return Name of main item
     */
    public String getName() {
        return name;
    }


    /**
     * Setter for the name of main item
     *
     * @param name Name of main item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the category of main item
     *
     * @return Category of main item
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setter for the category of main item
     *
     * @param category Category of main item
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Getter for the palettes's list of the main item
     *
     * @return List of palette for the main item
     */
    public List<Palette> getPalettes() {
        return palettes;
    }

    /**
     * Setter for the palettes's list of the main item
     *
     * @param palettes List of palette for the main item
     */
    public void setPalettes(List<Palette> palettes) {
        this.palettes = palettes;
    }
}
