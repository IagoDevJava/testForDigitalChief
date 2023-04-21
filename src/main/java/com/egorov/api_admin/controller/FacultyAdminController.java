package com.egorov.api_admin.controller;

import com.egorov.api_admin.service.FacultyAdminService;
import com.egorov.dto.FacultyDto;
import com.egorov.model.Faculty;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/universities/{universityId}/faculties")
public class FacultyAdminController {
    private final FacultyAdminService facultyAdminService;

    /**
     * создать факультет
     */
    @PostMapping()
    public ResponseEntity<FacultyDto> save(@RequestBody @Valid Faculty faculty,
                                           @PositiveOrZero @PathVariable Long universityId) {
        return new ResponseEntity<>(facultyAdminService.save(faculty, universityId), HttpStatus.OK);
    }

    /**
     * получить список факультетов
     */
    @GetMapping()
    public ResponseEntity<List<FacultyDto>> getFaculties(@PositiveOrZero @PathVariable Long universityId) {
        return new ResponseEntity<>(facultyAdminService.getAll(universityId), HttpStatus.OK);
    }

    /**
     * получить факультет по айди
     */
    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyDto> getFacultyById(@PositiveOrZero @PathVariable Long facultyId,
                                                     @PositiveOrZero @PathVariable Long universityId) {
        return new ResponseEntity<>(facultyAdminService.getById(universityId, facultyId), HttpStatus.OK);
    }

    /**
     * изменить факультет по айди
     */
    @PatchMapping("/{facultyId}")
    public ResponseEntity<FacultyDto> updateFacultyById(@PositiveOrZero @PathVariable Long facultyId,
                                                        @RequestBody Faculty faculty,
                                                        @PositiveOrZero @PathVariable Long universityId) {
        return new ResponseEntity<>(facultyAdminService
                .updateById(facultyId, faculty, universityId), HttpStatus.OK);
    }

    /**
     * удалить факультет по айди
     */
    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> deleteFacultyById(@PositiveOrZero @PathVariable Long facultyId,
                                                  @PositiveOrZero @PathVariable Long universityId) {
        facultyAdminService.delete(universityId, facultyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * удалить все факультеты
     */
    @DeleteMapping()
    public ResponseEntity<Void> deleteFaculties(@PositiveOrZero @PathVariable Long universityId) {
        facultyAdminService.deleteAll(universityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
