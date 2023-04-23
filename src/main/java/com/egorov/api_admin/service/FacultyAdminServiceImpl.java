package com.egorov.api_admin.service;

import com.egorov.dto.FacultyDto;
import com.egorov.exception.FacultyNotFoundException;
import com.egorov.model.Faculty;
import com.egorov.repository.FacultyRepository;
import com.egorov.repository.FacultyRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.egorov.mapper.FacultyMapper.toFacultyDto;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class FacultyAdminServiceImpl implements FacultyAdminService {
    private final FacultyRepository facultyRepository;
    private final UniversityAdminService universityAdminService;
    private final FacultyRepositoryImpl facultyRepositoryImpl;

    /**
     * создать факультет
     */
    @Transactional
    @Override
    public FacultyDto save(Faculty faculty, Long universityId) {
        universityAdminService.getById(universityId);
        faculty.setUniversityId(universityId);
        return toFacultyDto(facultyRepository.save(faculty));
    }

    /**
     * получить список факультетов
     */
    @Override
    @Transactional
    public List<FacultyDto> getAll(Long universityId) {
        universityAdminService.getById(universityId);
        List<FacultyDto> result = new ArrayList<>();
        for (Faculty faculty : facultyRepository.findFacultyByUniversityId(universityId)) {
            result.add(toFacultyDto(faculty));
        }

        return result;
    }

    /**
     * получить факультет по айди
     */
    @Override
    @Transactional
    public FacultyDto getById(Long universityId, Long facultyId) {
        universityAdminService.getById(universityId);
        return toFacultyDto(facultyRepository.findById(facultyId)
                .orElseThrow(() -> new FacultyNotFoundException("Faculty not found")));
    }

    /**
     * изменить факультет по айди
     */
    @Override
    @Transactional
    public FacultyDto updateById(Long facultyId, Faculty faculty, Long universityId) {
        universityAdminService.getById(universityId);
        return facultyRepositoryImpl.updateById(facultyId, faculty);
    }

    /**
     * удалить факультет по айди
     */
    @Override
    @Transactional
    public void delete(Long universityId, Long facultyId) {
        universityAdminService.getById(universityId);
        facultyRepository.deleteById(facultyId);
    }

    /**
     * удалить все факультеты университета
     */
    @Override
    @Transactional
    public void deleteAll(Long universityId) {
        universityAdminService.getById(universityId);
        facultyRepository.deleteFacultiesByUniversityId(universityId);
    }
}
