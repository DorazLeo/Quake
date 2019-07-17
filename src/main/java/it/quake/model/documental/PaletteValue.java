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

    @Column(name = "price")
    private Double price; //Price of palette value

    @ManyToMany(mappedBy = "paletteValues")
    @JsonBackReference
    private List<Palette> palettes = new ArrayList<>(); //palette's list of palette values

    /*Constructors*/

    /**
     * Default constructor
     */
    public PaletteValue() {
    }

    /**
     * Constructor used to save a new palette's value
     *
     * @param value               Value of palette value
     * @param commercialCode      Commercial code generated for palette value
     * @param imagePath           Immage path for palette value
     * @param visibilityCondition Visibility condition of palette's value
     * @param price               Price of palette value
     */
    public PaletteValue(@NotNull @Size(max = 100) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, @Size(max = 500) String visibilityCondition, Double price) {
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.visibilityCondition = visibilityCondition;
        this.price = price;
    }

    /**
     * Constructor used to update a palette's value
     *
     * @param idPaletteValue      Identifier number of palette value
     * @param value               Value of palette value
     * @param commercialCode      Commercial code generated for palette value
     * @param imagePath           Immage path for palette value
     * @param visibilityCondition Visibility condition of palette's value
     * @param price               Price of palette value
     */
    public PaletteValue(@NotNull Integer idPaletteValue, @NotNull @Size(max = 100) String value, @Size(max = 25) String commercialCode, @Size(max = 100) String imagePath, @Size(max = 500) String visibilityCondition, Double price) {
        this.idPaletteValue = idPaletteValue;
        this.value = value;
        this.commercialCode = commercialCode;
        this.imagePath = imagePath;
        this.visibilityCondition = visibilityCondition;
        this.price = price;
    }

    /*Getters and Setters*/

    /**
     * Getters of palette's value identifier number
     *
     * @return Identifier number of palette value
     */
    public Integer getIdPaletteValue() {
        return idPaletteValue;
    }

    /**
     * Setters of palette's value identifier number
     *
     * @param idPaletteValue Identifier number of palette value
     */
    public void setIdPaletteValue(Integer idPaletteValue) {
        this.idPaletteValue = idPaletteValue;
    }

    /**
     * Getters of palette value's value
     *
     * @return Value of palette value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setters of palette value's value
     *
     * @param value Value of palette value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Getter of palette value's commercial code
     *
     * @return Commercial code of palette value
     */
    public String getCommercialCode() {
        return commercialCode;
    }

    /**
     * Setter of palette value's commercial code
     *
     * @param commercialCode Commercial code of palette value
     */
    public void setCommercialCode(String commercialCode) {
        this.commercialCode = commercialCode;
    }

    /**
     * Getter of palette value's image path
     *
     * @return Image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Setter of palette value's image path
     *
     * @param imagePath Image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Getter of palette value's visibility condition
     *
     * @return Visibility condition
     */
    public String getVisibilityCondition() {
        return visibilityCondition;
    }

    /**
     * Setter of palette value's visibility condition
     *
     * @param visibilityCondition Visibility condition
     */
    public void setVisibilityCondition(String visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }

    /**
     * Getter of palette value's price
     *
     * @return Price of palette value
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter of palette value's price
     *
     * @param price Price of palette value
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Getter of palette's list containing an instance of palette value
     *
     * @return List of palette containing an instance of palette value
     */
    public List<Palette> getPalettes() {
        return palettes;
    }

    /**
     * Setter of palette's list containing an instance of palette value
     *
     * @param palettes List of palette containing an instance of palette value
     */
    public void setPalettes(List<Palette> palettes) {
        this.palettes = palettes;
    }
}
