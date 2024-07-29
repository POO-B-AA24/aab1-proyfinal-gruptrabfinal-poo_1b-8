package Controller;

import Model.*;
import java.util.Scanner;

public class Ruta extends DatosBuses {

    Scanner sc = new Scanner(System.in);
    private String horario;
    private String recorrido;

    public Ruta() {
    }

    public Ruta(String horario, String recorrido) {
        this.horario = horario;
        this.recorrido = recorrido;
    }

    public String getHorario() {
        return horario;
    }

    public String getRecorrido() {
        return recorrido;
    }

    @Override
    public void menu() {
        DatosBuses app = new DatosBuses();
        int opc;
        System.out.println("Desea consultar una optimizacion?[1]si");;
        System.out.println("[0]no");
        opc = sc.nextInt();
        if (opc == 1) {
            app.iniciar();
            app.mostrarHorariosRutas();
        } else {
            System.out.println("Un gusto haber ayudado");
        }
    }
}
