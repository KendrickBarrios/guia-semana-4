package org.kkbp.guia_practica_semana_4.controllers;

import jakarta.validation.Valid;
import org.kkbp.guia_practica_semana_4.dto.PracticeGroupDTO;
import org.kkbp.guia_practica_semana_4.services.PracticeGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/practice-groups")
public class PracticeGroupController {
    private final PracticeGroupService service;

    public PracticeGroupController(PracticeGroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PracticeGroupDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(this::buildNotFoundResponse);
    }


    public ResponseEntity<Map<String, String>> buildNotFoundResponse() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensaje", "Grupo de prácticas no encontrado"));
    }

    @PostMapping
    public ResponseEntity<PracticeGroupDTO> create(@Valid @RequestBody PracticeGroupDTO practiceGroup) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(practiceGroup));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody PracticeGroupDTO practiceGroup) {
        return service.update(id, practiceGroup)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(this::buildNotFoundResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return buildNotFoundResponse();
        }
        return ResponseEntity.ok(Map.of("mensaje", "Grupo de prácticas eliminado correctamente"));
    }
}
