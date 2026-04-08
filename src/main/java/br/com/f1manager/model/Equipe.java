package br.com.f1manager.model;

public class Equipe {

    private String id;

    private String nome;

    private String nacionalidade;


    public Equipe() {

    }

    public Equipe(String id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome  + " (" + nacionalidade + ")";
    }

}
