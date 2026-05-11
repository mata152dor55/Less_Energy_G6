package com.example.less_energy_g6.DTOs;

public class UserPreferencesDTO {
    private int idUserPreference;
    private String language;
    private String visualTheme;
    private String timeZone;
    private int idStatus;
    private int idUser;

    public int getIdUserPreference() {
        return idUserPreference;
    }

    public void setIdUserPreference(int idUserPreference) {
        this.idUserPreference = idUserPreference;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVisualTheme() {
        return visualTheme;
    }

    public void setVisualTheme(String visualTheme) {
        this.visualTheme = visualTheme;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
