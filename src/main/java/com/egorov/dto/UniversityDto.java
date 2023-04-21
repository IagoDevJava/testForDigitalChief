package com.egorov.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UniversityDto {
    Long id;
    String name;
    Long employeeId;
    String type;
    String workStatus;
}
