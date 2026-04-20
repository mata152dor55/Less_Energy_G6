package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "State")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idState;

    @Column(name = "nameState", length = 20, nullable = false)
    private String nameState;

    @Column(name = "description", length = 20, nullable = true)
    private String description;

    @OneToMany
    @JoinColumn(name = "idUser")
    private User user;

    public State(){

    }
}
