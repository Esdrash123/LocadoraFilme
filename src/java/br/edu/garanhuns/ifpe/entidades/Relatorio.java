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
    @Column(length = 8, nullable = false)
    private Date dataEntrega;
    @Column(length = 30)
    private double valorMulta;
    @Column(length = 8)
    private Date dataEmprestimo;
    @Column(length = 20)
    private String tempoAtraso;

    public Relatorio(Cliente cliente, Date dataEntrega, double valorMulta, Date dataEmprestimo, String tempoAtraso) {
        this.cliente = cliente;
        this.dataEntrega = dataEntrega;
        this.valorMulta = valorMulta;
        this.dataEmprestimo = dataEmprestimo;
        this.tempoAtraso = tempoAtraso;
    }

    @Deprecated
    public Relatorio() {
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

    public String getTempoAtraso() {
        return tempoAtraso;
    }

    public void setTempoAtraso(String tempoAtraso) {
        this.tempoAtraso = tempoAtraso;
    }

}
