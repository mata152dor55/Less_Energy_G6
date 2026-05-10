package com.example.less_energy_g6.Controllers;

import com.example.less_energy_g6.DTOs.UserDeviceDTO;
import com.example.less_energy_g6.Entities.Device;
import com.example.less_energy_g6.Entities.Status;
import com.example.less_energy_g6.Entities.User;
import com.example.less_energy_g6.Entities.UserDevice;
import com.example.less_energy_g6.ServiceInterfaces.IUserDeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/UserDevices")
public class UserDeviceController {
    @Autowired
    private IUserDeviceService userDeviceService;

    @PostMapping("/RegistrarUserDevice")
    public ResponseEntity<?> registrar(@RequestBody UserDeviceDTO dto) {
        if (dto.getDeviceAlias() == null) {
            return ResponseEntity.badRequest().body("El alias del dispositivo no puede ser nulo");
        }

        ModelMapper m = new ModelMapper();
        UserDevice ud = m.map(dto, UserDevice.class);

        User user = new User();
        user.setIdUser(dto.getIdUser());
        ud.setUser(user);

        Device device = new Device();
        device.setIdDevice(dto.getIdDevice());
        ud.setDevice(device);

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        ud.setStatus(status);

        ud.setCreatedDateTime(LocalDateTime.now());
        ud.setIdCreatedUser(1);
        ud.setIdEditUser(1);

        UserDevice userDevice = userDeviceService.insert(ud);
        UserDeviceDTO responseDTO = m.map(userDevice, UserDeviceDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/EliminarUserDevice/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Optional<UserDevice> userDevice = userDeviceService.listId(id);

        if (userDevice.isPresent()) {
            userDeviceService.delete(id);
            return ResponseEntity.ok("Relación Usuario-Dispositivo eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relación no encontrada");
        }
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<UserDevice> userDevice = userDeviceService.listId(id);

        if (userDevice.isPresent()) {
            UserDeviceDTO dto = m.map(userDevice.get(), UserDeviceDTO.class);
            dto.setIdUser(userDevice.get().getUser().getIdUser());
            dto.setIdDevice(userDevice.get().getDevice().getIdDevice());
            dto.setIdStatus(userDevice.get().getStatus().getIdStatus());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relación no encontrada");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody UserDeviceDTO dto) {
        Optional<UserDevice> userDevice = userDeviceService.listId(dto.getIdUserDevice());
        if (userDevice.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relación no encontrada");
        }

        UserDevice ud = userDevice.get();
        ud.setDeviceAlias(dto.getDeviceAlias());
        
        User user = new User();
        user.setIdUser(dto.getIdUser());
        ud.setUser(user);

        Device device = new Device();
        device.setIdDevice(dto.getIdDevice());
        ud.setDevice(device);

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus());
        ud.setStatus(status);

        ud.setEditDateTime(LocalDateTime.now());
        ud.setIdEditUser(1);

        userDeviceService.update(ud);
        return ResponseEntity.ok("Relación Usuario-Dispositivo actualizada correctamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserDeviceDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<UserDeviceDTO> lista = userDeviceService.list()
                .stream()
                .map(y -> {
                    UserDeviceDTO dto = m.map(y, UserDeviceDTO.class);
                    dto.setIdUser(y.getUser().getIdUser());
                    dto.setIdDevice(y.getDevice().getIdDevice());
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
