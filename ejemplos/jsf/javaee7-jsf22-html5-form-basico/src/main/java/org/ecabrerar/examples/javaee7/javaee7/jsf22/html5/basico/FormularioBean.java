/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jsf22.html5.basico;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author ecabrerar
 */
@ManagedBean
@SessionScoped
public class FormularioBean implements Serializable{
    
    private String nombre = "";
    private String email = "";
    private String emailValidacion = "";
    private String fecha = "";
    private String personas = "1";
    private String noches = "1";
    
    
    private String total = "99.00";

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the emailValidacion
     */
    public String getEmailValidacion() {
        return emailValidacion;
    }

    /**
     * @param emailValidacion the emailValidacion to set
     */
    public void setEmailValidacion(String emailValidacion) {
        this.emailValidacion = emailValidacion;
    }

    

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getNoches() {
        return noches;
    }

    public void setNoches(String noches) {
        this.noches = noches;
    }
    
    public void calcularTotal(AjaxBehaviorEvent event) throws AbortProcessingException {
        int nochesNum = 0;
        int personasNum = 1;
        int cantTotal;

        if (noches.trim().length() > 0) {
            nochesNum = Integer.parseInt(noches);
        }
        if (personas.trim().length() > 0) {
            personasNum = Integer.parseInt(personas);
        }

        cantTotal = (nochesNum * 99) + ((personasNum -1) * 10); 
        total = String.valueOf(cantTotal) + ".00";
    }

    public void cancelar(AjaxBehaviorEvent event) throws AbortProcessingException {
        nombre = "";
        email = "";
        emailValidacion = "";
        fecha = "";
        total = "99.00";
        noches = "1";
        personas = "1";
    }
    
}
