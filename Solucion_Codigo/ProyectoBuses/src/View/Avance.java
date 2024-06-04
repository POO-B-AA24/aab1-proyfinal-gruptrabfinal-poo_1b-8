package View;
import Model.*;
import java.util.Scanner;
public class Avance {
    public static void main(String[] args) {
        Scanner leer =new Scanner(System.in);
        int x;
        System.out.println("SISTEMA GESTION DE BUSES\n"
                + "Ingresar opcion deseada:\n"
                + "Horarios Buses         [1]\n"
                + "Ubicaciones Paradas    [2]\n"
                + "Optimizacion de la ruta[3]");
        x=leer.nextInt();
        ProyectoBimestralApp app = new ProyectoBimestralApp();
        app.iniciar(x);
    }
}