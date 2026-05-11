package com.example.less_energy_g6.dtos;

import java.math.BigDecimal;

public class MeasurementDTO {
    private int idMeasurement;
    private BigDecimal voltage;
    private BigDecimal current;
    private BigDecimal activePower;
    private int idStatus;
    private int idUserDevice;

    public int getIdMeasurement() {
        return idMeasurement;
    }

    public void setIdMeasurement(int idMeasurement) {
        this.idMeasurement = idMeasurement;
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getActivePower() {
        return activePower;
    }

    public void setActivePower(BigDecimal activePower) {
        this.activePower = activePower;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }
}
