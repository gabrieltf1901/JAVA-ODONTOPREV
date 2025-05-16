package com.odontoprev.service;

import com.odontoprev.dto.UsuarioDTO;
import com.odontoprev.model.Usuario;
import com.odontoprev.repository.UsuarioRepository;
import com.odontoprev.config.EntityMapper;
import com.odontoprev.dto.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        return usuarioMapper.toDto(usuario);
    }

    public UsuarioDTO create(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario saved = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(saved);
    }

    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario existing = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
        usuarioMapper.partialUpdate(existing, dto);
        Usuario updated = usuarioRepository.save(existing);
        return usuarioMapper.toDto(updated);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void register(UsuarioDTO dto) {
    }

    public void salvar(Usuario usuario) {

    }
}
