package com.example.less_energy_g6.repositories;

import com.example.less_energy_g6.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceRepository extends JpaRepository<Device, Integer> {
}
