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
        
        //Datos de prueba temporales para las busquedas
        
        Paquete[] listaPrueba = {
        new Paquete("P001", "Ana Mora", "San Jose", "Cartago", 2.5, 1),
        new Paquete("P002", "Luis Rojas", "Heredia", "Alajuela", 5.0, 2),
        new Paquete("P003", "Marta Solis", "Cartago", "Limon", 1.2, 3),
        new Paquete("P004", "Pedro Vega", "Alajuela", "San Jose", 8.0, 1),
        new Paquete("P005", "Sofia Leon", "Limon", "Heredia", 3.3, 2),
        new Paquete("P006", "Carlos Mena", "San Jose", "Heredia", 4.1, 2),
        new Paquete("P007", "Elena Ruiz", "Cartago", "Alajuela", 6.4, 3),
        new Paquete("P008", "Diego Castro", "Limon", "San Jose", 2.2, 1),
        new Paquete("P009", "Laura Pineda", "Heredia", "Cartago", 7.5, 2),
        new Paquete("P010", "Mario Quesada", "Alajuela", "Limon", 1.8, 3),
        new Paquete("P011", "Rosa Campos", "San Jose", "Limon", 9.0, 1),
        new Paquete("P012", "Jose Araya", "Cartago", "Heredia", 3.9, 2),
        new Paquete("P013", "Nadia Brenes", "Limon", "Alajuela", 5.6, 3),
        new Paquete("P014", "Oscar Vargas", "Heredia", "San Jose", 2.7, 1),
        new Paquete("P015", "Paula Jimenez", "Alajuela", "Cartago", 4.4, 2)
        };
        
        //Aca lo demas
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
        MenuPrincipal menu = new MenuPrincipal(lista, listaPrueba);
        menu.mostrarMenu();
    }

}
