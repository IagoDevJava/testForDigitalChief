package com.egorov.mapper;

import com.egorov.dto.UniversityDto;
import com.egorov.model.University;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * UniversityList to UniversityDtoList
     */
    public static List<UniversityDto> toUniversityDtoList(List<University> universities) {
        List<UniversityDto> result = new ArrayList<>();
        for (University university : universities) {
            result.add(toUniversityDto(university));
        }
        return result;
    }
}
