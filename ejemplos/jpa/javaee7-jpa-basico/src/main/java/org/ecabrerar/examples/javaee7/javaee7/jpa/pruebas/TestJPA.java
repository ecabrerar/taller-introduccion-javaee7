/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jpa.pruebas;

import java.util.List;
import org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Pais;
import org.ecabrerar.examples.javaee7.javaee7.jpa.servicios.ServicioPais;

/**
 *
 * @author ecabrerar
 */
public class TestJPA {
    
    public static void main(String[] args) {
        
        
        ServicioPais srv = new ServicioPais();        
                
        List<Pais> lstPais = srv.getListarTodos();
         
         for (Pais pais : lstPais) {
             System.out.println("Codigo:"+pais.getCodigoPais()+" Nombre:"+pais.getNombre());
        }
        
    }
}
