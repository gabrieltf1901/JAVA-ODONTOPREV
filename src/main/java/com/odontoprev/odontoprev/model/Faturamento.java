package com.odontoprev.odontoprev.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "FATURAMENTO_OP")
public class Faturamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROCEDIMENTO_OP_ID")
    private Long procedimentoOpId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProcedimentoOpId() {
        return procedimentoOpId;
    }

    public void setProcedimentoOpId(Long procedimentoOpId) {
        this.procedimentoOpId = procedimentoOpId;
    }
}

