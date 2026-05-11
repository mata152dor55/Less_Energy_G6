package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.Alert;
import com.example.less_energy_g6.Repositories.IAlertRepository;
import com.example.less_energy_g6.ServiceInterfaces.IAlertService;
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
