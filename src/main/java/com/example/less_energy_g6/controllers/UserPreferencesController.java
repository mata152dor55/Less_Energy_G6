package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.UserPreferencesDTO;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.User;
import com.example.less_energy_g6.entities.UserPreferences;
import com.example.less_energy_g6.servicesinterfaces.IUserPreferencesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserPreferences")
public class UserPreferencesController {
    @Autowired
    private IUserPreferencesService userPreferencesService;

    @PostMapping("/RegistrarPreferenciaUsuario")
    public ResponseEntity<?> registrar(@RequestBody UserPreferencesDTO dto) {
        if (dto.getLanguage() == null || dto.getVisualTheme() == null) {
            return ResponseEntity.badRequest().body("Los campos de preferencia no pueden ser nulos");
        }

        ModelMapper m = new ModelMapper();
        UserPreferences up = m.map(dto, UserPreferences.class);

        // Relaciones
        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        up.setStatus(status);

        User user = new User();
        user.setIdUser(dto.getIdUser());
        up.setUser(user);

        up.setCreatedDateTime(LocalDateTime.now());
        up.setIdCreatedUser(1);
        up.setIdEditUser(1);

        UserPreferences userPreferences = userPreferencesService.insert(up);
        UserPreferencesDTO responseDTO = m.map(userPreferences, UserPreferencesDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/EliminarPreferenciaUsuario/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Optional<UserPreferences> userPreferences = userPreferencesService.listId(id);

        if (userPreferences.isPresent()) {
            userPreferencesService.delete(id);
            return ResponseEntity.ok("Preferencia de usuario eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Preferencia no encontrada");
        }
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<UserPreferences> userPreferences = userPreferencesService.listId(id);

        if (userPreferences.isPresent()) {
            UserPreferencesDTO dto = m.map(userPreferences.get(), UserPreferencesDTO.class);
            dto.setIdStatus(userPreferences.get().getStatus().getIdStatus());
            dto.setIdUser(userPreferences.get().getUser().getIdUser());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Preferencia no encontrada");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody UserPreferencesDTO dto) {
        Optional<UserPreferences> userPreferences = userPreferencesService.listId(dto.getIdUserPreference());
        if (userPreferences.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Preferencia no encontrada");
        }

        UserPreferences up = userPreferences.get();
        up.setLanguage(dto.getLanguage());
        up.setVisualTheme(dto.getVisualTheme());
        up.setTimeZone(dto.getTimeZone());

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus());
        up.setStatus(status);

        User user = new User();
        user.setIdUser(dto.getIdUser());
        up.setUser(user);

        up.setEditDateTime(LocalDateTime.now());
        up.setIdEditUser(1);

        userPreferencesService.update(up);
        return ResponseEntity.ok("Preferencia actualizada correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserPreferencesDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<UserPreferencesDTO> lista = userPreferencesService.list()
                .stream()
                .map(y -> {
                    UserPreferencesDTO dto = m.map(y, UserPreferencesDTO.class);
                    dto.setIdStatus(y.getStatus().getIdStatus());
                    dto.setIdUser(y.getUser().getIdUser());
                    return dto;
                })
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
