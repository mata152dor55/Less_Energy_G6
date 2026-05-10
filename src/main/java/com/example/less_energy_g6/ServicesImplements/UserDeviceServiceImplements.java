package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.UserDevice;
import com.example.less_energy_g6.Repositories.IUserDeviceRepository;
import com.example.less_energy_g6.ServiceInterfaces.IUserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDeviceServiceImplements implements IUserDeviceService {

    @Autowired
    private IUserDeviceRepository userDeviceRepository;

    @Override
    public List<UserDevice> list() {
        return userDeviceRepository.findAll();
    }

    @Override
    public UserDevice insert(UserDevice ud) {
        return userDeviceRepository.save(ud);
    }

    @Override
    public void delete(int idUserDevice) {
        userDeviceRepository.deleteById(idUserDevice);
    }

    @Override
    public Optional<UserDevice> listId(int idUserDevice) {
        return userDeviceRepository.findById(idUserDevice);
    }

    @Override
    public void update(UserDevice ud) {
        userDeviceRepository.save(ud);
    }
}
