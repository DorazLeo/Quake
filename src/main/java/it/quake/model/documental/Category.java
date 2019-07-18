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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_parent", nullable = false)
    private Category parent; //Identifier number of category's parent

    /*Constructors*/

    public Category() {
    }

    public Category(@NotNull @Size(max = 1000) String name) {
        this.name = name;
    }

    public Category(@NotNull Integer idCategory, @NotNull @Size(max = 1000) String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    /*Getters and Setters*/

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
