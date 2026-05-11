package com.example.less_energy_g6.repositories;

import com.example.less_energy_g6.entities.ChatbotRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IChatbotRecordRepository extends JpaRepository<ChatbotRecord, Integer> {
}
