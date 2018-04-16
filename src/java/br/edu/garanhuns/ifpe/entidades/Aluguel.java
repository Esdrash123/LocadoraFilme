/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author esdra
 */
@Entity
@Table(name = "Aluguel")
public class Aluguel {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Cliente> ListaClientes;
    @OneToMany
    private List<Filme> ListaFilmes;
    @Column(length = 100)
    private int cod;
    @Column(length = 100, nullable = false)
    private String dataEntrega;
    @Column(length = 30)
    private double valorEmprestimo;
    @Column(length = 30)
    private double valorMulta;
    @Column(length = 100)
    private String dataEmprestimo;

    public Aluguel(int cod, List<Cliente> ListaClientes, List<Filme> ListaFilmes, String dataEntrega, double valorEmprestimo, String dataEmprestimo) {
        this.ListaClientes = ListaClientes;
        this.ListaFilmes = ListaFilmes;
        this.dataEntrega = dataEntrega;
        this.valorEmprestimo = valorEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.cod = cod;
    }
    

    @Deprecated
    public Aluguel() {
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

}
