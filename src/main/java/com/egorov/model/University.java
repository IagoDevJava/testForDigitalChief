package com.egorov.model;

import com.egorov.enumModel.TypeUniversity;
import com.egorov.enumModel.WorkStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
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
}
