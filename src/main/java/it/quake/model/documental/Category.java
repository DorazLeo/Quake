package it.quake.model.documental;

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
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCategory; //Identifier number of category

    @NotNull
    @Size(max = 1000)
    @Column(name = "name")
    private String name; //Name of category

    @Column(name = "parent_id")
    private Integer parentId; //Identifier number of category's parent

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
    public Category(@NotNull @Size(max = 1000) String name) {
        this.name = name;
    }

    /**
     * Constructor used to update one category
     *
     * @param idCategory Identifier number of category
     * @param name       Name of category
     */
    public Category(@NotNull Integer idCategory, @NotNull @Size(max = 1000) String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    /*Getters and Setters*/

    /**
     * Getter for the identifier number of category
     *
     * @return Identifier number of category
     */
    public Integer getIdCategory() {
        return idCategory;
    }

    /**
     * Setter for the identifier number of category
     *
     * @param idCategory Identifier number of category
     */
    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
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

    /**
     * Getter of category's parent identifier number
     *
     * @return Category's parent identifier number
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * Setter of category's parent identifier number
     *
     * @param parentId Category's parent identifier number
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
