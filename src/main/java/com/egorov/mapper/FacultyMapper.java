package com.egorov.mapper;

import com.egorov.dto.FacultyDto;
import com.egorov.model.Faculty;

public class FacultyMapper {
    /**
     * Faculty to FacultyDto
     */
    public static FacultyDto toFacultyDto(Faculty faculty) {
        return FacultyDto.builder()
                .id(faculty.getId())
                .name(faculty.getName())
                .employeeId(faculty.getEmployeeId())
                .universityId(faculty.getUniversityId())
                .workStatus(faculty.getWorkStatus())
                .build();
    }
}
