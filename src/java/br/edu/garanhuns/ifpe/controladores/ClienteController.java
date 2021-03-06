/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioCliente;
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
@ManagedBean(name = "cCliente")
@SessionScoped
public class ClienteController implements Serializable {

    private RepositorioGenerico<Cliente, String> repositorioCliente = null;
    private Cliente selectCliente;

    public ClienteController() {
        this.repositorioCliente = new RepositorioCliente();
    }

    public String inserir(Cliente cliente) {

        if (((RepositorioCliente) this.repositorioCliente).recuperarCpf(cliente.getCpf()) != null) {
            FacesContext.getCurrentInstance().addMessage("mensagensErro", new FacesMessage("Cliente com mesmo Cpf já cadastrado!"));
            return "CadastroCliente.xhtml";

        }

        if (cliente.getCpf().equals("000.000.000-00") || cliente.getCpf().equals("111.111.111-11")
                || cliente.getCpf().equals("222.222.222-22") || cliente.getCpf().equals("333.333.333-33")
                || cliente.getCpf().equals("444.444.444-44") || cliente.getCpf().equals("555.555.555-55")
                || cliente.getCpf().equals("666.666.666-66") || cliente.getCpf().equals("777.777.777-77")
                || cliente.getCpf().equals("888.888.888-88") || cliente.getCpf().equals("999.999.999-99")) {
            FacesContext.getCurrentInstance().addMessage("mensagensErro", new FacesMessage("O CPF "+cliente.getCpf() +" é invalido !"));
            return "CadastroCliente.xhtml";

        }
        this.repositorioCliente.inserir(cliente);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("OK!" + "O cliente '" + cliente.getNome() + "' foi cadastrado com sucesso!"));

        return "ApresentaClientes.xhtml";
    }

    public String atualizar(Cliente cliente) {

        String cpf = cliente.getCpf();

        if (cpf.length() != 11) {
            FacesContext.getCurrentInstance().addMessage("form:inputCpf", new FacesMessage("Erro", "O cpf tem que ter 11 DIGITOS"));
            return null;
        }

        if (((RepositorioCliente) this.repositorioCliente).recuperarCpf(cliente.getCpf()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente como mesmo Cpf já cadastrado!"));
            return null;

        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Parabéns", "o cliete '" + cliente.getNome() + "' foi alterado com sucesso!"));

        this.repositorioCliente.alterar(cliente);

        return "ApresentaCliente.xhtml";
    }

    public void deletar(Cliente cliente) {
        this.repositorioCliente.deletar(cliente);
    }

    public Cliente recuperaCliente(String cpf) {
        return this.repositorioCliente.recuperar(cpf);
    }

    public List<Cliente> getCliente() {
        return this.repositorioCliente.recuperarTodos();
    }

    public Cliente getSelectCliente() {
        return selectCliente;
    }

    public void setSelectCliente(Cliente selectCliente) {
        this.selectCliente = selectCliente;
    }

}
