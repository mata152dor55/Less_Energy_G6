package Entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ChatbotRecord")
public class ChatbotRecord {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idRecord;

    @Column (name = "contentRecord", nullable = false)
    private String contentRecord;

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
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idStatus")
    private Status status;


    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public String getContentRecord() {
        return contentRecord;
    }

    public void setContentRecord(String contentRecord) {
        this.contentRecord = contentRecord;
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
