/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gl.arbolbinarioweb.arbol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laure
 */
public class Arbol implements Serializable{
    private static final long serialVersionUID = 1L;

    private Node principal;

    public Arbol(){
        
    }
    private Node agregarRecursivo(Node actual, int valor) {
        if (actual == null) {
            return new Node(valor);
        }

        if (valor < actual.getValor()) {
            actual.setIzquierdo(agregarRecursivo(actual.getIzquierdo(), valor));
        } else if (valor > actual.getValor()) {
            actual.setDerecho(agregarRecursivo(actual.getDerecho(), valor));
        } else {
            return actual;
        }
        
        return actual;
    }

    public void agregar(int valor) {
        principal = agregarRecursivo(principal, valor);
    }

    public Arbol crearArbol(int[] nodos) {
        Arbol bt = new Arbol();
        for(int nodo:nodos){
            bt.agregar(nodo);
        }
        return bt;
    }

    public int profundidad(Node root) {
        if (root == null) {
            return 0;
        }
        int nLeft = profundidad(root.getIzquierdo());
        int nRight = profundidad(root.getDerecho());
        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }
    
    public List<Integer> obtenerVecinos(int valor){
        int nivel = obtenerNivel(principal, valor);
        return recorrerPorNiveles(principal,nivel,valor);
    }
    

    private int obtenerNivel(Node actual, int valor) {
        if (valor == actual.getValor()) {
            return 1;
        }
        return valor < actual.getValor() ?  1 + obtenerNivel(actual.getIzquierdo(), valor) : 1 + obtenerNivel(actual.getDerecho(), valor);
    }
    
    public List<Integer> recorrerPorNiveles(Node arbol,int nivel,int valor){
        List<Node> cola = new ArrayList<>();
        List<Node> aux = new ArrayList<>();
        cola.add(arbol);
        
        while(!cola.isEmpty()){
            Node actual = cola.get(0);
            cola.remove(0);
            aux.add(actual);
            if(actual!=null){
                cola.add(actual.getIzquierdo());                
                cola.add(actual.getDerecho());
            }
             
        }
        
        
        int[] valores = obtenerRangoValores(nivel);
        aux = aux.subList(valores[0], valores[1]);
        
        List<Integer> filaNodos = new ArrayList<>();        
        for(int i=0; i<aux.size(); i++){
            if(aux.get(i)!=null){
                if(aux.get(i).getValor()!=valor){
                    filaNodos.add(aux.get(i).getValor());
                }
            }
        }
       
        return filaNodos;
            
    }
    
    public int[] obtenerRangoValores(int nivel){
        int a = 0;
        int b = 1;
        for(int i=0; i<nivel; i++){
            if(i!=0){
                a += (int)Math.pow(2, (i-1));
                b += (int)Math.pow(2, (i));
            }
        }
        int[] valores = {a,b};
        return valores;
    }
    
    
    public Node getPrincipal() {
        return principal;
    }

    public void setPrincipal(Node principal) {
        this.principal = principal;
    }

}
