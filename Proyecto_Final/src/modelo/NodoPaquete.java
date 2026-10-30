/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



/**
 *
 * @author Joshua
 */
public class NodoPaquete {
     private Paquete dato;
    private NodoPaquete siguiente;

    public NodoPaquete(Paquete dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Paquete getDato() { return dato; }
    public NodoPaquete getSiguiente() { return siguiente; }
    public void setSiguiente(NodoPaquete siguiente) { this.siguiente = siguiente; }
}
