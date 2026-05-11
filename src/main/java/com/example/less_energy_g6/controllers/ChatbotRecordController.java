package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.ChatbotRecordDTO;
import com.example.less_energy_g6.entities.ChatbotRecord;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.User;
import com.example.less_energy_g6.servicesinterfaces.IChatbotRecordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ChatbotRecords")
public class ChatbotRecordController {
    @Autowired
    private IChatbotRecordService chatbotRecordService;

    @PostMapping("/RegistrarChatbotRecord")
    public ResponseEntity<?> registrar(@RequestBody ChatbotRecordDTO dto) {
        if (dto.getContentRecord() == null) {
            return ResponseEntity.badRequest().body("El contenido del registro no puede ser nulo");
        }

        ModelMapper m = new ModelMapper();
        ChatbotRecord c = m.map(dto, ChatbotRecord.class);

        // Relaciones
        User user = new User();
        user.setIdUser(dto.getIdUser());
        c.setUser(user);

        Status status = new Status();
        status.setIdStatus(dto.getIdStatus() != 0 ? dto.getIdStatus() : 1);
        c.setStatus(status);

        c.setCreatedDateTime(LocalDateTime.now());
        c.setIdCreatedUser(1);
        c.setIdEditUser(1);

        ChatbotRecord record = chatbotRecordService.insert(c);
        ChatbotRecordDTO responseDTO = m.map(record, ChatbotRecordDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<ChatbotRecord> record = chatbotRecordService.listId(id);

        if (record.isPresent()) {
            ChatbotRecordDTO dto = m.map(record.get(), ChatbotRecordDTO.class);
            dto.setIdUser(record.get().getUser().getIdUser());
            dto.setIdStatus(record.get().getStatus().getIdStatus());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro no encontrado");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ChatbotRecordDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<ChatbotRecordDTO> lista = chatbotRecordService.list()
                .stream()
                .map(y -> {
                    ChatbotRecordDTO dto = m.map(y, ChatbotRecordDTO.class);
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
