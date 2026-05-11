package com.example.less_energy_g6.DTOs;

public class ChatbotRecordDTO {
    private int idRecord;
    private String contentRecord;
    private int idUser;
    private int idStatus;

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public String getContentRecord() {
        return contentRecord;
    }

    public void setContentRecord(String contentRecord) {
        this.contentRecord = contentRecord;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }
}
