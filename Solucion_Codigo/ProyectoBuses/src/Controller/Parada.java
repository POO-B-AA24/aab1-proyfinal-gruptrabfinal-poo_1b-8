package Controller;

import Model.DatosBuses;
import java.util.Scanner;

public class Parada extends DatosBuses {

    private String nombre;
    private String ubicacion;
    Scanner sc = new Scanner(System.in);

    public Parada() {
    }

    public Parada(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public void menu() {
        int opc;
        DatosBuses app = new DatosBuses();
        System.out.println("Desea Consultar algo mas?");
        System.out.println("Si[1]/No[0]");
        opc = sc.nextInt();
        if (opc == 1) {
            app.menu();
        } else {
            System.out.println("Un gusto haberlo ayudado");
        }
    }
}
