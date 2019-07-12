package it.quake.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class of user's address
 *
 * @author Christopher Leofreddi
 */
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id_address")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAddress; //Identifier number of address

    @Size(max = 40)
    @NotNull
    @Column(name = "street")
    private String street; //Street of address

    @NotNull
    @Column(name = "house_number")
    private Integer houseNumber; //House number of street

    @Size(max = 10)
    @NotNull
    @Column(name = "postal_code")
    private String postalCode; //Postal code

    @Size(max = 25)
    @NotNull
    @Column(name = "country")
    private String country; //Country

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_nation", nullable = false)
    Nation nation; //Nation

    public Address() {
    }

    public Address(@Size(max = 40) @NotNull String street, @NotNull Integer houseNumber, @Size(max = 10) @NotNull String postalCode, @Size(max = 25) @NotNull String country, Nation nation) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.country = country;
        this.nation = nation;
    }

    public Address(@NotNull Integer idAddress, @Size(max = 40) @NotNull String street, @NotNull Integer houseNumber, @Size(max = 10) @NotNull String postalCode, @Size(max = 25) @NotNull String country, Nation nation) {
        this.idAddress = idAddress;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.country = country;
        this.nation = nation;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
