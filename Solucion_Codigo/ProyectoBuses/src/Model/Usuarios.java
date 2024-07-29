package Model;

import Controller.*;
import java.util.Scanner;

public class Usuarios {

    Scanner sc = new Scanner(System.in);
    String nombre;
    int edad;

    public Usuarios() {
    }

    public Usuarios(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void menu() {
        int opc;
        System.out.println("Ingrese su nombre");
        nombre = sc.nextLine();
        System.out.println("Ingrese su edad");
        edad = sc.nextInt();
        System.out.println("Porfavor ingrese el tipo de usuario que es");
        System.out.println("[1] Estudiante");
        System.out.println("[2] Personal Utpl");
        System.out.println("[3] Externo");
        opc = sc.nextInt();
        switch (opc) {

            case 1:
                Estudiante est = new Estudiante(nombre, edad);
                est.menu();
            case 2:
                PersonalUtpl prnal = new PersonalUtpl(nombre, edad);
                prnal.menu();
            case 3:
                Externo ex = new Externo(nombre, edad);
                ex.menu();
        }
    }
}
