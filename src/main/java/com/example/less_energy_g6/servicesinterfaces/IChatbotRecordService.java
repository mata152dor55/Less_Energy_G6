package com.example.less_energy_g6.servicesinterfaces;

import com.example.less_energy_g6.entities.ChatbotRecord;

import java.util.List;
import java.util.Optional;

public interface IChatbotRecordService {
    public List<ChatbotRecord> list();
    public ChatbotRecord insert(ChatbotRecord c);
    public Optional<ChatbotRecord> listId(int idRecord);
}
