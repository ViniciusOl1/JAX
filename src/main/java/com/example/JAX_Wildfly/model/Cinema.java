package com.example.JAX_Wildfly.model;

import java.util.Objects;

public class Cinema {
    private long id;
    private String titulo;
    private String endereco;

    public Cinema(long id, String titulo, String endereco) {
        this.id = id;
        this.titulo = titulo;
        this.endereco = endereco;
    }

    public Cinema() {

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinema)) return false;
        Cinema cinema = (Cinema) o;
        return id == cinema.id && Objects.equals(titulo, cinema.titulo) && Objects.equals(endereco, cinema.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, endereco);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
