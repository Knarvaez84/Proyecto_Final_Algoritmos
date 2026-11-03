/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

//Importo los paquetes
import estructuras.ListaPaquetes;
import modelo.Paquete;
import java.util.Scanner; //Libreria que permite leer el dato que digita el usuario

/**
 *
 * @author Anderson
 */
public class MenuPrincipal {

    private final ListaPaquetes lista;
    private final Scanner sc = new Scanner(System.in);

    public MenuPrincipal(ListaPaquetes lista) { //Aqui jalamos la lista del main
        this.lista = lista;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE ENTREGAS Y RUTAS =====");
            System.out.println("1. Gestionar paquetes");
            System.out.println("0. Salir");
            opcion = leerEntero("Digite el numero de la accion a realizar: ");

            switch (opcion) {
                case 1:
                    gestionarPaquetes();
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
                    if (lista.insertar(leerPaquete())) {
                        System.out.println("====Paquete insertado correctamente===.");
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
                    if (lista.eliminar(leerTexto("Código del paquete a eliminar: "))) {
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

}
