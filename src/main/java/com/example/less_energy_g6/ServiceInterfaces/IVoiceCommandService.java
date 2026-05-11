package com.example.less_energy_g6.ServiceInterfaces;

import com.example.less_energy_g6.Entities.VoiceCommand;

import java.util.List;
import java.util.Optional;

public interface IVoiceCommandService {
    public List<VoiceCommand> list();
    public VoiceCommand insert(VoiceCommand v);
    public Optional<VoiceCommand> listId(int idVoiceCommand);
}
