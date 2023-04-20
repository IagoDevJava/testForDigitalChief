package com.egorov.api_admin.service;

import com.egorov.dto.UniversityDto;
import com.egorov.model.University;

import java.util.List;

public interface UniversityAdminService {
    /**
     * создать университет
     */
    UniversityDto save(University university);

    /**
     * получить список университетов
     */
    List<UniversityDto> getAll();

    /**
     * получить университет по айди
     */
    UniversityDto getById(Long universityId);

    /**
     * изменить университет по айди
     */
    UniversityDto updateById(Long universityId, University university);

    /**
     * удалить университет по айди
     */
    void delete(Long universityId);

    /**
     * удалить все университеты
     */
    void deleteAll();
}
