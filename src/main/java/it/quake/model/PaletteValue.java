package it.quake.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "palette_value")
public class PaletteValue {

    @Id
    @NotNull
    @Column(name = "id_main_item")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //Identifier number of palette value

    @NotNull
    @Size(max = 45)
    @Column(name = "name")
    private String value; // Value of palette value

    @Size(max = 25)
    @Column(name = "commercial_code")
    private String commercialCode; //Commercial code generated for palette value

    @Size(max = 100)
    @Column(name = "image_path")
    private String imagePath; //Immage path for palette value

    @Size(max = 500)
    @Column(name = "visibility_condition")
    private String visibilityCondition;

    @Column(name = "price")
    private Double price; //Price of palette value

    @ManyToMany(mappedBy = "paletteValues")
    @JsonBackReference
    private List<Palette> palettes = new ArrayList<>(); //palette's list of palette values

    public PaletteValue() {
    }

    public PaletteValue(@NotNull @Size(max = 45) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, @Size(max = 500) String visibilityCondition, Double price, List<Palette> palettes) {
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.visibilityCondition = visibilityCondition;
        this.price = price;
        this.palettes = palettes;
    }

    public PaletteValue(@NotNull int id, @NotNull @Size(max = 45) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, @Size(max = 500) String visibilityCondition, Double price, List<Palette> palettes) {
        this.id = id;
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.visibilityCondition = visibilityCondition;
        this.price = price;
        this.palettes = palettes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCommercialCode() {
        return commercialCode;
    }

    public void setCommercialCode(String commercialCode) {
        this.commercialCode = commercialCode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getVisibilityCondition() {
        return visibilityCondition;
    }

    public void setVisibilityCondition(String visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Palette> getPalettes() {
        return palettes;
    }

    public void setPalettes(List<Palette> palettes) {
        this.palettes = palettes;
    }
}
