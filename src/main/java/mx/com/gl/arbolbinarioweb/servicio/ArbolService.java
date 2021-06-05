/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gl.arbolbinarioweb.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mx.com.gl.arbolbinarioweb.arbol.Arbol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author laure
 */
@Path("/v1/b-trees")
public class ArbolService {
    
    @GET  
    @Path("/ver")
    public Response sayHello() {     
          Arbol arbol = new Arbol();
          int[] ver = {1,2,3,4,5};
        Arbol arbolCreado = arbol.crearArbol(ver);
        int valor = arbol.profundidad(arbolCreado.getPrincipal());
        System.out.println(valor);
        return Response.ok("Hello World desde el API",MediaType.APPLICATION_JSON).build();   
    } 
    
    @POST
    @Path("/height")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(String str) throws JSONException {
        JSONObject objeto = new JSONObject(str);
        JSONArray arregloObjeto = objeto.getJSONArray("toTree");
        int[] a = new int[arregloObjeto.length()];
        for(int i=0; i< arregloObjeto.length(); i++){
            a[i] = arregloObjeto.getInt(i);
        }
        Arbol arbol = new Arbol();
        Arbol arbolCreado = arbol.crearArbol(a);
        int valor = arbol.profundidad(arbolCreado.getPrincipal());
        
        JSONObject objetoRespuesta = new JSONObject();
        objetoRespuesta.put("height", valor);
        String profundidad = objetoRespuesta.toString();
        return Response.ok(profundidad).build();
    }
    
}
