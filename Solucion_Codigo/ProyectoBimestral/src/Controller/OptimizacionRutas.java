package Controller;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class OptimizacionRutas {
    private int Npa;
    private String nombre;
    private List<RegistroParadas> paradas;

    public OptimizacionRutas(int Npa, String nombre) {
        this.Npa = Npa;
        this.nombre = nombre;
        this.paradas = new ArrayList<>();
    }

    public void agregarParada(RegistroParadas parada) {
        paradas.add(parada);
    }

    public void eliminarParada(RegistroParadas parada) {
        paradas.remove(parada);
    }

    public List<RegistroParadas> getParadas() {
        return paradas;
    }

    public List<RegistroParadas> optimizarRuta() {
        // Implementación del algoritmo de optimización de rutas
        return paradas;
    }

    public void guardar(Formatter formatter) {
        formatter.format("%d,%s%n", Npa, nombre);
        for (RegistroParadas parada : paradas) {
            parada.guardar(formatter);
        }
    }

    public static OptimizacionRutas leer(Scanner sc) {
        String[] data = sc.nextLine().split(",");
        return new OptimizacionRutas(Integer.parseInt(data[0]), data[1]);
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "Numero de la Parada" + "\n" +
                ", nombre='" + nombre + "\n" +
                ", paradas=" + paradas +
                '}';
    }

    public void add(OptimizacionRutas ruta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
