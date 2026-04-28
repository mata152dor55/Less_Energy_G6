package com.example.less_energy_g6.Repositories;

import com.example.less_energy_g6.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
