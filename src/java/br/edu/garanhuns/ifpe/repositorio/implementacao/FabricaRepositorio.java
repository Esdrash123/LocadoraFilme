/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.repositorio.implementacao;

import br.edu.garanhuns.ifpe.repositorio.comportamento.RepositorioGenerico;

/**
 *
 * @author RGR-PC
 */
public class FabricaRepositorio {
    
    public static final int Cliente = 1;
    public static final int Dependente = 2;
    public static final int Filme = 3;
    public static final int Relatorio = 4;
    
    public static final int BD = 1;
    
    public static RepositorioGenerico fabricarRepositorio(int tipoNegocio, int tipoPersistencia){
        if( tipoPersistencia == BD ){
            if(tipoNegocio == Cliente){
                return new RepositorioCliente();
            }
            else if(tipoNegocio == Dependente){
                return new RepositorioDependente();
            }
            else if(tipoNegocio == Filme){
                return new RepositorioFilme();
            }
            else if(tipoNegocio == Relatorio){
                return new RepositorioAluguel();
            }
            
        }
        return null;
    }
    
}
