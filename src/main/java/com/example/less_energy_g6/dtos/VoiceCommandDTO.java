package com.example.less_energy_g6.dtos;

public class VoiceCommandDTO {
    private int idVoiceCommand;
    private String transcription;
    private String performedAction;
    private int idUser;
    private int idStatus;

    public int getIdVoiceCommand() {
        return idVoiceCommand;
    }

    public void setIdVoiceCommand(int idVoiceCommand) {
        this.idVoiceCommand = idVoiceCommand;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getPerformedAction() {
        return performedAction;
    }

    public void setPerformedAction(String performedAction) {
        this.performedAction = performedAction;
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
