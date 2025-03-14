package com.odontoprev.odontoprev.service;

import com.odontoprev.odontoprev.model.Profissional;
import com.odontoprev.odontoprev.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<Profissional> listarTodos() {
        return profissionalRepository.findAll();
    }

    public Optional<Profissional> buscarPorId(Long id) {
        return profissionalRepository.findById(id);
    }

    public Profissional salvar(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    public void remover(Long id) {
        profissionalRepository.deleteById(id);
    }
}

