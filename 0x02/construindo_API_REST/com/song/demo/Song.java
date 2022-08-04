package com.song.demo;

import java.util.Objects;

public class Song {
    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Song() {
    }

    public Song(Integer id, String nome, String artista, String album, String anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.album, this.artista, this.anoLancamento);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Song song = (Song) obj;
        return this.nome.equals(song.getNome()) && this.artista.equals(song.getArtista())
                && this.album.equals(song.getAlbum()) && this.anoLancamento.equals(song.getAnoLancamento());
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nArtista: %s\nAlbum: %s\nAno Lancamento: %s",
                this.nome, this.artista, this.album, this.anoLancamento);
    }
}

