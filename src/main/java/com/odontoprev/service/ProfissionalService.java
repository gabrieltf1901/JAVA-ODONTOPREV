package com.odontoprev.service;

import com.odontoprev.dto.ProfissionalDTO;
import com.odontoprev.model.Profissional;
import com.odontoprev.repository.ProfissionalRepository;
import com.odontoprev.dto.ProfissionalMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;
    private final ProfissionalMapper profissionalMapper;

    public ProfissionalService(ProfissionalRepository profissionalRepository,
                               ProfissionalMapper profissionalMapper) {
        this.profissionalRepository = profissionalRepository;
        this.profissionalMapper = profissionalMapper;
    }

    public List<ProfissionalDTO> findAll() {
        return profissionalRepository.findAll().stream()
                .map(profissionalMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProfissionalDTO findById(Long id) {
        Profissional prof = profissionalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado: " + id));
        return profissionalMapper.toDto(prof);
    }

    public ProfissionalDTO create(ProfissionalDTO dto) {
        Profissional entity = profissionalMapper.toEntity(dto);
        Profissional saved = profissionalRepository.save(entity);
        return profissionalMapper.toDto(saved);
    }

    public ProfissionalDTO update(Long id, ProfissionalDTO dto) {
        Profissional existing = profissionalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado: " + id));
        profissionalMapper.partialUpdate(existing, dto);
        Profissional updated = profissionalRepository.save(existing);
        return profissionalMapper.toDto(updated);
    }

    public void delete(Long id) {
        profissionalRepository.deleteById(id);
    }
}
