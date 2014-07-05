/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.codecampsdq40.javaee7.webservices.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author ecabrerar
 */
@Path("holamundo")
public class HolaMundo {

    @Context
    private UriInfo context;

    @GET
    @Path("{name}")
    @Produces("text/plain")
    public String saludar(@PathParam("name") String name) {
        return "Enhorabuena " + (name == null ? "" : name) + " !";
    }
    
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hola Mundo!!</h1></body></html>";
    }

}
