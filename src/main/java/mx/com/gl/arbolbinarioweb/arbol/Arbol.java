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

    public Node getPrincipal() {
        return principal;
    }

    public void setPrincipal(Node principal) {
        this.principal = principal;
    }

}
