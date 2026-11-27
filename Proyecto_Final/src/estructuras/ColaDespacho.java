package estructuras;

import modelo.Paquete;

public class ColaDespacho {

    private static class Nodo {
        Paquete dato;
        Nodo siguiente;

        Nodo(Paquete dato) {
            this.dato = dato;
        }
    }

    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    public void encolar(Paquete p) {
        Nodo nuevo = new Nodo(p);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamanio++;
    }

    public Paquete desencolar() {
        if (estaVacia()) {
            return null;
        }
        Paquete p = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return p;
    }

    public Paquete verFrente() {
        return estaVacia() ? null : frente.dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola de despacho esta vacia.");
            return;
        }
        Nodo actual = frente;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.dato);
            actual = actual.siguiente;
            i++;
        }
    }
}