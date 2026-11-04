/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;


import estructuras.ListaPaquetes;
import modelo.Paquete;
import pruebas.MenuPrincipal;

/**
 *
 * @author Joshua
 */
public class ProyeBasesdeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ListaPaquetes lista = new ListaPaquetes();

        lista.insertar(new Paquete("P001", "Ana Mora", "San Jose", "Cartago", 2.5, 1));
        lista.insertar(new Paquete("P002", "Luis Rojas", "Heredia", "Alajuela", 5.0, 2));
        lista.insertar(new Paquete("P003", "Marta Solis", "Cartago", "Limon", 1.2, 3));
        lista.insertar(new Paquete("P004", "Pedro Vega", "Alajuela", "San Jose", 8.0, 1));
        lista.insertar(new Paquete("P005", "Sofia Leon", "Limon", "Heredia", 3.3, 2));

        System.out.println("=== PAQUETES REGISTRADOS (" + lista.getTamanio() + ") ===");
        lista.mostrar();

        System.out.println("\n=== BUSCAR ===");
        System.out.println("P003: " + lista.buscar("P003"));   
                
        System.out.println("P999: " + lista.buscar("P999"));   

        System.out.println("\n=== ELIMINAR P001 (primer nodo) ===");
        lista.eliminar("P001");
        lista.mostrar();

        System.out.println("\n=== ELIMINAR P004 (en medio) ===");
        lista.eliminar("P004");
        lista.mostrar();

        System.out.println("\nTamaño final: " + lista.getTamanio());
        
        //aca probar el menu
        MenuPrincipal menu = new MenuPrincipal(lista);
        menu.mostrarMenu();
    }

}
