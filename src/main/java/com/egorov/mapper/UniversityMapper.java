package com.egorov.mapper;

import com.egorov.dto.UniversityDto;
import com.egorov.model.University;

public class UniversityMapper {
    /**
     * University to UniversityDto
     */
    public static UniversityDto toUniversityDto(University university) {
        return UniversityDto.builder()
                .id(university.getId())
                .name(university.getName())
                .employeeId(university.getEmployeeId())
                .type(university.getType())
                .workStatus(university.getWorkStatus())
                .build();
    }
}
