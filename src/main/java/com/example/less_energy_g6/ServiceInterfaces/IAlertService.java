package com.example.less_energy_g6.ServiceInterfaces;

import com.example.less_energy_g6.Entities.Alert;

import java.util.List;
import java.util.Optional;

public interface IAlertService {
    public List<Alert> list();
    public Alert insert(Alert a);
    public void delete(int idAlert);
    public Optional<Alert> listId(int idAlert);
    public void update(Alert a);
}
