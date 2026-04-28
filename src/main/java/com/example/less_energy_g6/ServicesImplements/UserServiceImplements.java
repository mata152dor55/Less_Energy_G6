package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.User;
import com.example.less_energy_g6.Repositories.IUserRepository;
import com.example.less_energy_g6.ServiceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplements implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User insert(User u) {
        return userRepository.save(u);
    }
}
