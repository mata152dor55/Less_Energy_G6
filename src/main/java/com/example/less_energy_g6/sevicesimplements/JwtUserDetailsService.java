package com.example.less_energy_g6.sevicesimplements;


import com.example.less_energy_g6.entities.User;
import com.example.less_energy_g6.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByNameUser(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        if (user.getRole() != null) {
            roles.add(new SimpleGrantedAuthority(user.getRole().getNameRole()));
        }

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNameUser(), user.getPasswordHash(), roles);

        return ud;
    }
}