package Controller;

import Model.SistemaBuses;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OptimizacionRutas extends SistemaBuses {

    public String horas;
    public String paradasRecurrentes;
    private final String rutaArchivoOptimizacion = "C:\\Users\\USUARIO\\Documents"
            + "\\proyecto bimestral\\aab1-proyfinal-gruptrabfinal-poo_1b-8\\Varios"
            + "\\optimizacion.csv";

    public OptimizacionRutas(String horas, String paradasRecurrentes, RegistroRutas[] rutas, RegistroParadas[] paradas, OptimizacionRutas[] optimizaciones) {
        this.horas = horas;
        this.paradasRecurrentes = paradasRecurrentes;
    }

    @Override
    public void menu() {
    }

    private OptimizacionRutas[] leerOptimizaciones(String ruta) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(ruta));
        OptimizacionRutas[] optimizaciones = new OptimizacionRutas[19];
        int index = 0;
        while (fileIn.hasNextLine() && index < optimizaciones.length) {
            String linea = fileIn.nextLine();
            String[] partes = linea.split(";", 2);
            if (partes.length == 2) {
                index++;
            }
        }
        return optimizaciones;
    }

    private void mostrarOptimizacionesRutas() {
        System.out.println("==============OPTIMIZACIÓN DE RUTAS===============");
        for (OptimizacionRutas optimizacion : optimizaciones) {
            if (optimizacion != null) {
                System.out.println(horas + " | " + paradasRecurrentes);
            }
        }
    }

    @Override
    public void aniadir() {
    }
}
