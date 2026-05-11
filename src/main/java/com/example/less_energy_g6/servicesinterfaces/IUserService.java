package com.example.less_energy_g6.servicesinterfaces;

import com.example.less_energy_g6.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> list();
    public User insert(User u);
    public void delete(int idUser);
    public Optional<User> listId(int idUser);
    public void update(User u);
}
