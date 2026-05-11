package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.AlertDTO;
import com.example.less_energy_g6.entities.Alert;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.User;
import com.example.less_energy_g6.servicesinterfaces.IAlertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Alertas")
public class AlertController {
    @Autowired
    private IAlertService alertService;

    @PostMapping("/RegistrarAlerta")
    public ResponseEntity<?> registrar(@RequestBody AlertDTO dto) {
        if (dto.getDescription() == null) {
            return ResponseEntity.badRequest().body("La descripción de la alerta no puede ser nula");
        }

        ModelMapper m = new ModelMapper();
        Alert a = m.map(dto, Alert.class);

        // Relaciones
        User user = new User();
        user.setIdUser(dto.getIdUser());
        a.setUser(user);

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        a.setStatus(status);

        a.setDateCreation(LocalDateTime.now());
        a.setUserCreation(1);
        a.setUserModification(1);

        Alert alert = alertService.insert(a);
        AlertDTO responseDTO = m.map(alert, AlertDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/EliminarAlerta/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Optional<Alert> alert = alertService.listId(id);

        if (alert.isPresent()) {
            alertService.delete(id);
            return ResponseEntity.ok("Alerta eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alerta no encontrada");
        }
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Alert> alert = alertService.listId(id);

        if (alert.isPresent()) {
            AlertDTO dto = m.map(alert.get(), AlertDTO.class);
            dto.setIdUser(alert.get().getUser().getIdUser());
            dto.setIdStatus(alert.get().getStatus().getIdStatus());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alerta no encontrada");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody AlertDTO dto) {
        Optional<Alert> alert = alertService.listId(dto.getIdAlert());
        if (alert.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alerta no encontrada");
        }

        Alert a = alert.get();
        a.setDescription(dto.getDescription());
        
        User user = new User();
        user.setIdUser(dto.getIdUser());
        a.setUser(user);

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus());
        a.setStatus(status);

        a.setDateModification(LocalDateTime.now());
        a.setUserModification(1);

        alertService.update(a);
        return ResponseEntity.ok("Alerta actualizada correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlertDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<AlertDTO> lista = alertService.list()
                .stream()
                .map(y -> {
                    AlertDTO dto = m.map(y, AlertDTO.class);
                    dto.setIdUser(y.getUser().getIdUser());
                    dto.setIdStatus(y.getStatus().getIdStatus());
                    return dto;
                })
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
