
package com.gov.covid.controlevacina.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotEmpty(message = "O campo nome não pode ser vazio ou nulo!")
    private String nome;

    @Column(unique = true)
    @NotEmpty(message = "O campo E-mail não pode ser vazio ou nulo!")
    @Email(message = "O campo E-mail não é válido!")
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "O campo CPF não pode ser vazio ou nulo!")
    @CPF(message = "O campo CPF não é válido!")
    private  String CPF;

    @NotNull(message = "O campo Data de Nascimento não pode ser vazio ou nulo!")
    @JsonFormat(pattern ="dd/MM/yyyy")
    private Date dataNascimento;

    @Column(name = "data_cadastro", updatable=false)
    @JsonFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataCadastro;



    public Usuario() {
    }

    public Usuario(Long id,  String nome, String email, String CPF,  Date dataNascimento, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // METODO QUE VAI SER EXECUTADO ANTES E INSERIR A DATA ATUAL EM DT CADASTRO
    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }

}
