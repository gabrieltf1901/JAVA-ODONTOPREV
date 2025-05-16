package com.odontoprev.service;

import com.odontoprev.dto.ConsultaDTO;
import com.odontoprev.model.Consulta;
import com.odontoprev.model.Status;
import com.odontoprev.model.Usuario;
import com.odontoprev.model.Profissional;
import com.odontoprev.repository.ConsultaRepository;
import com.odontoprev.repository.UsuarioRepository;
import com.odontoprev.repository.ProfissionalRepository;
import com.odontoprev.dto.ConsultaMapper;
import com.odontoprev.messaging.ConsultaProducer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProfissionalRepository profissionalRepository;
    private final ConsultaMapper consultaMapper;
    private final ConsultaProducer consultaProducer;

    public ConsultaService(ConsultaRepository consultaRepository,
                           UsuarioRepository usuarioRepository,
                           ProfissionalRepository profissionalRepository,
                           ConsultaMapper consultaMapper,
                           ConsultaProducer consultaProducer) {
        this.consultaRepository = consultaRepository;
        this.usuarioRepository = usuarioRepository;
        this.profissionalRepository = profissionalRepository;
        this.consultaMapper = consultaMapper;
        this.consultaProducer = consultaProducer;
    }

    public List<ConsultaDTO> findAll() {
        return consultaRepository.findAll().stream()
                .map(consultaMapper::toDto)
                .collect(Collectors.toList());
    }

    public ConsultaDTO findById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada: " + id));
        return consultaMapper.toDto(consulta);
    }

    public ConsultaDTO schedule(ConsultaDTO dto) {

        Consulta entity = consultaMapper.toEntity(dto);


        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + dto.getUsuarioId()));
        Profissional profissional = profissionalRepository.findById(dto.getProfissionalId())
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado: " + dto.getProfissionalId()));
        entity.setUsuario(usuario);
        entity.setProfissional(profissional);


        entity.setStatus(Status.AGENDADA);


        Consulta saved = consultaRepository.save(entity);


        consultaProducer.sendConsultaAgendada(saved);

        return consultaMapper.toDto(saved);
    }

    public ConsultaDTO update(Long id, ConsultaDTO dto) {
        Consulta existing = consultaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada: " + id));

        // apenas atualiza campos permitidos
        consultaMapper.partialUpdate(existing, dto);
        Consulta updated = consultaRepository.save(existing);
        return consultaMapper.toDto(updated);
    }

    public void cancel(Long id) {
        Consulta existing = consultaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada: " + id));

        existing.setStatus(Status.CANCELADA);
        consultaRepository.save(existing);

        consultaProducer.sendConsultaCancelada(existing);
    }

    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<ConsultaDTO> buscarTodas() {
        return consultaRepository.findAll().stream().map(ent -> {
            ConsultaDTO dto = new ConsultaDTO();
            dto.setId(ent.getId());
            dto.setUsuarioId(ent.getUsuario().getId());
            dto.setProfissionalId(ent.getProfissional().getId());
            dto.setDataHora(ent.getDataHora());
            dto.setUsuarioNome(ent.getUsuario().getNome());
            dto.setProfissionalNome(ent.getProfissional().getNome());
            return dto;
        }).toList();
    }
}
