package com.example.less_energy_g6.dtos;

public class AlertDTO {
    private int idAlert;
    private String description;
    private int idUser;
    private int idStatus;

    public int getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(int idAlert) {
        this.idAlert = idAlert;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
}
