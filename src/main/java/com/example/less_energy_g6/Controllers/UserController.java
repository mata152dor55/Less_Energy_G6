package com.example.less_energy_g6.Controllers;

import com.example.less_energy_g6.DTOs.InsertUserDTO;
import com.example.less_energy_g6.Entities.Country;
import com.example.less_energy_g6.Entities.Role;
import com.example.less_energy_g6.Entities.Status;
import com.example.less_energy_g6.Entities.User;
import com.example.less_energy_g6.ServiceInterfaces.IUserService;
import org.hibernate.sql.Insert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/RegistrarUsuario")
    public ResponseEntity<?> registrar(@RequestBody InsertUserDTO dto){

        if (dto.getEmail() == null ) {
            return ResponseEntity.badRequest()
                    .body("El Email no puede ser nulo");
        }
        if (dto.getPasswordHash() == null) {
            return ResponseEntity.badRequest()
                    .body("La contraseña no puede ser nula");
        }
        ModelMapper m=new ModelMapper();
        User u=m.map(dto, User.class);
        Role defaultRole = new Role();

        defaultRole.setIdRole(1);
        u.setRole(defaultRole);

        Country defaultCountry = new Country();
        defaultCountry.setIdCountry(1);
        u.setCountry(defaultCountry);

        Status defaultStatus = new Status();
        defaultStatus.setIdStatus(1);
        u.setStatus(defaultStatus);

        u.setPasswordHash(dto.getPasswordHash());
        u.setDateCreation(LocalDateTime.now());

        User user= userService.insert(u);
        InsertUserDTO responseDTO=m.map(user,InsertUserDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
