/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

//Importo los paquetes
import estructuras.ListaPaquetes;
import modelo.Paquete;
import java.util.Scanner; //Libreria que permite leer el dato que digita el usuario
import estructuras.ColaDespacho;
import estructuras.PilaOperaciones;
import modelo.Operacion;

/**
 *
 * @author Anderson
 */
public class MenuPrincipal {

    private final ListaPaquetes lista;
    private final Scanner sc = new Scanner(System.in);
    private final ColaDespacho cola = new ColaDespacho();
    private final PilaOperaciones historial = new PilaOperaciones();

    public MenuPrincipal(ListaPaquetes lista) { //Aqui jalamos la lista del main
        this.lista = lista;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE ENTREGAS Y RUTAS =====");
            System.out.println("1. Gestionar paquetes");
            System.out.println("2. Cola de despacho");
            System.out.println("3. Historial de operaciones");
            System.out.println("0. Salir");
            opcion = leerEntero("Digite el numero de la accion a realizar: ");

            switch (opcion) {
                case 1:
                    gestionarPaquetes();
                    break;
                case 2:
                     gestionarDespacho();
                    break;
                case 3:
                 gestionarHistorial();
                    break;
               
                case 0:
                    System.out.println("¡Gracias por Utilizar el programa!");
                    break;
                default:
                    System.out.println("Opción NO VALIDA");
            }
        } while (opcion != 0);
    }

    public void gestionarPaquetes() {
        int opcion;
        do {
            System.out.println("\n--- Paquetes (" + lista.getTamanio() + " registrados) ---");
            System.out.println("1. Insertar paquete");
            System.out.println("2. Mostrar paquetes");
            System.out.println("3. Buscar paquete por código");
            System.out.println("4. Eliminar paquete por código");
            System.out.println("0. Volver");
            opcion = leerEntero("Digite el numero de la accion a realizar: ");

            switch (opcion) {
                case 1:
                    Paquete nuevo = leerPaquete();
                    if (lista.insertar(nuevo)) {
                        historial.apilar(new Operacion("INSERTAR", nuevo));
                        System.out.println("=====Paquete insertado correctamente====.");
                    } else {
                        System.out.println("Ya existe un paquete con el mismo codigo");
                    }
                    break;
                case 2:
                    lista.mostrar();
                    break;
                case 3:
                    Paquete p = lista.buscar(leerTexto("Código a buscar: "));
                    if (p != null) {
                        System.out.println("Paquete Encontrado: " + p);
                    } else {
                        System.out.println("El paquete buscado NO EXISTE");
                    }
                    break;
                case 4:
                    String codigoElim = leerTexto("Código del paquete a eliminar: ");
                    Paquete aEliminar = lista.buscar(codigoElim);
                    if (aEliminar != null && aEliminar.getEstado().equals("En cola")) {
                        System.out.println("No se puede eliminar: el paquete esta en la cola de despacho.");
                    } else if (lista.eliminar(codigoElim)) {
                        historial.apilar(new Operacion("ELIMINAR", aEliminar));
                        System.out.println("=====Paquete eliminado correctamente=====");
                    } else {
                        System.out.println("El paquete a eliminar NO EXISTE");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción NO VALIDA.");
            }
        } while (opcion != 0);
    }

    private Paquete leerPaquete() {
        String codigo = leerTexto("Digite el Código: ");
        String cliente = leerTexto("Digite el nombre del Cliente: ");
        String origen = leerTexto("Digite el Centro de origen: ");
        String destino = leerTexto("Digite el Centro de destino: ");
        double peso = leerDouble("Digite el Peso (kg): ");
        int prioridad = leerPrioridad();
        return new Paquete(codigo, cliente, origen, destino, peso, prioridad);
    }

    

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    private int leerPrioridad() {
        while (true) {
            int p = leerEntero("Prioridad (1 = alta, 2 = media, 3 = baja): ");
            if (p >= 1 && p <= 3) {
                return p;
            }
            System.out.println("Comando NO VALIDO, debe ser 1, 2 o 3.");
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Dato NO VALIDO, favor ingrese un número entero: ");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número VALIDO");
            }
        }
    }
        // ---------- PUNTO 10: COLA DE DESPACHO ----------
    public void gestionarDespacho() {
        int opcion;
        do {
            System.out.println("\n--- Cola de despacho (" + cola.getTamanio() + " en cola) ---");
            System.out.println("1. Agregar paquete a la cola");
            System.out.println("2. Despachar siguiente paquete");
            System.out.println("3. Ver siguiente paquete a despachar");
            System.out.println("4. Mostrar cola");
            System.out.println("0. Volver");
            opcion = leerEntero("Digite el numero de la accion a realizar: ");

            switch (opcion) {
                case 1:
                    Paquete aEncolar = lista.buscar(leerTexto("Codigo del paquete a encolar: "));
                    if (aEncolar == null) {
                        System.out.println("El paquete NO EXISTE");
                    } else if (!aEncolar.getEstado().equals("Pendiente")) {
                        System.out.println("Solo se pueden encolar paquetes Pendientes. Estado actual: "
                                + aEncolar.getEstado());
                    } else {
                        aEncolar.setEstado("En cola");
                        cola.encolar(aEncolar);
                        System.out.println("Paquete agregado a la cola de despacho.");
                    }
                    break;
                case 2:
                    Paquete despachado = cola.desencolar();
                    if (despachado == null) {
                        System.out.println("La cola de despacho esta vacia.");
                    } else {
                        despachado.setEstado("Despachado");
                        System.out.println("Paquete despachado: " + despachado);
                    }
                    break;
                case 3:
                    Paquete siguiente = cola.verFrente();
                    if (siguiente == null) {
                        System.out.println("La cola de despacho esta vacia.");
                    } else {
                        System.out.println("Siguiente a despachar: " + siguiente);
                    }
                    break;
                case 4:
                    cola.mostrar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion NO VALIDA.");
            }
        } while (opcion != 0);
    }

    // ---------- PUNTO 11: PILA DE OPERACIONES ----------
    public void gestionarHistorial() {
        int opcion;
        do {
            System.out.println("\n--- Historial de operaciones (" + historial.getTamanio() + " registradas) ---");
            System.out.println("1. Mostrar historial (la mas reciente primero)");
            System.out.println("2. Ver ultima operacion");
            System.out.println("3. Deshacer ultima operacion");
            System.out.println("0. Volver");
            opcion = leerEntero("Digite el numero de la accion a realizar: ");

            switch (opcion) {
                case 1:
                    historial.mostrar();
                    break;
                case 2:
                    Operacion ultima = historial.verTope();
                    if (ultima == null) {
                        System.out.println("No hay operaciones registradas.");
                    } else {
                        System.out.println("Ultima operacion: " + ultima);
                    }
                    break;
                case 3:
                    deshacerUltima();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion NO VALIDA.");
            }
        } while (opcion != 0);
    }

    private void deshacerUltima() {
        Operacion op = historial.verTope();
        if (op == null) {
            System.out.println("No hay operaciones para deshacer.");
            return;
        }
        Paquete p = op.getPaquete();

        if (op.getTipo().equals("INSERTAR")) {
            if (p.getEstado().equals("En cola")) {
                System.out.println("No se puede deshacer: el paquete " + p.getCodigo()
                        + " esta en la cola de despacho.");
                return;
            }
            lista.eliminar(p.getCodigo());
        } else if (op.getTipo().equals("ELIMINAR")) {
            if (!lista.insertar(p)) {
                System.out.println("No se puede deshacer: ya existe un paquete con el codigo " + p.getCodigo());
                return;
            }
        }

        historial.desapilar();
        System.out.println("Se deshizo: " + op);
    }

}
