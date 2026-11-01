/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner; //Libreria que permite leer el dato que digita el usuario
/**
 *
 * @author Anderson
 */
public class MenuPrincipal {

    public void mostrarMenu() {

        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gestionar Paquetes");
            System.out.println("2. Gestionar Despachos");
            System.out.println("3. Gestionar Repartidores");
            System.out.println("4. Gestionar Rutas");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    gestionarPaquetes();
                    break;

                case 2:
                    gestionarDespachos();
                    break;

                case 3:
                    gestionarRepartidores();
                    break;

                case 4:
                    gestionarRutas();
                    break;

                case 5:
                    System.out.println("Programa Cerrado");
                    break;

                default:
                    System.out.println("Opcion NO VALIDA.");
            }

        } while (opcion != 5);
    }

    public void gestionarPaquetes() {
        System.out.println("Gestion de paquetes");
        //Faltan el resto de clases para hacer funcional el metodo
    }

    public void gestionarDespachos() {
        System.out.println("Gestion de despachos");
        //Faltan el resto de clases para hacer funcional el metodo
    }

    public void gestionarRepartidores() {
        System.out.println("Gestion de repartidores");
        //Faltan el resto de clases para hacer funcional el metodo
    }

    public void gestionarRutas() {
        System.out.println("Gestion de rutas");
        //Faltan el resto de clases para hacer funcional el metodo
    }
    
}

