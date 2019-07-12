package it.quake.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * General class for user
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser; //Identifier number of user

    @Size(max = 30)
    @NotNull
    @Column(name = "name")
    private String name;

    @Size(max = 30)
    @NotNull
    @Column(name = "surname")
    private String surname;

    @Size(max = 255)
    @NotNull
    @Column(name = "email")
    private String email;

    @Size(max = 32)
    @NotNull
    @Column(name = "password")
    private String password;

    @Size(max = 16)
    @Column(name = "fiscal_code")
    private String fiscalCode;

    @Size(max = 11)
    @Column(name = "vat_number")
    private String vatNumber;

    @Size(max = 100)
    @Column(name = "user_number")
    private String userNumber;

    @Size(max = 30)
    @Column(name = "company")
    private String company;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_address", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    public User() {
    }

    public User(@Size(max = 30) @NotNull String name, @Size(max = 30) @NotNull String surname, @Size(max = 255) @NotNull String email, @Size(max = 32) @NotNull String password, @Size(max = 16) String fiscalCode, @Size(max = 11) String vatNumber, @Size(max = 100) String userNumber, @Size(max = 30) String company, Date createDate, Address address, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.fiscalCode = fiscalCode;
        this.vatNumber = vatNumber;
        this.userNumber = userNumber;
        this.company = company;
        this.createDate = createDate;
        this.address = address;
        this.role = role;
    }

    public User(@NotNull Integer idUser, @Size(max = 30) @NotNull String name, @Size(max = 30) @NotNull String surname, @Size(max = 255) @NotNull String email, @Size(max = 32) @NotNull String password, @Size(max = 16) String fiscalCode, @Size(max = 11) String vatNumber, @Size(max = 100) String userNumber, @Size(max = 30) String company, Date createDate, Address address, Role role) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.fiscalCode = fiscalCode;
        this.vatNumber = vatNumber;
        this.userNumber = userNumber;
        this.company = company;
        this.createDate = createDate;
        this.address = address;
        this.role = role;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
