package com.example.less_energy_g6.Controllers;

import com.example.less_energy_g6.DTOs.InsertUserDTO;
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

import java.time.LocalDate;

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
        if (dto.getPassword() == null) {
            return ResponseEntity.badRequest()
                    .body("La contrasseña no puede ser nula");
        }
        ModelMapper m=new ModelMapper();
        User u=m.map(dto, User.class);
        User user= userService.insert(u);
        InsertUserDTO responseDTO=m.map(user,InsertUserDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
