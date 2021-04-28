package com.example.JAX_Wildfly.model;

import java.util.Objects;

public class Filmes {
    private long id;
    private String titulo;
    private String categoria;
    private String duracao;
    private Cinema cinema;

    public Filmes(long id, String titulo, String categoria, String duracao, Cinema cinema) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.duracao = duracao;
        this.cinema = cinema;
    }

    public Filmes() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", duracao='" + duracao + '\'' +
                ", cinema=" + cinema +
                '}';
    }
}
