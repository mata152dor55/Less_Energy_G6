package com.example.less_energy_g6.Controllers;

import com.example.less_energy_g6.DTOs.InsertUserDTO;
import com.example.less_energy_g6.DTOs.UserDTO;
import com.example.less_energy_g6.DTOs.UserInfoDTO;
import com.example.less_energy_g6.Entities.Country;
import com.example.less_energy_g6.Entities.Role;
import com.example.less_energy_g6.Entities.Status;
import com.example.less_energy_g6.Entities.User;
import com.example.less_energy_g6.ServiceInterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @DeleteMapping("/EliminarUsuario/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id){
        Optional<User> user = userService.listId(id);

        if (user.isPresent()){
            userService.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usario no encontrado");
        }
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<User> user = userService.listId(id);

        if (user.isPresent()) {
            UserInfoDTO dto = m.map(user.get(), UserInfoDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarUsuario(@RequestBody UserDTO dto){
        Optional<User> user = userService.listId(dto.getIdUser());
        if (user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
        if (dto.getEmail() == null){
            return ResponseEntity.badRequest()
                    .body("El email no puede ser nulo");
        }

        User u = user.get();

        u.setNameUser(dto.getNameUser());
        u.setEmail(dto.getEmail());

        Country countryToUpdate = new Country();
        countryToUpdate.setIdCountry(dto.getIdCountry());
        u.setCountry(countryToUpdate);

        userService.update(u);

        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<UserDTO> lista = userService.list()
                .stream()
                .map(y -> m.map(y, UserDTO.class))
                .toList();

        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

}
