package com.egorov.api_admin.controller;

import com.egorov.api_admin.service.UniversityAdminService;
import com.egorov.dto.UniversityDto;
import com.egorov.model.University;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/universities")
public class UniversityAdminController {
    private final UniversityAdminService universityAdminService;

    /**
     * создать университет
     */
    @PostMapping()
    public ResponseEntity<UniversityDto> save(@RequestBody @Valid University university) {
        return ResponseEntity.ok(universityAdminService.save(university));
    }

    /**
     * получить список университетов
     */
    @GetMapping()
    public ResponseEntity<List<UniversityDto>> getUniversities() {
        return ResponseEntity.ok(universityAdminService.getAll());
    }

    /**
     * получить университет по айди
     */
    @GetMapping("/{universityId}")
    public ResponseEntity<UniversityDto> getUniversityById(@PositiveOrZero @PathVariable Long universityId) {
        return ResponseEntity.ok(universityAdminService.getById(universityId));
    }

    /**
     * изменить университет по айди
     */
    @PatchMapping("/{universityId}")
    public ResponseEntity<UniversityDto> updateUniversityById(@PositiveOrZero @PathVariable Long universityId,
                                                              @RequestBody University university) {
        return ResponseEntity.ok(universityAdminService.updateById(universityId, university));
    }

    /**
     * удалить университет по айди
     */
    @DeleteMapping("/{universityId}")
    public ResponseEntity<Void> deleteUniversityById(@PositiveOrZero @PathVariable Long universityId) {
        universityAdminService.delete(universityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * удалить все университеты
     */
    @DeleteMapping()
    public ResponseEntity<Void> deleteUniversities() {
        universityAdminService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
