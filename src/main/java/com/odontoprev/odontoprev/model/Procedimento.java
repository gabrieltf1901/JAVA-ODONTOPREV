package com.odontoprev.odontoprev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PROCEDIMENTO_OP")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO_UNITARIO")
    private Double precoUnitario;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "CONSULTA_OP_ID")
    private Long consultaOpId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getConsultaOpId() {
        return consultaOpId;
    }

    public void setConsultaOpId(Long consultaOpId) {
        this.consultaOpId = consultaOpId;
    }
}

