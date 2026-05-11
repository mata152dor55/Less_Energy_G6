package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.UserPreferences;
import com.example.less_energy_g6.Repositories.IUserPreferencesRepository;
import com.example.less_energy_g6.ServiceInterfaces.IUserPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPreferencesServiceImplements implements IUserPreferencesService {

    @Autowired
    private IUserPreferencesRepository userPreferencesRepository;

    @Override
    public List<UserPreferences> list() {
        return userPreferencesRepository.findAll();
    }

    @Override
    public UserPreferences insert(UserPreferences up) {
        return userPreferencesRepository.save(up);
    }

    @Override
    public void delete(int idUserPreference) {
        userPreferencesRepository.deleteById(idUserPreference);
    }

    @Override
    public Optional<UserPreferences> listId(int idUserPreference) {
        return userPreferencesRepository.findById(idUserPreference);
    }

    @Override
    public void update(UserPreferences up) {
        userPreferencesRepository.save(up);
    }
}
