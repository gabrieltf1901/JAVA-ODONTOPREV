package com.odontoprev.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CONSULTA")
public class Consulta{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_consulta")
    @SequenceGenerator(name = "seq_consulta", sequenceName = "SEQ_CONSULTA", allocationSize = 1)
    @Column(name = "CONSULTA_ID")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 20, nullable = false)
    private Status status;

    public Consulta() {}
    public Consulta(Usuario usuario, Profissional profissional, LocalDateTime dataHora, Status status) {
        this.usuario = usuario;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
