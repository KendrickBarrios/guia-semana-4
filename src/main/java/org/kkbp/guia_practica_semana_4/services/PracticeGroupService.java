package org.kkbp.guia_practica_semana_4.services;

import org.kkbp.guia_practica_semana_4.dto.PracticeGroupDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PracticeGroupService {
    private final List<PracticeGroupDTO> practiceGroups = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<PracticeGroupDTO> getAll() {
        return practiceGroups;
    }

    public Optional<PracticeGroupDTO> getById(Long id) {
        return practiceGroups.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public PracticeGroupDTO create(PracticeGroupDTO practiceGroup) {
        practiceGroup.setId(sequence.incrementAndGet());
        practiceGroups.add(practiceGroup);
        return practiceGroup;
    }

    public Optional<PracticeGroupDTO> update(Long id, PracticeGroupDTO data) {
        return getById(id).map(practiceGroup -> {
            practiceGroup.setName(data.getName());
            practiceGroup.setSize(data.getSize());
            practiceGroup.setRole(data.getRole());
            practiceGroup.setIsActive(data.getIsActive());
            return practiceGroup;
        });
    }

    public boolean delete(Long id) {
        return practiceGroups.removeIf(e -> e.getId().equals(id));
    }
}
