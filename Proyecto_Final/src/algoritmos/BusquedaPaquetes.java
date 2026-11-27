/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos;

import modelo.Paquete;

/**
 *
 * @author Anderson
 */
public class BusquedaPaquetes {

    private static int comparaciones; //Aqui se guardan el numero de comparaciones realizadas

    public static int getComparaciones() {
        return comparaciones;
    }

    //metodo de la busqueda secuencial
    public static int buscarSecuencial(Paquete[] datos, String buscado) {
        comparaciones = 0;
        for (int i = 0; i < datos.length; i++) {
            comparaciones++;
            
            if (datos[i].getCodigo().equals(buscado)) {
                return i;
            }
        }
        return -1;
    }

    //metodo de la busqueda binaria
    public static int buscarBinaria(Paquete[] datosOrdenados, String buscado) {
        comparaciones = 0;
        int inicio = 0;
        int fin = datosOrdenados.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            comparaciones++;
            int resultado = datosOrdenados[medio].getCodigo().compareTo(buscado);

            if (resultado == 0) {
                return medio;
            }

            if (resultado < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    //Metodo para verficar que los datos estan ordenados antes de realizar la busquewda binaria  
    public static boolean estaOrdenado(Paquete[] datos) {
        for (int i = 0; i < datos.length - 1; i++) {
            if (datos[i].getCodigo().compareTo(datos[i + 1].getCodigo()) > 0) {
                return false;
            }
        }
        return true;
    }

}
