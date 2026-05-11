package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.ChatbotRecord;
import com.example.less_energy_g6.Repositories.IChatbotRecordRepository;
import com.example.less_energy_g6.ServiceInterfaces.IChatbotRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatbotRecordServiceImplements implements IChatbotRecordService {
    @Autowired
    private IChatbotRecordRepository chatbotRecordRepository;

    @Override
    public List<ChatbotRecord> list() {
        return chatbotRecordRepository.findAll();
    }

    @Override
    public ChatbotRecord insert(ChatbotRecord c) {
        return chatbotRecordRepository.save(c);
    }

    @Override
    public Optional<ChatbotRecord> listId(int idRecord) {
        return chatbotRecordRepository.findById(idRecord);
    }
}
