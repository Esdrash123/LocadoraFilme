/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.entidades.Relatorio;
import br.edu.garanhuns.ifpe.model.dao.ManagerDao;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioRelatorio;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "cRelatorio")
@SessionScoped

public class RelatorioController {

      private RepositorioGenerico<Relatorio, String> repositorioRelatorio = null;
    private Relatorio selectRelatorio;

    public RelatorioController() {
        this.repositorioRelatorio = new RepositorioRelatorio();
    }

    public String inserir(Relatorio relatorio) {

        
        if (((RepositorioRelatorio) this.repositorioRelatorio).recuperar(relatorio.getCod()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Relatorio com o mesmo codigo já cadastrado!"));
            return null;

        }

        this.repositorioRelatorio.inserir(relatorio);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("OK", "O Relatorio '" + relatorio.getCod()+ "' foi cadastrado com sucesso!"));

        return "Menu.xhtml";
    }

    public String atualizar(Relatorio relatorio) {
     

        if (((RepositorioRelatorio) this.repositorioRelatorio).recuperar(relatorio.getCod()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Filme como mesmo titulo já cadastrado!"));
            return null;

        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Parabéns", "o filme '" + relatorio.getCod() + "' , com faxetaria de '"
                        + relatorio.getDataEntrega()+ "' foi alterado com sucesso!"));

        this.repositorioRelatorio.alterar(relatorio);

        return "ApresentaFilme.xhtml";
    }

    public void deletar(Relatorio filme) {
        this.repositorioRelatorio.deletar(filme);
    }

    public Relatorio recuperaFilme(String cod) {
        return this.repositorioRelatorio.recuperar(cod);
    }

    public List<Relatorio> getRelatorio() {
        return this.repositorioRelatorio.recuperarTodos();
    }

    public Relatorio getSelectRelatorio() {
        return selectRelatorio;
    }

    public void setSelectFilme(Relatorio selectRelatorio) {
        this.selectRelatorio = selectRelatorio;
    }
}
