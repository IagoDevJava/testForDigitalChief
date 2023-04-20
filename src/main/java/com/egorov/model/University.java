package com.egorov.model;

import com.egorov.enumModel.TypeUniversity;
import com.egorov.enumModel.WorkStatus;
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
    TypeUniversity type;
    @Column(name = "work_status")
    WorkStatus workStatus;

    public void setName(String name) {
        if (name != null) this.name = name;
    }

    public void setEmployeeId(Long employeeId) {
        if (employeeId != null) this.employeeId = employeeId;
    }

    public void setType(TypeUniversity type) {
        if (type != null) this.type = type;
    }

    public void setWorkStatus(WorkStatus workStatus) {
        if (workStatus != null) this.workStatus = workStatus;
    }
}
