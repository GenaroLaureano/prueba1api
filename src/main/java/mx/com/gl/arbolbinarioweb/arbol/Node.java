/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gl.arbolbinarioweb.arbol;

import java.io.Serializable;

/**
 *
 * @author laure
 */
public class Node implements Serializable{
    private static final long serialVersionUID = 1L;

    
    private int valor;
    private Node izquierdo;
    private Node derecho;

    public Node(){
        
    }
    public Node(int valor){
        this.valor=valor;
        this.izquierdo = null;
        this.derecho = null;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Node izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Node getDerecho() {
        return derecho;
    }

    public void setDerecho(Node derecho) {
        this.derecho = derecho;
    }
    
    

    
    
    
    
}
