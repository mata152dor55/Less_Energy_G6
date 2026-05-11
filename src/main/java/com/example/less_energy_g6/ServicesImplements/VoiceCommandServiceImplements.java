package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.VoiceCommand;
import com.example.less_energy_g6.Repositories.IVoiceCommandRepository;
import com.example.less_energy_g6.ServiceInterfaces.IVoiceCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoiceCommandServiceImplements implements IVoiceCommandService {
    @Autowired
    private IVoiceCommandRepository voiceCommandRepository;

    @Override
    public List<VoiceCommand> list() {
        return voiceCommandRepository.findAll();
    }

    @Override
    public VoiceCommand insert(VoiceCommand v) {
        return voiceCommandRepository.save(v);
    }

    @Override
    public Optional<VoiceCommand> listId(int idVoiceCommand) {
        return voiceCommandRepository.findById(idVoiceCommand);
    }
}
