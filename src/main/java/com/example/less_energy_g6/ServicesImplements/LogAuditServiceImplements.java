package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.LogAudit;
import com.example.less_energy_g6.Repositories.ILogAuditRepository;
import com.example.less_energy_g6.ServiceInterfaces.ILogAuditService;
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
