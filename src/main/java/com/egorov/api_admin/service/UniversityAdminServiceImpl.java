package com.egorov.api_admin.service;

import com.egorov.dto.UniversityDto;
import com.egorov.exception.UniversityNotFoundException;
import com.egorov.model.University;
import com.egorov.repository.UniversityRepository;
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
    public List<UniversityDto> getAll() {
        return toUniversityDtoList(universityRepository.findAll());
    }

    /**
     * получить университет по айди
     */
    @Override
    public UniversityDto getById(Long universityId) {
        return toUniversityDto(
                universityRepository.findById(universityId)
                        .orElseThrow(() -> new UniversityNotFoundException("University not found")));
    }

    /**
     * изменить университет по айди
     */
    @Override
    public UniversityDto updateById(Long universityId, University university) {
        University universityById = universityRepository.findById(universityId)
                .orElseThrow(() -> new UniversityNotFoundException("University not found"));

        universityById.setName(university.getName());
        universityById.setEmployeeId(university.getEmployeeId());
        universityById.setType(university.getType());
        universityById.setWorkStatus(university.getWorkStatus());

        return toUniversityDto(universityById);
    }

    /**
     * удалить университет по айди
     */
    @Override
    public void delete(Long universityId) {
        universityRepository.findById(universityId)
                .orElseThrow(() -> new UniversityNotFoundException("University not found"));
        universityRepository.deleteById(universityId);
    }

    /**
     * удалить все университеты
     */
    @Override
    public void deleteAll() {
        universityRepository.deleteAll();
    }
}
