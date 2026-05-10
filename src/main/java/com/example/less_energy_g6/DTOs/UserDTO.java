package com.example.less_energy_g6.DTOs;

import com.example.less_energy_g6.Entities.Country;
import com.example.less_energy_g6.Entities.Role;
import com.example.less_energy_g6.Entities.Status;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class UserDTO {
    private int idUser;
    private String nameUser;
    private String email;
    private int idCountry;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }
}
