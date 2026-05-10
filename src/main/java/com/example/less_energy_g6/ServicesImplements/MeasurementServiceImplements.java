package com.example.less_energy_g6.ServicesImplements;

import com.example.less_energy_g6.Entities.Measurement;
import com.example.less_energy_g6.Repositories.IMeasurementRepository;
import com.example.less_energy_g6.ServiceInterfaces.IMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImplements implements IMeasurementService {

    @Autowired
    private IMeasurementRepository measurementRepository;

    @Override
    public List<Measurement> list() {
        return measurementRepository.findAll();
    }

    @Override
    public Measurement insert(Measurement m) {
        return measurementRepository.save(m);
    }

    @Override
    public Optional<Measurement> listId(int idMeasurement) {
        return measurementRepository.findById(idMeasurement);
    }
}
