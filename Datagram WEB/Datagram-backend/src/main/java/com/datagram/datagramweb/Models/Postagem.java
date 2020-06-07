package com.datagram.datagramweb.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Postagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Autor_id")
    private Usuario autor;
    private String titulo;
    private String subtitulo;
    private String conteudo;
    private String date;
    private Integer curtida;


    @ElementCollection
    private Set<Integer> idsCurtida = new HashSet<>();// Para fazer o controle de quem curtiu o post, não permitindo a
                                                      // mesma pessoa curtir um post mais de uma vez.
    @ElementCollection
    @CollectionTable(name = "postagem_comentario", joinColumns = @JoinColumn(name = "postagem_id"))
    private List<Comentario> comentarios = new ArrayList<>();
    
    private Integer numComentarios;

    public Postagem(){
    }

    public Postagem(Integer id, Usuario autor, String titulo, String subtitulo, String conteudo, String date, Integer curtida) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.conteudo = conteudo;
        this.date = date;
        this.curtida = curtida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return autor;
    }

    public void setUsuario(Usuario usuario) {
        this.autor = usuario;
    }

    
    public String getTexto() {
        return conteudo;
    }

    public void setTexto(String texto) {
        this.conteudo = texto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdsCurtida(Integer idCurtida) {
        this.idsCurtida.add(idCurtida);
        this.curtida = idsCurtida.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Integer getCurtida() {
        return curtida;
    }

    @JsonIgnore
    public Set<Integer> getIdsCurtida() {
        return idsCurtida;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentario comentario) {
        this.comentarios.add(comentario);
        this.numComentarios++;
    }

    public Integer getNumComentarios() {
        return numComentarios;
    }

    public void setNumComentarios(Integer numComentarios) {
        this.numComentarios = numComentarios;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Postagem other = (Postagem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

    
}
