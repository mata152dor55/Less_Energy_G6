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
}
