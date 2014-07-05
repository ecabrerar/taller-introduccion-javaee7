/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.codecampsdq40.javaee7.json.demo;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author ecabrerar
 */
public class LeerObjetoDesdeStream {
    @Test
    public void testObjetoSimpleConDosElementos()  {
        JsonReader jsonReader = Json.createReader(Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("2.json"));
        JsonObject json = jsonReader.readObject();
        
        assertNotNull(json);
        assertFalse(json.isEmpty());
        assertTrue(json.containsKey("apple"));
        assertEquals("red", json.getString("apple"));
        assertTrue(json.containsKey("banana"));
        assertEquals("yellow", json.getString("banana"));
    }

    @Test
    public void testArreglo()  {
        JsonReader jsonReader = Json.createReader(Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("3.json"));
        JsonArray jsonArr = jsonReader.readArray();
        assertNotNull(jsonArr);
        assertEquals(2, jsonArr.size());
        

    }

    @Test
    public void testEstructuraCompuesta()  {
        JsonReader jsonReader = Json.createReader(Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("4.json"));
        JsonObject json = jsonReader.readObject();

        assertNotNull(json);
        assertFalse(json.isEmpty());
        assertTrue(json.containsKey("title"));
        assertEquals("The Matrix", json.getString("title"));
        assertTrue(json.containsKey("year"));
        assertEquals(1999, json.getInt("year"));
        assertTrue(json.containsKey("cast"));
        JsonArray jsonArr = json.getJsonArray("cast");
        assertNotNull(jsonArr);
        assertEquals(3, jsonArr.size());
        
    }
}
