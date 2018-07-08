/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.builders.BuilderAluguel;
import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.entidades.Aluguel;
import br.edu.garanhuns.ifpe.entidades.Filme;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioAluguel;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
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

public class AluguelController implements Serializable {

    private RepositorioGenerico<Aluguel, String> repositorioAluguel = null;
    private Aluguel selectAluguel;

    public AluguelController() {
        this.repositorioAluguel = new RepositorioAluguel();
    }

    public String inserir(Aluguel aluguel) {

        aluguel.setValorEmprestimo(valorAluguel(aluguel.getListaFilmes()));
        
        this.repositorioAluguel.inserir(aluguel);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("OK! O Aluguel  foi cadastrado com sucesso!"));

        return "ApresentaAluguel.xhtml";
    }

    public String atualizar(Aluguel aluguel) {

        this.repositorioAluguel.alterar(aluguel);

        return "ApresentaAluguel.xhtml";
    }

    public int calcularDias(BuilderAluguel aluguel) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date data1 = aluguel.getDataEmprestimo();
        Date data2 = aluguel.getDataEntrega();

        long diffInMillies = Math.abs(data2.getTime() - data1.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int) diff;
    }

    public void deletar(Aluguel aluguel) {
        this.repositorioAluguel.deletar(aluguel);
    }

    public Aluguel recuperaFilme(String cod) {
        return this.repositorioAluguel.recuperar(cod);
    }

    public List<Aluguel> getAluguel() {
        return this.repositorioAluguel.recuperarTodos();
    }

    public Aluguel getSelectAluguel() {
        return selectAluguel;
    }

    public void setSelectFilme(Aluguel selectAluguel) {
        this.selectAluguel = selectAluguel;
    }

    public double valorAluguel(List<Filme> listaFilmes) {
        double valor = 0;
        for (Filme f : listaFilmes) {
            valor += f.getValorFilme();
        }
        return valor;
    }

   
}
