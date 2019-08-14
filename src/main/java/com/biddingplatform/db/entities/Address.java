package com.biddingplatform.db.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "building", nullable = true)
    private Integer building;

    @Column(name = "apartment", nullable = true)
    private Integer apartment;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Country country;

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Integer getBuilding() {
        return building;
    }

    public Address setBuilding(Integer building) {
        this.building = building;
        return this;
    }

    public int getApartment() {
        return apartment;
    }

    public Address setApartment(int apartment) {
        this.apartment = apartment;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Address setCountry(Country country) {
        this.country = country;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Address setId(UUID id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        if (country != that.country) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (building != null ? !building.equals(that.building) : that.building != null) return false;
        if (apartment != null ? !apartment.equals(that.apartment) : that.apartment != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (apartment != null ? apartment.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
