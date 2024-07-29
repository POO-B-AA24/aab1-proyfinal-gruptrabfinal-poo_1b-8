package Controller;

import Model.Conexion;
import java.util.ArrayList;

public class Rutas {

    public Rutas(ArrayList<Conexion> listRutas) {
    }
    public void insertarDatos(Rutas rutas){
        (new Conexion()).insertarDatos(rutas);
    }
    public ArrayList<Rutas> MostrarDatos() {
        return (new Conexion()).mostrarDatos();
    }
}
