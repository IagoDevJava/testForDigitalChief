package com.egorov.repository;

import com.egorov.dto.FacultyDto;
import com.egorov.exception.FacultyNotFoundException;
import com.egorov.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.egorov.mapper.FacultyMapper.toFacultyDto;

@Component
public class FacultyRepositoryImpl {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyRepositoryImpl(@Lazy FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    /**
     * изменить факультет по айди
     */
    public FacultyDto updateById(Long facultyId, Faculty faculty) {
        Faculty facultyById = facultyRepository
                .findById(facultyId).orElseThrow(() -> new FacultyNotFoundException("Faculty not found"));

        facultyById.setName(faculty.getName());
        facultyById.setUniversityId(faculty.getUniversityId());
        facultyById.setEmployeeId(faculty.getEmployeeId());
        facultyById.setWorkStatus(faculty.getWorkStatus());

        Faculty save = facultyRepository.save(facultyById);
        return toFacultyDto(save);
    }
}
