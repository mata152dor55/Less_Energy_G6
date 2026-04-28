package Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserPreference")
public class UserPreferences {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idUserPreference;

    @Column (name = "language", length =  5, nullable = false)
    private String language;

    @Column (name = "visualTheme", length =  20, nullable = false)
    private String visualTheme;

    @Column (name = "timeZone", length = 50, nullable = false)
    private String timeZone;

    @Column (name = "createdDateTime", nullable = false)
    private LocalDateTime createdDateTime;

    @Column (name = "editDateTime", nullable = true)
    private LocalDateTime editDateTime;

    @Column (name = "editUser", nullable = true)
    private int idEditUser;

    @Column (name = "createdUser", nullable = true)
    private int idCreatedUser;

    @Column (name = "deleteDateTime", nullable = true)
    private LocalDateTime deleteDateTime;

    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;

    @ManyToOne
    @JoinColumn (name = "idUser")
    private  User user;

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

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getEditDateTime() {
        return editDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }

    public int getIdEditUser() {
        return idEditUser;
    }

    public void setIdEditUser(int idEditUser) {
        this.idEditUser = idEditUser;
    }

    public int getIdCreatedUser() {
        return idCreatedUser;
    }

    public void setIdCreatedUser(int idCreatedUser) {
        this.idCreatedUser = idCreatedUser;
    }

    public LocalDateTime getDeleteDateTime() {
        return deleteDateTime;
    }

    public void setDeleteDateTime(LocalDateTime deleteDateTime) {
        this.deleteDateTime = deleteDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
