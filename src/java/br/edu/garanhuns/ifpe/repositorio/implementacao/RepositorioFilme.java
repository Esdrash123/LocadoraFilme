/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.repositorio.implementacao;

import br.edu.garanhuns.ifpe.DAO.DaoManagerHiber;
import br.edu.garanhuns.ifpe.entidades.Filme;
import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author esdra
 */
public class RepositorioFilme implements RepositorioGenerico {

    @Override
    public void inserir(Object t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Object t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Object recuperar(Object titulo) {
        try {
            return (Filme) DaoManagerHiber.getInstance().recover("from Filme where titulo" + titulo).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }

    @Override
    public void deletar(Object t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Filme> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Filme");
    }

    public Object recuperarTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Filme recuperarCpf(String titulo) {
        try {

            DaoManagerHiber dao = DaoManagerHiber.getInstance();

            List<Filme> filme = dao.recover("from Filme where cpf = '" + titulo + "'");
            return (Filme) filme.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    
}
