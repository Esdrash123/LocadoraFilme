/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.repositorio.implementacao;

import br.edu.garanhuns.ifpe.DAO.DaoManagerHiber;
import br.edu.garanhuns.ifpe.entidades.Cliente;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author esdra
 */
public class RepositorioCliente implements RepositorioGenerico {

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
            return (Cliente) DaoManagerHiber.getInstance().recover("from Cliente where nome" + nome).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }

    @Override
    public void deletar(Object t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Cliente");
    }

    public Cliente recuperarCpf(String cpf) {
        try {

            DaoManagerHiber dao = DaoManagerHiber.getInstance();

            List<Cliente> cliente = dao.recover("from Cliente where cpf = '" + cpf + "'");
            return (Cliente) cliente.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
