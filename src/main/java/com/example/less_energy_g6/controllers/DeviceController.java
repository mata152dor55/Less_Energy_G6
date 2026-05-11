package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.DeviceDTO;
import com.example.less_energy_g6.entities.Device;
import com.example.less_energy_g6.servicesinterfaces.IDeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Dispositivos")
public class DeviceController {
    @Autowired
    private IDeviceService deviceService;

    @PostMapping("/RegistrarDispositivo")
    public ResponseEntity<?> registrar(@RequestBody DeviceDTO dto) {
        if (dto.getNameDevice() == null) {
            return ResponseEntity.badRequest().body("El nombre del dispositivo no puede ser nulo");
        }

        ModelMapper m = new ModelMapper();
        Device d = m.map(dto, Device.class);
        
        d.setDateCreation(LocalDateTime.now());
        d.setUserCreation(1);
        d.setUserModification(1);

        Device device = deviceService.insert(d);
        DeviceDTO responseDTO = m.map(device, DeviceDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/EliminarDispositivo/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Optional<Device> device = deviceService.listId(id);

        if (device.isPresent()) {
            deviceService.delete(id);
            return ResponseEntity.ok("Dispositivo eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dispositivo no encontrado");
        }
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Device> device = deviceService.listId(id);

        if (device.isPresent()) {
            DeviceDTO dto = m.map(device.get(), DeviceDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dispositivo no encontrado");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarDispositivo(@RequestBody DeviceDTO dto) {
        Optional<Device> device = deviceService.listId(dto.getIdDevice());
        if (device.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dispositivo no encontrado");
        }

        Device d = device.get();
        d.setNameDevice(dto.getNameDevice());
        d.setState(dto.getState());
        d.setBrand(dto.getBrand());
        d.setDateModification(LocalDateTime.now());
        d.setUserModification(1);

        deviceService.update(d);
        return ResponseEntity.ok("Dispositivo actualizado correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DeviceDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<DeviceDTO> lista = deviceService.list()
                .stream()
                .map(y -> m.map(y, DeviceDTO.class))
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
