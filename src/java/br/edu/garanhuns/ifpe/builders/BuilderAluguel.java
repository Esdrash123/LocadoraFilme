/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.builders;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.entidades.Aluguel;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "bAluguel")
@ViewScoped
public class BuilderAluguel {

    private Cliente cliente;
    private Date dataEntrega;
    private double valorEmprestimo;
    private double valorMulta;
    private Date dataEmprestimo;
    private int cod;

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


    public Aluguel criarRelatorio() {
        return new Aluguel(cod, cliente, dataEntrega, valorEmprestimo, valorMulta, dataEmprestimo);
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
