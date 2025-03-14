package com.odontoprev.odontoprev.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PACIENTE_OP")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "CONTATO")
    private String contato;

    @Column(name = "PLANO_DE_SAUDE")
    private String planoDeSaude;

    @Column(name = "HISTORICO_MEDICO")
    private String historicoMedico;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(String planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }
}
