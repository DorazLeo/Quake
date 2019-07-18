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

    public Nation() {
    }

    public Nation(@Size(max = 55) @NotNull String name) {
        this.name = name;
    }

    public Nation(@NotNull Integer idNation, @Size(max = 55) @NotNull String name) {
        this.idNation = idNation;
        this.name = name;
    }

    /*Getters And Setters*/

    public Integer getIdNation() {
        return idNation;
    }

    public void setIdNation(Integer idNation) {
        this.idNation = idNation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
