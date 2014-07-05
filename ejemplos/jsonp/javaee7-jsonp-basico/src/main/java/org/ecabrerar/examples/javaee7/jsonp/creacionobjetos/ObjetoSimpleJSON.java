/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.jsonp.creacionobjetos;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author ecabrerar
 */
public class ObjetoSimpleJSON {
    public static void main(String[] args) {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("apple", "red")
                .add("banana", "yellow")
                .build();
        
        System.out.println(""+jsonObject);
    }
}
