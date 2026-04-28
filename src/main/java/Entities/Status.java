package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private char idStatus;

    @Column(name = "nameState", length = 20, nullable = false)
    private String nameStatus;

    @Column(name = "description", length = 20, nullable = true)
    private String description;

    @OneToMany
    @JoinColumn(name = "idUser")
    private User user;

    public Status(){
    }

}
