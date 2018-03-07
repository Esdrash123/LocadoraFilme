/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.entidades.Aluguel;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioAluguel;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "cAluguel")
@SessionScoped

public class AluguelController {

      private RepositorioGenerico<Aluguel, String> repositorioRelatorio = null;
    private Aluguel selectAluguel;

    public AluguelController() {
        this.repositorioRelatorio = new RepositorioAluguel();
    }

    public String inserir(Aluguel relatorio) {


        this.repositorioRelatorio.inserir(relatorio);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("OK", "O Relatorio '" + relatorio.getCod()+ "' foi cadastrado com sucesso!"));

        return "ApresentaAlugel.xhtml";
    }

    public String atualizar(Aluguel aluguel) {
     

        if (((RepositorioAluguel) this.repositorioRelatorio).recuperar(aluguel.getCod()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Filme como mesmo titulo já cadastrado!"));
            return null;

        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Parabéns", "o filme '" + aluguel.getCod() + "' , com faxetaria de '"
                        + aluguel.getDataEntrega()+ "' foi alterado com sucesso!"));

        this.repositorioRelatorio.alterar(aluguel);

        return "ApresentaFilmes.xhtml";
    }

    public void deletar(Aluguel filme) {
        this.repositorioRelatorio.deletar(filme);
    }

    public Aluguel recuperaFilme(String cod) {
        return this.repositorioRelatorio.recuperar(cod);
    }

    public List<Aluguel> getAluguel() {
        return this.repositorioRelatorio.recuperarTodos();
    }

    public Aluguel getSelectAluguel() {
        return selectAluguel;
    }

    public void setSelectFilme(Aluguel selectAluguel) {
        this.selectAluguel = selectAluguel;
    }
}
