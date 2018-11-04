package com.example.hellcat.pac1.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class BookItem extends RealmObject {
    private Integer identificador;      //De momento no cogemos identificador como primary Key porque no nos lo dan, lo generamos nosotros
    private String titulo;
    private String autor;
    private Date fecha;
    private String descripcion;
    private String url;

    /*
     * Creación de la clase con los procedimietos get y set de cada valor.
     */
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Creado el constructor básico sin parámetros. Lo necesita Realm
    public BookItem (){

    }
    /*
     *   Creación del constructor de bookitem entrando todos sus valores.
     */

    public BookItem(Integer id, String titulo, String autor, Date fecha, String descripcion, String url) {
        this.identificador = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.url = url;
    }
}
