/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author esdra
 */
@Entity
@Table(name = "Filme")
public class Filme {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 30)
    private String titulo;

    @Column(length = 500)
    private String sinopse;

    @Column(length = 100, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLancamento;

    @Column(length = 10)
    private String faixaIndicativa;

    @Column(length = 100)
    private String categoria;

    @Column(length = 30)
    private double valorFilme;

    @Column(length = 5)
    private boolean disponivel;

    public Filme(String titulo, Date dataLancamento, String faixaIndicativa,String categoria, Double valorFilme, String sinopse, boolean disponivel) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.dataLancamento = dataLancamento;
        this.faixaIndicativa = faixaIndicativa;
        this.categoria = categoria;
        this.valorFilme = valorFilme;
        this.disponivel = disponivel;
    }

    @Deprecated
    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getFaixaIndicativa() {
        return faixaIndicativa;
    }

    public void setFaixaIndicativa(String faixaIndicativa) {
        this.faixaIndicativa = faixaIndicativa;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValorFilme() {
        return valorFilme;
    }

    public void setValorFilme(double valorFilme) {
        this.valorFilme = valorFilme;
    }

}
