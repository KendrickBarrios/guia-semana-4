package org.kkbp.guia_practica_semana_4.services;

import org.kkbp.guia_practica_semana_4.dto.SubjectDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SubjectService {
    private final List<SubjectDTO> subjects = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<SubjectDTO> getAll() {
        return subjects;
    }

    public Optional<SubjectDTO> getById(Long id) {
        return subjects.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public SubjectDTO create(SubjectDTO subject) {
        subject.setId(sequence.incrementAndGet());
        subjects.add(subject);
        return subject;
    }

    public Optional<SubjectDTO> update(Long id, SubjectDTO data) {
        return getById(id).map(subject -> {
            subject.setName(data.getName());
            subject.setAbbreviation(data.getAbbreviation());
            subject.setPracticeHours(data.getPracticeHours());
            subject.setRotates(data.getRotates());
            subject.setIsActive(data.getIsActive());
            return subject;
        });
    }

    public boolean delete(Long id) {
        return subjects.removeIf(e -> e.getId().equals(id));
    }
}
