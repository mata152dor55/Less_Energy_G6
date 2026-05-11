package com.example.less_energy_g6.Repositories;

import com.example.less_energy_g6.Entities.LogAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogAuditRepository extends JpaRepository<LogAudit, Integer> {
}
