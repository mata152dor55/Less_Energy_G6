package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.VoiceCommandDTO;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.User;
import com.example.less_energy_g6.entities.VoiceCommand;
import com.example.less_energy_g6.servicesinterfaces.IVoiceCommandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/VoiceCommands")
public class VoiceCommandController {
    @Autowired
    private IVoiceCommandService voiceCommandService;

    @PostMapping("/RegistrarVoiceCommand")
    public ResponseEntity<?> registrar(@RequestBody VoiceCommandDTO dto) {
        if (dto.getTranscription() == null || dto.getPerformedAction() == null) {
            return ResponseEntity.badRequest().body("La transcripción y la acción realizada no pueden ser nulas");
        }

        ModelMapper m = new ModelMapper();
        VoiceCommand v = m.map(dto, VoiceCommand.class);

        // Relaciones
        User user = new User();
        user.setIdUser(dto.getIdUser());
        v.setUser(user);

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        v.setStatus(status);

        v.setCreatedDateTime(LocalDateTime.now());
        v.setIdCreatedUser(1);
        v.setIdEditUser(1);

        VoiceCommand command = voiceCommandService.insert(v);
        VoiceCommandDTO responseDTO = m.map(command, VoiceCommandDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<VoiceCommand> command = voiceCommandService.listId(id);

        if (command.isPresent()) {
            VoiceCommandDTO dto = m.map(command.get(), VoiceCommandDTO.class);
            dto.setIdUser(command.get().getUser().getIdUser());
            dto.setIdStatus(command.get().getStatus().getIdStatus());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comando de voz no encontrado");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VoiceCommandDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<VoiceCommandDTO> lista = voiceCommandService.list()
                .stream()
                .map(y -> {
                    VoiceCommandDTO dto = m.map(y, VoiceCommandDTO.class);
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
