package it.quake.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * General class for define categorys of configurable items
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @NotNull
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //Identifier number of category

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name; //Name of category

    /*Constructors*/

    /**
     * Default constructor
     */
    public Category() {
    }

    /**
     * Constructor used to save one category
     *
     * @param name Name of category
     */
    public Category(@NotNull @Size(max = 100) String name) {
        this.name = name;
    }

    /**
     * Constructor used to update one category
     *
     * @param id   Identifier number of category
     * @param name Name of category
     */
    public Category(@NotNull int id, @NotNull @Size(max = 100) String name) {
        this.id = id;
        this.name = name;
    }

    /*Getters and Setters*/

    /**
     * Getter for the identifier number of category
     *
     * @return Identifier number of category
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the identifier number of category
     *
     * @param id Identifier number of category
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the name of category
     *
     * @return Name of category
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of category
     *
     * @param name Name of category
     */
    public void setName(String name) {
        this.name = name;
    }
}
