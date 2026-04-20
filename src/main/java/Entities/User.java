package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nameUser", length = 150, nullable = false)
    private String nameUser;

    @Column(name = "passwordHash", length = 225, nullable = false)
    private String passwordHash;

    @Column(name = "Email", length = 150, nullable = false)
    private String Email;

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

    public User(){

    }

    public User(int idUser, String nameUser, String passwordHash, String email, LocalDate dateCreation, LocalDate dateModification, int userCreation, int userModification, LocalDate userDelete) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passwordHash = passwordHash;
        this.Email = email;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.userCreation = userCreation;
        this.userModification = userModification;
        this.userDelete = userDelete;
    }

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
}
