/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.entidades.Relatorio;
import br.edu.garanhuns.ifpe.model.dao.ManagerDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esdra
 */
@ManagedBean(name = "cRelatorio")
@SessionScoped

public class RelatorioController {

    public void insert(Relatorio a) {
        ManagerDao.getCurrentInstance().insert(a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O Relatorio foi cadastrado"));
    }

    public void update(Relatorio a) {
        ManagerDao.getCurrentInstance().update(a);
    }

    public void deletar(Relatorio a) {
        ManagerDao.getCurrentInstance().delete(a);
    }

    public Relatorio read(Cliente cliente) {
        try {
            return (Relatorio) ManagerDao.getCurrentInstance()
                    .read("select a from Relatorio a where a.id=" + cliente, Relatorio.class).get(0);
        } catch (ArrayIndexOutOfBoundsException arr) {
            return null;
        }
    }
}
