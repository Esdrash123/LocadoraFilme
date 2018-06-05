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
    private String dataLancamento;
    private String faixaIndicativa;
    private boolean disponivel;

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

 public Filme criarFilme (){
        return new Filme(titulo, sinopse,dataLancamento,faixaIndicativa,disponivel);
    }
}
