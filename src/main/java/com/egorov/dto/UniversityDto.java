package com.egorov.dto;

import com.egorov.enumModel.TypeUniversity;
import com.egorov.enumModel.WorkStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UniversityDto {
    Long id;
    String name;
    Long employeeId;
    TypeUniversity type;
    WorkStatus workStatus;
}
