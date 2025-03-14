package com.odontoprev.odontoprev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PROFISSIONAL_OP")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CRM")
    private String crm;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "ESPECIALIDADE_ODONTOLOGICA")
    private String especialidadeOdontologica;

    @Column(name = "CONTATO")
    private String contato;

    @Column(name = "HORARIO_DE_CONSULTA")
    private String horarioDeConsulta;

    @Column(name = "AVALIACAO_QUALIDADE_SERVICO")
    private String avaliacaoQualidadeServico;

    @Column(name = "PACIENTE_OP_ID")
    private Long pacienteOpId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEspecialidadeOdontologica() {
        return especialidadeOdontologica;
    }

    public void setEspecialidadeOdontologica(String especialidadeOdontologica) {
        this.especialidadeOdontologica = especialidadeOdontologica;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHorarioDeConsulta() {
        return horarioDeConsulta;
    }

    public void setHorarioDeConsulta(String horarioDeConsulta) {
        this.horarioDeConsulta = horarioDeConsulta;
    }

    public String getAvaliacaoQualidadeServico() {
        return avaliacaoQualidadeServico;
    }

    public void setAvaliacaoQualidadeServico(String avaliacaoQualidadeServico) {
        this.avaliacaoQualidadeServico = avaliacaoQualidadeServico;
    }

    public Long getPacienteOpId() {
        return pacienteOpId;
    }

    public void setPacienteOpId(Long pacienteOpId) {
        this.pacienteOpId = pacienteOpId;
    }
}

