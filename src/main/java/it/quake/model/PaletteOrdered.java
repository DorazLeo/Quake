package it.quake.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of palette ordered include in the item
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "palette_ordered")
public class PaletteOrdered {

    @Id
    @Column(name = "id_palette_ordered")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPaletteOrdered; //Identifier number of palette ordered

    @Size(max = 45)
    @NotNull
    @Column(name = "name")
    private String name; //Name of the palette

    @Size(max = 100)
    @NotNull
    @Column(name = "value")
    private String value; //Value of the palette

    @Size(max = 25)
    @Column(name = "commercial_code")
    private String commercialCode; //Commercial code generated

    @Column(name = "price")
    private Double price; //Price of the palette

    @Size(max = 100)
    @Column(name = "image_path")
    private String imagePath; //Image path of the palette

    @ManyToMany(mappedBy = "paletteOrdereds")
    @JsonBackReference
    private List<MainItemOrdered> mainItemOrdereds = new ArrayList<>(); //Every main items orderd that have a this palette

    /*Constructor*/
    public PaletteOrdered() {
    }

    public PaletteOrdered(@Size(max = 45) @NotNull String name, @Size(max = 100) @NotNull String value, @Size(max = 25) String commercialCode, Double price, @Size(max = 100) String imagePath, List<MainItemOrdered> mainItemOrdereds) {
        this.name = name;
        this.value = value;
        this.commercialCode = commercialCode;
        this.price = price;
        this.imagePath = imagePath;
        this.mainItemOrdereds = mainItemOrdereds;
    }

    public PaletteOrdered(@NotNull Integer idPaletteOrdered, @Size(max = 45) @NotNull String name, @Size(max = 100) @NotNull String value, @Size(max = 25) String commercialCode, Double price, @Size(max = 100) String imagePath, List<MainItemOrdered> mainItemOrdereds) {
        this.idPaletteOrdered = idPaletteOrdered;
        this.name = name;
        this.value = value;
        this.commercialCode = commercialCode;
        this.price = price;
        this.imagePath = imagePath;
        this.mainItemOrdereds = mainItemOrdereds;
    }

    /*Getters and Setters*/
    public Integer getIdPaletteOrdered() {
        return idPaletteOrdered;
    }

    public void setIdPaletteOrdered(Integer idPaletteOrdered) {
        this.idPaletteOrdered = idPaletteOrdered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<MainItemOrdered> getMainItemOrdereds() {
        return mainItemOrdereds;
    }

    public void setMainItemOrdereds(List<MainItemOrdered> mainItemOrdereds) {
        this.mainItemOrdereds = mainItemOrdereds;
    }
}
