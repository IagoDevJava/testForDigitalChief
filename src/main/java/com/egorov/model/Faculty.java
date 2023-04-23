package com.egorov.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "faculties")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, length = 256)
    String name;
    @Column(name = "dean_id")
    Long employeeId;
    @Column(name = "work_status")
    String workStatus;
    @Column(name = "university_id", nullable = false)
    Long universityId;

    public void setName(String name) {
        if (name != null) this.name = name;
    }

    public void setEmployeeId(Long employeeId) {
        if (employeeId != null) this.employeeId = employeeId;
    }

    public void setWorkStatus(String workStatus) {
        if (workStatus != null) this.workStatus = workStatus;
    }

    public void setUniversityId(Long universityId) {
        if (universityId != null) this.universityId = universityId;
    }
}
