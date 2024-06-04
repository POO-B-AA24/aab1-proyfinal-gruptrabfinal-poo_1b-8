package Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Controller.*;

public class ProyectoBimestralApp {

    private final String rutaArchivoInfo = "C:\\Users\\pacaa\\OneDrive\\Documentos\\POO\\ProyectoBuses\\documentoInfo.csv";
    private final String rutaArchivoUbicacion = "C:\\Users\\pacaa\\OneDrive\\Documentos\\POO\\ProyectoBuses\\ubicaciones.csv";
    private final String rutaArchivoOptimizacion = "C:\\Users\\pacaa\\OneDrive\\Documentos\\POO\\ProyectoBuses\\optimizacion.csv";

    private Ruta[] rutas;
    private Parada[] paradas;
    private OptimizacionRutas[] optimizaciones;

    public void iniciar(int x) {
        try {
            rutas = leerRutas(rutaArchivoInfo);
            paradas = leerParadas(rutaArchivoUbicacion);
            optimizaciones = leerOptimizaciones(rutaArchivoOptimizacion);

            if(x==1){mostrarHorariosRutas();}
            if(x==2){mostrarUbicacionesParadas();}
            if(x==3){mostrarOptimizacionesRutas();}
            // Aquí puedes agregar la lógica para buscar paradas si lo deseas.
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado.");
        }
    }

    private Ruta[] leerRutas(String ruta) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(ruta));
        Ruta[] rutas = new Ruta[29];
        int index = 0;
        while (fileIn.hasNextLine() && index < rutas.length) {
            String linea = fileIn.nextLine();
            String[] partes = linea.split(";", 2);
            if (partes.length == 2) {
                rutas[index] = new Ruta(partes[0], partes[1]);
                index++;
            }
        }
        return rutas;
    }

    private Parada[] leerParadas(String ruta) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(ruta));
        Parada[] paradas = new Parada[72];
        int index = 0;
        while (fileIn.hasNextLine() && index < paradas.length) {
            String linea = fileIn.nextLine();
            String[] partes = linea.split(";", 2);
            if (partes.length == 2) {
                paradas[index] = new Parada(partes[0], partes[1]);
                index++;
            }
        }
        return paradas;
    }

    private OptimizacionRutas[] leerOptimizaciones(String ruta) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(ruta));
        OptimizacionRutas[] optimizaciones = new OptimizacionRutas[19];
        int index = 0;
        while (fileIn.hasNextLine() && index < optimizaciones.length) {
            String linea = fileIn.nextLine();
            String[] partes = linea.split(";", 2);
            if (partes.length == 2) {
                optimizaciones[index] = new OptimizacionRutas(partes[0], partes[1]);
                index++;
            }
        }
        return optimizaciones;
    }

    private void mostrarHorariosRutas() {
        System.out.println("============ HORARIOS DE LOS BUSES ===============");
        for (Ruta ruta : rutas) {
            if (ruta != null) {
                System.out.println(ruta.getHorario() + " | " + ruta.getRecorrido());
            }
        }
    }

    private void mostrarUbicacionesParadas() {
        System.out.println("============ UBICACIÓN DE LAS PARADAS ============");
        for (Parada parada : paradas) {
            if (parada != null) {
                System.out.println(parada.getNombre() + " | " + parada.getUbicacion());
            }
        }
    }

    private void mostrarOptimizacionesRutas() {
        System.out.println("==============OPTIMIZACIÓN DE RUTAS===============");
        for (OptimizacionRutas optimizacion : optimizaciones) {
            if (optimizacion != null) {
                System.out.println(optimizacion.getHoras() + " | " + optimizacion.getParadasRecurrentes());
            }
        }
    }
}
