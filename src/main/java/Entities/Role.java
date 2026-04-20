package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "nameRole", length = 50, nullable = false)
    private String nameRole;

    @Column(name = "description", length = 100, nullable = true)
    private String description;
}
