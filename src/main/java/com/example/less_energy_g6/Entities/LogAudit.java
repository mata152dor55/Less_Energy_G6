package com.example.less_energy_g6.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "LogAudit")
public class LogAudit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idLog;

    @Column (name = "tableName", length = 100, nullable = false)
    private String tableName;

    @Column (name = "idRecord", nullable = false)
    private int idRecord;

    @Column (name = "action", length = 20, nullable = false)
    private String action;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "oldValues",columnDefinition = "jsonb")
    private Map<String, Object> oldValues;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "newValues", columnDefinition = "jsonb")
    private Map<String, Object> newValues;

    @Column (name = "idUserAction")
    private int idUserAction;

    @Column (name = "dateTimeAction")
    private LocalDateTime actionDateTime;

    @Column (name = "sourceIP", length = 50)
    private String sourceIP;

    public LogAudit() {
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, Object> getOldValues() {
        return oldValues;
    }

    public void setOldValues(Map<String, Object> oldValues) {
        this.oldValues = oldValues;
    }

    public Map<String, Object> getNewValues() {
        return newValues;
    }

    public void setNewValues(Map<String, Object> newValues) {
        this.newValues = newValues;
    }

    public int getIdUserAction() {
        return idUserAction;
    }

    public void setIdUserAction(int idUserAction) {
        this.idUserAction = idUserAction;
    }

    public LocalDateTime getActionDateTime() {
        return actionDateTime;
    }

    public void setActionDateTime(LocalDateTime actionDateTime) {
        this.actionDateTime = actionDateTime;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public void setSourceIP(String sourceIP) {
        this.sourceIP = sourceIP;
    }
}
