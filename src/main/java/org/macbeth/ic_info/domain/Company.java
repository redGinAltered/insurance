package org.macbeth.ic_info.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Length(min=10, max=10)
    @Pattern(regexp = "[0-9]+")
    private String inn;

    @NotBlank
    @Length(min=13, max=13)
    @Pattern(regexp = "[0-9]+")
    private String ogrn;

    @NotBlank
    private String name;

    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    @Pattern(regexp = "[0-9]+")
    private String building;

    public Company() {
    }

    public Company(String inn, String ogrn, String name, String city, String street, String building) {
        this.inn = inn;
        this.ogrn = ogrn;
        this.name = name;
        this.city = city;
        this.street = street;
        this.building = building;
    }


    public Long getId() {
        return id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
