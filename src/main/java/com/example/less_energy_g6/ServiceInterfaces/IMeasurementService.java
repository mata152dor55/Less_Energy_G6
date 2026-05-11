package com.example.less_energy_g6.ServiceInterfaces;

import com.example.less_energy_g6.Entities.Measurement;

import java.util.List;
import java.util.Optional;

public interface IMeasurementService {
    public List<Measurement> list();
    public Measurement insert(Measurement m);
    public Optional<Measurement> listId(int idMeasurement);
}
