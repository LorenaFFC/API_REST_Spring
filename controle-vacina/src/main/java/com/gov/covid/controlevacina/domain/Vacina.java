package com.gov.covid.controlevacina.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotEmpty(message = "O campo nome não pode ser vazio ou nulo!")
    private String nome;

    @Column(updatable=false)
    @JsonFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataCadastro;

    @OneToOne
    @JoinColumn(name="Fk_Usuario",  referencedColumnName ="id", nullable = false, unique = true)
    private Usuario usuario;


    public Vacina() {
    }

    public Vacina(Long id, String nome, LocalDate dataCadastro, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.usuario = usuario;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // METODO QUE VAI SER EXECUTADO ANTES E INSERIR A DATA ATUAL EM DT CADASTRO
    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }
}
