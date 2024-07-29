package Model;

import Controller.OptimizacionRutas;
import Controller.Parada;
import Controller.Ruta;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DatosBuses {

    public final String rutaArchivoInfo = "C:\\Users\\pacaa\\OneDrive\\Documentos\\EstructuraDatos\\EstructuraDatos\\aab1-proyfinal-gruptrabfinal-poo_1b-8\\Varios";
    public final String rutaArchivoUbicacion = "C:\\Users\\pacaa\\OneDrive\\Documentos\\EstructuraDatos\\EstructuraDatos\\aab1-proyfinal-gruptrabfinal-poo_1b-8\\Varios";
    public final String rutaArchivoOptimizacion = "C:\\Users\\pacaa\\OneDrive\\Documentos\\EstructuraDatos\\EstructuraDatos\\aab1-proyfinal-gruptrabfinal-poo_1b-8\\Varios";
    Scanner sc = new Scanner(System.in);
    int opc;
    public Ruta[] rutas;
    public Parada[] paradas;
    public OptimizacionRutas[] optimizaciones;

    public void iniciar() {
        try {
            optimizaciones = leerOptimizaciones(rutaArchivoOptimizacion);
            mostrarOptimizacionesRutas();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado.");
        }
    }

    public void menu() {
        String x;
        System.out.println("Desea ingresar datos de su persona?Si[s]/No[n]");
        x=sc.nextLine();
        if(x.equals("s")){
            Usuarios user=new Usuarios();
            user.menu();
        }
        opc=4;
        do {
            System.out.println("Binevenido al Sistema de buses utpl");
            System.out.println("Indique la opcion que requiere");
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
                    }
                case 2:
                    Parada parada = new Parada();
                    try {
                        paradas = leerParadas(rutaArchivoUbicacion);
                        mostrarUbicacionesParadas();
                    } catch (FileNotFoundException e) {
                        System.err.println("Error: Archivo no encontrado.");
                    }
                    parada.menu();
            }
        } while (opc != 0);
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

    public void mostrarHorariosRutas() {
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
