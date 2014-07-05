/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecabrerar.examples.javaee7.javaee7.proyecto.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class HelloBean {

    public void sayhello(String name) {
        System.out.println("Hello,"+name);
    } 
}
