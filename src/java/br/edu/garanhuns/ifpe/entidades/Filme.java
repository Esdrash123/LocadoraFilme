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
    private String dataLancamento;

    @Column(length = 2)
    private int faixaIndicativa;

    @Column(length = 5)
    private boolean disponivel;

    public Filme(String titulo, String sinopse, String dataLancamento, int faixaIndicativa) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.dataLancamento = dataLancamento;
        this.faixaIndicativa = faixaIndicativa;
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

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getFaixaIndicativa() {
        return faixaIndicativa;
    }

    public void setFaixaIndicativa(int faixaIndicativa) {
        this.faixaIndicativa = faixaIndicativa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
