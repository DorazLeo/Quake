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

    @Column(name = "price")
    private Double price; //Price of palette value

    @ManyToMany
    @JoinTable(
            name = "palette_value_palette_value_disabled",
            joinColumns = @JoinColumn(name = "id_palette_value"),
            inverseJoinColumns = @JoinColumn(name = "id_palette_value_disabled"))
    private List<Palette> paletteValuesDisabled = new ArrayList<>(); //List of palette values disabled when a palette value will be choosen

    @ManyToMany(mappedBy = "paletteValues")
    @JsonBackReference
    private List<Palette> palettes = new ArrayList<>(); //palette's list of palette values



    /*Constructors*/

    public PaletteValue() {
    }

    public PaletteValue(@NotNull @Size(max = 100) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, Double price, List<Palette> paletteValuesDisabled, List<Palette> palettes) {
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.price = price;
        this.paletteValuesDisabled = paletteValuesDisabled;
        this.palettes = palettes;
    }

    public PaletteValue(Integer idPaletteValue, @NotNull @Size(max = 100) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, Double price, List<Palette> paletteValuesDisabled, List<Palette> palettes) {
        this.idPaletteValue = idPaletteValue;
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.price = price;
        this.paletteValuesDisabled = paletteValuesDisabled;
        this.palettes = palettes;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Palette> getPaletteValuesDisabled() {
        return paletteValuesDisabled;
    }

    public void setPaletteValuesDisabled(List<Palette> paletteValuesDisabled) {
        this.paletteValuesDisabled = paletteValuesDisabled;
    }

    public List<Palette> getPalettes() {
        return palettes;
    }

    public void setPalettes(List<Palette> palettes) {
        this.palettes = palettes;
    }
}
