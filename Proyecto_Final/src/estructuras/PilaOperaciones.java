package estructuras;

import modelo.Operacion;

public class PilaOperaciones {

    private static class Nodo {
        Operacion dato;
        Nodo siguiente;

        Nodo(Operacion dato) {
            this.dato = dato;
        }
    }

    private Nodo tope;
    private int tamanio;

    public void apilar(Operacion op) {
        Nodo nuevo = new Nodo(op);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Operacion desapilar() {
        if (estaVacia()) {
            return null;
        }
        Operacion op = tope.dato;
        tope = tope.siguiente;
        tamanio--;
        return op;
    }

    public Operacion verTope() {
        return estaVacia() ? null : tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay operaciones registradas.");
            return;
        }
        Nodo actual = tope;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.dato);
            actual = actual.siguiente;
            i++;
        }
    }
}