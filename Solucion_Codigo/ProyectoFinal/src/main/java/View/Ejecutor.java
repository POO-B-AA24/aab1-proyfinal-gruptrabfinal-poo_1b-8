package View;

import Model.*;
import Controller.*;
import java.util.ArrayList;
import java.util.List;

public class Ejecutor {

    public static void main(String[] args) {
        ArrayList<Conexion> lstRutas = new ArrayList<Conexion>();
        Rutas ruta = new Rutas(lstRutas);
        ArrayList<Conexion> lstHorarios = new ArrayList<Conexion>();
        Horarios horario = new Horarios(lstHorario);
        ArrayList<Conexion> lstParadas = new ArrayList<Conexion>();
        Paradas parada = new Paradas(lstParadas);
        for (Rutas rut : lstRutas) {
            Rutas.insertarDatos(rut);
        }
        ArrayList<Conexion> lstRutas = Rutas.mostrarDatos();
        for (Rutas rut : lstRutas) {
            System.out.println(rut);
        }
    }
}
