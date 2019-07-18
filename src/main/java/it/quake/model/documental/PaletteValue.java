package it.quake.model.documental;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * General class for palette's values
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "palette_value")
public class PaletteValue {

    @Id
    @Column(name = "id_palette_value")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaletteValue; //Identifier number of palette value

    @NotNull
    @Size(max = 100)
    @Column(name = "value")
    private String value; // Value of palette value

    @Size(max = 25)
    @Column(name = "commercial_code")
    private String commercialCode; //Commercial code generated for palette value

    @Size(max = 100)
    @Column(name = "image_path")
    private String imagePath; //Immage path for palette value

    @Size(max = 500)
    @Column(name = "visibility_condition")
    private String visibilityCondition; //Visibility condition is a pattern string containing one or more condition for make visible the palette's value

    @Size(max = 500)
    @Column(name = "unvisibility_condition")
    private String unvisibilityCondition; //Unvisibility condition is a pattern string containing one or more condition for make visible the palette's value

    @Column(name = "price")
    private Double price; //Price of palette value

    @ManyToMany(mappedBy = "paletteValues")
    @JsonBackReference
    private List<Palette> palettes = new ArrayList<>(); //palette's list of palette values

    /*Constructors*/

    public PaletteValue() {
    }

    public PaletteValue(@NotNull @Size(max = 100) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, @Size(max = 500) String visibilityCondition, @Size(max = 500) String unvisibilityCondition, Double price) {
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.visibilityCondition = visibilityCondition;
        this.unvisibilityCondition = unvisibilityCondition;
        this.price = price;
    }

    public PaletteValue(@NotNull Integer idPaletteValue, @NotNull @Size(max = 100) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, @Size(max = 500) String visibilityCondition, @Size(max = 500) String unvisibilityCondition, Double price) {
        this.idPaletteValue = idPaletteValue;
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.visibilityCondition = visibilityCondition;
        this.unvisibilityCondition = unvisibilityCondition;
        this.price = price;
    }

    /*Getters and Setters*/

    public Integer getIdPaletteValue() {
        return idPaletteValue;
    }

    public void setIdPaletteValue(Integer idPaletteValue) {
        this.idPaletteValue = idPaletteValue;
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

    public String getUnvisibilityCondition() {
        return unvisibilityCondition;
    }

    public void setUnvisibilityCondition(String unvisibilityCondition) {
        this.unvisibilityCondition = unvisibilityCondition;
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
