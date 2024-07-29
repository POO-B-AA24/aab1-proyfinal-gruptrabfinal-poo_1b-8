package Controller;

import Model.Usuarios;

public class Estudiante extends Usuarios {

    String carrera;
    String ciclo;

    public Estudiante(String nombre, int edad) {
        super(nombre, edad);
    }

    public Estudiante(String nombre, int edad, String carrera, String ciclo) {
        super(nombre, edad);
        this.carrera = carrera;
        this.ciclo = ciclo;
    }

    @Override
    public void menu() {

    }
}
