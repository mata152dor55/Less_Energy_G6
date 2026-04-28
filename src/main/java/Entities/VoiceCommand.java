package Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "VoiceComamnd")
public class VoiceCommand {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVoiceCommand;

    @Column (name ="transcription", length = 255, nullable = false)
    private String transcription;

    @Column (name = "performedAction", length = 100, nullable = false)
    private String performedAction;

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
    @JoinColumn (name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;


    public int getIdVoiceCommand() {
        return idVoiceCommand;
    }

    public void setIdVoiceCommand(int idVoiceCommand) {
        this.idVoiceCommand = idVoiceCommand;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getPerformedAction() {
        return performedAction;
    }

    public void setPerformedAction(String performedAction) {
        this.performedAction = performedAction;
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
