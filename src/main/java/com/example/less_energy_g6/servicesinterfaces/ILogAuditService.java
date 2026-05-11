package com.example.less_energy_g6.servicesinterfaces;

import com.example.less_energy_g6.entities.LogAudit;

import java.util.List;
import java.util.Optional;

public interface ILogAuditService {
    public List<LogAudit> list();
    public LogAudit insert(LogAudit l);
    public Optional<LogAudit> listId(int idLog);
}
