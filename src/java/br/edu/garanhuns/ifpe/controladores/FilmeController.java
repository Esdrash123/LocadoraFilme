/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Filme;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioFilme;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "cFilme")
@SessionScoped

public class FilmeController implements Serializable {

    private RepositorioGenerico<Filme, String> repositorioFilme = null;
    private Filme selectFilme;

    public FilmeController() {
        this.repositorioFilme = new RepositorioFilme();
    }

    public String inserir(Filme filme) {
        filme.setDisponivel(true);
        this.repositorioFilme.inserir(filme);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("OK!" + "O filme '" + filme.getTitulo() + "' foi cadastrado com sucesso!"));

        return "ApresentaFilmes.xhtml";
    }

    public String atualizar(Filme filme) {
        if (filme.getTitulo() != null) {
            FacesContext.getCurrentInstance().addMessage("form:inputNoTitule", new FacesMessage("Erro", "Já existe um filme com este titulo"));
            return null;
        }

        if (((RepositorioFilme) this.repositorioFilme).recuperarTitulo(filme.getTitulo()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Filme como mesmo titulo já cadastrado!"));
            return null;

        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Parabéns", "o filme '" + filme.getTitulo() + "' , com faxetaria de '"
                        + filme.getFaixaIndicativa() + "' foi alterado com sucesso!"));

        this.repositorioFilme.alterar(filme);

        return "ApresentaFilme.xhtml";
    }

    public void deletar(Filme filme) {
        this.repositorioFilme.deletar(filme);
    }

    public Filme recuperaFilme(String titulo) {
        return this.repositorioFilme.recuperar(titulo);
    }

    public List<Filme> getFilme() {
        return this.repositorioFilme.recuperarTodos();
    }

    public Filme getSelectFilme() {
        return selectFilme;
    }

    public void setSelectFilme(Filme selectFilme) {
        this.selectFilme = selectFilme;
    }
}
