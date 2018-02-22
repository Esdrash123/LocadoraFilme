/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.repositorio.implementacao;

import br.edu.garanhuns.ifpe.DAO.DaoManagerHiber;
import br.edu.garanhuns.ifpe.entidades.Dependente;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author esdra
 */
public class RepositorioDependente implements RepositorioGenerico {

    @Override
    public void inserir(Object t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Object t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Object recuperar(Object nome) {
        try {
            return (Dependente) DaoManagerHiber.getInstance().recover("from Dependente where nome" + nome).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }

    @Override
    public void deletar(Object t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Dependente> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Dependente");
    }

    public Dependente recuperarCpf(int cpf) {
        try {

            DaoManagerHiber dao = DaoManagerHiber.getInstance();

            List<Dependente> dependente = dao.recover("from Dependente where cpf = '" + cpf + "'");
            return (Dependente) dependente.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
