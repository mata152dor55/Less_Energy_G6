package com.example.less_energy_g6.servicesinterfaces;

import com.example.less_energy_g6.entities.Device;

import java.util.List;
import java.util.Optional;

public interface IDeviceService {
    public List<Device> list();
    public Device insert(Device d);
    public void delete(int idDevice);
    public Optional<Device> listId(int idDevice);
    public void update(Device d);
}
