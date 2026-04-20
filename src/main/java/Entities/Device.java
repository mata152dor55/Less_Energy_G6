package Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevice;

    @Column(name = "nameDevice", length = 150, nullable = false)
    private String nameDevice;

    @Column(name = "State", nullable = false)
    private Character State;

    @Column(name = "brand", length = 100, nullable = false)
    private String brand;

    @Column(name = "dateCreation", nullable = false)
    private LocalDate dateCreation;

    @Column(name = "dateModification", nullable = false)
    private LocalDate dateModification;

    @Column(name = "userCreation", nullable = false)
    private LocalDate userCreation;

    @Column(name = "userModification", nullable = false)
    private LocalDate userModification;

    @Column(name = "dateDelete", nullable = false)
    private LocalDate dateDelete;
}
