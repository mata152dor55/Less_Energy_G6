package com.example.less_energy_g6.servicesinterfaces;

import com.example.less_energy_g6.entities.AlertConfig;

import java.util.List;
import java.util.Optional;

public interface IAlertConfigService {
    public List<AlertConfig> list();
    public AlertConfig insert(AlertConfig ac);
    public void delete(int idAlertConfig);
    public Optional<AlertConfig> listId(int idAlertConfig);
    public void update(AlertConfig ac);
}
