package com.odontoprev.dto;

public class ProfissionalDTO {

    private Long id;
    private String nome;
    private String especialidade;
    private String telefone;

    public ProfissionalDTO() {}

    public ProfissionalDTO(Long id, String nome, String especialidade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
