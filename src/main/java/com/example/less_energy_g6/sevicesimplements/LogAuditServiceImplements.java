package com.example.less_energy_g6.sevicesimplements;

import com.example.less_energy_g6.entities.LogAudit;
import com.example.less_energy_g6.repositories.ILogAuditRepository;
import com.example.less_energy_g6.servicesinterfaces.ILogAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogAuditServiceImplements implements ILogAuditService {
    @Autowired
    private ILogAuditRepository logAuditRepository;

    @Override
    public List<LogAudit> list() {
        return logAuditRepository.findAll();
    }

    @Override
    public LogAudit insert(LogAudit l) {
        return logAuditRepository.save(l);
    }

    @Override
    public Optional<LogAudit> listId(int idLog) {
        return logAuditRepository.findById(idLog);
    }
}
