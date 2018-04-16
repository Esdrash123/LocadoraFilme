/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.builders;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.entidades.Aluguel;
import br.edu.garanhuns.ifpe.entidades.Filme;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "bAluguel")
@ViewScoped
public class BuilderAluguel {

    private List<Cliente> ListaClientes;

    private List<Filme> ListaFilmes;
    private String dataEntrega;
    private double valorEmprestimo;
    private double valorMulta;
    private String dataEmprestimo;
    private int cod;

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Aluguel criarAluguel() {
        return new Aluguel(cod, ListaClientes, ListaFilmes, dataEntrega, valorEmprestimo, dataEmprestimo);
    }

    public List<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public void setListaClientes(List<Cliente> ListaClientes) {
        this.ListaClientes = ListaClientes;
    }

    public List<Filme> getListaFilmes() {
        return ListaFilmes;
    }

    public void setListaFilmes(List<Filme> ListaFilmes) {
        this.ListaFilmes = ListaFilmes;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

}
