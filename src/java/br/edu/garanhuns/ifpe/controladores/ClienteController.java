/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.model.dao.ManagerDao;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioCliente;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class ClienteController {
    
    private RepositorioGenerico<Cliente,Integer> repositorioCliente = null;
    private Cliente selectCliente;
    
    public ClienteController() {
        this.repositorioCliente = new RepositorioCliente();
    }
    
    public String inserir(Cliente cliente) {

        String cpf = cliente.getCpf();
        
        if (cpf.length() != 11) {
            FacesContext.getCurrentInstance().addMessage("form:inputCpf", new FacesMessage("Erro", "O cpf tem que ter 11 DIGITOS"));
            return null;
        }

        if (((RepositorioCliente) this.repositorioCliente).recuperarCpf(cliente.getCpf()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente como mesmo Cpf já cadastrado!"));
            return null;

        }

        this.repositorioCliente.inserir(cliente);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("Parabéns", "O cliente '" + cliente.getNome() + "' foi cadastrado com sucesso!"));
        
        return "CadastroCliente.xhtml";
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

        return "ApresentaClente.xhtml";
    }

    public void deletar(Cliente cliente) {
        this.repositorioCliente.deletar(cliente);
    }
    
    public Cliente recuperaCliente(int cpf) {
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