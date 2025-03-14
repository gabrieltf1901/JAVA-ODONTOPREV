package com.odontoprev.odontoprev.service;

import com.odontoprev.odontoprev.model.Procedimento;
import com.odontoprev.odontoprev.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    public List<Procedimento> listarTodos() {
        return procedimentoRepository.findAll();
    }

    public Optional<Procedimento> buscarPorId(Long id) {
        return procedimentoRepository.findById(id);
    }

    public Procedimento salvar(Procedimento procedimento) {
        return procedimentoRepository.save(procedimento);
    }

    public void remover(Long id) {
        procedimentoRepository.deleteById(id);
    }
}
