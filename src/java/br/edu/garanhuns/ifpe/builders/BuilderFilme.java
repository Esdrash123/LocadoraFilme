/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.builders;

import br.edu.garanhuns.ifpe.entidades.Filme;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author esdra
 */

@ManagedBean(name="bFilme")
@ViewScoped

public class BuilderFilme {
    private String titulo;
    private String sinopse;
    private Date dataLancamento;
    private String faixaIndicativa;
    private String categoria;
    private double valorFilme;
    private int estoque;

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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

 public Filme criarFilme (){
        return new Filme(titulo, dataLancamento,faixaIndicativa,categoria,valorFilme,sinopse,estoque);
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
