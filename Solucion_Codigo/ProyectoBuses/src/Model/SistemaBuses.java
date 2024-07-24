package Model;

import java.util.Scanner;
import Controller.*;

public class SistemaBuses {

    Scanner sc = new Scanner(System.in);
   
    public RegistroRutas[] rutas;
    public RegistroParadas[] paradas;
    public OptimizacionRutas[] optimizaciones;

    public void menu() {
        int opc;
        System.out.println("SISTEMA GESTION DE BUSES\n"
                + "Ingresar opcion deseada:\n"
                + "Horarios Buses         [1]\n"
                + "Ubicaciones Paradas    [2]\n"
                + "Optimizacion de la ruta[3]");
        System.err.println("Error: Archivo no encontrado.");
        opc=sc.nextInt();
        switch(opc){
            /*
            aqui ingresar un menu cual el usuario decidira que quiere hacer y 
            mediante este ir a la clase correspondiente para indicarle que 
            opciones tiene disponible el usuario
            */
        }
    }
    public void aniadir() {
    }
}
