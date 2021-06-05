/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gl.arbolbinarioweb.servicio;

import java.util.List;
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
    
    
    @POST
    @Path("/height")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerProfundidad(String str) throws JSONException {
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
    
    @POST
    @Path("/neighbors")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerVecinos(String str) throws JSONException{
        JSONObject objeto = new JSONObject(str);
        JSONArray arregloObjeto = objeto.getJSONArray("toTree");
        int valor = objeto.getInt("node");
        int[] a = new int[arregloObjeto.length()];
        for(int i=0; i< arregloObjeto.length(); i++){
            a[i] = arregloObjeto.getInt(i);
        }
        Arbol arbol = new Arbol();
        Arbol arbolCreado = arbol.crearArbol(a);
        List<Integer> vecinos = arbolCreado.obtenerVecinos(valor);
        
        JSONObject objetoRespuesta = new JSONObject();
        objetoRespuesta.put("neighbors", vecinos);
        String respuesta = objetoRespuesta.toString();
        return Response.ok(respuesta).build();
        
    }
    
    @POST
    @Path("/bfs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bfs(String str) throws JSONException{
        JSONObject objeto = new JSONObject(str);
        JSONArray arregloObjeto = objeto.getJSONArray("toTree");
        int[] a = new int[arregloObjeto.length()];
        for(int i=0; i< arregloObjeto.length(); i++){
            a[i] = arregloObjeto.getInt(i);
        }
        Arbol arbol = new Arbol();
        Arbol arbolCreado = arbol.crearArbol(a);
        List<Integer> nodos = arbolCreado.recorridoPorAmplitud(arbolCreado.getPrincipal());
        
        JSONObject objetoRespuesta = new JSONObject();
        objetoRespuesta.put("bfs", nodos);
        String respuesta = objetoRespuesta.toString();
        return Response.ok(respuesta).build();
        
    }
    
}
