package com.example.less_energy_g6.Entities;

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
}
