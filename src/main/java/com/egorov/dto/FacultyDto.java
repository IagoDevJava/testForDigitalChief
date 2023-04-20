package com.egorov.dto;

import com.egorov.enumModel.WorkStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacultyDto {
    Long id;
    String name;
    Long employeeId;
    WorkStatus workStatus;
    Long universityId;
}
