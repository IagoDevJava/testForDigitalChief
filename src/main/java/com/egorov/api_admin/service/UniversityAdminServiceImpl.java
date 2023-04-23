package com.egorov.api_admin.service;

import com.egorov.dto.UniversityDto;
import com.egorov.exception.UniversityNotFoundException;
import com.egorov.model.University;
import com.egorov.repository.UniversityRepository;
import com.egorov.repository.UniversityRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.egorov.mapper.UniversityMapper.toUniversityDto;
import static com.egorov.mapper.UniversityMapper.toUniversityDtoList;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UniversityAdminServiceImpl implements UniversityAdminService {
    private final UniversityRepository universityRepository;
    private final UniversityRepositoryImpl universityRepositoryImpl;

    /**
     * создать университет
     */
    @Transactional
    @Override
    public UniversityDto save(University university) {
        return toUniversityDto(universityRepository.save(university));
    }

    /**
     * получить список университетов
     */
    @Override
    @Transactional
    public List<UniversityDto> getAll() {
        return toUniversityDtoList(universityRepository.findAll());
    }

    /**
     * получить университет по айди
     */
    @Override
    @Transactional
    public UniversityDto getById(Long universityId) {
        return toUniversityDto(
                universityRepository.findById(universityId)
                        .orElseThrow(() -> new UniversityNotFoundException("University not found")));
    }

    /**
     * изменить университет по айди
     */
    @Override
    @Transactional
    public UniversityDto updateById(Long universityId, University university) {
        return universityRepositoryImpl.update(universityId, university);
    }

    /**
     * удалить университет по айди
     */
    @Override
    @Transactional
    public void delete(Long universityId) {
        universityRepository.findById(universityId)
                .orElseThrow(() -> new UniversityNotFoundException("University not found"));
        universityRepository.deleteById(universityId);
    }

    /**
     * удалить все университеты
     */
    @Override
    @Transactional
    public void deleteAll() {
        universityRepository.deleteAll();
    }
}
