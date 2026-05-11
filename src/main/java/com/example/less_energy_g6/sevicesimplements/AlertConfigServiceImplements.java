package com.example.less_energy_g6.sevicesimplements;

import com.example.less_energy_g6.entities.AlertConfig;
import com.example.less_energy_g6.repositories.IAlertConfigRepository;
import com.example.less_energy_g6.servicesinterfaces.IAlertConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertConfigServiceImplements implements IAlertConfigService {

    @Autowired
    private IAlertConfigRepository alertConfigRepository;

    @Override
    public List<AlertConfig> list() {
        return alertConfigRepository.findAll();
    }

    @Override
    public AlertConfig insert(AlertConfig ac) {
        return alertConfigRepository.save(ac);
    }

    @Override
    public void delete(int idAlertConfig) {
        alertConfigRepository.deleteById(idAlertConfig);
    }

    @Override
    public Optional<AlertConfig> listId(int idAlertConfig) {
        return alertConfigRepository.findById(idAlertConfig);
    }

    @Override
    public void update(AlertConfig ac) {
        alertConfigRepository.save(ac);
    }
}
