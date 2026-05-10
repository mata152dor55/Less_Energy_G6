package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.User;
import com.example.less_energy_g6.Repositories.IUserRepository;
import com.example.less_energy_g6.ServiceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplements implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User insert(User u) {
        return userRepository.save(u);
    }

    @Override
    public void delete(int idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public Optional<User> listId(int idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public void update(User u) {
        userRepository.save(u);
    }
}
