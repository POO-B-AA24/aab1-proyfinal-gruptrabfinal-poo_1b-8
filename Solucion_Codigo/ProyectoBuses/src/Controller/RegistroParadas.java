package Controller;

import Model.SistemaBuses;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistroParadas extends SistemaBuses {

    public String nombre;
    public String ubicacion;
    private final String rutaArchivoUbicacion = "C:\\Users\\USUARIO\\Documents\\"
            + "proyecto bimestral\\aab1-proyfinal-gruptrabfinal-poo_1b-8\\Varios"
            + "\\ubicaciones.csv";

    public RegistroParadas(String nombre, String ubicacion, RegistroRutas[] rutas, RegistroParadas[] paradas, OptimizacionRutas[] optimizaciones) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    @Override
    public void menu(){
    }

    private RegistroParadas[] leerParadas(String ruta) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(ruta));
        RegistroParadas[] paradas = new RegistroParadas[72];
        int index = 0;
        while (fileIn.hasNextLine() && index < paradas.length) {
            String linea = fileIn.nextLine();
            String[] partes = linea.split(";", 2);
            if (partes.length == 2) {
                index++;
            }
        }
        return paradas;
    }

    private void mostrarUbicacionesParadas() {
        System.out.println("============ UBICACIÓN DE LAS PARADAS ============");
        for (RegistroParadas parada : paradas) {
            if (parada != null) {
                System.out.println(nombre + " | " + ubicacion);
            }
        }
    }
    @Override
    public void aniadir(){
    }
}
