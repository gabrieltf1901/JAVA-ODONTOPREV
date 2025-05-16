package com.odontoprev.dto;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long id;
    private Long usuarioId;
    private Long profissionalId;
    private LocalDateTime dataHora;
    private String status;

    private String usuarioNome;
    private String profissionalNome;

    public ConsultaDTO() {}

    public ConsultaDTO(Long id, Long usuarioId, Long profissionalId, LocalDateTime dataHora, String status) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.profissionalId = profissionalId;
        this.dataHora = dataHora;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private UsuarioDTO usuario;
    public UsuarioDTO getUsuario() { return usuario; }
    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getProfissionalNome() {
        return profissionalNome;
    }

    public void setProfissionalNome(String profissionalNome) {
        this.profissionalNome = profissionalNome;
    }
}
