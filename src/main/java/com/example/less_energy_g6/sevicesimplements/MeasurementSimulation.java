package com.example.less_energy_g6.sevicesimplements;

import com.example.less_energy_g6.entities.Device;
import com.example.less_energy_g6.entities.Measurement;
import com.example.less_energy_g6.entities.Status;
import com.example.less_energy_g6.entities.UserDevice;
import com.example.less_energy_g6.repositories.IDeviceRepository;
import com.example.less_energy_g6.repositories.IMeasurementRepository;
import com.example.less_energy_g6.repositories.IUserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MeasurementSimulation {
    @Autowired
    private IUserDeviceRepository userDeviceRepository;

    @Autowired
    private IMeasurementRepository measurementRepository;

    private final Random random = new Random();

    @Scheduled(fixedRate = 60000)
    public void simularLecturasDeHardware() {

        System.out.println("🤖 [SIMULADOR] Buscando dispositivos de usuarios para generar mediciones...");

        List<UserDevice> userDevices = userDeviceRepository.findAll();

        if (userDevices.isEmpty()) {
            System.out.println("🤖 [SIMULADOR] No hay dispositivos vinculados. Esperando...");
            return;
        }

        for (UserDevice ud : userDevices) {
            Measurement medicion = new Measurement();

            medicion.setUserDevice(ud);

            double voltajeAleatorio = 215.0 + (10.0 * random.nextDouble());
            double corrienteAleatoria = 0.5 + (7.5 * random.nextDouble());
            double potencia = voltajeAleatorio * corrienteAleatoria;

            medicion.setVoltage(BigDecimal.valueOf(voltajeAleatorio).setScale(2, RoundingMode.HALF_UP));
            medicion.setCurrent(BigDecimal.valueOf(corrienteAleatoria).setScale(2, RoundingMode.HALF_UP));
            medicion.setActivePower(BigDecimal.valueOf(potencia).setScale(2, RoundingMode.HALF_UP));

            medicion.setCreatedDateTime(LocalDateTime.now());
            medicion.setIdCreatedUser(0);

            Status estadoActivo = new Status();
            estadoActivo.setIdStatus(1);
            medicion.setStatus(estadoActivo);

            measurementRepository.save(medicion);

            System.out.println("⚡ Medición guardada: " + medicion.getActivePower() + " W");
        }
    }

}
