package Controller;
import java.time.LocalTime;
import java.util.Formatter;
import java.util.Scanner;

public class RegistroHorarios {
    private int Npa;
    private LocalTime horaSalida;
    private LocalTime horaEntrada;

    public RegistroHorarios(int Npa, LocalTime horaSalida, LocalTime horaEntrada) {
        this.Npa = Npa;
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
    }

    public void modificarHorario(LocalTime horaSalida, LocalTime horaEntrada) {
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
    }

    public void guardar(Formatter formatter) {
        formatter.format("%d,%s,%s%n", Npa, horaSalida, horaEntrada);
    }

    public static RegistroHorarios leer(Scanner sc) {
        String[] data = sc.nextLine().split(",");
        return new RegistroHorarios(Integer.parseInt(data[0]), LocalTime.parse(data[1]), LocalTime.parse(data[2]));
    }

    @Override
    public String toString() {
        return "Horario{" +
                "Numero de la Parada=" + Npa + "\n" +
                ", horaSalida=" + horaSalida + "\n" +
                ", horaEntrada=" + horaEntrada +
                '}';
    }
}
