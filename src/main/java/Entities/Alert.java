package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "Alert")
public class Alert {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAlert;

    @Column (name = "description", nullable = false)
    private String description;

    @Column(name = "dateCreation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "dateModification", nullable = false)
    private LocalDate dateModification;

    @Column(name = "userCreation", nullable = false)
    private int userCreation;

    @Column(name = "userModification", nullable = false)
    private int userModification;

    @Column(name = "userDelete", nullable = false)
    private LocalDate userDelete;

    @ManyToOne
    @JoinColumn (name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;

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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public int getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(int userCreation) {
        this.userCreation = userCreation;
    }

    public int getUserModification() {
        return userModification;
    }

    public void setUserModification(int userModification) {
        this.userModification = userModification;
    }

    public LocalDate getUserDelete() {
        return userDelete;
    }

    public void setUserDelete(LocalDate userDelete) {
        this.userDelete = userDelete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
