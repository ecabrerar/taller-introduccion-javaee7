/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ecabrerar.examples.javaee7.jsonp.creacionobjetos;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Construir objeto JSON con JsonBuilder
 *
 * @author ecabrerar
 */
public class ObjetoJSONCompuesto {

    public static void main(String[] args) {

        JsonObject value = Json.createObjectBuilder()
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
                .add("address", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("streetAddress", "21 2nd Street")
                                .add("city", "New York")
                                .add("state", "NY")
                                .add("postalCode", "10021")))
                .add("phoneNumber", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "212 555-1234"))
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "646 555-4567")))
                .build();
        
        System.out.println(""+value);
    }
}
