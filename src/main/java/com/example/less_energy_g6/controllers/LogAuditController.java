package com.example.less_energy_g6.controllers;

import com.example.less_energy_g6.dtos.LogAuditDTO;
import com.example.less_energy_g6.entities.LogAudit;
import com.example.less_energy_g6.servicesinterfaces.ILogAuditService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/LogAudits")
public class LogAuditController {
    @Autowired
    private ILogAuditService logAuditService;

    @PostMapping("/RegistrarLogAudit")
    public ResponseEntity<?> registrar(@RequestBody LogAuditDTO dto) {
        if (dto.getTableName() == null || dto.getAction() == null) {
            return ResponseEntity.badRequest().body("El nombre de la tabla y la acción no pueden ser nulos");
        }

        ModelMapper m = new ModelMapper();
        LogAudit l = m.map(dto, LogAudit.class);
        
        l.setActionDateTime(LocalDateTime.now());

        LogAudit logAudit = logAuditService.insert(l);
        LogAuditDTO responseDTO = m.map(logAudit, LogAuditDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/ListarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<LogAudit> logAudit = logAuditService.listId(id);

        if (logAudit.isPresent()) {
            LogAuditDTO dto = m.map(logAudit.get(), LogAuditDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Log no encontrado");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LogAuditDTO>> listar() {
        ModelMapper m = new ModelMapper();

        List<LogAuditDTO> lista = logAuditService.list()
                .stream()
                .map(y -> m.map(y, LogAuditDTO.class))
                .toList();

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }
}
