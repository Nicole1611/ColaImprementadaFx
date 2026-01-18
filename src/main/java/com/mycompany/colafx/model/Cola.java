package com.mycompany.colafx.model;

import java.util.function.IntConsumer;

public class Cola {
    private Nodo frente;
    private Nodo ultimo;

    public boolean encolar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            frente = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        return true;
    }

    public Integer desencolar() {
        if (isEmpty()) return null;
        int dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) ultimo = null;
        return dato;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public Integer peek() {
        if (isEmpty()) return null;
        return frente.dato;
    }

    public void forEach(IntConsumer action) {
        Nodo actual = frente;
        while (actual != null) {
            action.accept(actual.dato);
            actual = actual.siguiente;
        }
    }
}


