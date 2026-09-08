package org.kkbp.guia_practica_semana_4.controllers;

import jakarta.validation.Valid;
import org.kkbp.guia_practica_semana_4.dto.SubjectDTO;
import org.kkbp.guia_practica_semana_4.services.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAll() {
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
                .body(Map.of("mensaje", "Asignatura no encontrada"));
    }

    @PostMapping
    public ResponseEntity<SubjectDTO> create(@Valid @RequestBody SubjectDTO subject) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody SubjectDTO subject) {
        return service.update(id, subject)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(this::buildNotFoundResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return buildNotFoundResponse();
        }
        return ResponseEntity.ok(Map.of("mensaje", "Asignatura eliminada correctamente"));
    }
}
