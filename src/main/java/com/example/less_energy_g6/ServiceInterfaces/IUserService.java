package com.example.less_energy_g6.ServiceInterfaces;

import com.example.less_energy_g6.Entities.User;
import com.example.less_energy_g6.Entities.UserPreferences;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> list();
    public User insert(User u);
    public void delete(int idUser);
    public Optional<User> listId(int idUser);
    public void update(User u);
}
