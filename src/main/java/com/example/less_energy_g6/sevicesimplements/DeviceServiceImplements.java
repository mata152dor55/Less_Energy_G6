package com.example.less_energy_g6.sevicesimplements;

import com.example.less_energy_g6.entities.Device;
import com.example.less_energy_g6.repositories.IDeviceRepository;
import com.example.less_energy_g6.servicesinterfaces.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImplements implements IDeviceService {

    @Autowired
    private IDeviceRepository deviceRepository;

    @Override
    public List<Device> list() {
        return deviceRepository.findAll();
    }

    @Override
    public Device insert(Device d) {
        return deviceRepository.save(d);
    }

    @Override
    public void delete(int idDevice) {
        deviceRepository.deleteById(idDevice);
    }

    @Override
    public Optional<Device> listId(int idDevice) {
        return deviceRepository.findById(idDevice);
    }

    @Override
    public void update(Device d) {
        deviceRepository.save(d);
    }
}
