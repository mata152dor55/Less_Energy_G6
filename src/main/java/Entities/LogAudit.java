package Entities;

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
}
