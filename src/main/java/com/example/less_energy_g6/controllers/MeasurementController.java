package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.MeasurementDTO;
import com.example.less_energy_g6.entities.Measurement;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.UserDevice;
import com.example.less_energy_g6.servicesinterfaces.IMeasurementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Mediciones")
public class MeasurementController {
    @Autowired
    private IMeasurementService measurementService;

    @PostMapping("/RegistrarMedicion")
    public ResponseEntity<?> registrar(@RequestBody MeasurementDTO dto) {
        if (dto.getVoltage() == null || dto.getCurrent() == null || dto.getActivePower() == null) {
            return ResponseEntity.badRequest().body("Los valores de medición no pueden ser nulos");
        }

        ModelMapper m = new ModelMapper();
        Measurement me = m.map(dto, Measurement.class);

        // Relaciones
        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        me.setStatus(status);

        UserDevice ud = new UserDevice();
        ud.setIdUserDevice(dto.getIdUserDevice());
        me.setUserDevice(ud);

        me.setCreatedDateTime(LocalDateTime.now());
        me.setIdCreatedUser(1);
        me.setIdEditUser(1);

        Measurement measurement = measurementService.insert(me);
        MeasurementDTO responseDTO = m.map(measurement, MeasurementDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Measurement> measurement = measurementService.listId(id);

        if (measurement.isPresent()) {
            MeasurementDTO dto = m.map(measurement.get(), MeasurementDTO.class);
            dto.setIdStatus(measurement.get().getStatus().getIdStatus());
            dto.setIdUserDevice(measurement.get().getUserDevice().getIdUserDevice());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medición no encontrada");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MeasurementDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<MeasurementDTO> lista = measurementService.list()
                .stream()
                .map(y -> {
                    MeasurementDTO dto = m.map(y, MeasurementDTO.class);
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
