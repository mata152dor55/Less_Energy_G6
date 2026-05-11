package com.example.less_energy_g6.servicesinterfaces;

import com.example.less_energy_g6.entities.UserPreferences;

import java.util.List;
import java.util.Optional;

public interface IUserPreferencesService {
    public List<UserPreferences> list();
    public UserPreferences insert(UserPreferences up);
    public void delete(int idUserPreference);
    public Optional<UserPreferences> listId(int idUserPreference);
    public void update(UserPreferences up);
}
