package com.example.less_energy_g6.repositories;

import com.example.less_energy_g6.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByNameUser(String nameUser);
    User findByEmail(String email);
}
