package com.example.less_energy_g6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCountry;

    @Column(name = "nameCountry", length = 20, nullable = false)
    private String nameCountry;

    @Column(name = "codeCountry", length = 2, nullable = false)
    private String codeCountry;

    public Country() {
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }
}
