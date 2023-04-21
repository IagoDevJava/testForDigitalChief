package com.egorov.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "universities")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 256)
    String name;
    @Column(name = "rector_id")
    Long employeeId;
    @Column(nullable = false)
    String type;
    @Column(name = "work_status")
    String workStatus;

    public void setId(Long id) {
        if (id != null) this.id = id;
    }

    public void setName(String name) {
        if (name != null) this.name = name;
    }

    public void setEmployeeId(Long employeeId) {
        if (employeeId != null) this.employeeId = employeeId;
    }

    public void setType(String type) {
        if (type != null) this.type = type;
    }

    public void setWorkStatus(String workStatus) {
        if (workStatus != null) this.workStatus = workStatus;
    }
}
