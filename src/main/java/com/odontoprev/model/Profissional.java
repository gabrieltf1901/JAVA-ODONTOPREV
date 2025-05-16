package com.odontoprev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@Table(name = "PROFISSIONAL")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Profissional{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profissional")
    @SequenceGenerator(name = "seq_profissional", sequenceName = "SEQ_PROFISSIONAL", allocationSize = 1)
    @Column(name = "PROFISSIONAL_ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "ESPECIALIDADE", nullable = false, length = 100)
    private String especialidade;

    @Column(name = "TELEFONE", length = 20)
    private String telefone;

    public Profissional() {}
    public Profissional(String nome, String especialidade, String telefone) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
