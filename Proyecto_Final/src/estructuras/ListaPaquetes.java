/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import estructuras.NodoPaquete;
import modelo.Paquete;



/**
 *
 * @author Joshua
 */
public class ListaPaquetes {
     private NodoPaquete primero;
    private int tamanio;

    public ListaPaquetes() {
        primero = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    
    public boolean insertar(Paquete paquete) {
        if (buscar(paquete.getCodigo()) != null) {
            return false;   // no se permiten códigos repetidos
        }

        NodoPaquete nuevo = new NodoPaquete(paquete);

        if (primero == null) {
            primero = nuevo;
        } else {
            NodoPaquete actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamanio++;
        return true;
    }

    
    public void mostrar() {
        if (primero == null) {
            System.out.println("No hay paquetes registrados.");
            return;
        }
        NodoPaquete actual = primero;
        int numero = 1;
        while (actual != null) {
            System.out.println(numero + ". " + actual.getDato());
            actual = actual.getSiguiente();
            numero++;
        }
    }

    
    public Paquete buscar(String codigo) {
        NodoPaquete actual = primero;
        while (actual != null) {
            if (actual.getDato().getCodigo().equals(codigo)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        if (primero == null) {
            return false;
        }

        // Caso 1: es el primer nodo
        if (primero.getDato().getCodigo().equals(codigo)) {
            primero = primero.getSiguiente();
            tamanio--;
            return true;
        }

        
        NodoPaquete actual = primero;
        while (actual.getSiguiente() != null
                && !actual.getSiguiente().getDato().getCodigo().equals(codigo)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() == null) {
            return false; 
        }

        // El anterior salta al nodo que sigue del eliminado
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamanio--;
        return true;
    }
}
