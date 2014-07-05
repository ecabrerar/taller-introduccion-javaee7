/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jsf22.html5.form.upload;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author ecabrerar
 */
@Named(value = "FormBean")
@RequestScoped
public class FormularioBean {
     private Part archivo;

     public FormularioBean() {
    }

    /**
     * @return the archivo
     */
    public Part getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(Part archivo) {
        this.archivo = archivo;
    }

   
}
