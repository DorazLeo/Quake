package it.quake.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of main item orderd from user
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "main_item_ordered")
public class MainItemOrdered {

    @Id
    @Column(name = "id_main_item_ordered")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItemOrdered; //Identifier number of main item ordered

    @Size(max = 70)
    @NotNull
    @Column(name = "name")
    private String name; //Name

    @Size(max = 1000)
    @NotNull
    @Column(name = "category")
    private String category; //Category

    @ManyToMany
    @JoinTable(
            name = "main_item_ordered_palette_ordered",
            joinColumns = @JoinColumn(name = "id_main_item_ordered"),
            inverseJoinColumns = @JoinColumn(name = "id_palette_ordered"))
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PaletteOrdered> paletteOrdereds = new ArrayList<>(); //List of main item's palettes ordered from user

    /*Constructor*/

    public MainItemOrdered() {
    }

    public MainItemOrdered(@Size(max = 70) @NotNull String name, @Size(max = 1000) @NotNull String category, List<PaletteOrdered> paletteOrdereds) {
        this.name = name;
        this.category = category;
        this.paletteOrdereds = paletteOrdereds;
    }

    public MainItemOrdered(@NotNull Integer idItemOrdered, @Size(max = 70) @NotNull String name, @Size(max = 1000) @NotNull String category, List<PaletteOrdered> paletteOrdereds) {
        this.idItemOrdered = idItemOrdered;
        this.name = name;
        this.category = category;
        this.paletteOrdereds = paletteOrdereds;
    }

    public Integer getIdItemOrdered() {
        return idItemOrdered;
    }

    public void setIdItemOrdered(Integer idItemOrdered) {
        this.idItemOrdered = idItemOrdered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<PaletteOrdered> getPaletteOrdereds() {
        return paletteOrdereds;
    }

    public void setPaletteOrdereds(List<PaletteOrdered> paletteOrdereds) {
        this.paletteOrdereds = paletteOrdereds;
    }
}
