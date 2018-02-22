/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Dependente;
import br.edu.garanhuns.ifpe.model.dao.ManagerDao;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import br.edu.garanhuns.ifpe.repositorio.implementacao.RepositorioDependente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "cDependente")
@SessionScoped

public class DependenteController {

    private RepositorioGenerico<Dependente,Integer> repositorioDependente = null;
    private Dependente selectDependente;
    
    public DependenteController() {
        this.repositorioDependente = new RepositorioDependente();
    }
    
    public String inserir(Dependente dependente) {

        String cpf = Integer.toString(dependente.getCpf());
        
        if (cpf.length() != 11) {
            FacesContext.getCurrentInstance().addMessage("form:inputCpf", new FacesMessage("Erro", "O cpf tem que ter 11 DIGITOS"));
            return null;
        }

        if(dependente.getCliente() == null){
            FacesContext.getCurrentInstance().addMessage("form:inputDepende", new FacesMessage("Erro", "Cliente que você depende não existe"));
            return null;
        }

        if (((RepositorioDependente) this.repositorioDependente).recuperarCpf(dependente.getCpf()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dependente como mesmo Cpf já cadastrado!"));
            return null;

        }

        this.repositorioDependente.inserir(dependente);

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage("OK", "O dependente '" + dependente.getNome() + "' foi cadastrado com sucesso!"));
        
        return "ApresentaClientes.xhtml";
    }

    public String atualizar(Dependente dependente) {
        
        String cpf = Integer.toString(dependente.getCpf());
        
        if (cpf.length() != 11) {
            FacesContext.getCurrentInstance().addMessage("form:inputCpf", new FacesMessage("Erro", "O cpf tem que ter 11 DIGITOS"));
            return null;
        }

        if(dependente.getCliente() == null){
            FacesContext.getCurrentInstance().addMessage("form:inputDepende", new FacesMessage("Erro", "Cliente que você depende não existe"));
            return null;
        }

        if (((RepositorioDependente) this.repositorioDependente).recuperarCpf(dependente.getCpf()) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dependente como mesmo Cpf já cadastrado!"));
            return null;

        }
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Parabéns", "o dependente '" + dependente.getNome() + "' , do cliente '" +
                        dependente.getCliente() + "' foi alterado com sucesso!"));

        this.repositorioDependente.alterar(dependente);

        return "ApresentaClente.xhtml";
    }

    public void deletar(Dependente dependente) {
        this.repositorioDependente.deletar(dependente);
    }
    
    public Dependente recuperaDependente(int cpf) {
        return this.repositorioDependente.recuperar(cpf);
    }
    
    public List<Dependente> getDependente() {
        return this.repositorioDependente.recuperarTodos();
    }

    public Dependente getSelectDependente() {
        return selectDependente;
    }

    public void setSelectDependente(Dependente selectDependente) {
        this.selectDependente = selectDependente;
    }

}
