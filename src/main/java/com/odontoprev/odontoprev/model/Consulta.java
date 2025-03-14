package com.odontoprev.odontoprev.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONSULTA_OP")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_HORA_CONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraConsulta;

    @Column(name = "TIPO_PROCEDIMENTO")
    private String tipoProcedimento;

    @Column(name = "VALOR_CONSULTA")
    private Double valorConsulta;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROFISSIONAL_OP_ID")
    private Long profissionalOpId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public String getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(String tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProfissionalOpId() {
        return profissionalOpId;
    }

    public void setProfissionalOpId(Long profissionalOpId) {
        this.profissionalOpId = profissionalOpId;
    }
}
