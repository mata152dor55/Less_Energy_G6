package com.example.less_energy_g6.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Context")
public class Context {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idContext;

    @Column (name = "resume", nullable = false)
    private String resume;

    @Column (name = "lastTimeInteraction", nullable = false)
    private LocalDateTime lastTimeInteraction;

    @Column (name = "countMessages", nullable = true)
    private int countMessages;

    @Column (name = "usedTokens", nullable = true)
    private int usedTokens;


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
    @JoinColumn(name = "idRecord")
    private ChatbotRecord record;

    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;

    public Context() {
    }

    public int getIdContext() {
        return idContext;
    }

    public void setIdContext(int idContext) {
        this.idContext = idContext;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDateTime getLastTimeInteraction() {
        return lastTimeInteraction;
    }

    public void setLastTimeInteraction(LocalDateTime lastTimeInteraction) {
        this.lastTimeInteraction = lastTimeInteraction;
    }

    public int getCountMessages() {
        return countMessages;
    }

    public void setCountMessages(int countMessages) {
        this.countMessages = countMessages;
    }

    public int getUsedTokens() {
        return usedTokens;
    }

    public void setUsedTokens(int usedTokens) {
        this.usedTokens = usedTokens;
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

    public ChatbotRecord getRecord() {
        return record;
    }

    public void setRecord(ChatbotRecord record) {
        this.record = record;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
