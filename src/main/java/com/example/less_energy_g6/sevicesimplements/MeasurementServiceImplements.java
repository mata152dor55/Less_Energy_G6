package com.example.less_energy_g6.sevicesimplements;

import com.example.less_energy_g6.entities.Measurement;
import com.example.less_energy_g6.repositories.IMeasurementRepository;
import com.example.less_energy_g6.servicesinterfaces.IMeasurementService;
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
