/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

public class Repartidor {

    private String codigo;
    private String nombre;
    private boolean disponible;

    public Repartidor(String codigo, String nombre, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Devolvemos los datos
    @Override
    public String toString() {
        String estado;
        if (disponible) {
            estado = "Disponible";
        } else {
            estado = "No disponible";
        }
        return "Código: " + codigo + " | Nombre: " + nombre + " | Estado: " + estado;
    }
}
