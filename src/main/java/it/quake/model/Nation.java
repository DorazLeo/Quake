package it.quake.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class of nations
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "nation")
public class Nation {

    @Id
    @Column(name = "id_nation")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idNation; //Identifier number of nation

    @Size(max = 55)
    @NotNull
    @Column(name = "name")
    private String name; //Name of nation

    /*Constructor*/

    /**
     * Default constructor
     */
    public Nation() {
    }

    /**
     * Constructor used to save a nation
     *
     * @param name Name of nation
     */
    public Nation(@Size(max = 55) @NotNull String name) {
        this.name = name;
    }


    /**
     * Constructor used to update a nation
     * @param idNation //Identifier number of nation
     * @param name //Name of nation
     */
    public Nation(@NotNull Integer idNation, @Size(max = 55) @NotNull String name) {
        this.idNation = idNation;
        this.name = name;
    }

    /*Getters And Setters*/


    /**
     * Getter of nation's identifier number
     * @return Nation's identifier number
     */
    public Integer getIdNation() {
        return idNation;
    }

    /**
     * Setter of nation's identifier number
     * @param idNation Nation's identifier number
     */
    public void setIdNation(Integer idNation) {
        this.idNation = idNation;
    }

    /**
     * Getter of nation's name
     * @return Nation's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of nation's name
     * @param name Nation's name
     */
    public void setName(String name) {
        this.name = name;
    }
}
