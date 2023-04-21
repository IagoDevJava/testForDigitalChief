package com.egorov.repository;

import com.egorov.dto.UniversityDto;
import com.egorov.exception.UniversityNotFoundException;
import com.egorov.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static com.egorov.mapper.UniversityMapper.toUniversityDto;

@Component
public class UniversityRepositoryImpl {
    private final UniversityRepository repository;

    @Autowired
    public UniversityRepositoryImpl(@Lazy UniversityRepository repository) {
        this.repository = repository;
    }

    /**
     * изменить университет по айди
     */
    public UniversityDto update(Long universityId, University university) {
        University universityById = repository.findById(universityId)
                .orElseThrow(() -> new UniversityNotFoundException("University not found"));

        universityById.setName(university.getName());
        universityById.setEmployeeId(university.getEmployeeId());
        universityById.setType(university.getType());
        universityById.setWorkStatus(university.getWorkStatus());

        University save = repository.save(universityById);

        return toUniversityDto(save);
    }
}
