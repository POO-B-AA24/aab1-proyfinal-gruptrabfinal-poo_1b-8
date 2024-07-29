package Controller;

// Importa la clase Usuarios desde el paquete Model
import Model.*;
import java.util.Scanner;

// Define la clase Estudiante que extiende la clase Usuarios
public class Estudiante extends Usuarios {

    // Atributos específicos de la clase Estudiante
    String carrera; // La carrera que está cursando el estudiante
    String ciclo;   // El ciclo académico del estudiante
    Scanner sc= new Scanner(System.in);

    public Estudiante(String carrera, String ciclo, String nombre, int edad) {
        super(nombre, edad);
        this.carrera = carrera;
        this.ciclo = ciclo;
    }

    // Constructor de la clase Estudiante que recibe nombre y edad
    public Estudiante(String nombre, int edad) {
        // Llama al constructor de la clase base Usuarios
        super(nombre, edad);
    }

    // Constructor de la clase Estudiante que recibe nombre, edad, carrera y ciclo

    // Método sobreescrito de la clase base Usuarios
    @Override
    public void menu() {
        System.out.println("Bienvenido Por favor completar los datos");
        System.out.println("ingresar Carrera que estudia");
        carrera=sc.nextLine();
        System.out.println("Ingresar ciclo al que pertenece");
        ciclo=sc.nextLine();
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carrera=" + carrera + ", ciclo=" + ciclo + '}';
    }


    
}
