/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.jsonp.lecturaobjetos;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

/**
 *
 * @author ecabrerar
 */
public class LeerArregloSimpleJSON {
    public static void main(String[] args) {
        JsonReader jsonReader = Json.createReader(new StringReader("["
                + "  { \"apple\":\"red\" },"
                + "  { \"banana\":\"yellow\" }"
                + "]"));
        JsonArray jsonArr = jsonReader.readArray();
        
        System.out.println(""+jsonArr);
    }
}
