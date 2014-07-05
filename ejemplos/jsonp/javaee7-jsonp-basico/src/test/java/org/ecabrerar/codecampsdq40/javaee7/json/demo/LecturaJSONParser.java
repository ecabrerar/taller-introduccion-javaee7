/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.codecampsdq40.javaee7.json.demo;

import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author ecabrerar
 */
public class LecturaJSONParser {
     @Test
    public void testObjetoSimple()  {
        String json = "{"
                + "  \"apple\":\"red\","
                + "  \"banana\":\"yellow\""
                + "}";
        JsonParser parser = Json.createParser(new StringReader(json));
        assertEquals(JsonParser.Event.START_OBJECT, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.KEY_NAME, parser.next());
        assertEquals(JsonParser.Event.VALUE_STRING, parser.next());
        assertEquals(JsonParser.Event.END_OBJECT, parser.next());
    }

    @Test
    public void testArreglo()  {
        String json = "[{\"apple\":\"red\"},{\"banana\":\"yellow\"}]";
        JsonParser parser = Json.createParser(new StringReader(json));
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
        String json = "{\"title\":\"The Matrix\",\"year\":1999,\"cast\":[\"Keanu Reaves\",\"Laurence Fishburne\",\"Carrie-Anne Moss\"]}";
        JsonParser parser = Json.createParser(new StringReader(json));
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
