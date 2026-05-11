package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.AlertConfigDTO;
import com.example.less_energy_g6.entities.AlertConfig;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.UserDevice;
import com.example.less_energy_g6.servicesinterfaces.IAlertConfigService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AlertConfigs")
public class AlertConfigController {
    @Autowired
    private IAlertConfigService alertConfigService;

    @PostMapping("/RegistrarConfiguracionAlerta")
    public ResponseEntity<?> registrar(@RequestBody AlertConfigDTO dto) {
        if (dto.getAlertType() == null) {
            return ResponseEntity.badRequest().body("El tipo de alerta no puede ser nulo");
        }

        ModelMapper m = new ModelMapper();
        AlertConfig ac = m.map(dto, AlertConfig.class);

        // Relaciones
        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        ac.setStatus(status);

        UserDevice ud = new UserDevice();
        ud.setIdUserDevice(dto.getIdUserDevice());
        ac.setUserDevice(ud);

        ac.setCreatedDateTime(LocalDateTime.now());
        ac.setIdCreatedUser(1);
        ac.setIdEditUser(1);

        AlertConfig alertConfig = alertConfigService.insert(ac);
        AlertConfigDTO responseDTO = m.map(alertConfig, AlertConfigDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/EliminarConfiguracionAlerta/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Optional<AlertConfig> alertConfig = alertConfigService.listId(id);

        if (alertConfig.isPresent()) {
            alertConfigService.delete(id);
            return ResponseEntity.ok("Configuración de alerta eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuración no encontrada");
        }
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<AlertConfig> alertConfig = alertConfigService.listId(id);

        if (alertConfig.isPresent()) {
            AlertConfigDTO dto = m.map(alertConfig.get(), AlertConfigDTO.class);
            dto.setIdStatus(alertConfig.get().getStatus().getIdStatus());
            dto.setIdUserDevice(alertConfig.get().getUserDevice().getIdUserDevice());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuración no encontrada");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody AlertConfigDTO dto) {
        Optional<AlertConfig> alertConfig = alertConfigService.listId(dto.getIdAlertConfig());
        if (alertConfig.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Configuración no encontrada");
        }

        AlertConfig ac = alertConfig.get();
        ac.setAlertType(dto.getAlertType());
        ac.setValueTreshold(dto.getValueTreshold());
        ac.setNotifyPush(dto.getNotifyPush());
        ac.setNotifyEmail(dto.getNotifyEmail());
        ac.setMinuteFrequency(dto.getMinuteFrequency());

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus());
        ac.setStatus(status);

        UserDevice ud = new UserDevice();
        ud.setIdUserDevice(dto.getIdUserDevice());
        ac.setUserDevice(ud);

        ac.setEditDateTime(LocalDateTime.now());
        ac.setIdEditUser(1);

        alertConfigService.update(ac);
        return ResponseEntity.ok("Configuración actualizada correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlertConfigDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<AlertConfigDTO> lista = alertConfigService.list()
                .stream()
                .map(y -> {
                    AlertConfigDTO dto = m.map(y, AlertConfigDTO.class);
                    dto.setIdStatus(y.getStatus().getIdStatus());
                    dto.setIdUserDevice(y.getUserDevice().getIdUserDevice());
                    return dto;
                })
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
