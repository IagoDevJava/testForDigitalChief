package com.egorov.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacultyDto {
    Long id;
    String name;
    Long employeeId;
    String workStatus;
    Long universityId;
}
