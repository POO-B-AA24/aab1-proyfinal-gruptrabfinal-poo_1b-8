package Model;

import Controller.OptimizacionRutas;
import Controller.Parada;
import Controller.Ruta;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Define la clase DatosBuses para gestionar datos y operaciones relacionadas con rutas de buses
public class DatosBuses {

    // Rutas de los archivos de datos
    public final String rutaArchivoInfo = "varios//Rutas.csv";
    public final String rutaArchivoUbicacion = "varios//ubicaciones.csv";
    public final String rutaArchivoOptimizacion = "varios//optimizacion.csv";

    // Instancia de Scanner para la entrada de datos
    Scanner sc = new Scanner(System.in);

    // Variables para almacenar los datos leídos
    int opc;
    public Ruta[] rutas;
    public Parada[] paradas;
    public OptimizacionRutas[] optimizaciones;

    // Método para iniciar la aplicación y mostrar optimizaciones de rutas
    public void iniciar() {
        try {
            optimizaciones = leerOptimizaciones(rutaArchivoOptimizacion);
            mostrarOptimizacionesRutas();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado.");
        }
    }

    // Método principal del menú para interactuar con el usuario
    public void menu() {
        String x;
        System.out.println("Desea ingresar datos de su persona?Si[s]/No[n]");
        x = sc.nextLine();
        if (x.equals("s")) {
            Usuarios user = new Usuarios();
            user.menu();
        } else {
            opc = 4;
            do {
                System.out.println("Bienvenido al Sistema de buses UTPL");
                System.out.println("Indique la opción que requiere:");
                System.out.println("[1] Mostrar rutas y sus horarios");
                System.out.println("[2] Mostrar paradas y sus ubicaciones");
                System.out.println("[0] Salir");
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        Ruta ruta = new Ruta();
                        try {
                            rutas = leerRutas(rutaArchivoInfo);
                            mostrarHorariosRutas();
                            ruta.menu();
                        } catch (FileNotFoundException e) {
                            System.err.println("Error: Archivo no encontrado.");
                            ruta.menu();
                        }
                        break; // Se añadió 'break' para salir del case 1

                    case 2:
                        Parada parada = new Parada();
                        try {
                            paradas = leerParadas(rutaArchivoUbicacion);
                            mostrarUbicacionesParadas();
                        } catch (FileNotFoundException e) {
                            System.err.println("Error: Archivo no encontrado.");
                            parada.menu();
                        }
                        parada.menu();
                        break; // Se añadió 'break' para salir del case 2

                    default:
                        opc=0;
                        break; // Manejo de caso por defecto para opciones no válidas
                }
            } while (opc != 0);
        }
    }

    // Método para leer las rutas desde un archivo
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

    // Método para leer las paradas desde un archivo
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

    // Método para leer las optimizaciones desde un archivo
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

    // Método para mostrar los horarios de las rutas
    public void mostrarHorariosRutas() {
        System.out.println("============ HORARIOS DE LOS BUSES ===============");
        for (Ruta ruta : rutas) {
            if (ruta != null) {
                System.out.println(ruta.getHorario() + " | " + ruta.getRecorrido());
            }
        }
    }

    // Método para mostrar las ubicaciones de las paradas
    private void mostrarUbicacionesParadas() {
        System.out.println("============ UBICACIÓN DE LAS PARADAS ============");
        for (Parada parada : paradas) {
            if (parada != null) {
                System.out.println(parada.getNombre() + " | " + parada.getUbicacion());
            }
        }
    }

    // Método para mostrar las optimizaciones de rutas
    private void mostrarOptimizacionesRutas() {
        System.out.println("============== OPTIMIZACIÓN DE RUTAS ===============");
        for (OptimizacionRutas optimizacion : optimizaciones) {
            if (optimizacion != null) {
                System.out.println(optimizacion.getHoras() + " | " + optimizacion.getParadasRecurrentes());
            }
        }
    }
}
