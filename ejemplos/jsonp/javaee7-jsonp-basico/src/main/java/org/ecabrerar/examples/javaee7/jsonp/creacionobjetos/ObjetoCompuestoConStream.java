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
public class ObjetoCompuestoConStream {
    public static void main(String[] args) {
        JsonGeneratorFactory factory = Json.createGeneratorFactory(null);
        StringWriter w = new StringWriter();
        JsonGenerator gen = factory.createGenerator(w);

        gen
                .writeStartObject()
                .write("title", "The Matrix")
                .write("year", 1999)
                .writeStartArray("cast")
                .write("Keanu Reaves")
                .write("Laurence Fishburne")
                .write("Carrie-Anne Moss")
                .writeEnd()
                .writeEnd();
        gen.flush();
        
        System.out.println(""+w.toString());
    }
}
