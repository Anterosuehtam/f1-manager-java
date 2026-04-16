package com.br.f1_manager.model;

import java.time.LocalDate;

public class Piloto {

    private String id;
    private String nome;
    private String sobrenome;
    private int numero;
    private String sigla;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private String equipeAtual;

    public Piloto() {
    }

    public Piloto(String id, String nome, String sobrenome, int numero, String sigla, String nacionalidade, LocalDate dataNascimento, String equipeAtual) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
        this.sigla = sigla;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.equipeAtual = equipeAtual;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEquipeAtual() { return equipeAtual; }
    public void setEquipeAtual(String equipeAtual) { this.equipeAtual = equipeAtual; }

    @Override
    public String toString() {
        return "[" + sigla + "] " + nome + " " + sobrenome + " - Nº " + numero + " (" + nacionalidade + ")";
    }
}
