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

    public MainItem() {
    }

    public MainItem(@NotNull @Size(max = 70) String name, Category category, List<Palette> palettes) {
        this.name = name;
        this.category = category;
        this.palettes = palettes;
    }

    public MainItem(@NotNull Integer idMainItem, @NotNull @Size(max = 70) String name, Category category, List<Palette> palettes) {
        this.idMainItem = idMainItem;
        this.name = name;
        this.category = category;
        this.palettes = palettes;
    }

    /* Getters and Setters*/

    public Integer getIdMainItem() {
        return idMainItem;
    }

    public void setIdMainItem(Integer idMainItem) {
        this.idMainItem = idMainItem;
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

    public List<Palette> getPalettes() {
        return palettes;
    }

    public void setPalettes(List<Palette> palettes) {
        this.palettes = palettes;
    }
}
