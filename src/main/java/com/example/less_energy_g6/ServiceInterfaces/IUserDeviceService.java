package com.example.less_energy_g6.ServiceInterfaces;

import com.example.less_energy_g6.Entities.UserDevice;

import java.util.List;
import java.util.Optional;

public interface IUserDeviceService {
    public List<UserDevice> list();
    public UserDevice insert(UserDevice ud);
    public void delete(int idUserDevice);
    public Optional<UserDevice> listId(int idUserDevice);
    public void update(UserDevice ud);
}
