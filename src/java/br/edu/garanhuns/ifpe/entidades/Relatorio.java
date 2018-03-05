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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author esdra
 */
@Entity
@Table(name = "Relatorio")
public class Relatorio {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Cliente cliente;
    @Column(length = 100)
    private int cod;
    @Column(length = 100, nullable = false)
    private Date dataEntrega;
    @Column(length = 30)
    private double valorEmprestimo;
    @Column(length = 30)
    private double valorMulta;
    @Column(length = 100)
    private Date dataEmprestimo;

    public Relatorio(int cod, Cliente cliente, Date dataEntrega, double valorEmprestimo, double valorMulta, Date dataEmprestimo) {
        this.cliente = cliente;
        this.dataEntrega = dataEntrega;
        this.valorEmprestimo = valorEmprestimo;
        this.valorMulta = valorMulta;
        this.dataEmprestimo = dataEmprestimo;
        this.cod = cod;
    }

    @Deprecated
    public Relatorio() {
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

}
