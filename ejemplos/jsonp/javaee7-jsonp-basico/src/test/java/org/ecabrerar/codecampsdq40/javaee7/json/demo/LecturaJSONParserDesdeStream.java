/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.codecampsdq40.javaee7.json.demo;

import javax.json.Json;
import javax.json.stream.JsonParser;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author ecabrerar
 */
public class LecturaJSONParserDesdeStream {
     @Test
    public void testObjetoSimple()  {
        JsonParser parser = Json.createParser(Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("2.json"));

        assertEquals(JsonParser.Event.START_OBJECT, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.END_OBJECT, parser.next());
    }

    @Test
    public void testArreglo() {
        JsonParser parser = Json.createParser(Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("3.json"));

        assertEquals(JsonParser.Event.START_ARRAY, parser.next());
        assertEquals(JsonParser.Event.START_OBJECT, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.END_OBJECT, parser.next());
        assertEquals(JsonParser.Event.START_OBJECT, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.END_OBJECT, parser.next());
        assertEquals(JsonParser.Event.END_ARRAY, parser.next());
    }

    @Test
    public void testEstructuraCompuesta()  {
        JsonParser parser = Json.createParser(Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("4.json"));

        assertEquals(JsonParser.Event.START_OBJECT, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_NUMBER, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.START_ARRAY, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.END_ARRAY, parser.next());
        assertEquals(JsonParser.Event.END_OBJECT, parser.next());
    }

}
