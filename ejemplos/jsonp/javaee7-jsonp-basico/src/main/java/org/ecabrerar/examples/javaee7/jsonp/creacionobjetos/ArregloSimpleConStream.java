/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.jsonp.creacionobjetos;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

/**
 * Ejemplo con el Streaming APIs
 * @author ecabrerar
 */
public class ArregloSimpleConStream {
    public static void main(String[] args) {
         JsonGeneratorFactory factory = Json.createGeneratorFactory(null);
        StringWriter w = new StringWriter();
        JsonGenerator gen = factory.createGenerator(w);

        gen
                .writeStartArray()
                .writeStartObject()
                .write("apple", "red")
                .writeEnd()
                .writeStartObject()
                .write("banana", "yellow")
                .writeEnd()
                .writeEnd();
        gen.flush();
        
        System.out.println(""+w.toString());
    }
}
