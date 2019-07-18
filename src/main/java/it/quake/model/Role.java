package it.quake.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class of user's role
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRole; //Identifier number of role

    @Size(max = 30)
    @NotNull
    @Column(name = "role")
    private String role; //Role of user

    /*Constructor*/

    public Role() {
    }

    public Role(@Size(max = 30) @NotNull String role) {
        this.role = role;
    }

    public Role(@NotNull Integer idRole, @Size(max = 30) @NotNull String role) {
        this.idRole = idRole;
        this.role = role;
    }

    /*Getters and Setters*/

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
