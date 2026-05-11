package com.example.less_energy_g6.sevicesimplements;

import com.example.less_energy_g6.entities.Alert;
import com.example.less_energy_g6.repositories.IAlertRepository;
import com.example.less_energy_g6.servicesinterfaces.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertServiceImplements implements IAlertService {

    @Autowired
    private IAlertRepository alertRepository;

    @Override
    public List<Alert> list() {
        return alertRepository.findAll();
    }

    @Override
    public Alert insert(Alert a) {
        return alertRepository.save(a);
    }

    @Override
    public void delete(int idAlert) {
        alertRepository.deleteById(idAlert);
    }

    @Override
    public Optional<Alert> listId(int idAlert) {
        return alertRepository.findById(idAlert);
    }

    @Override
    public void update(Alert a) {
        alertRepository.save(a);
    }
}
