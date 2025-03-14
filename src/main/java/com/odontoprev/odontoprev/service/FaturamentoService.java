package com.odontoprev.odontoprev.service;

import com.odontoprev.odontoprev.model.Faturamento;
import com.odontoprev.odontoprev.repository.FaturamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturamentoService {

    @Autowired
    private FaturamentoRepository faturamentoRepository;

    public List<Faturamento> listarTodos() {
        return faturamentoRepository.findAll();
    }

    public Optional<Faturamento> buscarPorId(Long id) {
        return faturamentoRepository.findById(id);
    }

    public Faturamento salvar(Faturamento faturamento) {
        return faturamentoRepository.save(faturamento);
    }

    public void remover(Long id) {
        faturamentoRepository.deleteById(id);
    }
}

