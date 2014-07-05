/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jpa.servicios;

import org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Pais;

/**
 *
 * @author ecabrerar
 */
public class ServicioPais extends ServicioPersistenciaBase<Pais>{

    public ServicioPais() {
        super(Pais.class);
    }
    
    
    @Override
    public void borrar(long id) {
        
        Pais pais = getEntityManager().createEntityManager().find(Pais.class, id);
        
        if(pais==null){
            throw new RuntimeException("Registro no encontrado");
        }
        
        getEntityManager().createEntityManager().remove(pais);
        
    }  
}
