package modelo;

public class Operacion {

    private String tipo;      // "INSERTAR" o "ELIMINAR"
    private Paquete paquete;

    public Operacion(String tipo, Paquete paquete) {
        this.tipo = tipo;
        this.paquete = paquete;
    }

    public String getTipo() {
        return tipo;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    @Override
    public String toString() {
        return tipo + " -> paquete " + paquete.getCodigo();
    }
}