/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Joshua
 */
public class Paquete {
    private String codigo;
    private String cliente;
    private String centroOrigen;
    private String centroDestino;
    private double peso;
    private int prioridad;      // 1 = alta, 2 = media, 3 = baja
    private String estado;      // Pendiente, En cola, Despachado

    public Paquete(String codigo, String cliente, String centroOrigen,
                   String centroDestino, double peso, int prioridad) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.centroOrigen = centroOrigen;
        this.centroDestino = centroDestino;
        this.peso = peso;
        this.prioridad = prioridad;
        this.estado = "Pendiente";
    }

    public String getCodigo() { return codigo; }
    public String getCliente() { return cliente; }
    public String getCentroOrigen() { return centroOrigen; }
    public String getCentroDestino() { return centroDestino; }
    public double getPeso() { return peso; }
    public int getPrioridad() { return prioridad; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Cliente: " + cliente
                + " | " + centroOrigen + " -> " + centroDestino
                + " | Peso: " + peso + " kg | Prioridad: " + prioridad
                + " | Estado: " + estado;
    }
}
