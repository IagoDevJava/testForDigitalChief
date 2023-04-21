package com.egorov.api_admin.service;

import com.egorov.dto.FacultyDto;
import com.egorov.model.Faculty;

import java.util.List;

public interface FacultyAdminService {
    /**
     * создать факультет
     */
    FacultyDto save(Faculty faculty, Long universityId);

    /**
     * получить список факультетов
     */
    List<FacultyDto> getAll(Long universityId);

    /**
     * получить факультет по айди
     */
    FacultyDto getById(Long universityId, Long facultyId);

    /**
     * изменить факультет по айди
     */
    FacultyDto updateById(Long facultyId, Faculty faculty, Long universityId);

    /**
     * удалить факультет по айди
     */
    void delete(Long universityId, Long facultyId);

    /**
     * удалить все факультеты
     */
    void deleteAll(Long universityId);
}
