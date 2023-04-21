package com.egorov.repository;

import com.egorov.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    /**
     * найти все факультеты университета
     */
    List<Faculty> findFacultyByUniversityId(Long universityId);

    /**
     * удалить все факультеты университета
     */
    void deleteFacultiesByUniversityId(Long universityId);
}