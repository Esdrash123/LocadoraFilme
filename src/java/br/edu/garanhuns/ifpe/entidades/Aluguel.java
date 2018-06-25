/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

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

    @OneToOne
    private Cliente cliente;
    @ManyToMany
    private List<Filme> ListaFilmes;
    @Column(length = 100)
    private int cod;
    @Column(length = 100, nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrega;
    @Column(length = 30)
    private double valorEmprestimo;
    @Column(length = 30)
    private double valorMulta;
    @Column(length = 100)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmprestimo;

    public Aluguel(Cliente cliente, List<Filme> ListaFilmes, Date dataEmprestimo, Date dataEntrega, double valorEmprestimo) {
        this.cliente = cliente;
        this.ListaFilmes = ListaFilmes;
        this.dataEntrega = dataEntrega;
        this.valorEmprestimo = valorEmprestimo;
        this.dataEmprestimo = dataEmprestimo;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Filme> getListaFilmes() {
        return ListaFilmes;
    }

    public void setListaFilmes(List<Filme> ListaFilmes) {
        this.ListaFilmes = ListaFilmes;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getFilmes() {
        String ret = "";
        for (Filme f : ListaFilmes) {
            ret += f.getTitulo() + "\n";
        }
        return ret;
    }

}
