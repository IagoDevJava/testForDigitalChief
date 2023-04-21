package com.egorov.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
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
}
