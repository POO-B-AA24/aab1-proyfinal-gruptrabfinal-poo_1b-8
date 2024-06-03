package Controller;
import static View.SistemaEjecutor.gestion;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class RegistroParadas {

    private String nombre;
    private int Npa;
    private String ubicacion;
    private List<RegistroHorarios> horarios;

    public RegistroParadas(String nombre, int Npa, String ubicacion) {
        this.nombre = nombre;
        this.Npa = Npa;
        this.ubicacion = ubicacion;
        this.horarios = new ArrayList<>();
    }

    public static void registroParada(Scanner leer) {
        String nombre, ubicacion;
        int Npa;
        System.out.print("Nombre de la parada del bus: ");
        nombre = leer.nextLine();
        System.out.print("Número de parada: ");
        Npa = leer.nextInt();
        leer.nextLine();
        System.out.print("Ubicación: ");
        ubicacion = leer.nextLine();

        RegistroParadas parada = new RegistroParadas(nombre, Npa, ubicacion);
        gestion.regParada(parada);
        System.out.println("Guardado");
    }

    public int Npa() {
        return Npa;
    }

    public void setHorario(RegistroHorarios horario) {
        horarios.add(horario);
    }

    public List<RegistroHorarios> getHorarios() {
        return horarios;
    }

    public void guardar(Formatter formatter) {
        formatter.format("%s,%d,%s%n", nombre, Npa, ubicacion);
        for (RegistroHorarios horario : horarios) {
            horario.guardar(formatter);
        }
    }

    public static RegistroParadas leer(Scanner sc) {
        String[] data = sc.nextLine().split(",");
        RegistroParadas parada = new RegistroParadas(data[0], Integer.parseInt(data[1]), data[2]);
        return parada;
    }

    @Override
    public String toString() {
        return "Parada{"
                + ", Numero de la Parada=" + Npa + "\n"
                + ", Nombre de la Parada =" + nombre + '\n'
                + ", Ubicacion de la Parada =" + ubicacion + '\''
                + '}';
    }

    public void add(RegistroParadas parada) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
